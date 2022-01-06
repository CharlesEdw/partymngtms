package com.agileea.partymngrms.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Index;


@Entity
@Table(indexes = {
    @Index(name = "IdxFirstnameSurname", columnList = "firstname, surname"), 
    @Index(name = "IdxSurnameFirstname", columnList = "surname, firstname"),
    @Index(name = "IdxOrgname", columnList = "orgname")
})
public class Party implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstname;
    private String surname;
    private String orgname;
    private String dob;
    private String imageurl;
    private Boolean isorg;
    private String familyname;


    public Party() {
        super();
    }

    public Party(Long id, String firstname, String surname, String orgname, String dob, String imageurl, Boolean isorg,
            String familyname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.orgname = orgname;
        this.dob = dob;
        this.imageurl = imageurl;
        this.isorg = isorg;
        this.familyname = familyname;
    }

    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public Boolean getIsorg() {
        return isorg;
    }
    public void setIsorg(Boolean isorg) {
        this.isorg = isorg;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getFamilyname() {
        return familyname;
    }
    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

}   