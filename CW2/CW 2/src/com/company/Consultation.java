package com.company;
import java.util.Date;

public class Consultation extends Doctor{
    private String time__Slots;
    private String cost__;
    private String notes__;
    private Date date__;
    private String doctor__Name;

    public Consultation
            (
                    String name,
                    String specialization,
                    Date date,
                    String time,
                    String notes,
                    String consultationFee
            )
    {
        this.doctor__Name = name;
        super.
                setSpecialization(specialization);
        this.date__ = date;
        this.time__Slots = time;
        this.notes__ = notes;
    }
    public String getTimeSlots()
    {
        return time__Slots;
    }
    public String getCost()
    {
        return cost__;
    }
    public String getNotes()
    {
        return notes__;
    }
    public void setNotes(String Notes)
    {
        this.notes__ = notes__ ;
    }
    public String getDoctorName()
    {
        return doctor__Name;
    }
    public Date getDate()
    {
        return date__;
    }

    @Override
    public void setMedicalLicenseNumber(String medLicNumber)
    {
        super.
                setMedicalLicenseNumber(medLicNumber);
    }

}
