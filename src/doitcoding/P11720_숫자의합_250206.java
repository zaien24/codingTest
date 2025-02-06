import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static String sNum;
	static char[] cNum;

	public static void proc() {
		int result = 0;
		cNum = sNum.toCharArray();

		for (int i = 0; i < cNum.length; i++) {
			result += cNum[i] - '0';
		} 

		System.out.println(result);
	}

	public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		sNum = st.nextToken();
	}
	public static void main(String[] args) throws Exception {
		input();
		proc();
	}


}