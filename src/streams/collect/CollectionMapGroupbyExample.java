package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapGroupbyExample {

	public static void main(String[] args) {
		
		Student s1 = new Student("허성준", 25, Gender.MALE);
		Student s2 = new Student("최형준", 27, Gender.MALE);
		Student s3 = new Student("문선애", 29, Gender.FEMALE);
		Student s4 = new Student("김다희", 31, Gender.FEMALE);
		List<Student> students = Arrays.asList(s1, s2, s3, s4);
		
		Map<Gender, List<Student>> map;
		
//		Gender.MALE - Student1, Student2;
//		Gender.FEMALE - Student3, Student4;
		
		Map<Gender, List<Student>> gMap = students.stream() 
		.collect(Collectors.groupingBy(new Function<Student, Gender>() {
			@Override
			public Gender apply(Student t) {
				return t.gender;
			}
			}, Collectors.toList())); //젠더에 해당하는 요소 리스트에 담겠다
		
		Set<Gender> set = gMap.keySet();
		for(Gender g : set) { //g가 키값 리스트가 밸류
			System.out.println(g);
			List<Student> list = gMap.get(g);
			for(Student s : list) {
				System.out.println(s.name+ ", " + s.age);
			}
		}
//		결과
//		MALE
//		허성준, 25
//		최형준, 27
//		FEMALE
//		문선애, 29
//		김다희, 31

	}

}
