package streams;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FromArrayExample {

	public static void main(String[] args) {
		int[] intAry = { 3, 6, 4, 9, 7 };
		IntStream iStream = Arrays.stream(intAry);
		
		//iStream.filter((value) -> value >5)
		//.forEach((int value) -> System.out.println(value)); 람다식 밑에 두개} 빼고는 다 지워도됨
		iStream.filter(new IntPredicate() {
			@Override
			public boolean test(int value) {
			
				return value>5;
			}
			
		}).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println(value);
				
			}
			
		});
		iStream = Arrays.stream(intAry);
		long cnt =iStream.count();
		System.out.println("cnt: " + cnt);
		
		iStream = Arrays.stream(intAry);
		long cnt1 =iStream.sum();
		System.out.println("cnt: " + cnt1);
		
		iStream = Arrays.stream(intAry, 0, 4); //의미는 배열4번번호 빼고 출력하겠다 3 6 4 9 이렇게 4개 카운트는 4개
		cnt = iStream.peek(t -> System.out.println(t)).count(); //peek는 중간처리 3 6 4 9 가져옴
		System.out.println("cnt: " + cnt);
		
	}

}

