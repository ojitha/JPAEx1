package au.com.ojitha.blogspot.jpaex1.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author Ojitha
 */
@Embeddable
public class Address implements Serializable{
    @Column(name = "STREET")
    private String street;
    
    @Column(name = "SUBURB")
    private String suburb;

    @Enumerated(EnumType.STRING)
    private State state;
    
    public String getStreet() {
        return street;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    
    
}
