package com.staff.api.entity;

import java.util.Objects;

public class ContactDetails implements IEntity<ContactDetails> {
    private Integer idCandidate;
    private String contactDetail;
    public enum ContactDetailType {EMAIL, MOBILEPHONE, HOMEPHONE, ADDRESS
    };

    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Integer idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    @Override
    public String toString() {
        return "ContactDetails{" +
                "idCandidate=" + idCandidate +
                ", contactDetail='" + contactDetail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDetails that = (ContactDetails) o;
        return idCandidate == that.idCandidate &&
                Objects.equals(contactDetail, that.contactDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCandidate, contactDetail);
    }

    @Override
    public void setForeignKey(String foreignKey) {
        this.idCandidate = Integer.parseInt(foreignKey);
    }

    @Override
    public String getForeignKey() {
        /*TODO: */
        return this.idCandidate != null ? this.idCandidate.toString() : null;
    }
}
