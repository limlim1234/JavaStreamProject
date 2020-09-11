package streams.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		stream.flatMap(new Function<Integer, Stream<Integer>>(){
			@Override
			public Stream<Integer> apply(Integer t) {
				return Stream.of(t * 3);
			}
		}).forEach(System.out::println);
		
//		DoubleStream.of(0.3);
		//인컴부분 가져오기
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee, DoubleStream>() {
			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
		
			}
			//요소를 가져와야함

			/*
		 * }).filter(n -> n>2000).reduce(new DoubleBinaryOperator() {
		 * 
			 * @Override public double apply(double left, double right) { return
			 * left > right ? left:right; }
			 */
		}).reduce(new DoubleBinaryOperator() {

			@Override
			public double applyAsDouble(double left, double right) {
				System.out.println(left + ", " + right);
				return left + right;
			}
			
		});
				
		//참이면
	if(	result.isPresent())
System.out.println("result: " + result);
	else System.out.println("결과 없음");
		//forEach(System.out::println);
		//이름 가져오기
		Employee.employees().stream().flatMap(new Function<Employee, Stream<String>>() { //string은 이런식으로 써야함 Stream.of포함

			@Override
			public Stream<String> apply(Employee t) {
	//			Stream<String>stream=Stream.of(t.getName());
		//		return stream;	
				return Stream.of(t.getName());
			}
		}).//findFirst().ifPresent(System.out::println); //결과값이 있는지 없는지
		forEach(System.out::println);
		
	Optional<LocalDate> result2 = Employee.employees().stream().flatMap(new Function<Employee, Stream<LocalDate>>() {

			@Override
			public Stream<LocalDate> apply(Employee t) {
				
				return Stream.of(t.getDateOfBirth());
			}
			//리듀스로 최댓값 최솟값가져오기
			//최솟값 가져오기
		}).reduce(new BinaryOperator<LocalDate>() {

			@Override
			public LocalDate apply(LocalDate t, LocalDate u) {
				System.out.println(t+ ", " + u); //1991-01-01부터 결과
				return t.isBefore(u)? u:t; // 1 2 비교해서 작은값 밑으로 내려와서 3과 다시 비교하는식
			}
			
		});
		//.forEach(System.out::println);;
		System.out.println("min 값: " + result2 );
	}

}
