import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        HashMap<String, Integer> map = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            if(map.keySet().contains(input)) {
                int nextValue = map.get(input)+1;
                maxValue = Math.max(maxValue, nextValue);
                map.put(input, nextValue);
            } else {
                map.put(input, 1);
                maxValue = Math.max(maxValue, 1);
            }
        }

        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        ArrayList<String> maxKeyList = new ArrayList<>();

        for(String key: keyList) {
            int value = map.get(key);
            if(value == maxValue) {
                maxKeyList.add(key);
            }
        }

        Collections.sort(maxKeyList);

        System.out.println(maxKeyList.get(0));
    }
}