import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int originLen = input.length();
        
        String replaceInput = input.replace("DKSH", "");
        int replaceLen = replaceInput.length();
        System.out.println((originLen - replaceLen)/4);
    }
}