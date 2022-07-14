package ec.com.alexdevfs.sga.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;


@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByIdPersona", query = "SELECT p FROM Person p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Person.findByNombre", query = "SELECT p FROM Person p WHERE p.firstName = :nombre"),
    @NamedQuery(name = "Person.findByApellido", query = "SELECT p FROM Person p WHERE p.lastName = :apellido"),
    @NamedQuery(name = "Person.findByEmail", query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByTelefono", query = "SELECT p FROM Person p WHERE p.phone = :telefono")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Size(max = 45)
    @Column(name = "nombre")
    private String firstName;
    @Size(max = 45)
    @Column(name = "apellido")
    private String lastName;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
    @Size(max = 45)
    private String email;
    @Size(max = 45)
    @Column(name = "telefono")
    private String phone;
    
    @XmlTransient
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<User> userList;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
    
    public Person(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getPersonId() {
        return idPersona;
    }

    public void setPersonId(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "idPersona=" + idPersona + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + '}';
    }
    
}
