import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            if(str.equals("***")) break;
            
            StringBuffer sb = new StringBuffer(str);
            System.out.println(sb.reverse());
        }
    }
}