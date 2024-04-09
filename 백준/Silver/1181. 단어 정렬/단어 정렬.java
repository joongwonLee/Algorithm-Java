import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int N;
    static Set<String> inputSet;
    static ArrayList<String> inputList;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputSet = new HashSet<>();
        
        for(int i=0; i<N; i++) {
            String input = String.valueOf(br.readLine());
            inputSet.add(input);
        }
        
        inputList = new ArrayList<>(inputSet);
        inputList.sort(Comparator.comparing(String::length)
                      .thenComparing(Comparator.naturalOrder()));

        for(String str: inputList) {
            System.out.println(str);
        }
    }
}