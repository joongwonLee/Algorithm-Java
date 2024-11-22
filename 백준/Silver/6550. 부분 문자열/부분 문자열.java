import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while(true) {
            input = br.readLine();
            if(input==null) break;

            StringTokenizer stn = new StringTokenizer(input);
            String s = stn.nextToken();
            char[] t = stn.nextToken().toCharArray();
            String part = "";

            int sIndex = 0;
            for(int i=0; i<t.length; i++) {
                if(sIndex>=s.length()) break;
                
                if(t[i]==s.charAt(sIndex)) {
                    part+=String.valueOf(t[i]);
                    sIndex++;
                }
            }

            if(s.equals(part)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}