import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double sumOfPoint = 0.0;
        double sumOfCredit = 0.0;
        
        for(int i=0; i<20; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            
            String subject = stn.nextToken();
            Double credit = Double.parseDouble(stn.nextToken());
            String rating = stn.nextToken();

            if(!rating.equals("P")) sumOfCredit += credit;
            sumOfPoint += credit * getPointPerRating(rating);
        }
        
        System.out.println(sumOfPoint/sumOfCredit);
        
    }
    
    public static double getPointPerRating(String rating) {
        
        switch(rating) {
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }
}