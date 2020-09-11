package streams.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class CollectionDataBaseGroupbyExample {
	public static void main(String[] args) {
		// 직무별 - 사원 이름
		List<Employee> employee = new ArrayList<>();
		employee = EmpDAO.getEmpList();
		
		Map<String, List<Employee>> gMap = employee.stream() 
		.collect(Collectors.groupingBy(new Function<Employee, String>() {

			@Override
			public String apply(Employee t) {
				return t.getJobid();
			
			}
			
		}, Collectors.toList()));
		
		Set<String> set = gMap.keySet();
		for(String g : set) {
			System.out.println(g);
			List<Employee> list = gMap.get(g);
			for(Employee s : list) {
				System.out.println(s); 
		//		s.getJobid()+", " + s.getLastName()
				//"부서 : " + s + "사원: " + gMap.get(s));
			}
		}
		
	}
}
