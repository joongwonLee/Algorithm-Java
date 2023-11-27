import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//input
	static int X;
	static String str;
	
	//sol
	static int rpt; //blinking을 반복할 횟수
	static ArrayList<Character> charList; //입력으로 들어온 str을 하나씩 받는 list
	static ArrayList<String> strList; //blinking한 str을 저장하는 list
	
	//output
	static String result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		input();
		sol();
		output();
	}
	
	static void input() throws NumberFormatException, IOException {
		X = Integer.parseInt(br.readLine());
		str = br.readLine();
	}
	
	static void sol() {
		charList = new ArrayList<Character>();
		strList = new ArrayList<String>();
		
		for(int i = 0; i < str.length(); i++) {
			charList.add(str.toCharArray()[i]);
		}
		
		//입력으로 들어온 str은 strList에 무조건 저장 
		strList.add(str);
		
		//최대 str의 글자 길이만큼 돌면서 blinking을 시도 
		for(int i = 0; i < str.length(); i++) {
			String blinkStr = blinking();
			//blinking이 입력 str과 같을 때 반복문 종료 
			if(blinkStr.equals(str)) {
				break;
			}
			//blinking한 결과가 입력 str과 다르다면 strList에 저장 
			strList.add(blinkStr);
		}
		
		//strList.size(): blinking이 되고 있는 패턴의 길이 
		X = X%strList.size();
		
		//strList에서 횟수에 맞는 문자열을 꺼내 result에 대입 
		//strList가 1일땐, indexOutOfBoundsException이 뜨므로 분기 처리 
		if(strList.size()==1) result = strList.get(0);
		else result = strList.get(strList.size()-X);
	}
	
	static String blinking() {
		//글자 길이에 따라 글자들이 blink되는 횟수 규칙이 있음
		//len=5이면 2, len=6이면 2, len=7이면 3, len=8이면 3...
		int len = charList.size();
		if(len%2==0) rpt =len/2-1;
		else rpt = len/2;
		
		//blink되는 규칙 
		//1. 맨 뒤 요소를 char에 담음
		//2. 맨 뒤 요소 삭제
		//3. idx번째 요소에 char 추가 
		//4. idx는 2씩 증가 (원래 i번째 인덱스에 추가하는 것이지만 i-1번째 blink에서 추가가 되었기 때문에)
		int idx = 1;
		for(int i = 0; i < rpt; i++) {
			char c = charList.get(len-1);
			charList.remove(len-1);
			charList.add(idx, c);
			idx+=2;
		}

		//blinking된 list를 문자열로 변환 
		String arrStr = charList.toString();
		arrStr = arrStr.substring(1,arrStr.length()-1);
		arrStr = arrStr.replaceAll(", ", "");
		
		return arrStr;
	}
	
	static void output() {
		System.out.println(result);
	}
}
