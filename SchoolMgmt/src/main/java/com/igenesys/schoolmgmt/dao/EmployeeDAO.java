package com.igenesys.schoolmgmt.dao;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.igenesys.schoolmgmt.model.BaseReturn;
import com.igenesys.schoolmgmt.model.Employee;
import com.igenesys.schoolmgmt.model.ResponseStatus;



@Repository
public class EmployeeDAO {

	  private ResourceBundle resourBundle = ResourceBundle.getBundle("messages", Locale.US);
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  
	  public BaseReturn getEmployee(){
		  BaseReturn baseReturn = null;
		  try {
			String sql = "select *from employee order by empid";
			  List result = jdbcTemplate.queryForList(sql);
			 
			  ResponseStatus status = ResponseStatus.SUCCESS;
			  baseReturn = new BaseReturn(status.name(), status.getValue(), result);
		} catch (Exception e) {
		      ResponseStatus responseStatus = ResponseStatus.ERROR;
		      baseReturn = new BaseReturn(responseStatus.name(),responseStatus.getValue());

		}
	      
		   return baseReturn;
		}
	  
	  public BaseReturn insertEmployee(Employee employee){
		  BaseReturn baseReturn = null;
		  try {
			String sql = "INSERT INTO public.employee(empname, age, address, salary) VALUES ('"+employee.getEmpname()+"',"+employee.getAge()+",'"+employee.getAddress()+"',"+employee.getSalary()+")";
			  jdbcTemplate.update(sql);
			  String SQL = "select *from employee order by empid";
			  List result = jdbcTemplate.queryForList(SQL);
			  ResponseStatus status = ResponseStatus.SUCCESS;
			  baseReturn = new BaseReturn(status.name(), status.getValue(), result);
		} catch (Exception e) {
			  ResponseStatus status = ResponseStatus.ERROR;
			  baseReturn = new BaseReturn(status.name(), status.getValue());
		}
		return baseReturn;
	  }
	  
	  public BaseReturn updateEmployee(Employee employee){
		  BaseReturn baseReturn = null;
		  try {
			String sql ="UPDATE public.employee SET  empname='"+employee.getEmpname()+"', age="+employee.getAge()+", address='"+employee.getAddress()+"', salary="+employee.getSalary()+" WHERE empid="+employee.getEmpid()+"";
			  jdbcTemplate.update(sql);
			  String SQL ="select *from employee order by empid";
			  List result = jdbcTemplate.queryForList(SQL);
			  ResponseStatus status = ResponseStatus.SUCCESS;
			  baseReturn = new BaseReturn(status.name(), status.getValue(), result);
		} catch (Exception e) {
			  ResponseStatus status = ResponseStatus.ERROR;
			  baseReturn = new BaseReturn(status.name(), status.getValue());		
			  }
		  return baseReturn;
	  }
	  
	  public BaseReturn deleteEmployee(Employee employee){
		  BaseReturn baseReturn=null;
		  try {
			String sql = "delete from employee where empid="+employee.getEmpid()+"";
			  jdbcTemplate.update(sql);
			  String SQL ="select *from employee order by empid";
			  List rs = jdbcTemplate.queryForList(SQL);
			  ResponseStatus status = ResponseStatus.SUCCESS;
			  baseReturn = new BaseReturn(status.name(), status.getValue(),rs);
		} catch (Exception e) {
			
			ResponseStatus status = ResponseStatus.ERROR;
			  baseReturn = new BaseReturn(status.name(), status.getValue());
		}
		  return baseReturn;
	  }
}
