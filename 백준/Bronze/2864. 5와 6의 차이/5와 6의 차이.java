import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        char[] aNumArray = stn.nextToken().toCharArray();
        char[] bNumArray = stn.nextToken().toCharArray();
        
        StringBuffer aNumMinSB = new StringBuffer();
        StringBuffer aNumMaxSB = new StringBuffer();
        StringBuffer bNumMinSB = new StringBuffer();
        StringBuffer bNumMaxSB = new StringBuffer();
        
        int min = 0;
        int max = 0;
        
        for(int i=0; i<aNumArray.length; i++) {
            char now = aNumArray[i];
            if(now=='5'||now=='6') {
                aNumMinSB.append("5");
                aNumMaxSB.append("6");
            } else {
                aNumMinSB.append(String.valueOf(now));
                aNumMaxSB.append(String.valueOf(now));
            }
        }
        
        for(int i=0; i<bNumArray.length; i++) {
            char now = bNumArray[i];
            if(now=='5'||now=='6') {
                bNumMinSB.append("5");
                bNumMaxSB.append("6");
            } else {
                bNumMinSB.append(String.valueOf(now));
                bNumMaxSB.append(String.valueOf(now));
            }
        }
        
        min = Integer.parseInt(String.valueOf(aNumMinSB)) + Integer.parseInt(String.valueOf(bNumMinSB));
        max = Integer.parseInt(String.valueOf(aNumMaxSB)) + Integer.parseInt(String.valueOf(bNumMaxSB));
        
        System.out.println(min+" "+max);
    }
}