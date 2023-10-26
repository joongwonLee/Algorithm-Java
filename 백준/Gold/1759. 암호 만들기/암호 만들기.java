
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int L,C;
    static char[] charArr;
    static char[] code;

    // vowelCnt: 모음 개수, consonantCnt: 자음 개수
    static int vowelCnt, consonantCnt;

    static char[] vowelList = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        sb = new StringBuffer();

        L = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());

        charArr = new char[C];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) charArr[i] = stn.nextToken().charAt(0);
    }

    static void solve() {
        Arrays.sort(charArr);

        code = new char[L];
        combination(0,0, 0, 0);
    }

    // 재귀호출 형식의 조합 함수
    static void combination(int cnt, int start, int vowelCnt, int consonantCnt) {

        if(cnt==L) {
            // 모음이 1개 이상, 자음이 2개 이상일 때 출력
            if(vowelCnt>=1&&consonantCnt>=2) {
            String codeToStr = "";
            for(char codeChar: code) codeToStr+=codeChar;
            sb.append(codeToStr+"\n");
            }
            return;
        }

        for(int i=start; i<charArr.length; i++) {
            code[cnt] = charArr[i];
            // 모음에 포함될 때 모음Cnt+1 하여 재귀호출
            if(charArr[i]=='a'||charArr[i]=='e'||charArr[i]=='i'||charArr[i]=='o'||charArr[i]=='u') combination(cnt+1, i+1, vowelCnt+1, consonantCnt);
            // 모음이 포함안될 경우 자음Cnt+1 하여 재귀호출
            else combination(cnt+1, i+1, vowelCnt, consonantCnt+1);
        }
    }

    static void output() {
        System.out.print(sb);
    }
}
