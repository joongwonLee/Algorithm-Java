import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        char[][] seats = new char[11][21];
        for(int i=1; i<=10; i++) {
            for(int j=1; j<=20; j++) {
                seats[i][j] = '.';
            }
        }
        
        for(int i=0; i<N; i++) {
            String seat = br.readLine();
            char column = seat.charAt(0);
            int row = Integer.parseInt(seat.substring(1, seat.length()));

            seats[column-64][row] = 'o';
        }

        for(int i=1; i<=10; i++) {
            for(int j=1; j<=20; j++) {
                System.out.print(seats[i][j]);
            }
            System.out.println();
        }
    }
}