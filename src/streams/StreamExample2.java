package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student {
	String name;
	int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

public class StreamExample2 {

	public static void main(String[] args) {
		// 최재영, 90/ 민해주 88/ 김상민83/ 최형준 86
		// score>= 85 몇명인지 rCnt 변수에 담기
		// 3명 출력 85점이상
		List<Student> list = Arrays.asList(new Student("최재영", 90), new Student("민해주", 88), new Student("김상민", 83),
				new Student("최형준", 86));

		Stream<Student> students = list.stream();
		long iCnt = 0;
		students.filter(t -> t.score >= 85)
				.peek((t) -> System.out.println("peek => " + t.name + ", " + t.score)) //민해주와 최형준은 85점이상이라 
				//peek에 나온것
				.filter(t -> t.name.startsWith("최")) //최가 들어간거 
				.forEach(new Consumer<Student>() { //최 들어가고 85점 이상임
					@Override
					public void accept(Student t) {
						System.out.println("forEach => " + t.name+ ", " + t.score);
					}
				});
		System.out.println("총 인원: " + iCnt);
	}

}
