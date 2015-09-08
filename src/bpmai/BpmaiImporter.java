package bpmai;

import graph.Edge;
import graph.Node;
import graph.WorkflowGraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BpmaiImporter {
	final static boolean debug = false;
	//*rev?.json
	///Users/Max/Desktop/Uni/Forschungspraktikum/casebase/test/2011-05-26_Task3/193391552_rev1.json"
	public static ArrayList<WorkflowGraph> importModelsFrom(String dir){
		ArrayList<WorkflowGraph> repository = new ArrayList<>();
		Path directoryPath = Paths.get(dir);
		
		if (Files.isDirectory(directoryPath)) {
			//filter directory for models
		    try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, "*rev?.json")) {
		        for (Path path : stream) {
		        	System.out.println(path);
		        	WorkflowGraph g = convertToWorkflowGraph(importSingleModel(path.toString()));
		        	//add Filename
		        	g.file = path.getFileName().toString();
		        	
		        	repository.add(g);
		        }
		    } catch (IOException e) {
		        throw new RuntimeException(e);
		    }
		    //filter subdirectories
		    try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
		        for (Path path : stream) {
		        	if (Files.isDirectory(path)){
			        	repository.addAll(importModelsFrom(path.toString()));
		        	}
		        }
		    } catch (IOException e) {
		        throw new RuntimeException(e);
		    }
		}
		return repository;
	}
	
	public static ArrayList<WorkflowElement> importSingleModel(String path){
		ArrayList<WorkflowElement> elements = new ArrayList<>();
		Gson gson = new Gson();
		
        try {
            //FileInputStream input = new FileInputStream("/Users/Max/Desktop/Uni/Forschungspraktikum/casebase/test/2011-11-29_order abstraction/991991597_rev1.json");
        	FileInputStream input = new FileInputStream(path);
        	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
           
            //read file as JSON-Object
            JsonObject json = gson.fromJson(reader, JsonObject.class);
           
            //read elements as Array
            JsonArray model = json.getAsJsonArray("childShapes");

            //for every workflow element
            for(int i = 0; i < model.size(); i++){
                JsonObject element = model.get(i).getAsJsonObject();
                
                //BPMN-type
                JsonObject stencil = element.get("stencil").getAsJsonObject();
                String type = stencil.get("id").getAsString();
                
                //Read Pool
                if(type.equals("Pool")){
                	System.out.println("DEBUG");
                	JsonArray pool = element.getAsJsonArray("childShapes");
                	for(int j = 0; j < pool.size(); j ++){
                		JsonObject subElement = pool.get(j).getAsJsonObject();
                		
                		//BPMN-type
                        JsonObject stencilPool = subElement.get("stencil").getAsJsonObject();
                        String typePool = stencilPool.get("id").getAsString();
                        System.out.println("TEST: "+ typePool);
                        
                        //Read lane
                        if(typePool.equals("Lane")){
                        	JsonArray lane = subElement.getAsJsonArray("childShapes");
                        	for(int k = 0; k < lane.size(); k ++){
                        		JsonObject subSubElement = lane.get(k).getAsJsonObject();
                        		WorkflowElement laneWfe = readElement(subSubElement);
                        		if(laneWfe!= null){
                        			elements.add(laneWfe);
                        		}
                                JsonObject stencilLane = subSubElement.get("stencil").getAsJsonObject();
                                String typeLane = stencilLane.get("id").getAsString();
                                //System.out.println("TEST2: "+ typeLane);
                        	}
                        }
                		
                	}
				}

				WorkflowElement wfe = readElement(element);
				if (wfe != null) {
					elements.add(wfe);
				}

			}
            try {
				input.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return elements;
	}
	
	public static WorkflowElement readElement(JsonObject element){
		//BPMN-type
        JsonObject stencil = element.get("stencil").getAsJsonObject();
        String type = stencil.get("id").getAsString();
        
        //ID
        String id = element.get("resourceId").getAsString();
        
        //description
        JsonObject properties = element.get("properties").getAsJsonObject();
        String description;
        if(properties.get("name") != null){
            description = properties.get("name").getAsString();
            description = description.replaceAll("glossary://.*/", "");
            description = description.replaceAll(";", "");
            description = description.replaceAll("\n", " ");
        }
        else {
        	 description = "";
        }

        
        //debug
        if(debug){
            System.out.println("Element ID: " + id);
            System.out.println("Description: " + description);
            System.out.println("BPMN Type: " + type);
        }

       
       
        // read outgoing sequenceFlowIDs as Array
        ArrayList<String> outgoing = new ArrayList<>();
        JsonArray outgoingTo = element.get("outgoing").getAsJsonArray();
   
        for(int k = 0; k < outgoingTo.size(); k++){
        	//outgoing sequenceFlowID
            JsonObject out = outgoingTo.get(k).getAsJsonObject();
            String outTo = out.get("resourceId").getAsString();
            outgoing.add(outTo);
            
            //debug
            if(debug){
            	System.out.println("Outgoing to: " + outTo);
            }
        }
        if(debug){
        	System.out.println("------");
        }
        if(!type.equals("Pool")){
            return new WorkflowElement(id ,type ,description , outgoing);
        }
		return null;
	}
	
	public static WorkflowGraph convertToWorkflowGraph(ArrayList<WorkflowElement> elements){
		//create new empty workflow graph
		WorkflowGraph g = new WorkflowGraph();
		ArrayList<String> dropped = new ArrayList<String>();
		
		ArrayList<WorkflowElement> blockElements = elements.stream().filter(e -> !"SequenceFlow".equals(e.type)).collect(Collectors.toCollection(ArrayList::new));
		//Add Nodes
		for (WorkflowElement node : blockElements) {
			if(!node.type.equals("Pool")){
				if(!convertType(node).equals("drop")){
		            g.nodes.add(new Node(node.description, convertType(node), node.id));
				}
				else {
					dropped.add(node.id);
					System.err.println("Dropped: " + node.type + " Desc.: " + node.description);
				}
			}
        }
        //Add Edges
		ArrayList<WorkflowElement> sequenceFlowElements = elements.stream().filter(e -> "SequenceFlow".equals(e.type)).collect(Collectors.toCollection(ArrayList::new));
		for (WorkflowElement node : blockElements) {
			//if node has outgoing sequence flows
			if(!node.outgoing.isEmpty()){
				if(dropped.contains(node.id)){
					//Tail dropped -> do nothing
					System.err.println("Dropped Edge");
				}
				else {
					//get starting point of edge in workflow graph
					Node tail = g.nodes.stream().filter(e -> node.id.equals(e.getId())).limit(1).collect(Collectors.toList()).get(0);
					//for every outgoing SequenceFlow
					for(String outID: node.outgoing){
						//create edge and add to workflow graph
							try {
								WorkflowElement sequenceFlowElement = sequenceFlowElements.stream().filter(e -> outID.equals(e.id)).limit(1).collect(Collectors.toList()).get(0);
								Node head = g.nodes.stream().filter(e -> sequenceFlowElement.outgoing.get(0).equals(e.getId())).limit(1).collect(Collectors.toList()).get(0);
								g.edges.add(new Edge(sequenceFlowElement.description, sequenceFlowElement.id, tail, head));
								//debug
								if(debug){
									System.out.println("Adding Edge...");
									System.out.println("From: " + node.id +" (Destination: " + outID + ")");
									System.out.println("EdgeID: " + sequenceFlowElement.id +" (Destination: " + sequenceFlowElement.outgoing.get(0) + ")");
									System.out.println("To: " + head.getId());
								}
							}
							catch(IndexOutOfBoundsException e) {
								System.err.println("Ziel der ausgehenden Kante nicht gefunden");
								System.err.println("Tail:: type: " + tail.getBpmnType() + "  Description: " + tail.getDescription());
								//System.err.println("Head:: type: " + head.getBpmnType() + "Description: " + head.getDescription());
							}	
						}
					
				}
			}
		}
		//TODO Integrity check for workflow
		//System.out.println(g.hasOneStartEvent());
		
		//g.print();
		return g;
		
	}
	
	public static String convertType(WorkflowElement element){
	     String BpmnType;
	     switch (element.type) {
	         case "StartNoneEvent":
	             BpmnType = "StartEvent";
	             break;
	         case "StartMessageEvent":
	             BpmnType = "StartMessageEvent";
	             break;
	         case "StartTimerEvent":
	             BpmnType = "StartTimerEvent";
	             break;
	         case "Task":
	             BpmnType = "Task";
	             break;
	         case "CollapsedSubprocess":
	             BpmnType = "Task";
	             break;
	         case "Exclusive_Databased_Gateway":
	             BpmnType = "ExclusiveDatabasedXorGateway";
	             break;
	         case "EventbasedGateway":
	             BpmnType = "EventbasedGateway";
	             break;
	         case "EndNoneEvent":
	             BpmnType = "EndEvent";
	             break;
	         case "EndErrorEvent":
	             BpmnType = "EndErrorEvent";
	             break;
	         case "EndTerminateEvent":
	             BpmnType = "EndTerminateEvent";
	             break;
	         case "EndMessageEvent":
	             BpmnType = "EndMessageEvent";
	             break; 
	         case "IntermediateEvent":
	             BpmnType = "IntermediateEvent";
	             break; 
	         case "IntermediateTimerEvent":
	             BpmnType = "IntermediateTimerEvent";
	             break; 
	         case "IntermediateLinkEventThrowing":
	             BpmnType = "IntermediateLinkEventThrowing";
	             break; 
	         case "IntermediateErrorEvent":
	             BpmnType = "IntermediateErrorEvent";
	             break; 
	         case "IntermediateEscalationEvent":
	             BpmnType = "IntermediateEscalationEvent";
	             break;
	         case "IntermediateEscalationEventThrowing":
	             BpmnType = "IntermediateEscalationEventThrowing";
	             break;
	         case "Association_Undirected":
	             BpmnType = "drop";
	             break;
	         case "Association_Unidirectional":
	             BpmnType = "AssociationUnidirectional";
	             break;
	         case "DataObject":
	             BpmnType = "drop";
	             break;
	         case "InclusiveGateway":
	             BpmnType = "InclusiveGateway";
	             break;
	         case "ParallelGateway":
	             BpmnType = "ParallelGateway";
	             break;
	         case "TextAnnotation":
	             BpmnType = "drop";
	             break;
	         case "Subprocess":
	             BpmnType = "drop";
	             break;
	         case "ITSystem":
	             BpmnType = "drop";
	             break;
	         default:
	             throw new IllegalArgumentException("Invalid BPMN-Type: " + element.type);
	     }
	     return BpmnType;
	}

}
