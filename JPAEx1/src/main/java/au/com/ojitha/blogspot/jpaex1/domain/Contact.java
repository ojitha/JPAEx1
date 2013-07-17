/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.ojitha.blogspot.jpaex1.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 *
 * @author Ojitha
 */
@Embeddable
public class Contact implements Serializable {
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    
}
