package com.company;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class AppointmentTableModel extends AbstractTableModel {
    private final String[] column__Name =
            {
                    "ID NO ",
                    "PATIENT'S FIRST NANE ",
                    "PATIENT'S LAST NANE ",
                    "DATE OF BIRTH (DOB) ",
                    "GENDER ",
                    "MOBILE NUMBER (MN) ",
                    "DOCTORS NAME ",
                    "SPECIALIZATION ",
                    "RESERVED DATE ",
                    "RESERVED TIME PERIOD",
                    "FEE"
            };

    private final ArrayList<Patient>
            patient__List;
    private final ArrayList<Consultation>
            consultation__List;

    AppointmentTableModel(ArrayList<Patient> listOf_Patients,
                          ArrayList<Consultation> consultation_List)
    {
        this.patient__List = listOf_Patients;
        this.consultation__List = consultation_List;
    }
    @Override
    public int getRowCount()
    {
        return patient__List.size();
    }

    @Override
    public int getColumnCount()
    {
        return column__Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object te_mp = null;
        if (columnIndex == 0) {
            te_mp = patient__List.
                    get(rowIndex).
                    getUniqueId();
        } else if (columnIndex == 1) {
            te_mp = patient__List.
                    get(rowIndex).
                    getName();
        } else if (columnIndex == 2) {
            te_mp = patient__List.
                    get(rowIndex).
                    getSurname();
        }else if (columnIndex == 3) {
            te_mp = patient__List.
                    get(rowIndex).
                    getDob();
        } else if (columnIndex == 4) {
            te_mp = patient__List.
                    get(rowIndex).
                    getGender();
        } else if (columnIndex == 5) {
            te_mp = patient__List.
                    get(rowIndex).
                    getMobileNumber();
        } else if (columnIndex == 6) {
            te_mp = consultation__List.
                    get(rowIndex).
                    getDoctorName();
        } else if (columnIndex == 7) {
            te_mp = consultation__List.
                    get(rowIndex).
                    getSpecialization();
        } else if (columnIndex == 8) {
            te_mp = consultation__List.
                    get(rowIndex).
                    getDate();
        } else if (columnIndex == 9) {
            te_mp = consultation__List.
                    get(rowIndex).
                    getTimeSlots();
        } else if (columnIndex == 10) {
            te_mp = consultation__List.
                    get(rowIndex).
                    getCost();
        }
        return te_mp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
    @Override
    public void setValueAt(Object aValue,  int rowIndex, int columnIndex) {
        Patient row = ConsultationGUI.patient__List.get(rowIndex);
        if (0 == columnIndex) {
        } else if (1 == columnIndex) {
            row.setName((String) aValue);
        } else if (2 == columnIndex) {
            row.setSurname((String) aValue);
        } else if (3 == columnIndex) {
            row.setDob((Date) aValue);
        } else if (4 == columnIndex) {
            row.setGender((String) aValue);
        }  else if (5 == columnIndex) {
            row.setMobileNumber((String) aValue);
        } else if (6 == columnIndex) {
            JOptionPane.showMessageDialog
                    (
                            null,
                            "OOPS !!! YOU CANT CHANGE VALUES !!! ",
                            "ALERT !!!",
                            JOptionPane.WARNING_MESSAGE,
                            new ImageIcon("forbidden.png"));

        } else if (7 == columnIndex) {
            JOptionPane.showMessageDialog
                    (
                            null,
                            "OOPS !!! YOU CANT CHANGE VALUES !!!",
                            "ALERT !!!",
                            JOptionPane.WARNING_MESSAGE,
                            new ImageIcon("forbidden.png"));

        } else if (8 == columnIndex) {
            JOptionPane.showMessageDialog
                    (
                            null,
                            "OOPS !!! YOU CANT CHANGE VALUES !!!",
                            "ALERT !!!",
                            JOptionPane.WARNING_MESSAGE,
                            new ImageIcon("forbidden.png"));

        } else if (9 == columnIndex) {
            JOptionPane.showMessageDialog
                    (
                            null,
                            "OOPS !!! YOU CANT CHANGE VALUES !!!",
                            "ALERT !!!",
                            JOptionPane.WARNING_MESSAGE,
                            new ImageIcon("forbidden.png"));

        }else if (10 == columnIndex) {
            JOptionPane.showMessageDialog
                    (
                            null,
                            "OOPS!!! YOU CANT CHANGE VALUES !!!",
                            "ALERT !!!",
                            JOptionPane.WARNING_MESSAGE,
                            new ImageIcon("forbidden.png"));
        }
        ConsultationGUI.SaveInFile();
    }

    public String getColumnName(int col)
    {
        return column__Name[col];
    }

    public Class getColumnClass(int col)
    {
        if (col == 0) {
            return int.
                    class;
        }
        else if (col == 1)
        {
            return String.
                    class;
        }
        else if (col == 2)
        {
            return String.
                    class;
        }
        else if (col == 3)
        {
            return Date.
                    class;
        }
        else if (col == 4)
        {
            return String.
                    class;
        }
        else if (col == 5)
        {
            return String.
                    class;
        }
        else if (col == 6)
        {
            return String.
                    class;
        }
        else if (col == 7)
        {
            return String.
                    class;
        }
        else if (col == 8)
        {
            return Date.
                    class;
        }
        else if (col == 9)
        {
            return String.
                    class;
        }
        else if (col == 10)
        {
            return String.
                    class;
        }
        else {
            return null;
        }
    }
}

