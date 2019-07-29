package com.mycompany.springmvc.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TRAINER")
public class Trainer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    @Column(name = "FIRST_NAME", nullable = false)
    private String first_name;

    @Size(min = 4, max = 50)
    @Column(name = "LAST_NAME", nullable = false)
    private String last_name;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;

    @NotEmpty
    @Column(name = "SUBJECT", nullable = false)
    private String subject;

    @NotEmpty
    @Column(name = "USERNAME", nullable = false)
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + (this.first_name != null ? this.first_name.hashCode() : 0);
        hash = 41 * hash + (this.last_name != null ? this.last_name.hashCode() : 0);
        hash = 41 * hash + (this.dateOfBirth != null ? this.dateOfBirth.hashCode() : 0);
        hash = 41 * hash + (this.subject != null ? this.subject.hashCode() : 0);
        hash = 41 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trainer other = (Trainer) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.first_name == null) ? (other.first_name != null) : !this.first_name.equals(other.first_name)) {
            return false;
        }
        if ((this.last_name == null) ? (other.last_name != null) : !this.last_name.equals(other.last_name)) {
            return false;
        }
        if ((this.subject == null) ? (other.subject != null) : !this.subject.equals(other.subject)) {
            return false;
        }
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if (this.dateOfBirth != other.dateOfBirth && (this.dateOfBirth == null || !this.dateOfBirth.equals(other.dateOfBirth))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + ", fisrt_name=" + first_name + ", last_name=" + last_name + ", dateOfBirth=" + dateOfBirth + ", subject=" + subject + ", username=" + username + '}';
    }

}
