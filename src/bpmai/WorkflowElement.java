package bpmai;

import java.util.ArrayList;

public class WorkflowElement {
	public String id;
	public String type;
	public String description;
	public ArrayList<String> outgoing = new ArrayList<>();
	
	public WorkflowElement(String id, String type, String description, ArrayList<String> outgoing){
		this.id = id;
		this.type = type;
		this.description = description;
		this.outgoing = outgoing;
	}
}
