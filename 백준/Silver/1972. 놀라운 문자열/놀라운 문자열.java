import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        outer:
        while(true) {
            String input = br.readLine();
            if(input.equals("*")) break;
            
            int len = input.length();
            if(len<=2) {
                System.out.println(input+" is surprising.");
                continue;
            }
            
            for(int i=0; i<len-2; i++) {
                List<String> strList = new ArrayList<>();
                for(int j=0; j<len-i-1; j++){
                    String s = String.valueOf(input.charAt(j)) + String.valueOf(input.charAt(j+i+1));
                    for(String str: strList) {
                        if(str.equals(s)) {
                            System.out.println(input+" is NOT surprising.");
                            continue outer;
                        }
                    }
                    strList.add(s);
                }
            }

            System.out.println(input+" is surprising.");
        }
    }
}