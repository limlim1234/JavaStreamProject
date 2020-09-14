package common.excel;

import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import common.EmpDAO;
import common.Employee;

public class ExcelExample {
	
   public static void main(String[] args) {
      
      EmployeeExcelWriter writer = new EmployeeExcelWriter();
      
         List<Employee> list = EmpDAO.getEmpList();
         writer.xlsWriter(list);
      System.out.println("엑셀 완료");
      
   }

}

