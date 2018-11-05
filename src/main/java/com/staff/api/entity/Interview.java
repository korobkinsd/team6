package com.staff.api.entity;

import java.sql.Date;

public class Interview implements IEntity<Interview> {

    private Integer id;
    private Integer idVacancy;
    private Integer idCandidate;
    private Date planDate; //Date
    private Date factDate; //Date


    private boolean isNew() {
        return this.id == null;
    }
    public final Integer getId() {  return id; }
    public final void setId(Integer id) {
        this.id = id;
    }
    public final Integer getIdVacancy() { return idVacancy; }
    public final void setIdVacancy(Integer idVacancy)  { this.idVacancy = idVacancy; }
    public final Integer getIdCandidate() { return idCandidate; }
    public final void setIdCandidate(Integer idCandidate) { this.idCandidate = idCandidate; }
    public final Date getPlanDate() { return planDate; }
    public final void setPlanDate(Date planDate) { this.planDate = planDate; }
    public final Date getFactDate() { return factDate; }
    public final void setFactDate(Date factDate) { this.factDate = factDate; }


    @Override
    public String toString() {
        return "Interview [id=" + id + ", idVacancy=" + idVacancy + ", planDate=" + planDate + ", idCandidate=" + idCandidate
                + ", factDate=" + factDate + "]" + isNew();
    }

    @Override
    public void setForeignKey(String foreignKey) {
        this.id = Integer.parseInt(foreignKey);
    }

    @Override
    public String getForeignKey() {
        /*TODO: не думаю, что это правильно, но не придумал, как сделать лучше*/
        return this.id != null ? this.id.toString()  : "0000000000000000000000000000";
    }

    public int getForeignKeyInt() {
        return this.id != null ? this.id : 0;
    }
}
