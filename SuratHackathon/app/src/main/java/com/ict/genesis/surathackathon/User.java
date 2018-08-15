package com.ict.genesis.surathackathon;

/**
 * Created by Genesis on 23/09/2017.
 */

public class User {
    String _name;
    String _email;
    String _mno;
    String _gender;
    String _adr;
    String _pass;

    public String get_name() {
        return _name;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String email) {
        this._email = email;
    }

    public String get_mno() {
        return _mno;
    }

    public void set_mno(String mno) {
        this._mno = mno;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String gender) {
        this._gender = gender;
    }

    public String get_adr() {
        return _adr;
    }

    public void set_adr(String adr) {
        this._adr = adr;
    }

    public String get_pass() {
        return _pass;
    }

    public void set_pass(String pass) {
        this._pass = pass;
    }


    public User(){

    }

    public User(String name,String email,String mno,String gen,String adr,String pass){
        this._name=name;
        this._email=email;
        this._mno=mno;
        this._gender=gen;
        this._adr=adr;
        this._pass=pass;
    }
}
