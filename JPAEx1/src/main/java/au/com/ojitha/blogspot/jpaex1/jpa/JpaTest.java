package au.com.ojitha.blogspot.jpaex1.jpa;

import au.com.ojitha.blogspot.jpaex1.domain.Address;
import au.com.ojitha.blogspot.jpaex1.domain.Contact;
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		System.out.println(".. done");
	}




	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
                    Address addr1 = new Address();
                    addr1.setStreet("11 SummerLane");
                    addr1.setSuburb("Murrable");
                    addr1.setState(State.ACT);
                    Contact cont1 = new Contact();
                    cont1.setAddress(addr1);
                    Employee emp1 = new Employee();
                    emp1.setFirstName("Ojitha");
                    emp1.setLastName("Kumanayaka");
                    emp1.setContact(cont1);
                    manager.persist(emp1);
		}
	}


	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}


}
