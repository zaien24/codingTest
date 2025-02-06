public class Main {

	static int N;
	static String src;
	static int[] tmp;

	public static void proc() {
		int result = 0;
		= src.toCharArray();

		for (int i = 0; i < tmp.size;) {
			result += result + tmp[i];
		} 

		System.out.println(result);
	}

	public static void input() {
        BufferReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken);

		st = new StringTokenizer(br.readLine());
		src = st.nextToken;
	}
	public static void main(String[] args) {
		input();
		proc();
	}


}