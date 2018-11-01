package com.staff.api.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "feedbackstate", schema = "team6", catalog = "")
public class FeedbackstateEntity {
    private int id;
    private String name;
    private Collection<InterviewfeedbackEntity> interviewfeedbacksById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedbackstateEntity that = (FeedbackstateEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "feedbackstateByIdFeedbackState")
    public Collection<InterviewfeedbackEntity> getInterviewfeedbacksById() {
        return interviewfeedbacksById;
    }

    public void setInterviewfeedbacksById(Collection<InterviewfeedbackEntity> interviewfeedbacksById) {
        this.interviewfeedbacksById = interviewfeedbacksById;
    }
}
