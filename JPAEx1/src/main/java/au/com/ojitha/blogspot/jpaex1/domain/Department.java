package au.com.ojitha.blogspot.jpaex1.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "DEPT")
public class Department {
	@Id
	@TableGenerator(name = "deptId_Gen", 
		table = "ID_GEN", 
		pkColumnName = "ID_NAME", 
		valueColumnName = "LAST_VAL", 
		initialValue = 0,
		allocationSize=1)
	@GeneratedValue(generator="deptId_Gen")
	@Column(name = "DEPT_ID")
	private int deptId;

	@Column(name = "DEPT_NAME")
	private String name;

	@OneToMany(mappedBy="department")
	@OrderBy("personDetails.firstName ASC")
	private Collection<Employee> employees;
	
	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

}
