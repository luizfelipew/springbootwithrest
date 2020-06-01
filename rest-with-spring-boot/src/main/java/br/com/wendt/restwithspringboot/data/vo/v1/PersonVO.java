package br.com.wendt.restwithspringboot.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender", "enabled"})
public class PersonVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -1532146641385397203L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
    private String address;

    // @JsonIgnore
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("enabled")
    private Boolean enabled;

    public PersonVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(final Long key) {
        this.key = key;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final PersonVO personVO = (PersonVO) o;
        return Objects.equals(key, personVO.key) &&
            Objects.equals(firstName, personVO.firstName) &&
            Objects.equals(lastName, personVO.lastName) &&
            Objects.equals(address, personVO.address) &&
            Objects.equals(gender, personVO.gender) &&
            Objects.equals(enabled, personVO.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, firstName, lastName, address, gender, enabled);
    }

}
