package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
 
   public static List<Employee> getEmpList() {
	   Connection conn = ConnectionDB.getDB();
	   List<Employee> list = new ArrayList<>();
      String sql = "select employee_id, first_name, last_name, email, hire_date, job_id, salary" 
            +"\n"+ "from employees";
      
      try {
         
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            Employee e = new Employee();
            e.setEmployeeId(rs.getInt("employee_id"));
            e.setFirstName(rs.getString("first_name"));
            e.setLastName(rs.getString("last_name"));
            e.setEmail(rs.getString("email"));
            e.setHireDate(rs.getDate("hire_date").toLocalDate());
            e.setJobid(rs.getString("job_id"));
            e.setSalary(rs.getInt("salary"));
            
            list.add(e);
         }
         } catch (SQLException e) {

         e.printStackTrace();
      }
         
         
      return list;
      }
      
   }
   
   //List<Employee> getEmpList();
