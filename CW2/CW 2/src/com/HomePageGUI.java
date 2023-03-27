package com;
import com.company.ConsultationGUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HomePageGUI extends JFrame {
    private final JButton button_1;

    public HomePageGUI(){

        //Adding background image

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/res/background.jpg")));

        background.setBounds(0,0,2000,1250);


        //Adding " welcome " letter to the JFrame

        JLabel welcomeLetter = new JLabel("SKIN CONSULTATION MANAGER");
        welcomeLetter.setBounds(370, 25, 1100,50);
        welcomeLetter.setForeground(Color.BLACK);
        welcomeLetter.setFont(new Font("Times New Roman", Font.BOLD,45));
        background.add(welcomeLetter);

        JLabel icon1 = new JLabel();
        icon1.setIcon(new ImageIcon("uniLogo.png"));
        icon1.setIcon(new ImageIcon());
        icon1.setBounds(140, 15, 80,80);
        background.add(icon1);

        JLabel icon2 = new JLabel();
        icon2.setIcon(new ImageIcon(getClass().getResource("/res/iitLogo.png")));

        icon2.setBounds(230, 15, 80,80);
        background.add(icon2);

        //Add border with color

        Border border = BorderFactory.createLineBorder(Color.WHITE,5);
        background.setBorder(border);

        //Add Buttons to login page

        button_1 = new JButton("DOCTOR INFORMATION ");
        button_1.setBounds(300,270,800,130);
        button_1.setIcon(new ImageIcon(getClass().getResource("/res/icon1.png")));
        button_1.setFont(new Font("Times New Roman", Font.BOLD,25));
        button_1.addActionListener(e -> {
            if (e.getSource() == button_1){
                dispose();
                new DoctorListGUI();
            }
        });
        background.add(button_1);

        //Adding 2nd button

        JButton button_2 = new JButton("BOOK A CONSULTATION ");
        button_2.setBounds(300,450,800,130);
        button_2.setIcon(new ImageIcon(getClass().getResource("/res/icon2.png")));
        button_2.setFont(new Font("Times New Roman", Font.BOLD,25));
        button_2.addActionListener(e -> {
            dispose();
            new ConsultationGUI();
        });
        background.add(button_2);



        JLabel createdWord = new JLabel("CREATED BY THALUJA ALWIS");
        createdWord.setBounds(580,720, 300,50);
        createdWord.setFont(new Font("Times New Roman", Font.BOLD,15));
        background.add(createdWord);

        this.setTitle("WESTMINSTER SKIN CONSULTATION MANAGER ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1440, 800);
        this.setResizable(false);
        this.setVisible(true);
        this.add(background);
        this.setLayout(null);

    }
}
