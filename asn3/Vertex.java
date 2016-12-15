package asn3;

/**
 * Vertex java file for 3340 Asn3
 * Written by Ben Dumais, 250669195
 */
class Vertex {
    //Attributes
    private int key;    //Value of node
    private int id;     //Id of node
    private Vertex pi;  //Pointer to previous node in path
    
    //Constructor
    public Vertex(int i, int k){
        this.id = i;    //Initalize values that were input
        this.key = k;
        this.pi = null; //Set pi to null to begin with
    }
    
    //Get Methods
    public int get_key(){ return key; }
    public int get_id(){ return id; }
    public Vertex get_pi(){ return pi; }
    
    //Set Methods
    public void set_key(int k){ this.key = k; }
    public void set_id(int i){ this.id = i; }
    public void set_pi(Vertex v){ this.pi = v; }
    
}
