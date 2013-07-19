package au.com.ojitha.blogspot.jpaex1.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;

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
