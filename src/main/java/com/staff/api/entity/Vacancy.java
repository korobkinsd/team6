
package com.staff.api.entity;



public class Vacancy implements IEntity<Vacancy> {
    // form:hidden - hidden value
    private Integer id;

    // form:input - textbox
    private String position;

    // form:input - textbox
    private int idDeveloper;

    // form:input - password
    private double salaryFrom;

    private double salaryTo;

    private double experienceYearsRequire;

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String status) {
        this.state = status;
    }

    public double getExperienceYearsRequire() {
        return experienceYearsRequire;
    }

    public void setExperienceYearsRequire(double experienceYearsRequire) {
        this.experienceYearsRequire = experienceYearsRequire;
    }



    public boolean isNew() { return this.id == null;    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public double getSalaryFrom() {
        return salaryFrom;
    }

    public void setSalaryFrom(double salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    public double getSalaryTo() {
        return salaryTo;
    }

    public void setSalaryTo(double salaryTo) {
        this.salaryTo = salaryTo;
    }


    @Override
    public String toString() {
        return "Vacancy [id=" + id + ", position=" + position + ", idDeveloper=" + idDeveloper + ", salaryFrom=" + salaryFrom
                + ", salaryTo=" + salaryTo + ", experienceYearsRequire "+experienceYearsRequire+"]" + isNew();
    }

    @Override
    public void setForeignKey(String foreignKey) {
        this.id = Integer.parseInt(foreignKey);
    }

    @Override
    public String getForeignKey() {
        /*TODO: не думаю, что это правильно, но не придумал, как сделать лучше*/
        return this.id != null ? this.id.toString() : "0000000000000000000000000000";
    }

    public int getForeignKeyint() {

        return this.id != null ? this.id : 0;
    }

}


