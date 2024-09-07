import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String answer = "";

        for (int i = 0; i < 15; i++) {
            String str = br.readLine();

            for (int j = 0; j < 29; j++) {
                char word = str.charAt(j);

                if (word == 'w'){
                    answer = "chunbae";
                }else if(word == 'b'){
                    answer = "nabi";
                }else if(word == 'g'){
                    answer = "yeongcheol";
                }
            }
            
        }

        sb.append(answer);
        System.out.println(sb.toString());

    }
}