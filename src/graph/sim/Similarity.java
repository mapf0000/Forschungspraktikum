package graph.sim;

import org.apache.commons.lang3.StringUtils;

import graph.Edge;
import graph.Node;

public class Similarity {
	public static String sim = "lex";
	public static TaxonomyNode tax;
	static {
		/**
		 * BEGIN Taxonomy for Import/Export domain
		 */
		TaxonomyNode importExportTaxonomy = new TaxonomyNode("import/export", 0);
		
		//Release Goods
		TaxonomyNode releaseGoods = new TaxonomyNode("releaseGoods", 1);
		importExportTaxonomy.addChild(releaseGoods);
		releaseGoods.addChild(new TaxonomyNode("Loading Goods for Exportation"));
		releaseGoods.addChild(new TaxonomyNode("Release goods for export"));
		releaseGoods.addChild(new TaxonomyNode("Declaration validation and release goods"));
		releaseGoods.addChild(new TaxonomyNode("Release Goods"));
		releaseGoods.addChild(new TaxonomyNode("Release Goods for export"));
		releaseGoods.addChild(new TaxonomyNode("Container Released"));
		
		//Inspections
		TaxonomyNode inspections = new TaxonomyNode("inspections", 0.1);
		importExportTaxonomy.addChild(inspections);
		inspections.addChild(new TaxonomyNode("cargo check and check charges paid to port authority"));
		inspections.addChild(new TaxonomyNode("selectivity processing"));
		inspections.addChild(new TaxonomyNode("Provide testimony to overcome the problem"));
		inspections.addChild(new TaxonomyNode("Export or destruct"));
		inspections.addChild(new TaxonomyNode("Request refusal"));
		
		TaxonomyNode inspectionTransportation = new TaxonomyNode("inspectionTransportation", 1);
		inspections.addChild(inspectionTransportation);
		inspectionTransportation.addChild(new TaxonomyNode("Move Goods to warehouse"));
		inspectionTransportation.addChild(new TaxonomyNode("Move goods to check site"));
		
		TaxonomyNode inspectionProcess = new TaxonomyNode("inspection process", 0.3);
		inspections.addChild(inspectionProcess);
		inspectionProcess.addChild(new TaxonomyNode("Item inspection"));
		inspectionProcess.addChild(new TaxonomyNode("Physical Control"));
		inspectionProcess.addChild(new TaxonomyNode("Goods Inspection"));
		inspectionProcess.addChild(new TaxonomyNode("Inspection of Goods"));
		inspectionProcess.addChild(new TaxonomyNode("Physical Examination"));
		inspectionProcess.addChild(new TaxonomyNode("Detailed examination of Goods"));
		inspectionProcess.addChild(new TaxonomyNode("Item Inspection (before acceptance)"));
		inspectionProcess.addChild(new TaxonomyNode("Apply for reconditioning"));
		
		TaxonomyNode detailedInspection = new TaxonomyNode("detailedInspection", 0.5);
		inspectionProcess.addChild(detailedInspection);
		detailedInspection.addChild(new TaxonomyNode("compliance decision"));
		detailedInspection.addChild(new TaxonomyNode("collect sample for lab or field analysis"));
		detailedInspection.addChild(new TaxonomyNode("Re-sampling"));
		
		TaxonomyNode investigation = new TaxonomyNode("investigation", 1);
		detailedInspection.addChild(investigation);
		investigation.addChild(new TaxonomyNode("Stop for Investigation"));
		investigation.addChild(new TaxonomyNode("detain goods for investigation"));
		investigation.addChild(new TaxonomyNode("Detain shipment"));
		
		TaxonomyNode xRayInspection = new TaxonomyNode("x-ray inspection", 1);
		detailedInspection.addChild(xRayInspection);
		xRayInspection.addChild(new TaxonomyNode("Container X-Ray Inspection"));
		xRayInspection.addChild(new TaxonomyNode("Scan X-Ray Examination"));
		
		TaxonomyNode inspectionDecision = new TaxonomyNode("inspectionDesicion", 1);
		inspections.addChild(inspectionDecision);
		inspectionDecision.addChild(new TaxonomyNode("Risk Evaluation Decision"));
		inspectionDecision.addChild(new TaxonomyNode("Making Inspection Decision"));
		inspectionDecision.addChild(new TaxonomyNode("Make Inspection Decisson"));
		inspectionDecision.addChild(new TaxonomyNode("Deciding if physical inspection is required"));
		inspectionDecision.addChild(new TaxonomyNode("Make inspection descision"));
		inspectionDecision.addChild(new TaxonomyNode("Content Checking decision"));
		inspectionDecision.addChild(new TaxonomyNode("making sampling decision"));
		inspectionDecision.addChild(new TaxonomyNode("Inspection Desicion"));

		
		//Taxes
		TaxonomyNode taxes = new TaxonomyNode("taxes", 0.2);
		importExportTaxonomy.addChild(taxes);
		taxes.addChild(new TaxonomyNode("payment instruction"));
		taxes.addChild(new TaxonomyNode("Calculation of Duties and Taxes"));
		
		TaxonomyNode taxesPaymentCheck = new TaxonomyNode("taxesPaymentCheck", 1);
		taxes.addChild(taxesPaymentCheck);
		taxesPaymentCheck.addChild(new TaxonomyNode("Check Up of Payments or availability of guarantees regarding customs duties"));
		taxesPaymentCheck.addChild(new TaxonomyNode("Payment check"));
		
		TaxonomyNode taxesPayment = new TaxonomyNode("taxesPayment", 1);
		taxes.addChild(taxesPayment);
		taxesPayment.addChild(new TaxonomyNode("Payment of Duty"));
		taxesPayment.addChild(new TaxonomyNode("Payment of Duties and Taxes"));
		taxesPayment.addChild(new TaxonomyNode("payment"));
		taxesPayment.addChild(new TaxonomyNode("Export Tax Calculation and Payment"));
		taxesPayment.addChild(new TaxonomyNode("Calculation and payment of Duties and taxes"));
		
		//Customs
		TaxonomyNode customs = new TaxonomyNode("taxes", 0.2);
		importExportTaxonomy.addChild(customs);
		customs.addChild(new TaxonomyNode("recieving customs declaration and supporting docs"));
		customs.addChild(new TaxonomyNode("Receiving customs declaration"));
		customs.addChild(new TaxonomyNode("send release notification to customs"));
		customs.addChild(new TaxonomyNode("ship arrival notification"));
		
		TaxonomyNode customsDocCheck = new TaxonomyNode("custom document check", 1);
		customs.addChild(customsDocCheck);
		customsDocCheck.addChild(new TaxonomyNode("Document Control"));
		customsDocCheck.addChild(new TaxonomyNode("checking of customs declaration and supp. docs"));
		customsDocCheck.addChild(new TaxonomyNode("Checking of Customs desclation and supp. docs"));
		customsDocCheck.addChild(new TaxonomyNode("inspect document"));
		customsDocCheck.addChild(new TaxonomyNode("check declaration"));
		
		TaxonomyNode customsDeclaration = new TaxonomyNode("customs declaration", 1);
		customs.addChild(customsDeclaration);
		customsDeclaration.addChild(new TaxonomyNode("register custom declaration and support. documents"));
		customsDeclaration.addChild(new TaxonomyNode("Register Customer Declaration and support. Documents"));
		customsDeclaration.addChild(new TaxonomyNode("Register Customer Declaration and supp. docs"));
		customsDeclaration.addChild(new TaxonomyNode("registration of customs declaration"));
		customsDeclaration.addChild(new TaxonomyNode("customs declaration fill out, server registration, and print out"));
		customsDeclaration.addChild(new TaxonomyNode("register customer"));
		
		//Import/Export Process
		TaxonomyNode importExportProcess = new TaxonomyNode("import export process", 0.2);
		importExportTaxonomy.addChild(importExportProcess);
		
		TaxonomyNode permissions = new TaxonomyNode("permissions", 0.5);
		importExportProcess.addChild(permissions);
		permissions.addChild(new TaxonomyNode("Processing Import Permit"));
		
		TaxonomyNode importPermissions = new TaxonomyNode("import permissons", 1);
		permissions.addChild(importPermissions);
		importPermissions.addChild(new TaxonomyNode("Issuing Import Permit"));
		
		TaxonomyNode exportPermissions = new TaxonomyNode("export permissons", 1);
		permissions.addChild(exportPermissions);
		exportPermissions.addChild(new TaxonomyNode("Issuing Export Permit"));
		
		TaxonomyNode documentChecks = new TaxonomyNode("documentChecks", 1);
		importExportProcess.addChild(documentChecks);
		documentChecks.addChild(new TaxonomyNode("document checking"));
		documentChecks.addChild(new TaxonomyNode("document screening"));
		documentChecks.addChild(new TaxonomyNode("Checking Documents"));
		
		TaxonomyNode declarationDocuments = new TaxonomyNode("declaration documents", 0.8);
		importExportProcess.addChild(declarationDocuments);
		declarationDocuments.addChild(new TaxonomyNode("submit declaration and other documents"));
		
		TaxonomyNode importDocuments = new TaxonomyNode("import documents", 1);
		declarationDocuments.addChild(importDocuments);
		importDocuments.addChild(new TaxonomyNode("submit import documents"));
		importDocuments.addChild(new TaxonomyNode("filling of import entries"));
		
		TaxonomyNode exportDocuments = new TaxonomyNode("export documents", 1);
		declarationDocuments.addChild(exportDocuments);
		exportDocuments.addChild(new TaxonomyNode("submit export documents"));
		exportDocuments.addChild(new TaxonomyNode("filling of export entries"));
		exportDocuments.addChild(new TaxonomyNode("export declaration"));
		/***
		 * END Taxonomy
		 */
		tax = importExportTaxonomy;
	}

	public static double levenshteinSim(String a, String b){
		if(a.equals("") && b.equals("")){
			return 1;
		}
		return 1 - ((double) StringUtils.getLevenshteinDistance(a, b)) / (Math.max(a.length(), b.length()));
	}

	public static double edgeSim(Edge a, Edge b){
		return (levenshteinSim(a.getDescription(), b.getDescription())) * 0.5
				* (nodeSim(a.getTail(), b.getTail()) + nodeSim(a.getHead(), b.getHead()));
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
				ret = tax.getSimilartiy(a.getDescription(), b.getDescription());
				//System.out.println("Node Sim: "+ ret + " (" + a.getDescription() + ", " + b.getDescription());
			}	
		}
		return ret;
	}
	


}
