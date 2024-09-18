import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] alphabetNum = new int[26];
        List<Character> uospcList = new ArrayList<>();
        uospcList.add('u');
        uospcList.add('o');
        uospcList.add('s');
        uospcList.add('p');
        uospcList.add('c');
        
        char[] alphabetArray = br.readLine().toCharArray();
        
        for(int i=0; i<n; i++) {
            if(uospcList.contains(alphabetArray[i])) {
                alphabetNum[(int)(alphabetArray[i])-97]++;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<26; i++) {
            int alNum = alphabetNum[i];
            if((i==20
                ||i==14
                ||i==18
                ||i==15
                ||i==2
               )&&min>alNum) min = alNum;
        }

        if(min==Integer.MAX_VALUE) System.out.println("0");
        else System.out.println(min);
    }
}