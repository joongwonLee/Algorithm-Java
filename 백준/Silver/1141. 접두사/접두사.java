import java.util.*;
import java.io.*;

/**
key: 두 문자열 사이에 접두사 관계가 있다면 접두사가 되는 문자열(길이가 짧은)부터 삭제해야 최대 부분집합이 됨
1. 입력으로 받은 문자열 리스트를 문자열 길이 내림차순 정렬
2. 문자열 리스트를 순회하면서 두 문자열 사이에 접두사 관계가 있는지 체크
3. 접두사 관계가 있다면 문자열 리스트에서 짧은 문자열 삭제
4. 문자열 리스트 크기 출력 
**/
public class Main {
    
    static BufferedReader br;
    static int N;
    static List<String> strList;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        strList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            strList.add(input);
        }
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String str1, String str2) {
                return Integer.compare(str2.length(), str1.length());
            }
        };
        
        Collections.sort(strList, comp); // 문자열 길이순 내림차순 정렬
        
        firstLoop:
        for(int i=strList.size()-1; i>0; i--) {
            for(int j=i-1; j>=0; j--) {
                String shortTerm = strList.get(i);
                String longTerm = strList.get(j);
                
                if(isPrefix(longTerm, shortTerm)) {
                    strList.remove(i);
                    continue firstLoop;
                }
            }
        }
        
        System.out.println(strList.size());
    }
    
    // 두 문자열 사이에 접두사 관계가 있는지 판별하는 함수 
    public static boolean isPrefix(String longTerm, String shortTerm) {
        
        String prefixCandidate = longTerm.substring(0, shortTerm.length());
        
        if(prefixCandidate.equals(shortTerm)) return true;
        else return false;
    }
}