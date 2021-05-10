package Graphs;
import java.util.*;
public class Gra {
    private class Vertex{
    	HashMap<String,Integer> nbrs = new HashMap<>();
    }
    HashMap<String,Vertex>vtces;
    public Gra() {
    	vtces=new HashMap<>();
    }
    public int numVertex() {
    	return this.vtces.size();
    }
    public boolean containsVertex(String vname) {
    	return this.vtces.containsKey(vname);
    }
    public void addVertex(String name) {
    	if(vtces.containsKey(name)) {
    		return;
    	}
    	Vertex vtx = new Vertex();
    	vtces.put(name, vtx);
    }
    public void removeVertex(String vname) {
    	Vertex vtx = vtces.get(vname);
    	ArrayList<String>keys=new ArrayList<>(vtx.nbrs.keySet());
    	for(String key:keys) {
    		Vertex nbrVtx=vtces.get(key);
    		nbrVtx.nbrs.remove(vname);
    	}
    	vtces.remove(vname);
    }
    public void addEdge(String vname1,String vname2,int cost) {
    	Vertex vtx1 = vtces.get(vname1);
    	Vertex vtx2 = vtces.get(vname2);
    	if(vtx1==null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
    		return;
    	}
    	vtx1.nbrs.put(vname2, cost);
    	vtx2.nbrs.put(vname2, cost);
    }
    public void removeEdge(String vname1,String vname2) {
    	Vertex vtx1 = vtces.get(vname1);
    	Vertex vtx2 = vtces.get(vname2);
    	if(vtx1==null || vtx2==null || !vtx1.nbrs.containsKey(vname2)) {
    		return;
    	}
    	vtx1.nbrs.remove(vtx2);
    	vtx2.nbrs.remove(vtx1);
    }
    public boolean containsEdge(String vname1,String vname2) {
    	Vertex vtx1 = vtces.get(vname1);
    	Vertex vtx2 = vtces.get(vname2);
    	if(vtx1==null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
    		return false;
    	}
    	return true;
    }
    public int numEdges() {
    	ArrayList<String>keys = new ArrayList<>(vtces.keySet());
    	int count = 0;
    	for(String key:keys) {
    		Vertex vtx = vtces.get(key);
    		count+=vtx.nbrs.size();
    	}
    	return count/2;
    }
    public void display() {
    	ArrayList<String>vnames= new ArrayList<>(vtces.keySet());
    	for(String vname:vnames) {
    		String str = vname +"=>";
    		Vertex vtx = vtces.get(vname);
    		str+=vtx.nbrs;
    		System.out.println(str);
    	}
    	System.out.println("------------------");
    }
}
