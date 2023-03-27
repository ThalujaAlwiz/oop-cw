package com.company;

import java.util.Date;

public class Doctor extends Person implements Comparable<Doctor>{

    private String _specialization_;
    private String _medLicNumber_;

    public Doctor(String name,
                  String surName,
                  Date dob,
                  String mob,
                  String gender,
                  String medLicNumber,
                  String specialization)
    {
        super(
                name,
                surName,
                dob,
                mob,
                gender
        );

        this._medLicNumber_ = medLicNumber;
        this._specialization_ = specialization;

    }
    public Doctor(){}

    public String getMedicalLicenseNumber()
    {
        return _medLicNumber_;
    }
    public String getSpecialization()
    {
        return _specialization_;
    }



    public void  setMedicalLicenseNumber (String  medLicNumber)
    {
        this._medLicNumber_ = medLicNumber;
    }
    public void setSpecialization(String specialization)
    {
        this._specialization_ = specialization;
    }

    @Override
    public int compareTo(Doctor o)

    {
        return this.getSurname().compareToIgnoreCase(o.getSurname());
    }

}
