import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArray = br.readLine().toCharArray();
        char[] removedArray = "CAMBRIDGE".toCharArray();
        List<Character> removedList = new ArrayList<>();
        for(int i=0; i<removedArray.length; i++) {
            removedList.add(removedArray[i]);
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<inputArray.length; i++) {
            char now = inputArray[i];
            if(!removedList.contains(now)) sb.append(String.valueOf(now));
        }
        System.out.println(sb);
    }
}