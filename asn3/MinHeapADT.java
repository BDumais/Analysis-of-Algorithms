package asn3;

/**
 * MinHeapADT template java file for 3340 Asn3
 * Written by Ben Dumais, 250669195
 */
public interface MinHeapADT {
    
    void heap_ini(int keys[], int n);
    boolean in_heap(MinHeap hp, int id);
    int min_key(MinHeap hp);
    int min_id(MinHeap hp);
    int key(MinHeap hp, int id);
    Vertex delete_min(MinHeap hp);
    void decrease_key(MinHeap hp, int id, int k);
  
}
