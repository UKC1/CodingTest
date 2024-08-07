import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Student {
		String name;
		int kor;
		int eng;
		int math;
		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		public int getEng() {
			return eng;
		}

		public int getKor() {
			return kor;
		}

		public int getMath() {
			return math;
		}

		public String getName() {
			return name;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Student> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new Student(name, kor, eng, math));
		}
		list.sort(Comparator.comparingInt(Student::getKor).reversed().thenComparingInt(Student::getEng).reversed().thenComparingInt(Student::getMath).reversed().thenComparing(Student::getName));
		for (int i = 0; i < N; i++) {
			System.out.println(list.get(i).name);
		}
	}
}