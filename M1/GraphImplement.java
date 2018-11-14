package stu;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class GraphImplement implements Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private String keys[];
    private int Matrix[][];
    private final String type;
    public GraphImplement(In in,String temp) {
    	 this.V = in.readInt();
    	 //int E = in.readInt();
    	 //keys=in.Strineline().split(",");
    	// String links[]=in.Strineline().split(" ");
    	 this.type=temp;
         // System.out.println("===>Edges "+E);
         
    	
    		//this.V = in.readInt();
        try {
            //this.V = in.readInt();
            //System.out.println("===>vertices "+this.V);
        	if(this.type.equals("List"))
        	{
        		 if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
                 adj = (Bag<Integer>[]) new Bag[V];
                 for (int v = 0; v < V; v++) {
                     adj[v] = new Bag<Integer>();
                 }
                 int E = in.readInt();
                
                keys=in.Strineline().split(",");
                 
                 if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
                 for (int i = 0; i < E; i++) {
                 	String links[]=in.Strineline().split(" ");
                     int v = Integer.parseInt(links[0]);
                     int w = Integer.parseInt(links[1]);
                   
                     validateVertex(v);
                     validateVertex(w);
                     addEdge(v, w); 
                 }
            }
        	else if(this.type.equals("Matrix")) {
        		Matrix =new int[V][V];
        		 int E = in.readInt();
                 
                 keys=in.Strineline().split(",");
        		 if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
                 for (int i = 0; i < E; i++) {
                	String links[]=in.Strineline().split(" ");
                     int v = Integer.parseInt(links[0]);
                     int w = Integer.parseInt(links[1]);
                     validateVertex(v);
                     validateVertex(w);
                     addEdge(v, w); 
                 }
        	}
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }  	
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        if(this.type.equals("List")) {
        adj[v].add(w);
        adj[w].add(v);
        }
        
        else if(this.type.equals("Matrix")) 
        {
        	//System.out.println("v"+v+": w"+w);
        	Matrix[v][w]=1;
        	Matrix[w][v]=1;
        }
        
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        //String keys[]=in.Strineline().split(",");
        
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        if(this.type.equals("List")) {
        for (int v = 0; v < V; v++) 
        {
            s.append(keys[v] + ": ");
            for (int w : adj[v]) {
                s.append(keys[w] + " ");
            }
            s.append(NEWLINE);
        }
        }
        else
        {
        	for (int v = 0; v < V; v++) 
            {
                //s.append(keys[v] + ": ");
                for (int e = 0; e < E; e++) {
                    s.append(Matrix[v][e] + " ");
                }
                s.append(NEWLINE);
            }
        }
        
        return s.toString();
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	 String temp=sc.nextLine();
    	In in = new In(sc);
    	
    	   		
            GraphImplement G = new GraphImplement(in,temp);
            System.out.println(G);
    
    }

	@Override
	public boolean hasEdge(int v, int w) {
		// TODO Auto-generated method stub
		return false;
	}

}
