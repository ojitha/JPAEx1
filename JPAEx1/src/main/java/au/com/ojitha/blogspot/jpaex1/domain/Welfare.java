package au.com.ojitha.blogspot.jpaex1.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.TableGenerator;

@Entity
public class Welfare {
	
	@Id
	@TableGenerator(name = "welfareId_Gen", 
	table = "ID_GEN", 
	pkColumnName = "ID_NAME", 
	valueColumnName = "LAST_VAL", 
	initialValue = 0,
	allocationSize=1,
	pkColumnValue="seniority_id"
	)
	@GeneratedValue(generator="welfareId_Gen")
	private int seniority_id;
	
	@OneToMany(mappedBy="welfare")
	@OrderColumn(name="seniority_id")
	public List<Employee> employees;
}
