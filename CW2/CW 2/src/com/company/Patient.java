package com.company;
import java.util.Date;
import java.util.UUID;

public class Patient extends Person{

    private final int id_;

    public Patient
            (String name_, String sur_name, Date d_o_b, String mobile_Number, String gen_der)
    {
        super(name_, sur_name, d_o_b, mobile_Number, gen_der);
        this.id_ = generateUniqueId();
    }

    public int getUniqueId()
    {
        return
                this.id_;
    }

    public static int generateUniqueId() {
        UUID randomNumber =
                UUID.randomUUID();
        String value =
                ""+randomNumber;
        int uid=
                value.hashCode();
        String filterStr=
                ""+uid;
        value =
                filterStr.replaceAll("-", "");

        return Integer.parseInt(value);
    }
}