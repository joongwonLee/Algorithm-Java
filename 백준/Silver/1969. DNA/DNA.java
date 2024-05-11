import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int dnaNum = Integer.parseInt(stn.nextToken());
        int dnaLength = Integer.parseInt(stn.nextToken());
        
        int[][] AsciiCharNum = new int[dnaLength][26]; // A~Z까지 'A'-65 형식으로 해당 인덱스에 개수 저장 
        
        for(int i=0; i<dnaNum; i++) {
            char[] dna = br.readLine().toCharArray();
            for(int j=0; j<dnaLength; j++) {
                AsciiCharNum[j][dna[j]-65]++;
            }
        }

        StringBuffer sb = new StringBuffer();
        int minHammingDistance = 0;
        
        for(int i=0; i<dnaLength; i++) {
            int maxCount = 0;
            char maxChar = 'A';
            for(int j=0; j<26; j++) {
                if(AsciiCharNum[i][j] > maxCount) {
                    maxCount = AsciiCharNum[i][j];
                    maxChar = (char)(65+j); // 다시 숫자를 알파벳으로 변환
                }
            }
            sb.append(String.valueOf(maxChar));
            minHammingDistance += dnaNum-maxCount;
        }

        System.out.println(sb);
        System.out.println(minHammingDistance);
        
    }
}