package asn1_a;

/**
 * Ben Dumais
 * 250669195
 * 3340b Asn1
 */
public class Asn1_a {

    public static void main(String[] args) {
        for (int i = 1; i < 8; i++)
            System.out.println("F(" + i*5 + ") = " + fibb(i*5));
    }
    
    public static int fibb(int n){
        if (n==0) return 0;
        else if (n==1) return 1;
        else
            return fibb(n-1)+fibb(n-2);
    }    
}