package com.company;
import com.HomePageGUI;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        boolean ans_wer = true;
        try (Scanner scanner = new Scanner(System.in)) {
            WestminsterSkinConsultationManager west = new WestminsterSkinConsultationManager();

            // load all data from the file

            west.LoadFromFile(WestminsterSkinConsultationManager.list);

            ConsultationGUI.LoadFromFile(ConsultationGUI.patient__List,ConsultationGUI.consultation__List);

            System.out.println("\n  WELCOME TO WESTMINSTER SKIN CONSULTATION MANAGER \n");

            do {
                System.out.println("-------------------------------------------------");
                System.out.println("                    MAIN MENU                    ");
                System.out.println("-------------------------------------------------\n");
                System.out.println(" PRESS' 1 ' TO ADD A NEW DOCTOR                  \n");
                System.out.println(" PRESS' 2 ' TO DELETE A NEW DOCTOR               \n");
                System.out.println(" PRESS' 3 ' TO PRINT THE LIST OF ADDED DOCTORS   \n");
                System.out.println(" PRESS' 4 ' TO TO SAVE IN THE FILE               \n");
                System.out.println(" PRESS' 5 ' TO OPEN IN UI (USER INTERFACE )      \n");
                System.out.println(" PRESS' 6 ' TO QUIT FROM THE PROGRAM             \n");
                System.out.println("-------------------------------------------------\n");

                System.out.println("ENTER A NUMBER :");
                String userInput = scanner.next().toUpperCase();

                switch (userInput)
                {
                    case "1":
                        west.AddNewDoctor();
                        break;
                    case "2" :
                        west.DeleteDoctor();
                        break;
                    case "3" :
                        west.PrintListOfDoctor();
                        break;
                    case "4" :
                        west.SaveInFile();
                        break;
                    case "5" : EventQueue.invokeLater(() ->
                    {
                        try {
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                                UnsupportedLookAndFeelException e)
                        {
                            throw new RuntimeException(e);
                        }
                        new HomePageGUI();
                    });
                        break;
                    case "6" : ans_wer = false;

                }

            } while (ans_wer);
        }
        System.out.println("\n !! THANK YOU !!");
    }
}