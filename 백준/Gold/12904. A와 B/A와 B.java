
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static String S, T;
    static boolean canMake;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
    }

    static void solve() {

        // S를 확인하는 것이 아닌, T의 맨 뒷 자리를 확인하며
        // 문자열을 추가하기 전으로 돌아가기 
        while(S.length() != T.length()) {

            char[] TcharArr = T.toCharArray();
            
            if(TcharArr[T.length()-1] == 'A') {
                T = T.substring(0, T.length()-1);
            } else {
                T = T.substring(0, T.length()-1);
                T = reverse(T);
            }
        }

        canMake = S.equals(T);
    }

    // 문자열을 뒤집어주는 함수
    static String reverse(String str) {
        String revStr="";

        for(int i=str.length()-1; i>=0; i--) {
            revStr+=str.toCharArray()[i];
        }

        return revStr;
    }

    static void output() {
        if(canMake) System.out.println(1);
        else System.out.println(0);
    }
}
