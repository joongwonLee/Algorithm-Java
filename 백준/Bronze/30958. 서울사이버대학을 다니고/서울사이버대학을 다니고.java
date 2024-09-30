import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] logoSong = br.readLine().toCharArray();
        int[] alphabetNum = new int[26];
        int commaNum = 0;
        int periodNum = 0;
        
        for(int i=0; i<logoSong.length; i++) {
            char ch = logoSong[i];

            if(ch==' ') continue;
            else if(ch==',') commaNum++;
            else if(ch=='.') periodNum++;
            else alphabetNum[(int)ch-97]++;
        }
        
        int result = Math.max(commaNum, periodNum);
        for(int i=0; i<26; i++) {
            result = Math.max(result, alphabetNum[i]);
        }
        
        System.out.println(result);
    }
}