package graph.sim;

public class Taxonomy {
	public static TaxonomyNode importExport;
	public static TaxonomyNode importExportEdges;
	public static TaxonomyNode orders;
	public static TaxonomyNode ordersEdges;
	public static TaxonomyNode accounting;
	public static TaxonomyNode accountingEdges;
	
	static {
		/**
		 * BEGIN Taxonomy for domain "Import/Export"
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
		
		/**
		 * Edge Taxonomy ImportExport
		 */
		TaxonomyNode importExportEdgeTaxonomy = new TaxonomyNode("import/exportEdges", 0);
		
		//Documents
		TaxonomyNode paymentCheck = new TaxonomyNode("documentCheck", 0);
		importExportEdgeTaxonomy.addChild(paymentCheck);
		
		TaxonomyNode paymentReq = new TaxonomyNode("paymentReq", 1);
		paymentCheck.addChild(paymentReq);
		paymentReq.addChild(new TaxonomyNode("Payment Required"));
		
		TaxonomyNode paymentNotReq = new TaxonomyNode("paymentNotReq", 1);
		paymentCheck.addChild(paymentNotReq);
		paymentNotReq.addChild(new TaxonomyNode("No Payment Required"));
		
		//Documents
		TaxonomyNode documentCheck = new TaxonomyNode("documentCheck", 0);
		importExportEdgeTaxonomy.addChild(documentCheck);
		
		TaxonomyNode documentCheckReq = new TaxonomyNode("docCheckYes", 1);
		documentCheck.addChild(documentCheckReq);
		documentCheckReq.addChild(new TaxonomyNode("Document CHK Required"));
		documentCheckReq.addChild(new TaxonomyNode("Check Required"));
		
		TaxonomyNode documentCheckNotReq = new TaxonomyNode("docCheckNo", 1);
		documentCheck.addChild(documentCheckNotReq);
		documentCheckNotReq.addChild(new TaxonomyNode("Document CHK Not Required"));
		documentCheckNotReq.addChild(new TaxonomyNode("Automatic Acceptance"));

		
		//Inspection
		TaxonomyNode inspectionDesicion = new TaxonomyNode("inspectionDesicion", 0);
		importExportEdgeTaxonomy.addChild(inspectionDesicion);
		
		TaxonomyNode inspectionDesicionPositive = new TaxonomyNode("inspectionYes", 1);
		inspectionDesicion.addChild(inspectionDesicionPositive);
		inspectionDesicionPositive.addChild(new TaxonomyNode("Inspection Required"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Risky"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Problem Foud"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Suspect"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Physical  Inspection  Required"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Discrepacy found"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Inspection  Required"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Red check"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Inspoection Required"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Problems Found"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Testimony not accepted"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Sampling required"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Violative"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Violative re-sampling"));
		inspectionDesicionPositive.addChild(new TaxonomyNode("Unsuccessful  recontioning"));
		
		TaxonomyNode inspectionDesicionNegative = new TaxonomyNode("inspectionNo", 1);
		inspectionDesicion.addChild(inspectionDesicionNegative);
		inspectionDesicionNegative.addChild(new TaxonomyNode("not required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Inspection Not Required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("InspectionNot Required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Risk"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Problems found"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Suspect"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Physical Inspection not required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Discrepacy found"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Priority Channel"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Green Check"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Risky"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("No Inspection Required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Passable"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Sampling not required"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Testimony accepted"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Passable re-sampling"));
		inspectionDesicionNegative.addChild(new TaxonomyNode("Successful Reconditioning"));
		
		importExportEdges = importExportEdgeTaxonomy;
		/***
		 * END Taxonomy
		 */
		importExport = importExportTaxonomy;
	}
	
	static {
		/**
		 * BEGIN Taxonomy for domain "Orders"
		 */
		TaxonomyNode ordersTaxonomy = new TaxonomyNode("orders", 0);
		
		//Finishing
		TaxonomyNode finishOrder = new TaxonomyNode("finishOrder", 0.1);
		ordersTaxonomy.addChild(finishOrder);
		finishOrder.addChild(new TaxonomyNode("Finish process"));
		finishOrder.addChild(new TaxonomyNode("Close"));
		
		//Customer
		TaxonomyNode customer = new TaxonomyNode("customer", 0.1);
		ordersTaxonomy.addChild(customer);
		customer.addChild(new TaxonomyNode("Returning Customer"));
		
		TaxonomyNode customerInform = new TaxonomyNode("customerInform", 0.1);
		customer.addChild(customerInform);
		customerInform.addChild(new TaxonomyNode("Inform Customer"));

		TaxonomyNode customerType = new TaxonomyNode("customerType", 0.1);
		customer.addChild(customerType);
		customerType.addChild(new TaxonomyNode("Individual"));
		customerType.addChild(new TaxonomyNode("Educational"));
		customerType.addChild(new TaxonomyNode("Businesses "));
		
		//Checks
		TaxonomyNode checks = new TaxonomyNode("checks", 0.1);
		ordersTaxonomy.addChild(checks);
		checks.addChild(new TaxonomyNode("Inspect goods"));
		checks.addChild(new TaxonomyNode("Check sertificates"));
		checks.addChild(new TaxonomyNode("checked for completeness"));
		checks.addChild(new TaxonomyNode("check items "));
		
		//Search/Evaluation
		TaxonomyNode searchEval = new TaxonomyNode("searchEval", 0.1);
		ordersTaxonomy.addChild(searchEval);
		searchEval.addChild(new TaxonomyNode("Skip"));
		
		TaxonomyNode searchEvalFind = new TaxonomyNode("searchEvalFind", 1);
		searchEval.addChild(searchEvalFind);
		searchEvalFind.addChild(new TaxonomyNode("Find a service"));
		searchEvalFind.addChild(new TaxonomyNode("Internet Serach"));
		searchEvalFind.addChild(new TaxonomyNode("Start evaluation process"));
		
		//Shopping Cart
		TaxonomyNode shoppingCart = new TaxonomyNode("shoppingCart", 0.1);
		ordersTaxonomy.addChild(shoppingCart);
		shoppingCart.addChild(new TaxonomyNode("View Cart"));
		
		TaxonomyNode shoppingCartAdd = new TaxonomyNode("shoppingCartAdd", 1);
		shoppingCart.addChild(shoppingCartAdd);
		shoppingCartAdd.addChild(new TaxonomyNode("Add Product"));
		shoppingCartAdd.addChild(new TaxonomyNode("Add/Remove Items"));
		shoppingCartAdd.addChild(new TaxonomyNode("Add to waiting list"));
		
		TaxonomyNode shoppingCartCheckout = new TaxonomyNode("shoppingCartCheckout", 1);
		shoppingCart.addChild(shoppingCartCheckout);
		shoppingCartCheckout.addChild(new TaxonomyNode("Checkout"));
		shoppingCartCheckout.addChild(new TaxonomyNode("Proceed to Checkout"));
		shoppingCartCheckout.addChild(new TaxonomyNode("Checkout book"));
		
		TaxonomyNode shoppingCartContinue = new TaxonomyNode("shoppingCartContinue", 1);
		shoppingCart.addChild(shoppingCartContinue);
		shoppingCartContinue.addChild(new TaxonomyNode("Continue Shopping"));
		
		//Availability
		TaxonomyNode availability = new TaxonomyNode("availability", 0.1);
		ordersTaxonomy.addChild(availability);
		availability.addChild(new TaxonomyNode("Change reputation"));
		
		TaxonomyNode unavailable = new TaxonomyNode("unavailable", 1);
		availability.addChild(unavailable);
		unavailable.addChild(new TaxonomyNode("Send Status and Reason for un-availability"));
		unavailable.addChild(new TaxonomyNode("Unavailable"));
		unavailable.addChild(new TaxonomyNode("product not in stock"));
		
		TaxonomyNode available = new TaxonomyNode("available", 1);
		availability.addChild(available);
		available.addChild(new TaxonomyNode("Available"));
		available.addChild(new TaxonomyNode("product in stock"));
		available.addChild(new TaxonomyNode("Book Available"));
		available.addChild(new TaxonomyNode("Send Status of Availability"));

		TaxonomyNode availabilityCheck = new TaxonomyNode("availabilityCheck", 1);
		availability.addChild(availabilityCheck);
		availabilityCheck.addChild(new TaxonomyNode("Check availability"));
		availabilityCheck.addChild(new TaxonomyNode("Check stock availability"));
		availabilityCheck.addChild(new TaxonomyNode("Get Book Status"));
		
		//Feedback
		TaxonomyNode feedback = new TaxonomyNode("feedback", 0.1);
		ordersTaxonomy.addChild(feedback);
		feedback.addChild(new TaxonomyNode("Change reputation"));
		feedback.addChild(new TaxonomyNode("Create a new \"reputation entity\""));
		feedback.addChild(new TaxonomyNode("Give feedback"));
		
		TaxonomyNode feedbackCheck = new TaxonomyNode("feedbackCheck", 1);
		feedback.addChild(feedbackCheck);
		feedbackCheck.addChild(new TaxonomyNode("Check service reputation"));
		
		TaxonomyNode feedbackBad = new TaxonomyNode("feedbackBad", 1);
		feedback.addChild(feedbackBad);
		feedbackBad.addChild(new TaxonomyNode("Bad"));
		
		TaxonomyNode feedbackGood = new TaxonomyNode("feedbackGood", 1);
		feedback.addChild(feedbackGood);
		feedbackGood.addChild(new TaxonomyNode("Good"));
		
		TaxonomyNode feedbackNoInfo = new TaxonomyNode("feedbackNoInfo", 1);
		feedback.addChild(feedbackNoInfo);
		feedbackNoInfo.addChild(new TaxonomyNode("No information"));
		
		//buying desicion
		TaxonomyNode buying = new TaxonomyNode("buying", 0.2);
		ordersTaxonomy.addChild(buying);
		buying.addChild(new TaxonomyNode("Validate Supplies"));
		
		TaxonomyNode buyingYes = new TaxonomyNode("buyingYes", 1);
		buying.addChild(buyingYes);
		buyingYes.addChild(new TaxonomyNode("Buy"));
		buyingYes.addChild(new TaxonomyNode("Buy anyway"));
		buyingYes.addChild(new TaxonomyNode("yes"));
		buyingYes.addChild(new TaxonomyNode("Reserve products"));
		buyingYes.addChild(new TaxonomyNode("Book on loan"));
		buyingYes.addChild(new TaxonomyNode("Select service"));

		TaxonomyNode buyingNo = new TaxonomyNode("buyingYes", 1);
		buying.addChild(buyingNo);
		buyingNo.addChild(new TaxonomyNode("Don't buy"));
		buyingNo.addChild(new TaxonomyNode("no"));
		
		//procurement
		TaxonomyNode procurement= new TaxonomyNode("procurement", 0.1);
		ordersTaxonomy.addChild(procurement);
		procurement.addChild(new TaxonomyNode("Validate Supplies"));
		
		TaxonomyNode procurementRemove = new TaxonomyNode("procurementRemove", 1);
		procurement.addChild(procurementRemove);
		procurementRemove.addChild(new TaxonomyNode("Remove article from catalogue"));
		procurementRemove.addChild(new TaxonomyNode("Update manufacturing plan"));
		
		TaxonomyNode procurementList = new TaxonomyNode("procurementList", 1);
		procurement.addChild(procurementList);
		procurementList.addChild(new TaxonomyNode("Access suppliers file"));
		procurementList.addChild(new TaxonomyNode("Merge the list by supplier"));
		
		TaxonomyNode procurementReceive = new TaxonomyNode("procurementReceive", 1);
		procurement.addChild(procurementReceive);
		procurementReceive.addChild(new TaxonomyNode("Receive goods"));
		
		TaxonomyNode procurementProcure = new TaxonomyNode("procurementProcure", 1);
		procurement.addChild(procurementProcure);
		procurementProcure.addChild(new TaxonomyNode("Order Supplies"));
		procurementProcure.addChild(new TaxonomyNode("Place the order with the supplier"));
		procurementProcure.addChild(new TaxonomyNode("Procurement"));
		procurementProcure.addChild(new TaxonomyNode("procure item"));
		procurementProcure.addChild(new TaxonomyNode("Procure Items"));
		procurementProcure.addChild(new TaxonomyNode("Get good(s)"));
		procurementProcure.addChild(new TaxonomyNode("Procure"));
		procurementProcure.addChild(new TaxonomyNode("Retrieve product from warehouse"));
		
		//Order Process
		TaxonomyNode orderProcess = new TaxonomyNode("orderProcess", 0.1);
		ordersTaxonomy.addChild(orderProcess);
		orderProcess.addChild(new TaxonomyNode("Archive order"));
		orderProcess.addChild(new TaxonomyNode("scanned into computer"));
		orderProcess.addChild(new TaxonomyNode("Records Stored Electronically"));
		
		TaxonomyNode orderProcessSummary = new TaxonomyNode("orderProcessSummary", 1);
		orderProcess.addChild(orderProcessSummary);
		orderProcessSummary.addChild(new TaxonomyNode("Consolidate Orders"));
		orderProcessSummary.addChild(new TaxonomyNode("Generate Order summary"));
		
		TaxonomyNode orderProcessPlace = new TaxonomyNode("orderProcessPlace", 1);
		orderProcess.addChild(orderProcessPlace);
		orderProcessPlace.addChild(new TaxonomyNode("Place Order"));
		orderProcessPlace.addChild(new TaxonomyNode("Create Purchase Order Request"));
		orderProcessPlace.addChild(new TaxonomyNode("Anonymous purchase of product"));
		orderProcessPlace.addChild(new TaxonomyNode("Prepare purchase request"));
		orderProcessPlace.addChild(new TaxonomyNode("Return to service and finalize order"));
		
		TaxonomyNode orderProcessChange = new TaxonomyNode("orderProcessChange", 1);
		orderProcess.addChild(orderProcessChange);
		orderProcessChange.addChild(new TaxonomyNode("Revise Order"));
		orderProcessChange.addChild(new TaxonomyNode("Change Quantities "));
		orderProcessChange.addChild(new TaxonomyNode("Change Quantities"));
		orderProcessChange.addChild(new TaxonomyNode("Accept hold"));
		
		TaxonomyNode orderProcessDelete = new TaxonomyNode("orderProcessDelete", 1);
		orderProcess.addChild(orderProcessDelete);
		orderProcessDelete.addChild(new TaxonomyNode("Delete Order"));
		orderProcessDelete.addChild(new TaxonomyNode("Cancel Request"));
		
		TaxonomyNode orderProcessAccept = new TaxonomyNode("orderProcessAccept", 1);
		orderProcess.addChild(orderProcessAccept);
		orderProcessAccept.addChild(new TaxonomyNode("Accept Order"));
		orderProcessAccept.addChild(new TaxonomyNode("Receive Book Request"));
		
		TaxonomyNode orderProcessReject = new TaxonomyNode("orderProcessReject", 1);
		orderProcess.addChild(orderProcessReject);
		orderProcessReject.addChild(new TaxonomyNode("Reject order"));
		orderProcessReject.addChild(new TaxonomyNode("Reject"));
		
		TaxonomyNode orderProcessValidate = new TaxonomyNode("orderProcessValidate", 1);
		orderProcess.addChild(orderProcessValidate);
		orderProcessValidate.addChild(new TaxonomyNode("Analyze Order"));
		orderProcessValidate.addChild(new TaxonomyNode("Validate Order"));
		orderProcessValidate.addChild(new TaxonomyNode("Review Order"));
		orderProcessValidate.addChild(new TaxonomyNode("Analyze Purchase Order Request"));
		
		TaxonomyNode orderProcessConfirm = new TaxonomyNode("orderProcessConfirm", 1);
		orderProcess.addChild(orderProcessConfirm);
		orderProcessConfirm.addChild(new TaxonomyNode("Confirm Order"));
		orderProcessConfirm.addChild(new TaxonomyNode("Confirm Product Order (based on availability and time frame)"));
		
		//Payment
		TaxonomyNode payment = new TaxonomyNode("payment", 0.1);
		ordersTaxonomy.addChild(payment);
		payment.addChild(new TaxonomyNode("Coupon"));
		
		TaxonomyNode paymentCreditCard = new TaxonomyNode("paymentCreditCard", 0.2);
		payment.addChild(paymentCreditCard);
		paymentCreditCard.addChild(new TaxonomyNode("Check credit card"));
		
		TaxonomyNode paymentCreditCardAccept = new TaxonomyNode("paymentCreditCardAccept", 1);
		paymentCreditCard.addChild(paymentCreditCardAccept);
		paymentCreditCardAccept.addChild(new TaxonomyNode("Accept credit card"));
		
		TaxonomyNode paymentCreditCardSelect = new TaxonomyNode("paymentCreditCardSelect", 1);
		paymentCreditCard.addChild(paymentCreditCardSelect);
		paymentCreditCardSelect.addChild(new TaxonomyNode("Select Existing Card"));
		paymentCreditCardSelect.addChild(new TaxonomyNode("Add New Card"));
		
		TaxonomyNode paymentCreditCardCheck = new TaxonomyNode("paymentCreditCardCheck", 1);
		paymentCreditCard.addChild(paymentCreditCardCheck);
		paymentCreditCardCheck.addChild(new TaxonomyNode("Check credit card"));
		paymentCreditCardCheck.addChild(new TaxonomyNode("Check credit rating"));
		paymentCreditCardCheck.addChild(new TaxonomyNode("Perform Credit Check"));
		
		TaxonomyNode paymentInvoice = new TaxonomyNode("paymentInvoice", 1);
		payment.addChild(paymentInvoice);
		paymentInvoice.addChild(new TaxonomyNode("Send invoice"));
		paymentInvoice.addChild(new TaxonomyNode("Emit invoice"));
		
		TaxonomyNode paymentTransaction = new TaxonomyNode("paymentTransaction", 0.2);
		payment.addChild(paymentTransaction);
		paymentTransaction.addChild(new TaxonomyNode("Rollback transaction"));
		
		TaxonomyNode transactionCheck = new TaxonomyNode("transactionCheck", 1);
		paymentTransaction.addChild(transactionCheck);
		transactionCheck.addChild(new TaxonomyNode("Check if payment received"));
		transactionCheck.addChild(new TaxonomyNode("Check balance"));
		transactionCheck.addChild(new TaxonomyNode("Check account validity (payment ok etc.)"));
		
		TaxonomyNode transactionRecieve = new TaxonomyNode("transactionRecieve", 1);
		paymentTransaction.addChild(transactionRecieve);
		transactionRecieve.addChild(new TaxonomyNode("Receive payment"));
		transactionRecieve.addChild(new TaxonomyNode("recieve payment "));
		transactionRecieve.addChild(new TaxonomyNode("Confirm payment"));
		transactionRecieve.addChild(new TaxonomyNode("Payment Made"));
		
		TaxonomyNode transactionSend = new TaxonomyNode("transactionSend", 1);
		paymentTransaction.addChild(transactionSend);
		transactionSend.addChild(new TaxonomyNode("Payment for service"));
		transactionSend.addChild(new TaxonomyNode("Payment Process"));
		transactionSend.addChild(new TaxonomyNode("Pay invoice"));
		transactionSend.addChild(new TaxonomyNode("Commit transaction"));
		transactionSend.addChild(new TaxonomyNode("Financial settlement"));
		
		TaxonomyNode paymentAdress = new TaxonomyNode("paymentAdress", 1);
		payment.addChild(paymentAdress);
		paymentAdress.addChild(new TaxonomyNode("Add Billing Address"));
		paymentAdress.addChild(new TaxonomyNode("Change Billing Address"));
		
		TaxonomyNode paymentMethod = new TaxonomyNode("paymentMethod", 1);
		payment.addChild(paymentMethod);
		paymentMethod.addChild(new TaxonomyNode("Select  Payment  Method "));
		paymentMethod.addChild(new TaxonomyNode("Change Payment Method"));
		paymentMethod.addChild(new TaxonomyNode("Choose payment method "));
		
		//Customer Account
		TaxonomyNode customerAccount = new TaxonomyNode("customerAccount", 0.1);
		ordersTaxonomy.addChild(customerAccount);
		
		TaxonomyNode accountCreation = new TaxonomyNode("accountCreation", 1);
		customerAccount.addChild(accountCreation);
		accountCreation.addChild(new TaxonomyNode("New user registration"));
		accountCreation.addChild(new TaxonomyNode("Create Account"));
		
		TaxonomyNode accountChange = new TaxonomyNode("accountChange", 1);
		customerAccount.addChild(accountChange);
		accountChange.addChild(new TaxonomyNode("Update Customer file"));
		
		TaxonomyNode accountLogin = new TaxonomyNode("accountLogin", 0.3);
		customerAccount.addChild(accountLogin);
		accountLogin.addChild(new TaxonomyNode("Sign In"));
		accountLogin.addChild(new TaxonomyNode("Existing user login"));
		accountLogin.addChild(new TaxonomyNode("Login"));
		accountLogin.addChild(new TaxonomyNode("Log in"));
		accountLogin.addChild(new TaxonomyNode("Login to Trepaid"));
		accountLogin.addChild(new TaxonomyNode("Enter username and password"));
		
		TaxonomyNode accountLoginAccept = new TaxonomyNode("accountLoginAccept", 1);
		accountLogin.addChild(accountLoginAccept);
		accountLoginAccept.addChild(new TaxonomyNode("user accept"));
		accountLoginAccept.addChild(new TaxonomyNode("Accept user credentials"));
		
		TaxonomyNode accountLoginDeny = new TaxonomyNode("accountLoginDeny", 1);
		accountLogin.addChild(accountLoginDeny);
		accountLoginDeny.addChild(new TaxonomyNode("Decline user credentials"));
		accountLoginDeny.addChild(new TaxonomyNode("user reject"));
		accountLoginDeny.addChild(new TaxonomyNode("Password Assistance"));
		
		//Shipping
		TaxonomyNode shipping = new TaxonomyNode("shipping", 0.1);
		ordersTaxonomy.addChild(shipping);
		shipping.addChild(new TaxonomyNode("Calculate & Enter Shipping Details"));
		
		TaxonomyNode shippingStart = new TaxonomyNode("shippingStart", 1);
		shipping.addChild(shippingStart);
		shippingStart.addChild(new TaxonomyNode("Ship product"));
		shippingStart.addChild(new TaxonomyNode("Arrange Shipment"));
		shippingStart.addChild(new TaxonomyNode("Ship article"));
		shippingStart.addChild(new TaxonomyNode("Send Order"));
		shippingStart.addChild(new TaxonomyNode("Send product"));
		shippingStart.addChild(new TaxonomyNode("send item "));
		shippingStart.addChild(new TaxonomyNode("Send service to client "));
		shippingStart.addChild(new TaxonomyNode("Send"));

		TaxonomyNode shippingAdress = new TaxonomyNode("shippingAdress", 0.3);
		shipping.addChild(shippingAdress);
		
		TaxonomyNode shippingAdressGet = new TaxonomyNode("shippingAdress", 1);
		shippingAdress.addChild(shippingAdressGet);
		shippingAdressGet.addChild(new TaxonomyNode("Get shipment address"));
		
		TaxonomyNode shippingAdressManagement = new TaxonomyNode("shippingAdressManagement", 0.8);
		shippingAdress.addChild(shippingAdressManagement);
		
		TaxonomyNode shippingAdressAdd = new TaxonomyNode("shippingAdressAdd", 1);
		shippingAdressManagement.addChild(shippingAdressAdd);
		shippingAdressAdd.addChild(new TaxonomyNode("Add  Shipping  Address"));
		shippingAdressAdd.addChild(new TaxonomyNode("Add New Shipping Address"));
		
		TaxonomyNode shippingAdressSelect = new TaxonomyNode("shippingAdressSelect", 1);
		shippingAdressManagement.addChild(shippingAdressSelect);
		shippingAdressSelect.addChild(new TaxonomyNode("Edit Ship to Address"));
		shippingAdressSelect.addChild(new TaxonomyNode("Choose Shipping Address"));
		shippingAdressSelect.addChild(new TaxonomyNode("Change Shipping Address"));
		shippingAdressSelect.addChild(new TaxonomyNode("Select Ship to Address"));
		
		TaxonomyNode shippingPriority = new TaxonomyNode("shippingPriority", 1);
		shipping.addChild(shippingPriority);
		shippingPriority.addChild(new TaxonomyNode("Expedited Shipping"));
		shippingPriority.addChild(new TaxonomyNode("Standard Shipping"));
		shippingPriority.addChild(new TaxonomyNode("Priority Shipping"));
		/***
		 * END Taxonomy
		 */
		orders = ordersTaxonomy;
		
		/**
		 * Edge Taxonomy ImportExport
		 */
		TaxonomyNode ordersEdgeTaxonomy = new TaxonomyNode("import/exportEdges", 0);
		
		//availability
		TaxonomyNode availability1 = new TaxonomyNode("availability", 0);
		ordersEdgeTaxonomy.addChild(availability1);
		availability1.addChild(new TaxonomyNode("Check availability"));
		
		TaxonomyNode availabilityYes = new TaxonomyNode("availabilityYes", 0);
		availability1.addChild(availability1);
		availabilityYes.addChild(new TaxonomyNode("Yes"));
		
		TaxonomyNode availabilityNo = new TaxonomyNode("availabilityNo", 0);
		availability1.addChild(availability1);
		availabilityNo.addChild(new TaxonomyNode("No"));
		
		//procurement
		TaxonomyNode procurement1 = new TaxonomyNode("procurement", 0);
		ordersEdgeTaxonomy.addChild(procurement1);
		procurement1.addChild(new TaxonomyNode("Procure"));
		
		//payments
		TaxonomyNode payments = new TaxonomyNode("payments", 0);
		ordersEdgeTaxonomy.addChild(payments);
		
		TaxonomyNode paymentSend = new TaxonomyNode("paymentSend", 1);
		payments.addChild(paymentSend);
		paymentSend.addChild(new TaxonomyNode("Send"));

		
		/***
		 * END Taxonomy
		 */
		ordersEdges = ordersEdgeTaxonomy;
	}
	
	static {
		/**
		 * BEGIN Taxonomy for domain "Accounting"
		 */
		TaxonomyNode accountingTaxonomy = new TaxonomyNode("accounting", 0);
		
		//SAP
		TaxonomyNode sap = new TaxonomyNode("sap", 0.1);
		accountingTaxonomy.addChild(sap);
		
		TaxonomyNode sapLookup = new TaxonomyNode("sapLookup", 1);
		sap.addChild(sapLookup);
		sapLookup.addChild(new TaxonomyNode("Lookup SAP Vendor Number"));
		sapLookup.addChild(new TaxonomyNode("Locate vendor in SAP system"));
		
		TaxonomyNode sapLogin = new TaxonomyNode("sapLogin", 1);
		sap.addChild(sapLogin);
		sapLogin.addChild(new TaxonomyNode("Log in SAP"));
		sapLogin.addChild(new TaxonomyNode("Log on to SAP"));
		
		TaxonomyNode sapInvoice = new TaxonomyNode("sapInvoice", 1);
		sap.addChild(sapInvoice);
		sapInvoice.addChild(new TaxonomyNode("Enter invoices into  SAP system"));
		sapInvoice.addChild(new TaxonomyNode("Enter Invoice Data in SAP"));
		sapInvoice.addChild(new TaxonomyNode("Enter invoice details in SAP"));
		
		//SLA
		TaxonomyNode sla = new TaxonomyNode("sla", 0.1);
		accountingTaxonomy.addChild(sla);
		
		TaxonomyNode slaStatus = new TaxonomyNode("slaStatus", 0.5);
		sla.addChild(slaStatus);
		slaStatus.addChild(new TaxonomyNode("Lookup SLA on Excel file"));
		
		TaxonomyNode slaStatusUnknown = new TaxonomyNode("slaStatusUnknown", 1);
		slaStatus.addChild(slaStatusUnknown);
		slaStatusUnknown.addChild(new TaxonomyNode("SLA Unknown"));
		
		TaxonomyNode slaStatusKnown = new TaxonomyNode("slaStatusKnown", 1);
		slaStatus.addChild(slaStatusKnown);
		slaStatusKnown.addChild(new TaxonomyNode("SLA Known"));
		
		TaxonomyNode slaCheck = new TaxonomyNode("slaCheck", 1);
		sla.addChild(slaCheck);
		slaCheck.addChild(new TaxonomyNode("Lookup SLA on Excel file"));
		slaCheck.addChild(new TaxonomyNode("Lookup SLA"));
		slaCheck.addChild(new TaxonomyNode("Check SLA Arrangements in Excel "));
		slaCheck.addChild(new TaxonomyNode("check if SLA is known?"));
		
		//Checks/Comparisons
		TaxonomyNode checks = new TaxonomyNode("checks", 0.1);
		accountingTaxonomy.addChild(checks);
		checks.addChild(new TaxonomyNode("check if invoice is urgent"));
		
		TaxonomyNode checksReports = new TaxonomyNode("checksReports", 1);
		checks.addChild(checksReports);
		checksReports.addChild(new TaxonomyNode("Compare report to actual invoice "));
		checksReports.addChild(new TaxonomyNode("Compare report with paper invoice"));
		checksReports.addChild(new TaxonomyNode("Compare Report"));
		checksReports.addChild(new TaxonomyNode("Compare Report Information with Invoice "));
		checksReports.addChild(new TaxonomyNode("Compare Paper Invoice With Entered Invoice"));
		checksReports.addChild(new TaxonomyNode("Compares the details in report with the actual paper invoice "));

		TaxonomyNode checksInvoice = new TaxonomyNode("checksInvoice", 0.8);
		checks.addChild(checksInvoice);
		checksInvoice.addChild(new TaxonomyNode("Check Invoice for Errors"));
		checksInvoice.addChild(new TaxonomyNode("Inspection"));
		
		TaxonomyNode checksInvoiceCorrectness = new TaxonomyNode("checksInvoiceCorrectness", 1);
		checksInvoice.addChild(checksInvoiceCorrectness);
		checksInvoiceCorrectness.addChild(new TaxonomyNode("Check Invoice Entered Correctly on Invoice Entry Form"));
		checksInvoiceCorrectness.addChild(new TaxonomyNode("Check invoice data for errors"));
		checksInvoiceCorrectness.addChild(new TaxonomyNode("Check For Compliance"));
		
		TaxonomyNode checksInvoiceCompleteness = new TaxonomyNode("checksInvoiceCompleteness", 1);
		checksInvoice.addChild(checksInvoiceCompleteness);
		checksInvoiceCompleteness.addChild(new TaxonomyNode("Check Invoice for  Completeness"));
		checksInvoiceCompleteness.addChild(new TaxonomyNode("Check Invoice Completeness"));
		checksInvoiceCompleteness.addChild(new TaxonomyNode("Check completeness"));
		checksInvoiceCompleteness.addChild(new TaxonomyNode("Check invoice completeness"));
		checksInvoiceCompleteness.addChild(new TaxonomyNode("check invoice completeness "));
		checksInvoiceCompleteness.addChild(new TaxonomyNode("Check for Invoice Completeness"));
		
		//Reporting
		TaxonomyNode report = new TaxonomyNode("report", 0.1);
		accountingTaxonomy.addChild(report);
		report.addChild(new TaxonomyNode("Keep performance record of DEO"));
		
		TaxonomyNode reportPrint = new TaxonomyNode("reportPrint", 1);
		report.addChild(reportPrint);
		reportPrint.addChild(new TaxonomyNode("Print report "));
		reportPrint.addChild(new TaxonomyNode("Print report"));
		reportPrint.addChild(new TaxonomyNode("Print a report of invoices entered"));
		reportPrint.addChild(new TaxonomyNode("Print Report - All Recently Entered Invoices by Client"));
		reportPrint.addChild(new TaxonomyNode("Print Report With Invoices For Client"));
		reportPrint.addChild(new TaxonomyNode("Prints a report with all invoices that recently entered for client "));
		
		//Vendor
		TaxonomyNode vendor = new TaxonomyNode("vendor", 0.1);
		accountingTaxonomy.addChild(vendor);
		vendor.addChild(new TaxonomyNode("Create Vendor Master Record Request"));
		
		TaxonomyNode vendorNotFound = new TaxonomyNode("vendorNotFound", 0.1);
		vendor.addChild(vendorNotFound);
		vendorNotFound.addChild(new TaxonomyNode("Vendor # Does Not Exist"));
		vendorNotFound.addChild(new TaxonomyNode("Vendor not found"));
		
		TaxonomyNode vendorFound = new TaxonomyNode("vendorFound", 0.1);
		vendor.addChild(vendorFound);
		vendorFound.addChild(new TaxonomyNode("Vendor # Exists"));
		vendorFound.addChild(new TaxonomyNode("Vendor found"));
		
		//Invoices
		TaxonomyNode invoice = new TaxonomyNode("invoice", 0.1);
		accountingTaxonomy.addChild(invoice);
		invoice.addChild(new TaxonomyNode("put Red Stamp on invoice"));
		
		TaxonomyNode invoiceBatch = new TaxonomyNode("invoiceBatch", 0.2);
		invoice.addChild(invoiceBatch);
		invoiceBatch.addChild(new TaxonomyNode("Select a batch of invoice"));
		
		TaxonomyNode invoiceBatchFinish = new TaxonomyNode("invoiceBatchFinish", 1);
		invoiceBatch.addChild(invoiceBatchFinish);
		invoiceBatchFinish.addChild(new TaxonomyNode("Finish batch"));
		invoiceBatchFinish.addChild(new TaxonomyNode("End of each batch processed"));
		
		TaxonomyNode invoiceBatchSort = new TaxonomyNode("invoiceBatchSort", 0.4);
		invoiceBatch.addChild(invoiceBatchSort);
		invoiceBatchSort.addChild(new TaxonomyNode("Allocate In Separate Batches"));
		
		TaxonomyNode invoiceBatchSortHigh = new TaxonomyNode("invoiceBatchSortHigh", 1);
		invoiceBatchSort.addChild(invoiceBatchSortHigh);
		invoiceBatchSort.addChild(new TaxonomyNode("Place in batch >= $2500"));
		invoiceBatchSort.addChild(new TaxonomyNode(">=$2500"));
		
		TaxonomyNode invoiceBatchSortLow = new TaxonomyNode("invoiceBatchSortLow", 1);
		invoiceBatchSort.addChild(invoiceBatchSortLow);
		invoiceBatchSortLow.addChild(new TaxonomyNode("Place in batch <$2500"));
		invoiceBatchSortLow.addChild(new TaxonomyNode("< $2500"));
		
		TaxonomyNode invoiceDelay = new TaxonomyNode("invoiceDelay", 0.4);
		invoice.addChild(invoiceDelay);
		invoiceDelay.addChild(new TaxonomyNode("Inspect For Previous Delays"));
		
		TaxonomyNode invoiceDelayDelayed = new TaxonomyNode("invoiceDelayDelayed", 1);
		invoiceDelay.addChild(invoiceDelayDelayed);
		invoiceDelayDelayed.addChild(new TaxonomyNode("Delayed"));
		
		TaxonomyNode invoiceDelayNotDelayed = new TaxonomyNode("invoiceDelayNotDelayed", 1);
		invoiceDelay.addChild(invoiceDelayNotDelayed);
		invoiceDelayNotDelayed.addChild(new TaxonomyNode("Not Delayed"));
		
		TaxonomyNode invoicePriority = new TaxonomyNode("invoicePriority", 1);
		invoice.addChild(invoicePriority);
		invoicePriority.addChild(new TaxonomyNode("Highlight As Urgent"));
		invoicePriority.addChild(new TaxonomyNode("Prioritise urgent invoices "));
		invoicePriority.addChild(new TaxonomyNode("Highlight As Urgent"));
		
		TaxonomyNode invoiceTransport = new TaxonomyNode("invoiceTransport", 0.2);
		invoice.addChild(invoiceTransport);
		invoiceTransport.addChild(new TaxonomyNode(""));
		
		TaxonomyNode invoiceTransportReceive = new TaxonomyNode("invoiceTransportReceive", 1);
		invoiceTransport.addChild(invoiceTransportReceive);
		invoiceTransportReceive.addChild(new TaxonomyNode("Received From Master Data Entry Department"));
		invoiceTransportReceive.addChild(new TaxonomyNode("Received From Admin Officer"));
		invoiceTransportReceive.addChild(new TaxonomyNode("Get invoices from outbox"));
		invoiceTransportReceive.addChild(new TaxonomyNode("Open and categories Invoices"));
		invoiceTransportReceive.addChild(new TaxonomyNode("Obtain invoices from outbox "));
		
		TaxonomyNode invoiceTransportSend = new TaxonomyNode("invoiceTransportSend", 0.6);
		invoiceTransport.addChild(invoiceTransportSend);
		
		TaxonomyNode invoiceTransportSendtoOfficer = new TaxonomyNode("invoiceTransportSendtoOfficer", 1);
		invoiceTransportSend.addChild(invoiceTransportSendtoOfficer);
		invoiceTransportSendtoOfficer.addChild(new TaxonomyNode("Send form back to Data Entry Officer"));
		invoiceTransportSendtoOfficer.addChild(new TaxonomyNode("Return invoice to data entry officer "));
		invoiceTransportSendtoOfficer.addChild(new TaxonomyNode("Send back to data entry officer"));
		
		TaxonomyNode invoiceTransportSendtoReg = new TaxonomyNode("invoiceTransportSendtoReg", 1);
		invoiceTransportSend.addChild(invoiceTransportSendtoReg);
		invoiceTransportSendtoReg.addChild(new TaxonomyNode("Send Invoice to Registery"));
		invoiceTransportSendtoReg.addChild(new TaxonomyNode("Forward Invoice to Registry"));
		
		TaxonomyNode invoiceEntryform = new TaxonomyNode("invoiceEntryform", 0.2);
		invoice.addChild(invoiceEntryform);
		
		TaxonomyNode invoiceEntryformFillout = new TaxonomyNode("invoiceEntryformFillout", 0.6);
		invoiceEntryform.addChild(invoiceEntryformFillout);
		invoiceEntryformFillout.addChild(new TaxonomyNode("Enter details"));
		invoiceEntryformFillout.addChild(new TaxonomyNode("Enter Invoice"));
		invoiceEntryformFillout.addChild(new TaxonomyNode("Fill in invoice entry form"));
		invoiceEntryformFillout.addChild(new TaxonomyNode("fill out invoice entry form"));
		invoiceEntryformFillout.addChild(new TaxonomyNode("Fill Invoice Entry Form"));
		
		TaxonomyNode invoiceEntryformFilloutVendor = new TaxonomyNode("invoiceEntryformFilloutVendor", 1);
		invoiceEntryform.addChild(invoiceEntryformFilloutVendor);
		invoiceEntryformFilloutVendor.addChild(new TaxonomyNode("Add SAP Vendor# to Invoice Entry Form"));
		invoiceEntryformFilloutVendor.addChild(new TaxonomyNode("Add SAP Vendor number to invoice"));
		invoiceEntryformFilloutVendor.addChild(new TaxonomyNode("Add Vendor # to Invoice Entry Form"));
		
		TaxonomyNode invoiceEntryformFilloutDeadline = new TaxonomyNode("invoiceEntryformFilloutDeadline", 1);
		invoiceEntryform.addChild(invoiceEntryformFilloutDeadline);
		invoiceEntryformFilloutDeadline.addChild(new TaxonomyNode("enter processing deadline date on IEF"));
		invoiceEntryformFilloutDeadline.addChild(new TaxonomyNode("Enter Deadline According to SLA"));
		
		TaxonomyNode invoiceEntryformFilloutDate = new TaxonomyNode("invoiceEntryformFilloutDate", 1);
		invoiceEntryform.addChild(invoiceEntryformFilloutDate);
		invoiceEntryformFilloutDate.addChild(new TaxonomyNode("Enter invoicing processing date"));
		
		TaxonomyNode invoiceEntryformAttach = new TaxonomyNode("invoiceEntryformAttach", 1);
		invoiceEntryform.addChild(invoiceEntryformAttach);
		invoiceEntryformAttach.addChild(new TaxonomyNode("Attach Invoice Entry Form"));
		invoiceEntryformAttach.addChild(new TaxonomyNode("staple Invoices entry form "));
		invoiceEntryformAttach.addChild(new TaxonomyNode("Stable Erntry Form To Invoice"));
		invoiceEntryformAttach.addChild(new TaxonomyNode("Staple invoices entry form"));
		
		TaxonomyNode invoiceErrors = new TaxonomyNode("invoiceErrors", 0.2);
		invoice.addChild(invoiceErrors);
		
		TaxonomyNode invoiceErrorsRecord = new TaxonomyNode("invoiceErrorsRecord", 1);
		invoiceErrors.addChild(invoiceErrorsRecord);
		invoiceErrorsRecord.addChild(new TaxonomyNode("Record errors per data entry officer "));
		invoiceErrorsRecord.addChild(new TaxonomyNode("Record mistakes for  Data Entry Officer"));
		invoiceErrorsRecord.addChild(new TaxonomyNode("Record Number of Mistakes"));
		invoiceErrorsRecord.addChild(new TaxonomyNode("Record  number of mistakes"));
		
		TaxonomyNode invoiceErrorsStatus = new TaxonomyNode("invoiceErrorsStatus", 0.4);
		invoiceErrors.addChild(invoiceErrorsStatus);

		TaxonomyNode invoiceErorrsNoError = new TaxonomyNode("invoiceErorrsNoError", 1);
		invoiceErrorsStatus.addChild(invoiceErorrsNoError);
		invoiceErorrsNoError.addChild(new TaxonomyNode("No Data Entry Errors"));
		invoiceErorrsNoError.addChild(new TaxonomyNode("No Errors Found"));
		invoiceErorrsNoError.addChild(new TaxonomyNode("No Error Found"));
		
		TaxonomyNode invoiceErorrsError = new TaxonomyNode("invoiceStatusError", 1);
		invoiceErrorsStatus.addChild(invoiceErorrsError);
		invoiceErorrsError.addChild(new TaxonomyNode("Invoice Error"));
		invoiceErorrsError.addChild(new TaxonomyNode("Data Entry Errors"));
		invoiceErorrsError.addChild(new TaxonomyNode("Errors found"));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlight 'Has Error' Invoice Entry Form"));
		invoiceErorrsError.addChild(new TaxonomyNode("Data Entry Errors Found"));
		invoiceErorrsError.addChild(new TaxonomyNode("Error found"));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlights error on the invoice entry form "));
		invoiceErorrsError.addChild(new TaxonomyNode("Error Found"));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlight error"));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlight errors"));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlight error on invoice entry form"));
		invoiceErorrsError.addChild(new TaxonomyNode("Invoice \"Sparked\""));
		invoiceErorrsError.addChild(new TaxonomyNode("Highlight errors on invoice entry form"));
		
		TaxonomyNode invoiceStatus = new TaxonomyNode("invoiceStatus", 0.4);
		invoice.addChild(invoiceStatus);
		
		TaxonomyNode invoiceStatusComplete = new TaxonomyNode("invoiceStatusComplete", 1);
		invoiceStatus.addChild(invoiceStatusComplete);
		invoiceStatusComplete.addChild(new TaxonomyNode("Invoice Complete"));
		invoiceStatusComplete.addChild(new TaxonomyNode("Entry form completed"));
		invoiceStatusComplete.addChild(new TaxonomyNode("Invoice Is Complete"));
		
		TaxonomyNode invoiceStatusIncomplete = new TaxonomyNode("invoiceStatusIncomplete", 1);
		invoiceStatus.addChild(invoiceStatusIncomplete);
		invoiceStatusIncomplete.addChild(new TaxonomyNode("Invoice is Incomplete"));
		invoiceStatusIncomplete.addChild(new TaxonomyNode("incomplete invoice"));
		invoiceStatusIncomplete.addChild(new TaxonomyNode("Invoice incomplete"));
		invoiceStatusIncomplete.addChild(new TaxonomyNode("Invoice Not Complete"));
		invoiceStatusIncomplete.addChild(new TaxonomyNode("Complete Invoice Entry Form"));
		
		TaxonomyNode invoiceCheckoff = new TaxonomyNode("invoiceCheckoff", 0.5);
		invoice.addChild(invoiceCheckoff);
		invoiceCheckoff.addChild(new TaxonomyNode("Tick \"Invoice Entered\"Box"));
		invoiceCheckoff.addChild(new TaxonomyNode("Tag Invoice Entered on Invoice Entry Form"));
		
		TaxonomyNode invoiceCheckoffValidated = new TaxonomyNode("invoiceStatusCompleteValidated", 1);
		invoiceCheckoff.addChild(invoiceCheckoffValidated);
		invoiceCheckoffValidated.addChild(new TaxonomyNode("Change status to validated "));
		invoiceCheckoffValidated.addChild(new TaxonomyNode("Change Status of Invoice to 'Validated'"));
		invoiceCheckoffValidated.addChild(new TaxonomyNode("Mark invoice status as validated in SAP"));
		invoiceCheckoffValidated.addChild(new TaxonomyNode("Change Status To Validated in SAP"));
		invoiceCheckoffValidated.addChild(new TaxonomyNode("Change status to parked to validated"));
		
		TaxonomyNode invoiceCheckoffCompleteness = new TaxonomyNode("invoiceCheckoffCompleteness", 1);
		invoiceCheckoff.addChild(invoiceCheckoffCompleteness);
		invoiceCheckoffCompleteness.addChild(new TaxonomyNode("Tick complete Box"));
		invoiceCheckoffCompleteness.addChild(new TaxonomyNode("Tick invoice complete"));

		TaxonomyNode invoiceCheckoffCorrectness = new TaxonomyNode("invoiceCheckoffCorrectness", 1);
		invoiceCheckoff.addChild(invoiceCheckoffCorrectness);
		invoiceCheckoffCorrectness.addChild(new TaxonomyNode("Tick box \"invoice entered correctly\""));
		invoiceCheckoffCorrectness.addChild(new TaxonomyNode("Tick 'invoice entered correctly' box"));
		invoiceCheckoffCorrectness.addChild(new TaxonomyNode("Check The Box ?invoice entered correctly? on the Invoice Entry Form"));
		invoiceCheckoffCorrectness.addChild(new TaxonomyNode("Mark invoice as entered correctly"));
		invoiceCheckoffCorrectness.addChild(new TaxonomyNode("Invoice Correct"));
		
		TaxonomyNode invoiceSorting = new TaxonomyNode("invoiceSorting", 0.8);
		invoice.addChild(invoiceSorting);
		invoiceSorting.addChild(new TaxonomyNode("Sort Batch Containing Invoice"));
		
		TaxonomyNode invoiceSortingByVendor = new TaxonomyNode("invoiceSortingByVendor", 1);
		invoiceSorting.addChild(invoiceSortingByVendor);
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort Invoice Per Vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Re-sorting Invoices Per Vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort Invoice by Vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort invoices by vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sorting By Vendor Required"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort invoices per vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort invoice per vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Prefers sorting by vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort by Vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort Batch by Vendor"));
		invoiceSortingByVendor.addChild(new TaxonomyNode("Sort Batch Containing Invoice per Vendor"));
		
		TaxonomyNode invoiceSortingByClient = new TaxonomyNode("invoiceSortingByClient", 1);
		invoiceSorting.addChild(invoiceSortingByClient);
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort Invoices Per Client "));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort invoices by client "));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort invoice by client"));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort Invoices by Client"));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort invoices per client"));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort by per client"));
		invoiceSortingByClient.addChild(new TaxonomyNode("Sort Batch Containing Invoice per Client"));
		
		TaxonomyNode invoiceSortingByAmount = new TaxonomyNode("invoiceSortingByAmount", 1);
		invoiceSorting.addChild(invoiceSortingByAmount);
		invoiceSortingByAmount.addChild(new TaxonomyNode("Re-sorting By Invoice Amount"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sort By Price"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sort by Amount"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sorting By Price Required"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sort by highest amount"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sort invoice per amount"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Prefers sorting by amount"));
		invoiceSortingByAmount.addChild(new TaxonomyNode("Sort invoices by amount"));
		
		/***
		 * END Taxonomy
		 */
		accounting = accountingTaxonomy;
	}
}
