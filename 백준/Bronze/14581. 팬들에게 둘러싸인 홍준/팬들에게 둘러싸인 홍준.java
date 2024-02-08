import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static String str;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        str = br.readLine();
        
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==1&&j==1) System.out.print(":"+str+":");
                else System.out.print(":fan:");
            }
            System.out.println();
        }
    }
}