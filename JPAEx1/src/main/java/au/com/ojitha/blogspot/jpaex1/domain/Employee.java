package au.com.ojitha.blogspot.jpaex1.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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


    
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="DEPT_ID")
    private Department department;
    
    @OneToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="ASSET_NO")
    private Asset asset;
    
    @ManyToMany(cascade={CascadeType.PERSIST})
    @JoinTable(name="EMP_WORK", 
    	joinColumns=@JoinColumn(name="LINK_EMP_ID"),
    	inverseJoinColumns=@JoinColumn(name="LINK_WORK_ID" )	)
    private Collection<Work> works;
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Collection<Work> getWorks() {
		return works;
	}

	public void setWorks(Collection<Work> works) {
		this.works = works;
	}
	
	
 
}
