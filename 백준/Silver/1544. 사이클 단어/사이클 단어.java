import java.util.*;
import java.io.*;

public class Main {
    
    static List<String> resultList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            isThereSameWord(str);
        }
        
        System.out.println(resultList.size());
    }
    
    public static void isThereSameWord(String str) {
        
        boolean isThere = false;
        
        for(String s: resultList) {
            if(isSameWord(s, str)) {
                isThere = true;
                break;
            }
        }
        
        if(!isThere) resultList.add(str); 
    }
    
    public static boolean isSameWord(String str1, String str2) {
        if(str1.length()!=str2.length()) return false;
        
        String twiceStr = str1+str1;
        
        if(twiceStr.contains(str2)) return true;
        else return false;
    }
}