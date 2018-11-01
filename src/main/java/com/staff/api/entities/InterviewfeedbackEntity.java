package com.staff.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "interviewfeedback", schema = "team6", catalog = "")
public class InterviewfeedbackEntity {
    private int idInterview;
    private int idInterviewer;
    private int idFeedbackState;
    private String reason;
    private InterviewEntity interviewByIdInterview;
    private UserEntity userByIdInterviewer;
    private FeedbackstateEntity feedbackstateByIdFeedbackState;

    @Basic
    @Column(name = "idInterview")
    public int getIdInterview() {
        return idInterview;
    }

    public void setIdInterview(int idInterview) {
        this.idInterview = idInterview;
    }

    @Basic
    @Column(name = "idInterviewer")
    public int getIdInterviewer() {
        return idInterviewer;
    }

    public void setIdInterviewer(int idInterviewer) {
        this.idInterviewer = idInterviewer;
    }

    @Basic
    @Column(name = "idFeedbackState")
    public int getIdFeedbackState() {
        return idFeedbackState;
    }

    public void setIdFeedbackState(int idFeedbackState) {
        this.idFeedbackState = idFeedbackState;
    }

    @Basic
    @Column(name = "reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterviewfeedbackEntity that = (InterviewfeedbackEntity) o;

        if (idInterview != that.idInterview) return false;
        if (idInterviewer != that.idInterviewer) return false;
        if (idFeedbackState != that.idFeedbackState) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idInterview;
        result = 31 * result + idInterviewer;
        result = 31 * result + idFeedbackState;
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idInterview", referencedColumnName = "id", nullable = false)
    public InterviewEntity getInterviewByIdInterview() {
        return interviewByIdInterview;
    }

    public void setInterviewByIdInterview(InterviewEntity interviewByIdInterview) {
        this.interviewByIdInterview = interviewByIdInterview;
    }

    @ManyToOne
    @JoinColumn(name = "idInterviewer", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByIdInterviewer() {
        return userByIdInterviewer;
    }

    public void setUserByIdInterviewer(UserEntity userByIdInterviewer) {
        this.userByIdInterviewer = userByIdInterviewer;
    }

    @ManyToOne
    @JoinColumn(name = "idFeedbackState", referencedColumnName = "id", nullable = false)
    public FeedbackstateEntity getFeedbackstateByIdFeedbackState() {
        return feedbackstateByIdFeedbackState;
    }

    public void setFeedbackstateByIdFeedbackState(FeedbackstateEntity feedbackstateByIdFeedbackState) {
        this.feedbackstateByIdFeedbackState = feedbackstateByIdFeedbackState;
    }
}
