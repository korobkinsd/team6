package com.staff.api.entity;

import com.staff.web.CandidateController;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
@Table("candidate")
public class Candidate implements IEntity<Candidate>{

    public enum CandidateState {
          ARCHIVE("В архиве")
        , ACTIVE("Активен");

        private final String description;

        CandidateState(final String description) {
            this.description = description;
        }

        public String getDescription() { return description; }
    }
    private Collection<ContactDetails> contactDetailsById;

    private final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message="is required")
    @Size(min=3, max=255, message="name must be between 3 and 255 characters long")
    private String name;

    private String surname;

    @Min(0)
    private double salary;

    @Past
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotNull(message="is required")
    private CandidateState candidateState;

    @OneToMany(mappedBy = "candidateByIdCandidate")
    private Collection<ContactDetails> getContactDetailsById() {
        return this.contactDetailsById;
    };

    public final List<ContactDetails> getContactDetailsList() {
        return contactDetailsList;
    }

    public void setContactdetailsById(Collection<ContactDetails> contactdetailsById) {
        this.contactdetailsById = contactdetailsById;
    }

    public final void setContactDetailsList(List<ContactDetails> contactDetailsList) {
        this.contactDetailsList = contactDetailsList;
    }


    public final boolean isNew() {
        return this.id == null;
    }

    public final Integer getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final String getSurname() {
        return surname;
    }

    public final double getSalary() {
        return salary;
    }

    public final Date getBirthday() {
        return birthday;
    }

    public final CandidateState getCandidateState() {
        return candidateState;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setSurname(String surname) {
        this.surname = surname;
    }

    public final void setSalary(double salary) {
        this.salary = salary;
    }

    //public void setBirthday(Date birthday) {
    //    this.birthday = birthday;
    //}

    public final void setBirthday(String birthday) {
        String[] validPatterns = {"dd.MM.yyyy","yyyy-MM-dd","dd/MM/yyyy","dd-MM-yyyy","dd/mm/yy"};
        SimpleDateFormat formatter = new SimpleDateFormat();
        for (String validPattern : validPatterns) {
            try {
                formatter.applyPattern(validPattern);
                formatter.setLenient(false);
                Date ret = new Date(formatter.parse(birthday).getTime());
                this.birthday = ret;
                return;
            } catch (ParseException e) {
                //ok, just take next pattern
            }
        }
        logger.debug("Pattern for [" + birthday + "] is not supported!");
    }

    public final void setCandidateState(String st) {
        CandidateState[] states = CandidateState.values();

        for(CandidateState c : states) {
            if (st.equals(c.getDescription())) {
                this.candidateState = c;
            }
        }
    }

    public final void setCandidateState(CandidateState candidateState) {
        this.candidateState = candidateState;
    }

    public final String getBirthdayAsString() {
        if (!(this.birthday == null)) {
            Format formatter = new SimpleDateFormat("dd.MM.yyyy");
            return formatter.format(birthday);
        } else {
            return "";
        }
        //return String.format("%td.%tm.%tY",birthday,birthday,birthday);
    }

    // get a string like '01.03.2015', parse it and set birthday of Candidate
    /*public void setBirthday(String s) {

        if (s == null) {
            return;
        }
        try {
            int day = Integer.parseInt(s.substring(0, 2));
            int month = Integer.parseInt(s.substring(3, 5))-1;
            int year = Integer.parseInt(s.substring(6, 10));
            birthday.set(year, month, day);
        } catch (Exception e) {
            e.printStackTrace();
            birthday.set(1900, Calendar.JANUARY, 1);
        }
    }*/

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id &&
                Double.compare(candidate.salary, salary) == 0 &&
                Objects.equals(name, candidate.name) &&
                Objects.equals(surname, candidate.surname) &&
                Objects.equals(birthday, candidate.birthday) &&
                candidateState == candidate.candidateState;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id, name, surname, salary, birthday, candidateState);
    }

    @Override
    public final String toString() {
        return "Candidate [" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", birthday=" + getBirthdayAsString() +
                ", candidateState=" + candidateState +
                "]";
    }

    @Override
    public final void setForeignKey(final String foreignKey) {
        this.id = Integer.parseInt(foreignKey);
    }

    @Override
    public final String getForeignKey() {
        return this.id != null ? this.id.toString() : "-1";
    }
}
