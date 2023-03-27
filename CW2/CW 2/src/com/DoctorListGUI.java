package com;
import com.company.ListTableModel;
import com.company.WestminsterSkinConsultationManager;
import javax.swing.*;
import java.awt.*;
public class DoctorListGUI extends JFrame {
    private JButton backToHome_Butn;

    DoctorListGUI(){

        //Code for the Frame

        ImageIcon imageR = new
                ImageIcon(getClass().getResource("/res/UpperImage.png"));
        ImageIcon imageL = new
                ImageIcon(getClass().getResource("/res/UpperImage.png"));
        ImageIcon imageB = new
                ImageIcon(getClass().getResource("/res/UpperImage.png"));

        this.
                setTitle("WESTMINSTER SKIN CONSULTATION MANAGER ");
        this.
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.
                setVisible(true);
        this.
                setSize(1440, 800);
        this.
                setResizable(false);
        this.
                setLayout(null);
        this.
                add(UpperPanel());
        this.
                add(BottomPanel(imageB));
        this.
                add(LeftPanel(imageL));
        this.
                add(RightPanel(imageR));
        this.
                add(ScrollPane());
    }

    /**
     * Codes that contains the upper panel
     * @return JPanel
     */
    private JPanel UpperPanel(){
        final JPanel upper__Panel;
        final JLabel upper__Label;

        backToHome_Butn = new
                JButton();
        backToHome_Butn.setBounds(1270, 35, 100, 50);
        backToHome_Butn.setIcon(new
                ImageIcon(getClass().getResource("/res/HomeIcon.png")));
        backToHome_Butn.addActionListener(e -> {
            if (e.getSource() == backToHome_Butn){
                backToHome_Butn.setBackground(new
                        Color(224, 213, 247));
                this.dispose();
                new HomePageGUI();
            }
        });

        JLabel label = new
                JLabel("DOCTOR INFORMATION ");
        label.setIcon(new
                ImageIcon(getClass().getResource("/res/DoctorIcon.png")));
        label.setBounds(648, 35, 450, 70);
        label.setForeground(Color.BLACK);
        label.setFont(new
                Font("Times New Roman", Font.BOLD,30));

        upper__Label = new
                JLabel(new
                ImageIcon(getClass().getResource("/res/UpperImage.png")));
        upper__Label.setBounds(0, 0, 1699, 1700);
        upper__Label.add(label);
        upper__Label.add(backToHome_Butn);

        upper__Panel = new
                JPanel();
        upper__Panel.setBounds(0, 0, 1440, 120);
        upper__Panel.add(upper__Label);
        return upper__Panel;
    }

    /**
     * Codes that contains the right panel
     * @return JPanel
     */
    private JPanel RightPanel(ImageIcon image){
        JPanel right__SidePanel;
        JLabel right__Label;

        right__Label = new
                JLabel(image);
        right__Label.setBounds(0, 0, 70, 580);

        right__SidePanel = new
                JPanel();
        right__SidePanel.setBounds(1370,120, 70, 580);
        right__SidePanel.add(right__Label);

        return right__SidePanel;
    }

    /**
     * Codes that contain the Left panel
     * @return JPanel
     */
    private JPanel LeftPanel(ImageIcon image){

        JLabel left__Label;
        JPanel left__SidePanel;

        left__Label = new
                JLabel(image);
        left__Label.setBounds(0,0, 70, 580);

        left__SidePanel = new
                JPanel();
        left__SidePanel.setBounds(0,120, 70, 580);
        left__SidePanel.add(left__Label);

        return left__SidePanel;
    }

    /**
     * Codes that contain bottom panel
     * @return JPanel
     */
    private JPanel BottomPanel(ImageIcon image){
        JPanel bottom__Panel;
        JLabel bottom__Label;

        JLabel createdWor_d = new
                JLabel("CREATED BY THALUJA ALWIS");
        createdWor_d.setBounds(680,30, 300,20);
        createdWor_d.setFont(new
                Font("Times New Roman", Font.BOLD,15));

        bottom__Label = new
                JLabel(image);
        bottom__Label.setBounds(0, 0,1440, 75);
        bottom__Panel = new
                JPanel();
        bottom__Panel.setBounds(0, 700, 1440,75);
        bottom__Label.add(createdWor_d);
        bottom__Panel.add(bottom__Label);

        return bottom__Panel;
    }

    /**
     * Codes that contain
     * @return JScrollPane
     */
    private JScrollPane ScrollPane(){
        final JScrollPane scrollPane;

        //Creating an object of custom table model class
        ListTableModel model_ = new
                ListTableModel(WestminsterSkinConsultationManager.list);

        //Defining the table
        JTable table = new
                JTable(model_);
        table.setBackground(Color.white);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new
                Color(88,171,181));
        table.setSelectionForeground(Color.BLACK);
        table.setGridColor(Color.BLACK);
        table.setFont(new
                Font("Times New Roman", Font.PLAIN,13));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new
                Font("Times New Roman", Font.BOLD,14));
        table.getTableHeader().setPreferredSize(new
                Dimension(90,50));
        table.getTableHeader().setForeground(new
                Color(218,93,66));
        table.setAutoCreateRowSorter(true);

        scrollPane = new
                JScrollPane(table);
        scrollPane.setBounds(70, 120, 1300,583);

        return scrollPane;
    }
}