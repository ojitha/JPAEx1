package au.com.ojitha.blogspot.jpaex1.jpa;

import au.com.ojitha.blogspot.jpaex1.domain.Address;
import au.com.ojitha.blogspot.jpaex1.domain.Asset;
import au.com.ojitha.blogspot.jpaex1.domain.Contact;
import au.com.ojitha.blogspot.jpaex1.domain.Department;
import au.com.ojitha.blogspot.jpaex1.domain.Leave;
import au.com.ojitha.blogspot.jpaex1.domain.PersonDetails;
import au.com.ojitha.blogspot.jpaex1.domain.Phone;
import au.com.ojitha.blogspot.jpaex1.domain.Work;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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
		EntityTransaction tx = manager.getTransaction();
		List<Employee> emps=null;
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
		
//		tx.begin();
//		Employee e = manager.find(Employee.class, 2);
//		Asset a = e.getAsset();
//		System.out.println(a.getEmployee().getEmpId());
//		tx.commit();

//		tx.begin();
//		Asset a = manager.find(Asset.class, 2);
//		Employee e = a.getEmployee();
//		System.out.println(e.getEmpId());
		
		
//		System.out.println(a.getEmployee().getEmpId());
//		tx.commit();

//		tx.begin();
//		Employee e = manager.find(Employee.class, 2);
//		Department d = e.getDepartment();
//		Collection<Employee> employees = d.getEmployees();
//		for (Employee employee : employees) {
//			System.out.println(employee.getEmpId());
//		}
//		tx.commit();
		
//		tx.begin();
//		Department d = manager.find(Department.class, 1);
//		Collection<Employee> employees = d.getEmployees();
//		for (Employee employee : employees) {
//			System.out.println(employee.getEmpId());
//		}
//		
//		tx.commit();
		
//		tx.begin();
//			test.addWork();
//		tx.commit();
		

		System.out.println(".. done");
	}




	private List<Employee> createEmployees() {
		List<Employee> employees = new ArrayList<>();
			Department dept = manager.find(Department.class, 2);
			if (dept == null){
				dept = new Department();
				dept.setName("Admin");
			}
			
			Work w1 = new Work();
			w1.setStartDate(new Date());
			w1.setDescription("work-1");
			
			Work w2 = new Work();
			w2.setStartDate(new Date());
			w2.setDescription("work-2");
			
			Work w3 = new Work();
			w3.setStartDate(new Date());
			w3.setDescription("work-3");
			
			List<Work> work1_2 = new ArrayList<Work>();
			work1_2.add(w1);
			work1_2.add(w2);
			
			List<Work> work2_3 = new ArrayList<Work>();
			work2_3.add(w2);
			work2_3.add(w3);
			
			List<Work> work3 = new ArrayList<Work>();
			work3.add(w3);
			


				
                    Address addr1 = new Address();
                    addr1.setStreet("13 SummerLane");
                    addr1.setSuburb("Murrable");
                    addr1.setState(State.NSW);
                    Contact cont1 = new Contact();
                    cont1.setAddress(addr1);
                    Employee emp1 = new Employee();
                    PersonDetails d1 = new PersonDetails();
                    emp1.setPersonDetails(d1);
                    d1.setFirstName("Ojll");
                    d1.setLastName("Mark");
                    emp1.setDepartment(dept);
                    emp1.setContact(cont1);
                    Asset a1 = new Asset();
                    a1.setBuilding(1);
                    emp1.setAsset(a1);
                    emp1.setWorks(work1_2);
                    
                    Address addr2 = new Address();
                    addr2.setStreet("13 Mary bay");
                    addr2.setSuburb("Murrable");
                    addr2.setState(State.ACT);
                    Contact cont2 = new Contact();
                    cont2.setAddress(addr2);
                    Employee emp2 = new Employee();
                    PersonDetails d2 = new PersonDetails();
                    d2.setFirstName("Romio");
                    d2.setLastName("Juliat");
                    emp2.setPersonDetails(d2);
                    emp2.setDepartment(dept);
                    emp2.setContact(cont2);
                    Asset a2 = new Asset();
                    a2.setBuilding(2);
                    emp2.setAsset(a2);
                    emp2.setWorks(work2_3);
                    Department dept3 = new Department();
                    dept3.setName("payroll");
                    Address addr3 = new Address();
                    addr3.setStreet("13 bay");
                    addr3.setSuburb("Murgge");
                    addr3.setState(State.ACT);
                    Contact cont3 = new Contact();
                    cont3.setAddress(addr3);
                    Employee emp3 = new Employee();
                    PersonDetails d3 = new PersonDetails();
                    emp3.setPersonDetails(d3);
                    d3.setFirstName("Kava");
                    d3.setLastName("Saki");
                    emp3.setDepartment(dept3);
                    emp3.setContact(cont2);
                    Asset a3 = new Asset();
                    a3.setBuilding(3);
                    emp3.setAsset(a3);
                    emp3.setWorks(work3);
                    manager.persist(emp1);
                    manager.persist(emp2);
                    manager.persist(emp3);
                    List<Leave> leaves = new ArrayList<Leave>();
                    Leave l1 = new Leave();
                    l1.setStartDate(new Date());
                    l1.setEndDate(Calendar.getInstance());
                    Leave l2 = new Leave();
                    l2.setStartDate(new Date());
                    l2.setEndDate(Calendar.getInstance());
                    Leave l3 = new Leave();
                    l3.setStartDate(new Date());
                    l3.setEndDate(Calendar.getInstance());
                    leaves.add(l1); leaves.add(l2); leaves.add(l3);
                    emp3.setLeaves(leaves);

                   
                    Phone p1 = new Phone();
                    p1.setPhoneNumber(1234);
                    Phone p2 = new Phone();
                    p2.setPhoneNumber(1434);
                    List<Phone> phones = new ArrayList<Phone>();
                    phones.add(p1);
                    phones.add(p2);
                    emp3.setPhones(phones);
                    
                   
                    
                    employees.add(emp1);
                    employees.add(emp2);
                    employees.add(emp3);
                    
                   
                    
		return employees;
	}
	

}
