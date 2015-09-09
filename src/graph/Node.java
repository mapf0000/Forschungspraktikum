package graph;

public class Node {
	private String description;
	private String bpmnType;
	private String id;

	public Node(String description, String bpmnType, String id){
		this.description = description;
		this.bpmnType = bpmnType;
		this.id = id;
	}
	
	public String getBpmnType() {
		return bpmnType;
	}

	// public void setBpmnClass(String bpmnClass) {
	// this.bpmnType = bpmnClass;
	// }
	public String getDescription() {
		return description;
	}

	public void setDescription(String descripton) {
		this.description = descripton;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String toString(){
		if(description.equals(""))
			return bpmnType;
		else 
			return description;
	}
}
