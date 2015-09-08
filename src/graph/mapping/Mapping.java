package graph.mapping;

import graph.Edge;
import graph.Node;
import graph.sim.Similarity;

import java.io.Serializable;
import java.util.ArrayList;

public class Mapping implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ArrayList<NodeEntry> nodeEntries = new ArrayList<>();
	public ArrayList<EdgeEntry> edgeEntries = new ArrayList<>();
	public double similarity;
	public String queryWorkflowFile;
	public String caseWorkflowFile;
	
	public boolean notMapped(Node nC){
		for(NodeEntry nodeEntry: nodeEntries){
			if(nodeEntry.nc.equals(nC)){
				return false;
			}
		}
		return true;
	}
	
	public boolean notMapped(Edge eC){
		for(EdgeEntry edgeEntry: edgeEntries){
			if(edgeEntry.ec.equals(eC)){
				return false;
			}
		}
		return true;
	}
	
	public boolean areMapped(Node nQ, Node nC){
		for(NodeEntry nodeEntry: nodeEntries){
			if(nodeEntry.nq.equals(nQ) && nodeEntry.nc.equals(nC)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isLegalMapping(Node nq, Node nc){
		if(!notMapped(nc)){
			//System.out.println("Already Mapped ID: " + nc.getId());
			return false;
		}
		if(!nq.getBpmnType().equals(nc.getBpmnType())){
			
			return false;
		}
		return true;
	}
	
	public boolean isLegalMapping(Edge eQ, Edge eC){
		if(!notMapped(eC)){
			return false;
		}
		if(!eQ.getTail().getBpmnType().equals(eC.getTail().getBpmnType()) && !eQ.getHead().getBpmnType().equals(eC.getHead().getBpmnType())){
			return false;
		}
		if(!areMapped(eQ.getTail(), eC.getTail()) && !areMapped(eQ.getHead(), eC.getHead())){
			//System.out.println("Not Mapped: ID-Query(tail): " + eQ.getTail().getId() + " ID-Case(tail): " + eC.getTail().getId());
			//System.out.println("Not Mapped: ID-Query(head): " + eQ.getHead().getId() + " ID-Case(head): " + eC.getHead().getId());
			return false;
		}
		return true;
	}
	
	public void mapNodes(Node nq, Node nc){
		nodeEntries.add(new NodeEntry(nq, nc));
	}
	
	public void mapEdges(Edge eq, Edge ec){
		edgeEntries.add(new EdgeEntry(eq, ec));
	}
	
	public double computeSimilarity(int a, int b){
		double nodeSim = 0;
		for(NodeEntry entry : nodeEntries){
			nodeSim += Similarity.nodeSim(entry.nq, entry.nc);
		}
		double edgeSim = 0;
		for(EdgeEntry entry : edgeEntries){
			edgeSim += Similarity.edgeSim(entry.eq, entry.ec);
		}
		similarity = (nodeSim+edgeSim)/ (0d+a+b);
		return similarity;
	}
	
	public void printWithIDs(){
		System.out.println("___________________");
		System.out.println("======MAPPING======");
		System.out.println("Similarity: " + similarity);
		System.out.println("Nodes:");
		nodeEntries.stream().forEach(e -> System.out.println(e.nq.getId() +" -> " + e.nc.getId()));
		System.out.println("Edges:");
		edgeEntries.stream().forEach(e -> System.out.println(e.eq.getId() +" -> " + e.ec.getId()));
	}
	
	public void printWithDescription(){
		System.out.println("======MAPPING======");
		System.out.println("Similarity: " + similarity);
		System.out.println("___________________");
		System.out.println("Nodes:");
		System.out.println("___________________");
		nodeEntries.stream().forEach(e -> System.out.println(e.nq.toString() +" -> " + e.nc.toString()));
		System.out.println("___________________");
		System.out.println("Edges:");
		System.out.println("___________________");
		edgeEntries.stream().forEach(e -> System.out.println("(" + e.eq.getTail().toString() +", " + e.eq.getHead().toString()  +") -> " + "(" + e.ec.getTail().toString()  +", " + e.ec.getHead().toString() + ")"));
	}

}
