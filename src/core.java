import graph.Edge;
import graph.Node;
import graph.WorkflowGraph;
import graph.mapping.Mapping;
import graph.sim.AStarSearch;
import graph.sim.Retrieval;
import graph.sim.Similarity;
import graph.sim.TaxonomyNode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONException;

import bpmai.BpmaiImporter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class core {

	public static void main(String[] args) throws IOException, JSONException {
		
//		WorkflowGraph w1 = new WorkflowGraph();
//		w1.nodes.add(new Node("", "start"));
//		w1.nodes.add(new Node("book flight", "Event"));
		//BpmaiImporter.convertToWorkflowGraph(BpmaiImporter.importSingleModel("s"));

//		WorkflowGraph queryTest = new WorkflowGraph();
//		queryTest.nodes.add(new Node("", "StartEvent", "1"));
//		queryTest.nodes.add(new Node("A", "Task", "2"));
//		queryTest.nodes.add(new Node("B", "Task", "3"));
//		queryTest.nodes.add(new Node("C", "Task", "4"));
//		queryTest.nodes.add(new Node("D", "Task", "5"));
//		queryTest.nodes.add(new Node("", "EndTask", "6"));
//		queryTest.edges.add(new Edge("","1E",queryTest.nodes.get(0),queryTest.nodes.get(1)));
//		queryTest.edges.add(new Edge("","2E",queryTest.nodes.get(1),queryTest.nodes.get(2)));
//		queryTest.edges.add(new Edge("","3E",queryTest.nodes.get(2),queryTest.nodes.get(3)));
//		queryTest.edges.add(new Edge("","4E",queryTest.nodes.get(3),queryTest.nodes.get(4)));
//		queryTest.edges.add(new Edge("","5E",queryTest.nodes.get(4),queryTest.nodes.get(5)));
//		WorkflowGraph caseTest = new WorkflowGraph();
//		caseTest.nodes.add(new Node("", "StartEvent", "1"));
//		caseTest.nodes.add(new Node("A", "Task", "2"));
//		caseTest.nodes.add(new Node("B", "Task", "3"));
//		caseTest.nodes.add(new Node("C", "Task", "4"));
//		caseTest.nodes.add(new Node("D", "Task", "5"));
//		caseTest.nodes.add(new Node("", "EndTask", "6"));
//		caseTest.edges.add(new Edge("","1E",caseTest.nodes.get(0),caseTest.nodes.get(1)));
//		caseTest.edges.add(new Edge("","2E",caseTest.nodes.get(1),caseTest.nodes.get(2)));
//		caseTest.edges.add(new Edge("","3E",caseTest.nodes.get(2),caseTest.nodes.get(3)));
//		caseTest.edges.add(new Edge("","4E",caseTest.nodes.get(3),caseTest.nodes.get(4)));
//		caseTest.edges.add(new Edge("","5E",caseTest.nodes.get(4),caseTest.nodes.get(5)));
//		System.out.println(Similarity.nodeSim(queryTest.nodes.get(0), caseTest.nodes.get(0)));	
//		Mapping testMapping = new Mapping();
//		testMapping.mapNodes(queryTest.nodes.get(0), caseTest.nodes.get(0));
//		testMapping.mapNodes(queryTest.nodes.get(1), caseTest.nodes.get(1));
//		testMapping.mapNodes(queryTest.nodes.get(2), caseTest.nodes.get(2));
//		testMapping.mapNodes(queryTest.nodes.get(3), caseTest.nodes.get(3));
//		testMapping.mapNodes(queryTest.nodes.get(4), caseTest.nodes.get(4));
//		testMapping.mapEdges(queryTest.edges.get(0), caseTest.edges.get(0));
//		testMapping.mapEdges(queryTest.edges.get(1), caseTest.edges.get(1));
//		testMapping.mapEdges(queryTest.edges.get(2), caseTest.edges.get(2));
//		testMapping.mapEdges(queryTest.edges.get(3), caseTest.edges.get(3));
		//System.out.println(testMapping.computeSimilarity(queryTest.nodes.size(), queryTest.edges.size()));
		
//		AStarSearch AStar = new AStarSearch(queryTest, caseTest);
//		AStar.aStarI();
		
//		AStarSearch AStar = new AStarSearch(repository.get(1), repository.get(5));
//		Mapping a = AStar.aStarI();
//		System.out.println("Similarity: " + a.computeSimilarity(repository.get(1).nodes.size(), repository.get(1).edges.size()));
//		System.out.println(repository.get(1).file);
//		a.printWithDescription();
		
		/**
		 * Anfragen
		 * Domäne: Import/Export
		 */
		WorkflowGraph queryIE1 = new WorkflowGraph();
		queryIE1.file = "ImportExport_Anfrage1_591201708.png";
		queryIE1.nodes.add(new Node("register customer", "Task", "1"));
		queryIE1.nodes.add(new Node("check declaration", "Task", "2"));
		queryIE1.nodes.add(new Node("Calculation of duties and taxes", "Task", "3"));
		queryIE1.edges.add(new Edge("","1E",queryIE1.nodes.get(0),queryIE1.nodes.get(1)));
		queryIE1.edges.add(new Edge("","2E",queryIE1.nodes.get(1),queryIE1.nodes.get(2)));
		
		WorkflowGraph queryIE2 = new WorkflowGraph();
		queryIE2.file = "ImportExport_Anfrage2_1759586074.png";
		queryIE2.nodes.add(new Node("Selectivity Processing", "Task", "1"));
		queryIE2.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryIE2.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "3"));
		queryIE2.nodes.add(new Node("Goods Inspection", "Task", "4"));
		queryIE2.nodes.add(new Node("Scan X-Ray Examination", "Task", "5"));
		queryIE2.edges.add(new Edge("","1E",queryIE2.nodes.get(0),queryIE2.nodes.get(1)));
		queryIE2.edges.add(new Edge("Red Check","2E",queryIE2.nodes.get(1),queryIE2.nodes.get(2)));
		queryIE2.edges.add(new Edge("Green Check","3E",queryIE2.nodes.get(1),queryIE2.nodes.get(3)));
		queryIE2.edges.add(new Edge("","4E",queryIE2.nodes.get(3),queryIE2.nodes.get(2)));
		queryIE2.edges.add(new Edge("","5E",queryIE2.nodes.get(2),queryIE2.nodes.get(4)));
		
		WorkflowGraph queryIE3 = new WorkflowGraph();
		queryIE3.file = "ImportExport_Anfrage6_556323465.png";
		queryIE3.nodes.add(new Node("Receiving customs declaration", "Task", "1"));
		queryIE3.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryIE3.nodes.add(new Node("inspect document", "Task", "3"));
		queryIE3.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "4"));
		queryIE3.nodes.add(new Node("Payment check", "Task", "5"));
		queryIE3.edges.add(new Edge("","1E",queryIE3.nodes.get(0),queryIE3.nodes.get(1)));
		queryIE3.edges.add(new Edge("check required","2E",queryIE3.nodes.get(1),queryIE3.nodes.get(2)));
		queryIE3.edges.add(new Edge("check not required","3E",queryIE3.nodes.get(1),queryIE3.nodes.get(3)));
		queryIE3.edges.add(new Edge("","4E",queryIE3.nodes.get(2),queryIE3.nodes.get(3)));
		queryIE3.edges.add(new Edge("","5E",queryIE3.nodes.get(3),queryIE3.nodes.get(4)));
		
		WorkflowGraph queryIE4 = new WorkflowGraph();
		queryIE4.file = "ImportExport_Anfrage7";
		queryIE4.nodes.add(new Node("Document checking", "Task", "1"));
		queryIE4.nodes.add(new Node("Inspection Desicion", "Task", "2"));
		queryIE4.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "3"));
		queryIE4.edges.add(new Edge("","1E",queryIE4.nodes.get(0),queryIE4.nodes.get(1)));
		queryIE4.edges.add(new Edge("","2E",queryIE4.nodes.get(1),queryIE4.nodes.get(2)));
		
		WorkflowGraph queryIE5= new WorkflowGraph();
		queryIE5.file = "ImportExport_Anfrage8";
		queryIE5.nodes.add(new Node("Inspection Desicion", "Task", "1"));
		queryIE5.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryIE5.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "3"));
		queryIE5.nodes.add(new Node("Release Goods", "Task", "4"));
		queryIE5.edges.add(new Edge("","1E",queryIE5.nodes.get(0),queryIE5.nodes.get(1)));
		queryIE5.edges.add(new Edge("not required","2E",queryIE5.nodes.get(1),queryIE5.nodes.get(2)));
		queryIE5.edges.add(new Edge("","3E",queryIE5.nodes.get(2),queryIE5.nodes.get(3)));
		
		/**
		 * Anfragen
		 * Domäne: Bestellungen
		 */
		WorkflowGraph queryB1 = new WorkflowGraph();
		queryB1.file = "Bestellungen_Anfrage1_146960581.png";
		queryB1.nodes.add(new Node("Check availability", "Task", "1"));
		queryB1.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryB1.nodes.add(new Node("Send", "Task", "3"));
		queryB1.nodes.add(new Node("Procure", "Task", "4"));
		queryB1.edges.add(new Edge("","1E",queryB1.nodes.get(0),queryB1.nodes.get(1)));
		queryB1.edges.add(new Edge("Yes","2E",queryB1.nodes.get(1),queryB1.nodes.get(2)));
		queryB1.edges.add(new Edge("No","2E",queryB1.nodes.get(1),queryB1.nodes.get(3)));
		
		WorkflowGraph queryB2 = new WorkflowGraph();
		queryB2.file = "Bestellungen_Anfrage2_1383.png";
		queryB2.nodes.add(new Node("Get Shipment Address", "Task", "1"));
		queryB2.nodes.add(new Node("Ship Product", "Task", "2"));
		queryB2.edges.add(new Edge("","1E",queryB2.nodes.get(0),queryB1.nodes.get(1)));
		
		WorkflowGraph queryB3 = new WorkflowGraph();
		queryB3.file = "Bestellungen_Anfrage3_1206.png";
		queryB3.nodes.add(new Node("Check Credit Card", "Task", "1"));
		
		WorkflowGraph queryB4 = new WorkflowGraph();
		queryB4.file = "Bestellungen_Anfrage4_6063.png";
		queryB4.nodes.add(new Node("Reject Order", "Task", "1"));
		
		WorkflowGraph queryB5 = new WorkflowGraph();
		queryB5.file = "BestellungenNEU_Anfrage5_5683.png";
		queryB5.nodes.add(new Node("Financial Settlement", "Task", "1"));
		queryB5.nodes.add(new Node("Financial Settlement", "Endevent", "2"));
		queryB5.edges.add(new Edge("","1E",queryB5.nodes.get(0),queryB5.nodes.get(1)));
		
		/**
		 * Anfragen
		 * Domäne: Abrechnungen
		 */
		WorkflowGraph queryA1 = new WorkflowGraph();
		queryA1.file = "Abrechnung_Anfrage1_1096.png";
		queryA1.nodes.add(new Node("Print Report", "Task", "1"));
		queryA1.nodes.add(new Node("Compare Report", "Task", "2"));
		queryA1.edges.add(new Edge("","1E",queryA1.nodes.get(0),queryA1.nodes.get(1)));
		
		WorkflowGraph queryA2 = new WorkflowGraph();
		queryA2.file = "Abrechnung_Anfrage2_4311.png";
		queryA2.nodes.add(new Node("Check Invoice for Errors", "Task", "1"));
		queryA2.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryA2.nodes.add(new Node("Highlight errors", "Task", "3"));
		queryA2.nodes.add(new Node("Invoice Correct", "Task", "4"));
		queryA2.edges.add(new Edge("","1E",queryA2.nodes.get(0),queryA2.nodes.get(1)));
		queryA2.edges.add(new Edge("Error Found","2E",queryA2.nodes.get(1),queryA2.nodes.get(2)));
		queryA2.edges.add(new Edge("No Error","3E",queryA2.nodes.get(1),queryA2.nodes.get(3)));
		
		WorkflowGraph queryA3 = new WorkflowGraph();
		queryA3.file = "Abrechnung_Anfrage3_1251.png";
		queryA3.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "1"));
		queryA3.nodes.add(new Node("Sort by Amount", "Task", "2"));
		queryA3.nodes.add(new Node("Sort by Vendor", "Task", "3"));
		queryA3.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "4"));
		queryA3.edges.add(new Edge("","1E",queryA3.nodes.get(0),queryA3.nodes.get(1)));
		queryA3.edges.add(new Edge("","2E",queryA3.nodes.get(0),queryA3.nodes.get(2)));
		queryA3.edges.add(new Edge("","3E",queryA3.nodes.get(1),queryA3.nodes.get(3)));
		queryA3.edges.add(new Edge("","4E",queryA3.nodes.get(2),queryA3.nodes.get(3)));
		
		WorkflowGraph queryA4 = new WorkflowGraph();
		queryA4.file = "Abrechnung_Anfrage4_5324.png";
		queryA4.nodes.add(new Node("Check for Invoice Completeness", "Task", "1"));
		queryA4.nodes.add(new Node("", "ExclusiveDatabasedXorGateway", "2"));
		queryA4.nodes.add(new Node("Inspection", "Task", "3"));
		queryA4.edges.add(new Edge("","1E",queryA4.nodes.get(0),queryA4.nodes.get(1)));
		queryA4.edges.add(new Edge("Invoice is complete","2E",queryA4.nodes.get(1),queryA4.nodes.get(2)));
		
		WorkflowGraph queryA5 = new WorkflowGraph();
		queryA5.file = "Abrechnung_Anfrage5_5209.png";
		queryA5.nodes.add(new Node("Sort Invoices by Client", "Task", "1"));
		queryA5.nodes.add(new Node("Sort Invoices by Vendor", "Task", "2"));
		queryA5.edges.add(new Edge("","1E",queryA5.nodes.get(0),queryA5.nodes.get(1)));

		//importExportTaxonomy.findNode("document checking");
		//System.out.println(importExportTaxonomy.findNode("document checking").level);
		//System.out.println(importExportTaxonomy.getSimilartiy("submit export documents", "Release Goods"));
		//ArrayList<WorkflowGraph> importExport = BpmaiImporter.importModelsFrom("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/ImportExport");
		
		//Import-Export Evaluation:
//		ArrayList<WorkflowGraph> importExport = BpmaiImporter.importModelsFrom("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/ImportExport");
//		importExport.get(0).print();
//		Retrieval ret = new Retrieval(queryIE5, importExport);
//		ret.retrieve();
		
		//Bestellungen Evaluation:
//		ArrayList<WorkflowGraph> bestellungen = BpmaiImporter.importModelsFrom("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/Bestellung");
//		graph.sim.Similarity.sim = "lex";
//		graph.sim.Similarity.tax = graph.sim.Taxonomy.orders;
//		bestellungen.get(0).print();
//		Retrieval ret2 = new Retrieval(queryB1, bestellungen);
//		ret2.retrieve();
		
		//Abrechnung Evaluation
		ArrayList<WorkflowGraph> abrechnungen = BpmaiImporter.importModelsFrom("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/abrechnung");
		abrechnungen.get(0).print();
		graph.sim.Similarity.sim = "sem";
		graph.sim.Similarity.tax = graph.sim.Taxonomy.accounting;
		Retrieval ret2 = new Retrieval(queryA1, abrechnungen);
		ret2.retrieve();
		
//		ArrayList<WorkflowGraph> reise = BpmaiImporter.importModelsFrom("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/reise");
	}

}
