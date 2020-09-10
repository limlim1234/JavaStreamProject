package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctExample {

	public static void main(String[] args) {
		String[] strAry = { "Hong", "Park", "Choi", "Hong" };
		Stream<String> sStream = Arrays.stream(strAry);
	sStream.distinct().forEach(System.out::println);
//		sStream.distinct().forEach(System.out::println);

		sStream = Arrays.stream(strAry);
		sStream.sorted().forEach(System.out::println); //사전순으로 

		Student[] students = { new Student("이화진", 50), new Student("이화진", 50), new Student("이화진", 55),
				new Student("동광희", 60), new Student("우청일", 70), new Student("김도은", 70) };

		Stream<Student> tStream = Arrays.stream(students);
//	tStream.distinct().forEach(System.out::println);
//		tStream.sorted().forEach(System.out::println); //에러남 스튜던크클래스 가서 impe하기
		tStream.sorted(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score; //비교하는거 
			}
		}).forEach(System.out::println);

	}

}
