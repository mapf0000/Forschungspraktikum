import java.io.IOException;
import java.util.ArrayList;

import bpmai.BpmaiImporter;

import graph.Edge;
import graph.Node;
import graph.WorkflowGraph;
import graph.sim.Retrieval;
public class core {

	public static void main(String[] args) throws IOException {
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

		
		//Import-Export Evaluation:
		ArrayList<WorkflowGraph> importExport = BpmaiImporter.importModelsFrom("case base/ImportExport");
		graph.sim.Similarity.sim = "lex";
		Retrieval ret = new Retrieval(queryIE1, importExport);
		ret.retrieve();
		
		graph.sim.Similarity.sim = "sem";
		graph.sim.Similarity.nodeTax = graph.sim.Taxonomy.importExport;
		graph.sim.Similarity.edgeTax = graph.sim.Taxonomy.importExportEdges;
		ret.retrieve();
		
	}

}
