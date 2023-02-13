package b_클래스배열;

public class 클배_문자열테스트1 {

	/* 9:55~10:20
	 * class Student{
	 * 	String name;
	 * 	int score;
	 * }
	 */
	public static void main(String[] args) {

		String data = "";
		data += "김영희/30\n";
		data += "이만수/40\n";
		data += "이철민/60";

		// 문제1)data에 있는 내용을 잘라서 studentList 에 저장후 전체출력
		String temp[] = data.split("\n");
		Student[] studentList = new Student[temp.length];
		System.out.println("============");
		System.out.printf("%s\t%s\n", "이름", "점수");
		System.out.println("------------");
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			Student st = new Student();
			st.name = temp2[0];
			st.score = Integer.parseInt(temp2[1]);
			studentList[i] = st;
			System.out.printf("%s\t%d\n", st.name, st.score);
		}
		System.out.println("============");

		// 문제2)꼴등 삭제후 다시 data에 저장
		int min = 100;
		int idx = 0;
		data = "";
		System.out.println("data");
		System.out.println("------------");
		for (Student st : studentList) {
			if (min > st.score) {
				min = st.score;
				continue;
			}
			data += st.name + "/" + st.score + "\n";
			idx++;
		}
		System.out.println(data);
	}
}
