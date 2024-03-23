import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static BufferedReader br;

    static HashMap<Integer, Integer> pointMap;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        pointMap = new HashMap<>();

        for(int i=1; i<=8; i++) {
            int point = Integer.parseInt(br.readLine());

            pointMap.put(i, point);
        }

        List<Integer> keySet = new ArrayList<>(pointMap.keySet());

        keySet.sort(new Comparator<Integer>() {
            // 점수 내림차순 정렬 
            @Override
            public int compare(Integer o1, Integer o2) {
                return pointMap.get(o2).compareTo(pointMap.get(o1));
            }
        });

        int sum = 0;
        List<Integer> sortedKeySet = new ArrayList<>();
        
        for(int i=0; i<5; i++) {
            int key = keySet.get(i);
            sum += pointMap.get(key);
            sortedKeySet.add(key);
        }

        StringBuffer sb = new StringBuffer();
        Collections.sort(sortedKeySet);
        for(int key: sortedKeySet) {
            sb.append(key+" ");
        }

        System.out.println(sum);
        System.out.print(sb);
    }
}