import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String[]  args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char c1 = br.readLine().charAt(0);
        char c2 = br.readLine().charAt(0);
        char c3 = br.readLine().charAt(0);
        
        if((c1=='l'&&c2=='k'&&c3=='p')||
          (c1=='l'&&c2=='p'&&c3=='k')||
          (c1=='k'&&c2=='l'&&c3=='p')||
          (c1=='k'&&c2=='p'&&c3=='l')||
          (c1=='p'&&c2=='l'&&c3=='k')||
          (c1=='p'&&c2=='k'&&c3=='l')) {
            System.out.println("GLOBAL");
        } else {
            System.out.println("PONIX");
        }
    }
}