package com.staff.api.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ContactDetails implements IEntity<ContactDetails> {
    private Integer idCandidate;
    private String contactDetail;
    public enum ContactDetailType {EMAIL, MOBILEPHONE, HOMEPHONE, ADDRESS}

    public final int getIdCandidate() {
        return idCandidate;
    }

    public final void setIdCandidate(final Integer idCandidate) {
        this.idCandidate = idCandidate;
    }

    public final String getContactDetail() {
        return contactDetail;
    }

    public final void setContactDetail(final String contactDetail) {
        this.contactDetail = contactDetail;
    }

    @Override
    public final String toString() {
        return "ContactDetails{" +
                "idCandidate=" + idCandidate +
                ", contactDetail='" + contactDetail + '\'' +
                '}';
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactDetails that = (ContactDetails) o;
        return idCandidate == that.idCandidate &&
                Objects.equals(contactDetail, that.contactDetail);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(idCandidate, contactDetail);
    }

    @Override
    public final void setForeignKey(final String foreignKey) {
        this.idCandidate = Integer.parseInt(foreignKey);
    }

    @Override
    public final String getForeignKey() {
        return this.idCandidate != null ? this.idCandidate.toString() : null;
    }
}
