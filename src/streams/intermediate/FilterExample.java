package streams.intermediate;

import java.util.List;
import java.util.function.Predicate;

public class FilterExample {

	public static void main(String[] args) {
		List<Employee> list = Employee.employees();
		list.stream().filter(new Predicate<Employee>() { // 스트림생성
			@Override
			public boolean test(Employee t) {
				return t.isMale();
			}
		}).peek(s -> {
			s.setIncome(s.getIncome()*0.9);
		}).forEach(System.out::println);
		
/*		list.stream().filter(new Predicate<Employee() {
			return t.getDateOfBirth().isBefore(LocalDate.of(1993,Mont }
			}).forEach(System.out::println);
		} */
	}

}
