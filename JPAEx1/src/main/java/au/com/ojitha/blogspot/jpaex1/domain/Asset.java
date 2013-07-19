package au.com.ojitha.blogspot.jpaex1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

@Entity
public class Asset {
	@Id
	@TableGenerator(name = "assetNo_Gen", 
		table = "ID_GEN", 
		pkColumnName = "ID_NAME", 
		valueColumnName = "LAST_VAL", 
		initialValue = 0,
		allocationSize=1)
	@GeneratedValue(generator="assetNo_Gen")
	@Column(name="ASSET_NO")
	private int assetNo;
	
	@OneToOne(mappedBy="asset")
	private Employee employee;
	
	@Column(name="BUILDING_NO")
	private int building;

	public int getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(int assetNo) {
		this.assetNo = assetNo;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
}
