package au.com.ojitha.blogspot.jpaex1.jpa;

import au.com.ojitha.blogspot.jpaex1.domain.Address;
import au.com.ojitha.blogspot.jpaex1.domain.Contact;
import au.com.ojitha.blogspot.jpaex1.domain.Department;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import au.com.ojitha.blogspot.jpaex1.domain.Employee;
import au.com.ojitha.blogspot.jpaex1.domain.State;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		List<Employee> emps=null;
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			emps = test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		for (Employee employee : emps) {
			System.out.println("Id : "+ employee.getEmpId());
		}

		System.out.println(".. done");
	}




	private List<Employee> createEmployees() {
		List<Employee> employees = new ArrayList<>();
			Department dept = manager.find(Department.class, 2);
			if (dept == null){
				dept = new Department();
				dept.setName("Admin");
			}
                    Address addr1 = new Address();
                    addr1.setStreet("13 SummerLane");
                    addr1.setSuburb("Murrable");
                    addr1.setState(State.NSW);
                    Contact cont1 = new Contact();
                    cont1.setAddress(addr1);
                    Employee emp1 = new Employee();
                    emp1.setFirstName("Ojll");
                    emp1.setLastName("Mark");
                    emp1.setDepartment(dept);
                    emp1.setContact(cont1);

                    
                    Address addr2 = new Address();
                    addr2.setStreet("13 Mary bay");
                    addr2.setSuburb("Murrable");
                    addr2.setState(State.ACT);
                    Contact cont2 = new Contact();
                    cont2.setAddress(addr2);
                    Employee emp2 = new Employee();
                    emp2.setFirstName("Romio");
                    emp2.setLastName("Juliat");
                    emp2.setDepartment(dept);
                    emp2.setContact(cont2);
                    
                    Department dept3 = new Department();
                    dept3.setName("payroll");
                    Address addr3 = new Address();
                    addr3.setStreet("13 bay");
                    addr3.setSuburb("Murgge");
                    addr3.setState(State.ACT);
                    Contact cont3 = new Contact();
                    cont3.setAddress(addr3);
                    Employee emp3 = new Employee();
                    emp3.setFirstName("Kava");
                    emp3.setLastName("Saki");
                    emp3.setDepartment(dept3);
                    emp3.setContact(cont2);
                    
                    manager.persist(emp1);
                    manager.persist(emp2);
                    manager.persist(emp3);
                    employees.add(emp1);
                    employees.add(emp2);
                    employees.add(emp3);
                    
                    
		return employees;
	}
}
