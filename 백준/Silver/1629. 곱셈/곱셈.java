
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static long A, B, C;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        stn = new StringTokenizer(br.readLine());
        A = Long.parseLong(stn.nextToken());
        B = Long.parseLong(stn.nextToken());
        C = Long.parseLong(stn.nextToken());

        System.out.println(powAndDivide(A, B));
    }

    static long powAndDivide(long a, long b) {

        if(b==0) {
            return 1;
        }
        else if(b==1) {
            return a%C;
        }
        else if(b%2==0) {
            long ll = (powAndDivide(a, b/2)%C);
            return ll*ll%C;
        }
        else if(b%2!=0) {
            return (a*powAndDivide(a, b-1)%C)%C;
        }

        return -1L;
    }

}
