package streams.intermediate.terminate;

import java.sql.SQLException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;


public class ReduceExample {

	public static void main(String[] args) throws SQLException {
		
//사원의 평균급여를 계산
		List<Employee> empList = EmpDAO.getEmpList();
		
		//전체사원의 컬렉션을 통해 스트림생성
		Stream<Employee> stream= empList.stream();
		//Employee -> IntStream매핑
		OptionalDouble avg =stream.filter(new Predicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getJobid().equals("IT_PROG");  
		}
	}).flatMapToInt(new Function<Employee, IntStream>() {

			@Override
			public IntStream apply(Employee t) {
				
				return IntStream.of(t.getSalary());
			}
			
		}).average(); //최종처리
		
		
		System.out.println("평균급여는: " + avg.getAsDouble());
		
		
		
		
		
	}

}
