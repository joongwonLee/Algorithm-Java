import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int angleA, angleB, angleC;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        angleA = Integer.parseInt(br.readLine());
        angleB = Integer.parseInt(br.readLine());
        angleC = Integer.parseInt(br.readLine());
        
        if(angleA==60&&angleB==60&&angleC==60) {
            System.out.println("Equilateral");
        } 
        else if(angleA+angleB+angleC==180) {
            if(angleA==angleB||angleB==angleC||angleA==angleC) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
        else {
            System.out.println("Error");
        }
        
    }
}