package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public PersonVO() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO personVO)) return false;

        return Objects.equals(id, personVO.id) && Objects.equals(firstName, personVO.firstName) && Objects.equals(lastName, personVO.lastName) && Objects.equals(address, personVO.address) && Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(firstName);
        result = 31 * result + Objects.hashCode(lastName);
        result = 31 * result + Objects.hashCode(address);
        result = 31 * result + Objects.hashCode(gender);
        return result;
    }
}
