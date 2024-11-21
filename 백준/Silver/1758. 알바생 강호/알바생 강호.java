import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> tips = new ArrayList<>();
        for(int i=0; i<N; i++) {
            tips.add(Integer.parseInt(br.readLine()));
        }
        
        // 예상 팁이 큰 사람일 수록 높은 등수로 놓는 것이 음수 값을 최소로 할 수 있는 최선의 선택 
        Collections.sort(tips, Comparator.reverseOrder());
        
        long result = 0;
        for(int i=0; i<N; i++) {
            int tip = tips.get(i)-i;
            result += (tip>0) ? tip : 0;
        }
        
        System.out.println(result);
    }
}