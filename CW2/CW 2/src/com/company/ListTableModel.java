package com.company;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class ListTableModel extends AbstractTableModel
{
    private final String[] column_Name = {"MEDICAL LICENCE NUMBER", "NAME OF THE DOCTOR", "DATE OF BIRTH", "GENDER", "MOBILE NUMBER ", "SPECIALIZATION"};
    private final ArrayList<Doctor> doc_List;

    public ListTableModel(ArrayList<Doctor> listOfDoc){
        listOfDoc=WestminsterSkinConsultationManager.list;
        doc_List = listOfDoc;

        for(int j=0;j<doc_List.size();j++){
            System.out.println(doc_List.get(j).getName());
        }

    }


    @Override
    public int getRowCount()
    {
        return doc_List.size();
    }

    @Override
    public int getColumnCount()
    {
        return column_Name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object te_mp = null;
        if(columnIndex == 0)
        {
            te_mp = doc_List.get(rowIndex).
                    getMedicalLicenseNumber();
        }
        else if(columnIndex == 1){
            te_mp = doc_List.get(rowIndex).
                    getName() + " " + doc_List.get(rowIndex).getSurname();
        }
        else if(columnIndex == 2){
            te_mp = doc_List.get(rowIndex).
                    getDob();
        }
        else if(columnIndex == 3){
            te_mp = doc_List.get(rowIndex).
                    getGender();
        }
        else if(columnIndex == 4){
            te_mp = doc_List.get(rowIndex).
                    getMobileNumber();
        }
        else if(columnIndex == 5){
            te_mp = doc_List.get(rowIndex).
                    getSpecialization();
        }
        return te_mp;
    }

    public String getColumnName(int col){
        return column_Name[col];
    }

    public Class getColumnClass(int _Column){
        if(_Column == 0){
            return String.class;
        }
        else if(_Column == 1){
            return String.class;
        }
        else if(_Column == 2){
            return Date.class;
        }
        else if(_Column == 3){
            return String.class;
        }
        else if(_Column == 4){
            return String.class;
        }
        else if(_Column == 5){
            return String.class;
        }
        else {
            return null;
        }
    }
}