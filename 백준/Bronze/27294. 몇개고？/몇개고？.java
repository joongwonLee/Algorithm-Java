import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(stn.nextToken());
        int S = Integer.parseInt(stn.nextToken());
        
        if(S==1||T<=11||T>16) System.out.println(280);
        else System.out.println(320);
    }
}