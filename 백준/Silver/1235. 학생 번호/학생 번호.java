import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] strArray = new String[N];
        
        for(int i=0; i<N; i++) {
            strArray[i] = br.readLine();
        }
        
        int len = strArray[0].length();
        for(int i=1; i<=len; i++) {
            Set<String> substrSet = new HashSet<>();
            for(int j=0; j<N; j++) {
                substrSet.add(strArray[j].substring(len-i, len));
            }
            if(substrSet.size()==N) {
                System.out.println(i);
                return;
            }
        }
    }
}