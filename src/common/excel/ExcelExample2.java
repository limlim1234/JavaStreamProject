package common.excel;

import java.util.List;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class ExcelExample2 {
	public static void main(String[] args) {
		//IT_PROG 사원들의 사원번호, 이름, 메일주소, 급여, 입사일 정보를 생성하는 코드 it_prog.xls로 생성하세요
		EmployeeExcelWriter2 writer = new EmployeeExcelWriter2(); 

		List<Employee> list = EmpDAO.getEmpList();
		List<Employee> emp = list.stream().filter(s -> s.getJobid().equals("IT_PROG")).collect(Collectors.toList());
		// 다시 호출
		writer.xlsWriter(emp);
		System.out.println("엑셀 완료");

	}
}
