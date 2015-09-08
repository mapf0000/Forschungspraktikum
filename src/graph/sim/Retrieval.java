package graph.sim;

import graph.WorkflowGraph;
import graph.mapping.Mapping;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Retrieval {
	WorkflowGraph query;
	ArrayList<WorkflowGraph> caseBase;
	ArrayList<Mapping> ranking;
	
	public Retrieval(WorkflowGraph query, ArrayList<WorkflowGraph> caseBase){
		this.query = query;
		this.caseBase = caseBase;
		ranking = new ArrayList<>();
	}
	
	public void retrieve(){
		for(WorkflowGraph workflow: caseBase){
			AStarSearch AStar = new AStarSearch(query, workflow);
			Mapping m = AStar.aStarI();
			m.computeSimilarity(query.nodes.size(), query.edges.size());
			m.queryWorkflowFile = query.file;
			m.caseWorkflowFile = workflow.file;
			ranking.add(m);
		}
		ranking = ranking.stream().sorted((s1, s2) -> Double.compare(s2.similarity, s1.similarity)).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("====== Retrieval ======");
		System.out.println("Query Workflow: " + query.file);
		System.out.println("_________________");
		System.out.println("Ranking:");
		int i = 1;
		for(Mapping m: ranking){
			System.out.println(i+". Similarity: " + m.similarity + " File: " + m.caseWorkflowFile);
			i++;
		}

	}

}
