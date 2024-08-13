import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(stn.nextToken()));
            yList.add(Integer.parseInt(stn.nextToken()));
        }
        
        Collections.sort(xList);
        Collections.sort(yList);
        
        if(N==1) {
            System.out.println("0");
            return;
        }

        int area = (xList.get(N-1) - xList.get(0)) * (yList.get(N-1) - yList.get(0));
        System.out.println(area);
    }
}