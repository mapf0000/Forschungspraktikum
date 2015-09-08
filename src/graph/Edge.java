package graph;

public class Edge {
	private String description;
	private String id;
	private Node tail;
	private Node head;

	public Edge(String description, String id, Node tail, Node head) {
		this.description = description;
		this.id = id;
		this.tail = tail;
		this.head = head;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.tail = head;
	}

}
