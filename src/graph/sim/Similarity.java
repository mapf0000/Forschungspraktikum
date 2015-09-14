package graph.sim;

import org.apache.commons.lang3.StringUtils;

import graph.Edge;
import graph.Node;

public class Similarity {
	public static String sim = "lex";
	public static TaxonomyNode nodeTax;
	public static TaxonomyNode edgeTax;

	public static double levenshteinSim(String a, String b){
		if(a.equals("") && b.equals("")){
			return 1;
		}
		return 1 - ((double) StringUtils.getLevenshteinDistance(a, b)) / (Math.max(a.length(), b.length()));
	}

	public static double edgeSim(Edge a, Edge b){
		double ret = 0;
		if(sim.equals("lex")){
			//Ähnlichkeitsberechnung Lexikalisch
			ret = (levenshteinSim(a.getDescription(), b.getDescription())) * 0.5
					* (nodeSim(a.getTail(), b.getTail()) + nodeSim(a.getHead(), b.getHead()));
		} 
		else if(sim.equals("sem")){
			//Ähnlichkeitsberechnung Semantisch
			if(a.getDescription().equals("") && b.getDescription().equals("")){
				ret = 1;
			} else	if(a.getDescription().equals("") || b.getDescription().equals("")){
				ret = 0;
			}
			else {
				ret = edgeTax.getSimilartiy(a.getDescription(), b.getDescription());
				//System.out.println("Node Sim: "+ ret + " (" + a.getDescription() + ", " + b.getDescription());
			}	
		}
		return ret;
	}
	
	public static double nodeSim(Node a, Node b){
		//Verschiedene BPMN-Klassen -> sim = 0
		if(a.getBpmnType() != b.getBpmnType()){
			return 0;
		}
		double ret = 0;
		
		if(sim.equals("lex")){
			//Ähnlichkeitsberechnung Lexikalisch
			ret = levenshteinSim(a.getDescription(), b.getDescription());
		} 
		else if(sim.equals("sem")){
			//Ähnlichkeitsberechnung Semantisch
			if(a.getDescription().equals("") && b.getDescription().equals("")){
				ret = 1;
			} else	if(a.getDescription().equals("") || b.getDescription().equals("")){
				ret = 0;
			}
			else {
				ret = nodeTax.getSimilartiy(a.getDescription(), b.getDescription());
				//System.out.println("Node Sim: "+ ret + " (" + a.getDescription() + ", " + b.getDescription());
			}	
		}
		return ret;
	}
	


}
