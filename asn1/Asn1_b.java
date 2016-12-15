package asn1_b;

/**
 * Ben Dumais
 * 250669195
 * 3340b Asn1
 */

public class Asn1_b {
    public static void main(String[] args) {
        for (int i = 1; i < 31; i++)
            System.out.println("F(" + i*10 + ") = " + String.valueOf(fibb(i*10)));
    }
    
    public static double fibb(int n){
        double[] arr;
        arr = new double[n];
        
        arr[0]=0;
        arr[1]=1;
        
        for(int i=2;i<n;i++) {
            arr[i]=arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }       
}
