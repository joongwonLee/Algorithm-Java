import java.util.*;
import java.io.*;

public class Main {
    
    static class Resistance {
        String value;
        long multi;
        
        public Resistance(String value, long multi) {
            this.value = value;
            this.multi = multi;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Resistance first = getResistance(br.readLine());
        Resistance second = getResistance(br.readLine());
        Resistance third = getResistance(br.readLine());
        
        long result = Long.parseLong(first.value+second.value) * third.multi;
        System.out.println(result);
    }
    
    static Resistance getResistance(String color) {
        
        switch(color) {
            case "black":
                return new Resistance("0", 1);
            case "brown":
                return new Resistance("1", 10);
            case "red":
                return new Resistance("2", 100);
            case "orange":
                return new Resistance("3", 1000);
            case "yellow":
                return new Resistance("4", 10000);
            case "green":
                return new Resistance("5", 100000);
            case "blue":
                return new Resistance("6", 1000000);
            case "violet":
                return new Resistance("7", 10000000);
            case "grey":
                return new Resistance("8", 100000000);
            case "white":
                return new Resistance("9", 1000000000);
            default:
                return new Resistance("error", 0);
        }
    }
}