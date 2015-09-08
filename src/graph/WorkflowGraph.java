package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkflowGraph {
	public String file;
	public ArrayList<Node> nodes = new ArrayList<>();
	public ArrayList<Edge> edges = new ArrayList<>();
	
	public boolean isValidGraph(){
		boolean ret = false;
		
		return ret;
	}
	
	public void print(){
		System.out.println("______________");
		System.out.println("Workflow Graph");
		System.out.println("______________");
		System.out.println("Nodes:");
		nodes.stream().forEach(node -> System.out.println("BPMN-Element: " + node.getBpmnType() + " | Description: " + node.getDescription()));
		System.out.println("______________");
		System.out.println("Edges:");
		edges.stream().forEach(edge -> {
			if(edge.getTail().getDescription().equals("") && edge.getHead().getDescription().equals("")){
				System.out.println("From: " + edge.getTail().getBpmnType() + " To: " + edge.getHead().getBpmnType());
			}
			if(edge.getTail().getDescription().equals("") && !edge.getHead().getDescription().equals("")){
				System.out.println("From: " + edge.getTail().getBpmnType() + " To: " + edge.getHead().getDescription());
			}
			if(!edge.getTail().getDescription().equals("") && edge.getHead().getDescription().equals("")){
				System.out.println("From: " + edge.getTail().getDescription() + " To: " + edge.getHead().getBpmnType());
			}
			if(!edge.getTail().getDescription().equals("") && !edge.getHead().getDescription().equals("")){
				System.out.println("From: " + edge.getTail().getDescription() + " To: " + edge.getHead().getDescription());
			}
		});
		System.out.println("______________");
	}
	
	public boolean hasOneStartEvent(){
		List<Node> startElement = nodes.stream().filter(node -> "StartEvent".equals(node.getBpmnType())).collect(Collectors.toList());
		if(startElement.size() == 1){
			return true;
		} 
		else {
			return false;
		}
	}
}
