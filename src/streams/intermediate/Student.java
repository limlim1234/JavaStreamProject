package streams.intermediate;

import java.util.Objects;



public class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int hashCode() {
	
		// return this.score;
		return Objects.hashCode(this.name) + this.score;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student that = (Student) obj;
//			return this.score == that.score;
//			return this.name == that.name;
			return this.name.equals(that.name) && this.score == that.score;

		} else {
			return false;
		}
	}

//소스 - 투 스트링
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
@Override
public int compareTo(Student that) {
	return this.score - that.score; //음수값: 오름차순, 양수값: 내림차순
	}
}
