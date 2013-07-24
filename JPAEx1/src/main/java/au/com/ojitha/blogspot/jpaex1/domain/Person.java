package au.com.ojitha.blogspot.jpaex1.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 *
 * @author Ojitha
 */
@MappedSuperclass
public class Person {
    


    @OneToMany(cascade={CascadeType.PERSIST})
    private Collection<Phone> phones;

    @Embedded
    private Contact contact;
    
    @Embedded
    private PersonDetails personDetails;
    
	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

	public PersonDetails getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}
    
    
}
