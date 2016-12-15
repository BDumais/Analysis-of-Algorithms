package asn2;

/**
 * Ben Dumais
 * 250669195
 * 3340b Asn2
 */

//A basic class to represent a node in a tree
public class Node {

    private Node parent;    //Reference to parent of this node
    private int key;        //Value of node
    
    //Constructor
    public Node(int i){
        parent = null;      //Set parent to null
        key = i;            //Set Value to input i
    }
    
    //Get and Sets for attributes
    public int getKey(){ return key; }
    public void setKey(int k){ key = k; }
    public Node getParent(){ return parent; }
    public void setParent(Node n){ parent = n; }
    
}
