package com.staff.api.entity;

import java.sql.Date;

public class Interview implements IEntity<Interview> {

    Integer id;
    Integer idVacancy;
    Integer idCandidate;
    Date planDate; //Date
    Date factDate; //Date


    public boolean isNew() {
        return (this.id == null);
    }
    public Integer getId() {  return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getIdVacancy() { return idVacancy; }
    public void setIdVacancy(Integer idVacancy)  { this.idVacancy = idVacancy; }
    public Integer getIdCandidate() { return idCandidate; }
    public void setIdCandidate(Integer idCandidate) { this.idCandidate = idCandidate; }
    public Date getPlanDate() { return planDate; }
    public void setPlanDate(Date planDate) { this.planDate = planDate; }
    public Date getFactDate() { return factDate; }
    public void setFactDate(Date factDate) { this.factDate = factDate; }


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
