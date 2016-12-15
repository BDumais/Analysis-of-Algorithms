/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asn2;

/**
 *
 * @author bendu
 */
public interface UnionFind {
    
    void make_set(int i) throws Exception;
    void union_sets(int i, int k) throws Exception;
    int find_set(int i) throws Exception;
    int final_sets();
    
}
