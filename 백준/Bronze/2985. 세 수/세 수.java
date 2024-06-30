import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        
        if(A+B==C) {
            System.out.println(A+"+"+B+"="+C);
        } else if(A-B==C) {
            System.out.println(A+"-"+B+"="+C);
        } else if(A*B==C) {
            System.out.println(A+"*"+B+"="+C);
        } else if(A/B==C&&A%B==0) {
            System.out.println(A+"/"+B+"="+C);
        } else if(B+C==A) {
            System.out.println(A+"="+B+"+"+C);
        } else if(B-C==A) {
            System.out.println(A+"="+B+"-"+C);
        } else if(B*C==A) {
            System.out.println(A+"="+B+"*"+C);
        } else if(B/C==A&&B%C==0) {
            System.out.println(A+"="+B+"/"+C);
        }
    }
}