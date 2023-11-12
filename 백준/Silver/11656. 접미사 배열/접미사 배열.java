
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static String str;

    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();

    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
    }

    static void solve() {
        result = new ArrayList<>();

        for(int i=0; i<str.length(); i++) {
            result.add(str.substring(i));
        }

        Collections.sort(result);
    }

    static void output() {
        sb = new StringBuffer();

        for(String str: result) {
            sb.append(str+"\n");
        }

        System.out.println(sb);
    }
}
