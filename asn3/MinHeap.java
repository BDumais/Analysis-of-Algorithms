package asn3;

/**
 * MinHeap java file for 3340 Asn3
 * Written by Ben Dumais, 250669195
 */

public class MinHeap implements MinHeapADT {
  
    /*
     * I am very unsure of this implementation.. I tried to follow the example
     * given during lectures by using an index array to reference elements,
     * but the heapify does not seem to work. I suspect an issue with converting
     * between 0 and 1 index, where the heapify compares the wrong nodes
     * I am unable to figure out this issue, but if this heap were to properly
     * sort and return nodes the program should work
    */
    
    //Attributes
    private Vertex[] A;         //List of vertexes
    private int[] H;            //Index array
    private int size;           //Number of items in heap
    private int max, h_max;     //Max sizes for arrays
    
    //Constructor, used by initializer
    public MinHeap(int n){
        
        A = new Vertex[n];  //Initialize to size of n
        H = new int[2*n-1]; //Initialize to size of 2n-1
        size = 0;
        max = n;
        h_max = 2*n-1;
    }
    
    //*************//
    //Initialize method for heap
    public void heap_ini(int keys[], int n){
 //       H[0] = -1;
 //       insert(new Vertex(1, 0));
        for(int i=0; i<n; i++){
            H[i] = -1;                  //Initialize values for index
            insert(new Vertex(i+1, 0)); //Insert new vertex with id i
                                                         //Sets value to 0
        }
        heapify();   //Heapify
    }
    
    //Heapify method
    private void heapify(){
        for(int i = max; i < h_max; i++)    //Initialize indexes
            H[i] = i - max + 1;
        for(int i = max-1; i > 1; i--){       //Compare values of indexed nodes
            if (A[H[2*i-1]].get_key() < A[H[2*i]].get_key())    //If left < right
                H[i] = H[2*i-1];                      //Set reference to left
            else
                H[i] = H[2*i];                    //else set to right
        }
    }
    
//    private void swap(int p1, int p2){
//        int t = H[p1];
//        H[p1] = H[p2];
//        H[p2] = t;
//    }
    
    //Method to insert value into heap
    public void insert(Vertex v){
        if(H[size] == -1){
            A[size] = v;
            H[size] = size;
            size++;
        }
    }

    /* Note */
    //Following methods were implemented as per lecture notes
    
    //Method to check if an id exists in heap
    public boolean in_heap(MinHeap hp, int id){
        return hp.A[H[id-1]] == null;
    }
    
    //Method to return key of minimum element
    public int min_key(MinHeap hp){
        return hp.A[H[0]].get_key();
    }
    
    //Method to return id of minimum element
    public int min_id(MinHeap hp){
        return hp.H[0];
    }
    
    //Method to return key of vertex indexed by id
    public int key(MinHeap hp, int id){
        return hp.A[H[id-1]].get_key();
    }
    
    //Method to return vertex indexed by id
    public Vertex get(MinHeap hp, int id){
        return hp.A[H[id-1]];
    }
    
    //Method to remove smallest item and return it
    public Vertex delete_min(MinHeap hp){
        //hp.A[0].key = Integer.MAX_VALUE;
        hp.H[H[0]+hp.size-1] = 0;
        Vertex v = A[H[0]];
        int i = (H[0]+hp.size-1)/2;
        size--;
        while (i > 0){
            if(hp.A[H[2*i]].get_key() < hp.A[H[2*i+1]].get_key())
                hp.H[i] = hp.H[2*i];
            else
                hp.H[i] = hp.H[2*i+1];
            i = i/2;
        }
        return v;
    }
    
    //Method to update value of a vertex and re-heapify
    public void decrease_key(MinHeap hp, int id, int k){
        hp.A[id-1].set_key(k);
        int i = (id+hp.size-2)/2;
        while (i >= 0){
            if(hp.A[H[2*i]].get_key() < hp.A[H[2*id+1]].get_key())
                hp.H[i] = hp.H[2*i];
            else
                hp.H[i] = hp.H[2*i+1];
            i = i/2;
        }
    }
    
    //Helper methods
    public boolean is_empty(){
        return size==0;
    }
    private boolean is_leaf(int p){
        return p > size/2;
    }    
    
}
