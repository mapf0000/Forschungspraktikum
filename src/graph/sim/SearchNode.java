package graph.sim;

import java.util.ArrayList;

import graph.Edge;
import graph.Node;
import graph.mapping.Mapping;


public class SearchNode {
	ArrayList<Node> nodes = new ArrayList<>();
	ArrayList<Edge> edges = new ArrayList<>();
	Mapping mapping = new Mapping();
	Double f = null;

}
