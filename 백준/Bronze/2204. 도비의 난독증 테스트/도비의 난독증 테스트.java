import java.util.*;
import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            String[] strArray = new String[n];
            for(int i=0; i<n; i++) {
                strArray[i] = br.readLine();
            }
            Arrays.sort(strArray, String.CASE_INSENSITIVE_ORDER);
            System.out.println(strArray[0]);
        }
    }
}