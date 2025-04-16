package Comparable;

public class Employee implements Comparable<Employee>{

    String name;
    Integer id;
    Integer salary;

    public Employee(String name, Integer id, Integer salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
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


	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
    
    
}
