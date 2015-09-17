package graph.sim;

import java.util.LinkedList;

public class TaxonomyNode {
	private TaxonomyNode parent = null;
	private int level;
	private String term;
	private String concept;
	public double similarity;
	private LinkedList<TaxonomyNode> children;
	
	public TaxonomyNode getParent(){
		return this.parent;
	}
	
	public int getLevel(){
		return this.level;
	}
	
	public TaxonomyNode(String term){
		this.term = term;
	}
	
	public TaxonomyNode(String concept, double similarity){
		this.concept = concept;
		this.similarity = similarity;
		this.children = new LinkedList<TaxonomyNode>();
	}
	
    public void addChild(TaxonomyNode child)
    {
    	child.parent = this;
    	if(parent == null){
    		child.level = 0;
    	}
    	else {
    		child.level = level+1;
    	}
        this.children.add(child);
    }

    public void addChildren(LinkedList<TaxonomyNode> children)
    {
    	for(TaxonomyNode child: children){
    		child.parent = this;
        	if(parent == null){
        		child.level = 1;
        	}
        	else {
        		child.level = level+1;
        	}
    	}
        this.children.addAll(children);
    }
    
    public TaxonomyNode findNode(String term)
    {
    	TaxonomyNode ret;
        if(this.term != null){
        	if(this.term.toLowerCase().equals(term.toLowerCase())){
            	return ret = this;
        	}
        }
        else {
            for (TaxonomyNode node: children)
            {
            	ret = node.findNode(term);
            	if(ret != null){
            		return ret;
            	}
            }
        }

        return null;
    }
    
    public double getSimilartiy(String termA, String termB){
    	TaxonomyNode a = findNode(termA);
    	TaxonomyNode b = findNode(termB);
    	if(a == null){
    		throw new IllegalArgumentException("Invalid Node description(A): " + termA);
    	}
    	if(b == null){
    		throw new IllegalArgumentException("Invalid Node description(B): " + termB);
    	}
    	if(a.getParent() != null && b.getParent() != null){
    		if(a.getParent() == b.getParent()){
    			return 1;
    		}
    		a = a.getParent();
    		b = b.getParent();
    		//System.out.println("a level: " + a.getLevel());
    		//System.out.println("b level: " + b.getLevel());
    		while(a.getLevel() > b.getLevel()){
    			a = a.getParent();
    			//System.out.println("Increment a");
    		}
    		while(a.getLevel() < b.getLevel()){
    			b = b.getParent();
    			//System.out.println("Increment b");
    		}
    		if(a == b){
    			//System.out.println(a.concept);
    			return a.similarity;
    		}
    		else {
    			while(a != b){
    	    		a = a.getParent();
    	    		b = b.getParent();
    			}
    			return a.similarity;
    		}
    	}
    	return -1;
    }

}
