import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        if(N>=380&&N<425) {
            System.out.println("Violet");
        } 
        else if(N>=425&&N<450) {
            System.out.println("Indigo");
        }
        else if(N>=450&&N<495) {
            System.out.println("Blue");
        }
        else if(N>=495&&N<570) {
            System.out.println("Green");
        }
        else if(N>=570&&N<590) {
            System.out.println("Yellow");
        }
        else if(N>=590&&N<620) {
            System.out.println("Orange");
        }
        else if(N>=620&&N<=780) {
            System.out.println("Red");
        }
    }
}