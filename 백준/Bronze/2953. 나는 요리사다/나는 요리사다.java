import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int person = 0;
        int maxPoint = Integer.MIN_VALUE;
        
        for(int i=1; i<=5; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0; j<4; j++) {
                sum += Integer.parseInt(stn.nextToken());
            }
            if(sum>maxPoint) {
                maxPoint = sum;
                person = i;
            }
        }
        
        System.out.println(person+" "+maxPoint);
    }
}