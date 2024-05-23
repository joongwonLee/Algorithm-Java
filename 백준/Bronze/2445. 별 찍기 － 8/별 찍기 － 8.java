import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=2*N-1; i++) {
            
            for(int j=1; j<=2*N; j++) {
                if(i==N) {
                    System.out.print("*");
                } else if(i<N) {
                    if(j<=i||(2*N+1)-j<=i) System.out.print("*");
                    else System.out.print(" ");
                } else {
                    if(j<=2*N-i||(2*N+1)-j<=(2*N-i)) System.out.print("*");
                    else System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}