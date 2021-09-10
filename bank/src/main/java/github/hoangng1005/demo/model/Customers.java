package github.hoangng1005.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(
            updatable = false,
            nullable = false
    )
    private String idcu;
    @Column(
            name = "full_name",
            columnDefinition = "nvarchar(50)"
    )
    private String full_name;
    @Column(
            name = "dob"
    )
    private LocalDate dob;
    @Column(
            name = "address",
            columnDefinition = "nvarchar(50)"
    )
    private String address;
    @Column(
            name = "ssn",
            columnDefinition = "nvarchar(10)"
    )
    private String ssn;
    @Column(
            name = "phone_numb",
            columnDefinition = "nvarchar(10)"
    )
    private String phone_numb;
    @Column(
            name = "sex",
            columnDefinition = "nvarchar(10)"
    )
    private String sex;
    @Column(
            name = "email",
            columnDefinition = "nvarchar(50)"
    )
    private String email;
    @Column(
            name = "idbranch",
            columnDefinition = "nvarchar(10)"
    )
    private String idbranch;

    @Transient
    private int age;

    public Customers(){}

    public Customers(String idcu, String full_name, LocalDate dob, String address, String ssn, String phone_numb, String sex, String email, String idbranch) {
        this.idcu = idcu;
        this.full_name = full_name;
        this.dob = dob;
        this.address = address;
        this.ssn = ssn;
        this.phone_numb = phone_numb;
        this.sex = sex;
        this.email = email;
        this.idbranch = idbranch;
    }

    public String getIdcu() {
        return idcu;
    }

    public void setIdcu(String idcu) {
        this.idcu = idcu;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone_numb() {
        return phone_numb;
    }

    public void setPhone_numb(String phone_numb) {
        this.phone_numb = phone_numb;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(String idbranch) {
        this.idbranch = idbranch;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "idcu='" + idcu + '\'' +
                ", full_name='" + full_name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", ssn='" + ssn + '\'' +
                ", phone_numb='" + phone_numb + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", idranch='" + idbranch + '\'' +
                ", age=" + age +
                '}';
    }
}
