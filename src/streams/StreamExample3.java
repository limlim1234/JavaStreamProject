package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*class ConClass implements Consumer<Student> {
 int sum = 0;
 int cnt = 0;
 
	@Override
	public void accept(Student t) {
	
		
	}
	
}*/
public class StreamExample3 {
	static int sum = 0, cnt = 0;

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("최재영", 90), new Student("민해주", 88), new Student("김상민", 83),
				new Student("최형준", 86));

		Stream<Student> stream = list.stream();
		// forEach(총 점수 , 평균 가지고 오는 기능 구현); 변수 두개 필요

		stream.forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				sum += t.score;
				cnt++;

			}

		});
		System.out.println("총점: " + sum + ", 평균: " + (sum / (double) cnt));

	}

}
