import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static Set<String> birdColorSet;
    static ArrayList<String> birdColorList;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        birdColorSet = new HashSet<>();
        
        stn = new StringTokenizer(br.readLine());
        
        String fatherBodyColor = String.valueOf(stn.nextToken());
        String fatherTailColor = String.valueOf(stn.nextToken());
        
        birdColorSet.add(fatherBodyColor);
        birdColorSet.add(fatherTailColor);
        
        stn = new StringTokenizer(br.readLine());
        
        String motherBodyColor = String.valueOf(stn.nextToken());
        String motherTailColor = String.valueOf(stn.nextToken());
        
        birdColorSet.add(motherBodyColor);
        birdColorSet.add(motherTailColor);
        
        birdColorList = new ArrayList<>(birdColorSet);
        Collections.sort(birdColorList);
        
        for(String firstColor: birdColorList) {
            for(String secondColor: birdColorList) {
                System.out.println(firstColor+" "+secondColor);
            }
        }
    }
}