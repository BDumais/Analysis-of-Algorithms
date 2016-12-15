package asn2;

/**
 * Ben Dumais
 * 250669195
 * 3340b Asn2
 */
public class Uandf implements UnionFind{
    private Node nodes[];
    private int sets, max;
    private boolean finished;
    
    //Creates union find structure
    public Uandf(int n){  
        nodes = new Node[n];    //Array of nodes, array position is index
        sets = 0;               //Number of sets in structure
        max = n;                //Maximum value for node & size of array
        finished = false;       //Boolean to test if structure has been finalized
    }
    
    //Creates a new set by adding node into respective position of array
    public void make_set(int i) throws Exception{
        if(finished) return;       //If finalized, exit
        
        if (i < 0 || i >= max)      //If i is invalid, throw exception
            throw new Exception();
        
        nodes[i] = new Node(i); //Create new node with input value and store
        sets++;     //Increment sets
    }
    
    //Finds a node in structure and returns the representative for that set
    public int find_set(int i) throws Exception{
        if (i < 0 || i >= max)  //If i is invalid, throw exception
            throw new Exception();
        
        Node current = nodes[i];    //Get node referenced by i
        while (current.getParent() != null) //Loop until parent is null
            current = current.getParent();
        
        //Once the parent is null, we are at the root of that set
        return current.getKey();
    } 
    
    //Joins two sets
    public void union_sets(int i, int j) throws Exception{
        
        if(finished) return;    //If finalized, exit

        if (i < 0 || i > max)           //If i or j are invalid, throw exception
            throw new Exception();
        else if (j < 0 || j > max)
            throw new Exception();
        
        int root_i = find_set(i);   //Get root of set containing i
        int root_j = find_set(j);   //Get root of set containing j
        
        if(root_i == root_j)    //If the roots are the same, do not join
            return;
        
        //Set root of j's set to root of set containing i
        nodes[root_j].setParent(nodes[root_i]);
        sets --;    //Decrement sets

    }
    
    //Finalizes set and returns amount of sets
    public int final_sets(){
        finished = true;
        
        //Get first set's representative and reset key to 1
        try{ nodes[find_set(0)].setKey(1); }
        catch(Exception e){}
        
        //In the following, we get the root of a set and get its key
        //If key is over 1, it is a set we have not reset yet
        //Since we have set the first set already, next root we read will be 1
        // or greater
        
        int j = 1;
        for(int i=1; i < max; i++)  //Loop through rest of sets
                try{
                    Node n = nodes[find_set(i)]; //Get root of set
                    if(n.getKey() > j)  //If it is greater than current j
                        n.setKey(++j);  //Set its key to j and increment
                }
                catch(Exception e){}
        
        return sets;
    }
}

