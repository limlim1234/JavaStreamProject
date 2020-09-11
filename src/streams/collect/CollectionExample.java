package streams.collect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import streams.intermediate.Student;

public class CollectionExample {

	public static void main(String[] args) {
		Set<String> setStr = new HashSet<>(); // set은 순서가 없다
		setStr.add(new String("최재영"));
		setStr.add(new String("민해주"));
		setStr.add(new String("김상민"));

		Iterator<String> iter = setStr.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

		List<Student> students = new ArrayList<>();
		students.add(new Student("허성준", 80));
		students.add(new Student("최형준", 90));

		for (Student s : students) {
			System.out.println(s);
		}

		List<Student> studentsw = new ArrayList<>();
		studentsw.add(new Student("김다희", 80));
		studentsw.add(new Student("김도은", 90));

		List<Student> studentr = new ArrayList<>();
		studentr.add(new Student("홍길동", 50));
		studentr.add(new Student("김유신", 45));

		Map<String, Integer> map = new HashMap<>(); // 맵은 키 밸류
		map.put("동광희", 25);
		map.put("김시무", 26);

		Set<String> key = map.keySet(); // 키를 기준으로 밸류 가져올수있음
		Iterator<String> itr = key.iterator();
		while (itr.hasNext()) {
			String k = itr.next(); // 키에 해당값을 가져옴
			System.out.println(map.get(k)); // value값을 가지고옴 키값을 넣어주면 밸류값됨
		}

		Map<String, List<Student>> stMap = new HashMap<>(); // 밸류가 컬렉션
		stMap.put("남자", students);
		stMap.put("여자", studentsw);
		stMap.put("재평가", studentr);

		Set<String> setk = stMap.keySet();
		for (String s : setk) {
			System.out.println(s);
			// 스튜던츠가 컬렉션이니까
			List<Student> valueList = stMap.get(s);
			for (Student st : valueList) {
				System.out.println(st);

	
			}

		}
			System.out.println("-------------");
		Set<String> setr = stMap.keySet();
		for (String r : setr) {
			System.out.println(r);

			List<Student> valueList1 = stMap.get(r);
			for (Student sr : valueList1) {
				System.out.println(sr);
			}
		}

}

}
