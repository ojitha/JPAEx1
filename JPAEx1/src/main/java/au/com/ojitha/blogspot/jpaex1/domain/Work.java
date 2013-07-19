package au.com.ojitha.blogspot.jpaex1.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Work {

	@Id
	@TableGenerator(name = "workId_Gen", 
		table = "ID_GEN", 
		pkColumnName = "ID_NAME", 
		valueColumnName = "LAST_VAL", 
		initialValue = 0,
		allocationSize=1,
		pkColumnValue="WORK_ID")
	@GeneratedValue(generator="workId_Gen")
	@Column(name="WORK_ID")
	private int workId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@ManyToMany(cascade={CascadeType.PERSIST},mappedBy="works")
	private Collection<Employee> employees;

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	
}
