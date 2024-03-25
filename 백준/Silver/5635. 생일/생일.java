import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int n;
    
    static HashMap<Integer, String> peopleInfo; // 이름, 생일이 같은 사람은 없으므로 key 값을 생일로 지정 
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        peopleInfo = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            stn = new StringTokenizer(br.readLine());
            String name = String.valueOf(stn.nextToken());
            int day = Integer.parseInt(stn.nextToken());
            int month = Integer.parseInt(stn.nextToken());
            int year = Integer.parseInt(stn.nextToken());
            
            String dayStr = (day<10) ? "0"+String.valueOf(day) : String.valueOf(day);
            String monthStr = (month<10) ? "0"+String.valueOf(month) : String.valueOf(month);
            String yearStr = String.valueOf(year);
            
            int birth = Integer.parseInt(yearStr+monthStr+dayStr);
            peopleInfo.put(birth, name);
        }
        
        List<Integer> keyList = new ArrayList<>(peopleInfo.keySet());
        Collections.sort(keyList);
        
        System.out.println(peopleInfo.get(keyList.get(keyList.size()-1)));
        System.out.println(peopleInfo.get(keyList.get(0)));
    }
}