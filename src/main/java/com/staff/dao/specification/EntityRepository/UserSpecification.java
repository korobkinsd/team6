package com.staff.dao.specification.EntityRepository;

import com.staff.api.entity.User;
import com.staff.api.enums.Sort.SortUserFields;
import com.staff.api.specification.IUserSpecification;
import com.staff.dao.specification.Specification;

import java.util.List;

public class UserSpecification extends Specification<User> implements IUserSpecification{

    private final String _like = " like ";

    private String GetFilterLike(String value){
        return this._like + " '%" + value + "%' ";
    }

    private String Stub(){
        return this.getSpecification() + " 1 = 1 ";
    }

    @Override
    public IUserSpecification GetAnd(){
        this.setSpecification(  this.getSpecification() == " where " ? this.getSpecification() : this.getSpecification() + " and "  );
        return this;
    }

    @Override
    public IUserSpecification GetById(String id) {
        this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.ID.toString()));
        this.ConcatForEquals(id);
        return this;
    }

    @Override
    public IUserSpecification GetByIdIn(List<Integer> ids) {
        if(ids != null && ids.size() > 0){
            this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.ID.toString()));
            this.ConcatForOr(ids);
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public IUserSpecification GetByName(String name) {
        return null;
    }

    @Override
    public IUserSpecification GetByNameLike(String name) {
        if (name != null && !name.isEmpty()){
            this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.NAME.toString()) + GetFilterLike(name));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public IUserSpecification GetByEmail(String email) {
        return null;
    }

    @Override
    public IUserSpecification GetByEmailLike(String email) {
        if (email != null && !email.isEmpty()){
            this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.EMAIL.toString()) + GetFilterLike(email));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }

    @Override
    public IUserSpecification GetBySurname(String surname) {
        return null;
    }

    @Override
    public IUserSpecification GetBySurnameLike(String surname) {
        if (surname != null && !surname.isEmpty()){
            this.setSpecification(this.getSpecification() + " ".concat(SortUserFields.SURNAME.toString()) + GetFilterLike(surname));
        }else{
            this.setSpecification(this.Stub());
        }
        return this;
    }
}
