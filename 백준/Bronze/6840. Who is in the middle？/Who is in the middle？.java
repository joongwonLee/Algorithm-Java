import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> intList = new ArrayList<>();
        
        intList.add(Integer.parseInt(br.readLine()));
        intList.add(Integer.parseInt(br.readLine()));
        intList.add(Integer.parseInt(br.readLine()));
        
        Collections.sort(intList);
        
        System.out.println(intList.get(1));
    }
}