package com.company;
import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    private String doc__Name;
    private String sur__name;
    private Date d_o_b;
    private String m_o_b;
    private String gen_der;

    public Person() {
    }

    public void setName(String docName)
    {
        this.doc__Name = docName;
    }

    public void setSurname(String surname)
    {
        this.sur__name = surname;
    }

    public void setDob(Date dob)
    {
        this.d_o_b = dob;
    }

    public void setMobileNumber(String mob)
    {
        this.m_o_b = mob;
    }

    public void setGender(String gender)
    {
        this.gen_der = gender;

    }



    Person(String docName,String surname, Date dob, String mob, String gender){
        this.doc__Name = docName;
        this.sur__name = surname;
        this.d_o_b = dob;
        this.m_o_b = mob;
        this.gen_der = gender;
    }
    public String getName()
    {
        return doc__Name;
    }

    public String getSurname()
    {
        return sur__name;
    }

    public Date getDob()
    {
        return d_o_b;
    }

    public String getMobileNumber()
    {
        return m_o_b;
    }

    public String getGender()
    {
        return gen_der;

    }
}