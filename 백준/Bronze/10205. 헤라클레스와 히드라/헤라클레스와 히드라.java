import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=K; i++) {
            System.out.println("Data Set "+i+":");
            
            int h = Integer.parseInt(br.readLine());
            char[] medusa = br.readLine().toCharArray();
            
            for(int j=0; j<medusa.length; j++) {
                if(medusa[j]=='c') h++;
                else h--;
            }
            System.out.println(h+"\n");
        }
    }
}