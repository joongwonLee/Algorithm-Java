import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static String S,T;

    static boolean operCan;

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

    /**
     * S -> T로 가는 연산 1.문자열 뒤에 A 추가, 2.문자열 뒤에 B를 추가하고 문자열 뒤집기
     * 반대로 T의 맨 뒷자리를 확인하면서 연산하기 전으로 되돌아가기 (T의 길이가 S의 길이가 될 때까지)
     *      단, T의 맨 뒷자리가 A라면, T의 맨 앞자리를 탐색
     * 두 문자열의 길이가 같아지면, 두 값이 같은지 확인
     */
    static void solve() {
        operCan = false;
        operString(T, T.length());
    }

    // 연산을 수행하는 함수
    // 1번 연산과 2번 연산을 모두 수행하는 형태로 함수 재귀 호출
    static void operString(String T, int TLen) {

        if(TLen == S.length()) {
            if(S.equals(T)) operCan = true;

//            System.out.println(S+", "+T);
            return;
        }


        // 1. 만약 맨 뒷자리가 B라면 무조건 2번 연산(문자열 뒤에 B를 추가하고 뒤집기)을 수행
        if(T.charAt(T.length()-1)=='B') {
            if(T.charAt(0)=='B') operString(reverseString(T), TLen-1);
            else return;
        }

        // 2. 만약 맨 뒷자리가 A라면
        else {
            // 맨 앞자리가 A이건, B이건 무조건 A를 더하는 연산 탐색
            operString(T.substring(0, T.length()-1), TLen-1);
            // 맨 앞자리가 B라면, 2번 연산 탐색
            if(T.charAt(0)=='B') operString(reverseString(T), TLen-1);
        }
    }

    // 2변 연산 함수
    // 문자열을 거꾸로 뒤집고, 마지막 문자를 빼는 함수
    static String reverseString(String str) {

        char[] resultCharSet = new char[str.length()-1];

        for(int i=0; i<str.length()-1; i++) {
            resultCharSet[i] = str.charAt(str.length()-1-i);
        }

        return String.valueOf(resultCharSet);
    }

    static void output() {

        if(operCan) System.out.print(1);
        else System.out.println(0);
    }
}
