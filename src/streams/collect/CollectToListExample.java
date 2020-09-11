package streams.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//열거형타입
enum Gender {
	MALE, FEMALE;
}

class Student {
	// 필드
	String name;
	int age;
	Gender gender;

	// 생성자
	public Student(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

}

public class CollectToListExample {

	public static void main(String[] args) {
		Student s1 = new Student("허성준", 25, Gender.MALE);
		Student s2 = new Student("최형준", 27, Gender.MALE);
		Student s3 = new Student("문선애", 29, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3);
		//남학생들
		Collector<Student, ?, List<Student>> collector = Collectors.toList(); // 저장할장소, 처리, 병렬방식 셋은 toSet();
		List<Student> newList = students.stream()
		.filter(s -> s.gender == Gender.MALE)
		.collect(collector);
		
		newList.stream() //새로운 컬렉션을 만들겠다
		.forEach(s -> System.out.println(s.name + "," + s.age));
		// .forEach(s ->System.out.println(s.name + ", " + s.age));
		
		//나이가 25넘는 사람들 셋에 담기
		System.out.println("25세 이상인 학생들");
		Set<Student> set = students.stream()
				.filter(s -> s.age > 25)
				.collect(Collectors.toSet());
		Iterator<Student> iter = set.iterator();
		while(iter.hasNext()) {
			Student s =iter.next();
			System.out.println(s.name + ", " + s.age);
		}

	}

}
