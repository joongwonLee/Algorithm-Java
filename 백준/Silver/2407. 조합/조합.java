
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
	static BufferedReader br;
	static StringTokenizer stn;
	
	static int n, m;
	
	static BigInteger result;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		output();
	}
	
	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		stn = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(stn.nextToken());
		m = Integer.parseInt(stn.nextToken());
		
	}
	
	static void solve() {
		BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        result = n1.divide(n2);
	}
	
	static void output() {
		System.out.println(result);
	}

}
