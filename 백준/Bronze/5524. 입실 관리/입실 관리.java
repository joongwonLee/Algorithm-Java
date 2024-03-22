import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int N;
    
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String str = String.valueOf(br.readLine());
            sb.append(str.toLowerCase()+"\n");
        }

        System.out.println(sb);
    }
}