import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chessboard = new char[8][8];
        
        for(int i=0; i<8; i++) {
            chessboard[i] = br.readLine().toCharArray();
        }
        
        int count = 0;
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(i%2==0&&j%2==0&&chessboard[i][j]=='F') count++;
                else if(i%2==1&&j%2==1&&chessboard[i][j]=='F') count++;
            }
        }
        
        System.out.println(count);
    }
}