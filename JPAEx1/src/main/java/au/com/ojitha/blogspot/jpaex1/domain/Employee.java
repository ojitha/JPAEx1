/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.ojitha.blogspot.jpaex1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Ojitha
 */
@Entity
public class Employee extends Person{
    @Id
    @Column(name = "EMP_ID")
    private int empId;

    private Contact contact;
    
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
 
}
