package common;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import common.EmpDAO;
import common.Employee;


public class StreamMapExample {
   public static void main(String[] args) {
      EmpDAO emp = new EmpDAO();
      List<Employee> employees = emp.getEmpList();
      
      //salery가 10000 이상인 사원들 출력.
      
      employees.stream().filter(new Predicate<Employee>() {

         @Override
         public boolean test(Employee t) {
            return t.getSalary() > 10000;
         }
      }).forEach(System.out::println);
      
      
      System.out.println("----------------------------");
      
      List<Employee> employees1 = emp.getEmpList();
      
      employees1.stream().filter(new Predicate<Employee>() {

		@Override
		public boolean test(Employee t) {
			LocalDate a = LocalDate.of(1995, 01, 01);
			return t.getHireDate().isAfter(a);
		}
    	  
      }).forEach(System.out::println);
      
      System.out.println("----------------------------");
      
      List<Employee> employees2 = emp.getEmpList();
      employees2.stream().filter(new Predicate<Employee>() {

		@Override
		public boolean test(Employee t) {
			 LocalDate a = LocalDate.of(1995, 01, 01);
	    	  return t.getHireDate().isBefore(a);
			
		}
    	
      }).forEach(System.out::println);
      
      System.out.println("----------------------------");
      //reduce로 샐러리 최댓값 최솟값 구하기
      List<Employee> employee = null;
      try {
          employees = EmpDAO.getEmpList();
          System.out.println("---------------------");
          System.out.println("> salary가 가장큰사람의 salary : ");      
          OptionalInt sal = employees.stream()
                .flatMapToInt(new Function<Employee, IntStream>(){
                   @Override
                   public IntStream apply(Employee t) {
                      return IntStream.of(t.getSalary()); // Employee의 salary를 받아온 상태임
                   }
                }).reduce(new IntBinaryOperator() {

                   @Override
                   public int applyAsInt(int left, int right) {
                      
                      return left > right ? left : right; // 이미 샐러리로 선택되어있으니까 .getSalary 또 쓰지마
                   }
                });
          System.out.println(sal);
       } catch (SQLException e) {
          e.printStackTrace();
       }
    }



   }
   
}