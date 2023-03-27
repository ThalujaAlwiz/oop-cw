package com.company;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements  SkinConsultationManager {
    public static ArrayList<Doctor> list = new ArrayList<>(10);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void AddNewDoctor() {
        String userChoice = "";
        do {
            try{
                int counter = list.size();

                //Check whether the list contains total of 10 doctors
                if (!(counter == 10)){
                    System.out.println("------------------------------------");
                    System.out.println( "         ADD NEW DOCTOR " );
                    System.out.println("------------------------------------");
                    System.out.println("1. ENTER THE NAME OF THE DOCTOR :");
                    String docName = "DR. "+ scanner.next();


                    System.out.println("2. ENTER THE SURNAME OF THE DOCTOR :");
                    String surName = scanner.next();

                    System.out.println("3. ENTER THE PHONE NUMBER OF THE DOCTOR :");
                    String mob = scanner.next();

                    System.out.println("4. SELECT GENDER:");
                    System.out.println("--------------------");
                    System.out.println("1. MALE");
                    System.out.println("2. FEMALE");
                    System.out.println("--------------------");

                    int selectGender = scanner.nextInt();
                    String gender;
                    if (selectGender == 1) {
                        gender = "MALE";
                    } else if (selectGender == 2) {
                        gender = "FEMALE";
                    }else {
                        System.out.println("OHH !!! YOU ENTERED A INVALID NUMBER ");
                        break;
                    }

                    System.out.println("5. ENTER THE BIRTHDAY OF THE DOCTOR (DD/MM/YYYY):");
                    String doctorDob = scanner.next();
                    Date dob = dateFormat.parse(doctorDob);


                    System.out.println("6. ENTER DOCTOR'S MEDICAL LICENSE NUMBER :");
                    String medLicNumber = scanner.next();

                    System.out.println("7. SELECT THE CONSULTATION FROM BELOW :");
                    System.out.println("---------------------------------------");
                    System.out.println("1. COSMETIC DERMATOLOGY");
                    System.out.println("2. MEDICAL DERMATOLOGY");
                    System.out.println("3. PEDIATRIC DERMATOLOGY");
                    System.out.println("4. SURGICAL DERMATOLOGY");
                    System.out.println("5. Other");

                    int number = scanner.nextInt();
                    String specialization = "";
                    if (number == 1){
                        specialization = "COSMETIC DERMATOLOGY";
                    } else if (number == 2) {
                        specialization = "MEDICAL DERMATOLOGY";

                    } else if (number == 3) {
                        specialization = "PEDIATRIC DERMATOLOGY";

                    } else if (number == 4) {
                        specialization = "SURGICAL DERMATOLOGY";

                    } else if (number == 5) {
                        System.out.println("ENTER THE SPECIALIZATION :");
                        specialization = scanner.next();
                    }else {
                        System.out.println("OHH !!! YOU ENTERED A INVALID NUMBER");
                    }

                    Doctor docter = new Doctor(docName,
                            surName,
                            dob,
                            mob,
                            gender,
                            medLicNumber,
                            specialization);

                    list.add(docter);
                    System.out.println("DOCTOR ADDED SUCCESSFULLY !");

                    System.out.println("\nYOU CAN ADD " +
                            (10 - (++counter))
                            + " MORE DOCTORS ");

                    System.out.println("DO YOU NEED TO ADD MORE DOCTORS ?(Y/N):");
                    userChoice = scanner.next();
                }
                else {
                    System.out.println("CAN'T ADD DOCTORS, YOU CAN ONLY ADD 10 DOCTORS !");
                    break;
                }

            }catch (ParseException e){
                System.out.println("ENTERED NUMBER IS INVALID !");
            }
            catch (Exception a){
                System.out.println(" OOPS !!! CANT ADD DOCTORS, SOMETHING WENT WRONG !");
            }

        }while (userChoice.equalsIgnoreCase("Y"));

        System.out.println("RETURN TO THE MAIN MENU");

    }

    @Override
    public void DeleteDoctor() {
        try{
            System.out.println("------------------------------------");
            System.out.println( "         DELETE DOCTOR " );
            System.out.println("------------------------------------");

            System.out.println(" ENTER DOCTORS MEDICAL LICENSE NUMBER :");
            String lLicenceNo = scanner.next();

            if (!(list.isEmpty())){
                for (Doctor doctor:list) {
                    if (lLicenceNo.equals(doctor.getMedicalLicenseNumber())) {
                        System.out.println("DO YOU WANT DO DELETE THIS " + doctor.getName() + " ?(Y/N)");
                        String answer = scanner.next();

                        if (answer.equalsIgnoreCase("Y")) {
                            list.remove(doctor);
                            System.out.println("DOCTOR DELETED SUCCESSFULLY !");
                        } else {
                            System.out.println("RETURN TO THE MAIN MENU");
                        }
                        break;
                    }
                }
            }else {
                System.out.println("CAN'T FIND THE DOCTOR !");
            }
        }catch (Exception e){
            System.out.println("OOPS !!! CANT DELETE DOCTORS, SOMETHING WENT WRONG !");
        }

    }

    @Override
    public void PrintListOfDoctor() {
        try{

            System.out.println("------------------------------------");
            System.out.println( "       LIST OF DOCTORS " );
            System.out.println("------------------------------------");
            System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %s\n",
                    "NAME",
                    "SURNAME",
                    "GENDER",
                    "DATE OF BIRTH",
                    "MOBILE NUMBER",
                    "MEDICAL LICENSE NUMBER",
                    "SPECIALIZATION\n");

            if (list.isEmpty()){
                System.out.println("\n");
                System.out.println("\nCOULDN'T FIND ANY DATA !\n");
            }
            else {
                //creating new arraylist for sort

                ArrayList<Doctor> sortedArray = new ArrayList<>();

                //add main array list object to new arraylist

                sortedArray.addAll(list);
                for (Doctor doctor: sortedArray) {
                    System.out.printf("%-25s %-25s %-25s %-25s %-25s %-25s %s\n",
                            doctor.getName(),
                            doctor.getSurname(),
                            doctor.getGender(),
                            dateFormat.format(doctor.getDob()),
                            doctor.getMobileNumber(),
                            doctor.getMedicalLicenseNumber(),
                            doctor.getSpecialization());
                }

                //sort new array list
                Collections.sort(list);

            }

        }
        catch (Exception e){
            System.out.println("OOPS !!! CANT PRINT DOCTORS LIST, SOMETHING WENT WRONG !");
        }
    }

    @Override
    public void SaveInFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("filename.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Doctor doctor:
                    list) {
                objectOutputStream.writeObject(doctor);
            }
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("SUCCESSFULLY SAVED THE DATA TO THE FILE !");

        } catch (Exception e) {
            System.out.println("OOPS !!! SOMETHING WENT WRONG !");
        }
    }

    @Override
    public void LoadFromFile(ArrayList<Doctor> list){
        try{
            FileInputStream fileInputStream = new FileInputStream("filename.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                try{
                    Doctor doctor = (Doctor) objectInputStream.readObject();
                    list.add(doctor);
                }
                catch (Exception e){
                    break;
                }
            }
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (IOException e){
            System.out.println("OOPS !!! CAN'T FIND THE FILE SOMETHING WENT WRONG !");
        }
    }
}