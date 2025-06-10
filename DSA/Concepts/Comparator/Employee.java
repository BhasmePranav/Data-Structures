package Comparator;

import java.util.Comparator;

public class Employee {

    String name;
    Integer id;
    Integer salary;

    public Employee(String name, Integer id, Integer salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    public Employee() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

class SortBySalary implements Comparator<Employee>
{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.salary.compareTo(o2.salary);
    }
    
}

class SortByName implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1 , Employee e2)
	{
		return e1.getName().compareTo(e2.getName());
	}
}
