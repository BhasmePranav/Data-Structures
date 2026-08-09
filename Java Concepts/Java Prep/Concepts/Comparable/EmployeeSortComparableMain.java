package Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeSortComparableMain {
	
	public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Pranav" , 7 , 67000));
        empList.add(new Employee("Jack" , 45 , 60000));
        empList.add(new Employee("Dino" , 23 , 45000));
        
        Collections.sort(empList);
        for(Employee e : empList)
        {
        	System.out.println(e.getName()+"  "+e.getSalary()+"  "+e.getId());
        }
        
	}

}
