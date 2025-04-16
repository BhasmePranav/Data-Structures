package Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeComparatorMain {
    
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Pranav" , 7 , 67000));
        empList.add(new Employee("Jack" , 45 , 60000));
        empList.add(new Employee("Dino" , 23 , 45000));

        SortBySalary sc = new SortBySalary();
        Collections.sort(empList  , sc);
        System.out.println("Sorted By Id");
        for(Employee e : empList)
        {
        	System.out.println(e.getName()+"  "+e.getSalary()+"  "+e.getId());
        }
        
        System.out.println("\n\nSorted By Name");
        SortByName sn = new SortByName();
        Collections.sort(empList  , sn);
        
        for(Employee e : empList)
        {
        	System.out.println(e.getName()+"  "+e.getSalary()+"  "+e.getId());
        }
        
    }
}
