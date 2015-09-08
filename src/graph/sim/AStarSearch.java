package graph.sim;

import org.apache.commons.lang3.SerializationUtils;

import graph.Edge;
import graph.Node;
import graph.WorkflowGraph;
import graph.mapping.EdgeEntry;
import graph.mapping.Mapping;
import graph.mapping.NodeEntry;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class AStarSearch {
	final int QUEUELIMIT = 1000;
	WorkflowGraph queryWorkflow;
	WorkflowGraph caseWorkflow;
	
	public AStarSearch(WorkflowGraph queryWorkflow, WorkflowGraph caseWorkflow){
		this.queryWorkflow = queryWorkflow;
		this.caseWorkflow = caseWorkflow;
	}
	
	public Mapping aStarI(){
		ArrayList<SearchNode> queue = new ArrayList<>();
		SearchNode sZero = new SearchNode();
		sZero.nodes = (ArrayList<Node>) queryWorkflow.nodes.clone();
		sZero.edges = (ArrayList<Edge>) queryWorkflow.edges.clone();
		sZero.mapping = new Mapping();
		sZero.f = 1d;
		queue.add(sZero);
		//System.out.println(queue.get(0).nodes.size());
		//System.out.println(queue.get(0).nodes.size());
		while(!queue.get(0).nodes.isEmpty() || !queue.get(0).edges.isEmpty()){
			//System.out.println("Nodes: " + queue.get(0).nodes.size());
			//System.out.println("Edges: " + queue.get(0).edges.size());
			queue = expand(queue);
		}
		return queue.get(0).mapping;
	}
	
	public ArrayList<SearchNode> expand(ArrayList<SearchNode> queue){
		boolean nodesMapped = false;
		SearchNode s = queue.get(0);
		queue.remove(0);
		//System.out.println(s.nodes.size());
		if(!s.nodes.isEmpty()){
			boolean mapped = false;
			Node xQ = s.nodes.get(new Random().nextInt(s.nodes.size()));
			for(Node nC: caseWorkflow.nodes){
				if(s.mapping.isLegalMapping(xQ, nC)){
					//System.out.println("New Node Mapping");
					SearchNode sNew = new SearchNode();
					sNew.mapping = new Mapping();
					sNew.mapping.nodeEntries = (ArrayList<NodeEntry>) s.mapping.nodeEntries.clone();
					sNew.mapping.edgeEntries = (ArrayList<EdgeEntry>) s.mapping.edgeEntries.clone();
					sNew.mapping.mapNodes(xQ, nC);
					//System.out.println("Similarity: " + sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()));
					sNew.nodes = (ArrayList<Node>) s.nodes.clone();
					sNew.edges = (ArrayList<Edge>) s.edges.clone();
					sNew.nodes.remove(xQ);
					sNew.f = sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()) + h(sNew);
					queue.add(sNew);
					mapped = true;
					nodesMapped = true;
				}
			}
			if(!mapped){
				s.nodes.remove(xQ);
				queue.add(s);
			}

		}
		else if(!s.edges.isEmpty()){
			boolean mapped = false;
			Edge xQ = s.edges.get(new Random().nextInt(s.edges.size()));
			for(Edge eC: caseWorkflow.edges){
				//TODO LEGAL MAPPING FIXEN
				if(s.mapping.isLegalMapping(xQ, eC)){
					//System.out.println("New Edge Mapping");
					SearchNode sNew = new SearchNode();
					sNew.mapping = new Mapping();
					sNew.mapping.nodeEntries = (ArrayList<NodeEntry>) s.mapping.nodeEntries.clone();
					sNew.mapping.edgeEntries = (ArrayList<EdgeEntry>) s.mapping.edgeEntries.clone();
					sNew.mapping.mapEdges(xQ, eC);
					//System.out.println("Similarity: " + sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()));
					sNew.nodes = (ArrayList<Node>) s.nodes.clone();
					sNew.edges = (ArrayList<Edge>) s.edges.clone();
					sNew.edges.remove(xQ);
					sNew.f = sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()) + h(sNew);
					queue.add(sNew);
					mapped = true;
				}
			}
			if(!mapped){
				s.edges.remove(xQ);
				queue.add(s);
			}
		}
		//Queue sortieren nach f
		queue = queue.stream().sorted((s1, s2) -> Double.compare(s2.f, s1.f)).collect(Collectors.toCollection(ArrayList::new));
		//Queue limit
		int i = queue.size();
		if(i > QUEUELIMIT) {
			queue.subList(QUEUELIMIT, i).clear();
		}
		return queue;
	}
	
	public double h(SearchNode s){
		double h = (0d + s.nodes.size() + s.edges.size()) / (queryWorkflow.nodes.size() + queryWorkflow.edges.size());
		//System.out.println("h: " + h);
		return h;
	}
	
	/**
	 * TODO A*II
	 * 
	 */
	public ArrayList<SearchNode> expand2(ArrayList<SearchNode> queue){
		boolean nodesMapped = false;
		SearchNode s = queue.get(0);
		queue.remove(0);
		for(Edge xQ: s.edges){
			if(!s.nodes.contains(xQ.getTail()) && !s.nodes.contains(xQ.getHead())){
				boolean mapped = false;
				for(Edge eC: caseWorkflow.edges){
					if(s.mapping.isLegalMapping(xQ, eC)){
						//System.out.println("New Edge Mapping");
						SearchNode sNew = new SearchNode();
						sNew.mapping = new Mapping();
						sNew.mapping.nodeEntries = (ArrayList<NodeEntry>) s.mapping.nodeEntries.clone();
						sNew.mapping.edgeEntries = (ArrayList<EdgeEntry>) s.mapping.edgeEntries.clone();
						sNew.mapping.mapEdges(xQ, eC);
						//System.out.println("Similarity: " + sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()));
						sNew.nodes = (ArrayList<Node>) s.nodes.clone();
						sNew.edges = (ArrayList<Edge>) s.edges.clone();
						sNew.edges.remove(xQ);
						sNew.f = sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()) + h(sNew);
						queue.add(sNew);
						mapped = true;
					}
				}
				if(!mapped){
					s.edges.remove(xQ);
					queue.add(s);
				}
			}
		}
		if(!s.edges.isEmpty()){
			boolean mapped = false;
			Edge xQ = s.edges.get(new Random().nextInt(s.edges.size()));
			for(Edge eC: caseWorkflow.edges){
				//TODO LEGAL MAPPING FIXEN
				if(s.mapping.isLegalMapping(xQ, eC)){
					//System.out.println("New Edge Mapping");
					SearchNode sNew = new SearchNode();
					sNew.mapping = new Mapping();
					sNew.mapping.nodeEntries = (ArrayList<NodeEntry>) s.mapping.nodeEntries.clone();
					sNew.mapping.edgeEntries = (ArrayList<EdgeEntry>) s.mapping.edgeEntries.clone();
					sNew.mapping.mapEdges(xQ, eC);
					//System.out.println("Similarity: " + sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()));
					sNew.nodes = (ArrayList<Node>) s.nodes.clone();
					sNew.edges = (ArrayList<Edge>) s.edges.clone();
					sNew.edges.remove(xQ);
					sNew.f = sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()) + h(sNew);
					queue.add(sNew);
					mapped = true;
				}
			}
			if(!mapped){
				s.edges.remove(xQ);
				queue.add(s);
			}
		}
		
		if(!s.nodes.isEmpty()){
			boolean mapped = false;
			Node xQ = s.nodes.get(new Random().nextInt(s.nodes.size()));
			for(Node nC: caseWorkflow.nodes){
				if(s.mapping.isLegalMapping(xQ, nC)){
					//System.out.println("New Node Mapping");
					SearchNode sNew = new SearchNode();
					sNew.mapping = new Mapping();
					sNew.mapping.nodeEntries = (ArrayList<NodeEntry>) s.mapping.nodeEntries.clone();
					sNew.mapping.edgeEntries = (ArrayList<EdgeEntry>) s.mapping.edgeEntries.clone();
					sNew.mapping.mapNodes(xQ, nC);
					//System.out.println("Similarity: " + sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()));
					sNew.nodes = (ArrayList<Node>) s.nodes.clone();
					sNew.edges = (ArrayList<Edge>) s.edges.clone();
					sNew.nodes.remove(xQ);
					sNew.f = sNew.mapping.computeSimilarity(queryWorkflow.nodes.size(), queryWorkflow.edges.size()) + h(sNew);
					queue.add(sNew);
					mapped = true;
					nodesMapped = true;
				}
			}
			if(!mapped){
				s.nodes.remove(xQ);
				queue.add(s);
			}
		}
		//Queue sortieren nach f
		queue = queue.stream().sorted((s1, s2) -> Double.compare(s2.f, s1.f)).collect(Collectors.toCollection(ArrayList::new));
		//queue.stream().sorted((s1, s2) -> Double.compare(s1.f, s2.f)).forEach(e -> System.out.println(e.f));
//		for(SearchNode se: queue){
//			System.out.println("SearchNode with f-value: " + se.f);
//		}

		return queue;
	}
}
