package streams.collect;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseExample {

	public static void main(String[] args) {
	 //employee 테이블.
	//입사일자 기준  1990년대 입사한 사람들
		//List 컬렉션에 저장
		List<Employee> employee = new ArrayList<>();
		employee = EmpDAO.getEmpList();
		LocalDate date1 = 
				LocalDate.parse("1990-01-01",DateTimeFormatter.ISO_DATE);
		employee.stream()
		.filter(a -> a.getHireDate().isAfter(date1)&&a.getHireDate().
		isBefore(LocalDate.parse("1999-12-31",DateTimeFormatter.ISO_DATE)))
		.forEach(System.out::println);
//		LocalDate date2 = 
//				
//				employee.stream()
//				.filter(b -> a.getHireDate().isBefore(LocalDate.parse("1999-12-31",DateTimeFormatter.ISO_DATE))).forEach(System.out::println);
				
		
		//job =>ST_CLERK 인 사람들의 이름과 급여를 컬렉션에 저장	
		System.out.println("----------------");
		
		
	Map<String, Integer> Empmap = employee.stream().filter(s ->s.getJobid().equals("ST_CLERK"))
			.collect(Collectors.toMap(new Function<Employee, String>() {
				@Override
				public String apply(Employee t) {
					return t.getLastName();
				}
			},new Function<Employee, Integer>() {
				@Override
				public Integer apply(Employee t) {
					return t.getSalary();
				}
			}));
	Set<String> keys = Empmap.keySet();
	for (String s : keys) {
		System.out.println("이름: " + s+", 급여: " + Empmap.get(s));
	}
		
		
				
		
		}

}
