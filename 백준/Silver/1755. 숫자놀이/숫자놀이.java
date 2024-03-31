import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int M, N;
    static ArrayList<String> numStrList;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(stn.nextToken());
        N = Integer.parseInt(stn.nextToken());
        
        numStrList = new ArrayList<>();
        
        for(int i=M; i<=N; i++) {
            String num = String.valueOf(i);
            String fullNumOfEnglish = "";
            
            for(int j=0; j<num.length(); j++) {
                String numOfEnglish = getNumOfEnglish(String.valueOf(num.charAt(j)));
                fullNumOfEnglish += numOfEnglish+" ";
            }
            
            fullNumOfEnglish += num;
            
            numStrList.add(fullNumOfEnglish);
        }
        
        Collections.sort(numStrList);
        
        for(int i=0; i<numStrList.size(); i++) {
            String numStr = numStrList.get(i);
            String[] strList = numStr.split(" ");
            System.out.print(strList[strList.length-1]+" ");
            if(i%10==9) System.out.println();
        }
    }
    
    public static String getNumOfEnglish(String input) {
        switch(input) {
            case "0":
                return "zero";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
        }
        
        return "";
    }
}