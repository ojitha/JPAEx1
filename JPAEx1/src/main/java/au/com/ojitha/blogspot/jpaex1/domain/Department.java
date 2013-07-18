package au.com.ojitha.blogspot.jpaex1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

}
