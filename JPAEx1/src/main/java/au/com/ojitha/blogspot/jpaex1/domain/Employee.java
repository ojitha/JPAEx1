package au.com.ojitha.blogspot.jpaex1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

/**
 *
 * @author Ojitha
 */
@Entity
public class Employee extends Person{
    @Id
	@TableGenerator(name = "empId_Gen", 
		table = "ID_GEN", 
		pkColumnName = "ID_NAME", 
		valueColumnName = "LAST_VAL", 
		initialValue = 0,
		allocationSize=1)
    @GeneratedValue(generator="empId_Gen")
    @Column(name = "EMP_ID")
    private int empId;

    private Contact contact;
    
    @ManyToOne(cascade={CascadeType.PERSIST})
    private Department department;
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
 
}
