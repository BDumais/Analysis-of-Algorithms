package asn3;

/**
 * Edge java file for 3340 Asn3
 * Written by Ben Dumais, 250669195
 */
public class Edge {
    
    //Attributes
    public Vertex u, v; //Verticies for start and end of edge
    public int w;       //Weight of edge
    
    //Constructor
    public Edge(Vertex s, Vertex f, int weight){
        this.u = s;
        this.v = f;
        this.w = weight;
    }
    
    /* NOTE */
    //Made attributes public for sake of coding ease -> avoids many
    // layers of method calls
    
}
