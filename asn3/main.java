package asn3;

//Imports
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Main java file for 3340 Asn3
 * Written by Ben Dumais, 250669195
 */
public class main {

    //Global Variables
    static int numV, numE;
    static MinHeap Q;
    static List<Vertex> S;
    static List<Edge> eList;
    
    //Method to initialize Graph for Single Source
    static private void initialize_SS(){
        //Nodes are intially set to zero, so we only have to change nodes 2 - n
        for(int i=2; i<=numV; i++){        //Set value of other vertexes to max value
            Q.get(Q, i).set_key(Integer.MAX_VALUE);
        } 
    }
    
    //Method to relax a node, updating it value
    static private void relax(Edge e){
        if(e.v.get_key() > (e.u.get_key() + e.w)){  //If value of current node plus w is less than the next node
            Q.decrease_key(Q, e.v.get_id(), e.u.get_key() + e.w); //update value of v in heap
            e.v.set_pi(e.u);               //Set v to point to current node
        }
    }
    
    //Method to recursively print the shortest path
    static private void print_SS(Vertex v){
        if (v == null)
            System.out.println(v.get_id() + " -- ");
        else{
            print_SS(v.get_pi());
            System.out.print( v.get_id() + " -- ");
            }
    }   
    
    //Main Function
    public static void main(String[] args) {
        
        if(args.length != 1){
            System.out.println("Please enter the name of an input file, ex test.txt");
            return;
        }
        
        //Read in file and construct vertexes and edges
        File f = new File(args[0]); //Use input as filename
        try{    
            Scanner in = new Scanner(f);  //Create scanner from file
            
            numV = Integer.parseInt(in.nextLine()); //Parse the first line   
            
            int[] ids = new int[numV];            
            for(int i=0; i < numV; i++)   //Loop and create all vertexes
                ids[i] = i+1;
            
            Q = new MinHeap(numV);
            Q.heap_ini(ids, numV);
            
            eList = new ArrayList<Edge>();
            
            //Next we read in edge info
            while(in.hasNext()){        //Loop until we hit end of file
                String s = in.nextLine();   //Get next line
                int u, v, w;             //Create variables for u, v, and w
                StringTokenizer tok = new StringTokenizer(s);
                u = Integer.parseInt(tok.nextToken());  //Prase info from line
                v = Integer.parseInt(tok.nextToken());
                w = Integer.parseInt(tok.nextToken());
                eList.add(new Edge(Q.get(Q, u),Q.get(Q, v), w));  //create edge and add to list
            }   
        }
        //If an exception is thrown, catch it and print error
        catch(FileNotFoundException e){
            System.out.println("Unable to find File");
            return;
        }

        //Begin Dijkstra's Algorithm
        
        initialize_SS();        //Initialize Vertex values
        S = new ArrayList<Vertex>();    //Initialize List of visited Vertexes
        
        //Loop until we exhaust all of the heap
        while(!Q.is_empty()){
            Vertex u = Q.delete_min(Q);   //Extract minimum value vertex
            S.add(u);                   //Add it to visited nodes
            for(Edge e : eList){        //Loop through edges, finding one 
                if(e.u == u && Q.in_heap(Q, e.v.get_id())){   //If the current edge starts at u and v is not visited
                    relax(e);   //Relax and update vertex values
                }
            }
        }
        
        //Print results
        
        //Print graph as List
        System.out.println(S.toString());
        
        //Print Shortest Path
        if(S.get(numV-1).get_pi() != null){
            print_SS(S.get(numV-1).get_pi());   //Start printing front to back
            System.out.print(S.get(numV-1));    //Print last node
        }
        else
            System.out.println("Error printing Path: no path to last vertex found");
        
    }//End of Main
    
}
