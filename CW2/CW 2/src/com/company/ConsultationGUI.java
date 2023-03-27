package com.company;
import com.HomePageGUI;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import java.util.Objects;

public class ConsultationGUI extends JFrame {
    public static final ArrayList< Patient >
            patient__List = new ArrayList<>();

    public static final ArrayList<Consultation>
            consultation__List = new ArrayList<>();

    private final JTextField
            textField__ForFName,
            textField__ForSurname,
            textField__ForMobile;

    private final JRadioButton
            male;
    private final JLabel
            labelField__ForDOB,
            label__ForDate;

    private final JTextArea
            textArea__ForNotes;

    private final DefaultComboBoxModel<Object>
            doc__Names = new DefaultComboBoxModel<>();

    private final DefaultComboBoxModel<Object>
            specialization__BoxModel = new DefaultComboBoxModel<>();

    private final DefaultComboBoxModel<Object>
            timeSlot__BoxModel = new DefaultComboBoxModel<>();

    private JButton
            backTo__HomeBtn;

    private String
            gender,
            dob,
            picked__Date,
            nameOfTheSelected__Doctor;

    private Date
            date,
            picked__Date1;

    private JComboBox
            comboForThe__Specialization,
            comboBoxFor__DocName,
            jComboBoxFor__Time;

    public ConsultationGUI() {
        JLabel patientDetails = new JLabel("PATIENT DETAILS");
        patientDetails.setBounds(640, 35, 300, 100);
        patientDetails.setFont(new Font("Times New Roman", Font.BOLD, 25));


        textField__ForFName = new JTextField();
        textField__ForFName.
                setBounds(790, 150, 200, 40);
        textField__ForFName.
                setFont(new Font("Times New Roman", Font.BOLD, 18));
        textField__ForFName.
                setBackground(new Color(207, 205, 202));

        JLabel forFirstName = new JLabel("FIRST NAME");
        forFirstName.
                setBounds(640, 150, 150, 35);
        forFirstName.
                setFont(new Font("Times New Roman", Font.BOLD, 17));

        textField__ForSurname = new JTextField();
        textField__ForSurname.
                setBounds(1190, 150, 200, 40);
        textField__ForSurname.
                setFont(new Font("Times New Roman", Font.BOLD, 18));
        textField__ForSurname.
                setBackground(new Color(207, 205, 202));

        JLabel forSurName = new JLabel("SURNAME");
        forSurName.setFont(new Font("Times New Roman", Font.BOLD, 17));
        forSurName.setBounds(1020, 150, 150, 35);

        labelField__ForDOB = new JLabel();
        labelField__ForDOB.
                setBounds(790, 230, 150, 35);
        labelField__ForDOB.
                setFont(new Font("Times New Roman", Font.BOLD, 18));
        labelField__ForDOB.
                setBackground(new Color(207, 205, 202));
        labelField__ForDOB.
                setOpaque(true);


        JLabel forDOB = new JLabel("DATE OF BIRTH ");
        forDOB.setFont(new Font("Times New Roman", Font.BOLD, 17));
        forDOB.setBounds(640, 230, 150, 35);


        JButton calender__Btn = new JButton();
        calender__Btn.setIcon(new ImageIcon("calendar.png"));
        calender__Btn.setBounds(945, 230, 50, 40);
        calender__Btn.addActionListener(ae -> labelField__ForDOB.setText(new DatePicker(this).setPickedDate()));

        textField__ForMobile = new JTextField();
        textField__ForMobile.
                setBounds(1190, 230, 200, 40);
        textField__ForMobile.
                setFont(new Font("Times New Roman", Font.BOLD, 18));
        textField__ForMobile.
                setBackground(new Color(207, 205, 202));

        JLabel forMobile = new JLabel("MOBILE NUMBER ");
        forMobile.setFont(new Font("Times New Roman", Font.BOLD, 17));
        forMobile.setBounds(1020, 230, 180, 35);

        JLabel gender = new JLabel("GENDER");
        gender.setSize(100, 20);
        gender.setLocation(640, 310);
        gender.setFont(new Font("Times New Roman", Font.BOLD, 17));


        male = new JRadioButton("MALE");
        male.
                setFont(new Font("Times New Roman", Font.BOLD, 15));
        male.
                setSelected(true);
        male.
                setSize(75, 20);
        male.
                setLocation(790, 310);

        JRadioButton female = new JRadioButton("FEMALE");
        female.
                setFont(new Font("Times New Roman", Font.BOLD, 15));
        female.
                setSelected(false);
        female.
                setSize(110, 20);
        female.
                setLocation(900, 310);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.
                add(male);
        genderGroup.
                add(female);

        JSeparator jSeparator = new JSeparator();
        jSeparator.
                setOrientation(SwingConstants.HORIZONTAL);
        jSeparator.
                setBounds(640, 340, 750, 10);
        jSeparator.
                setBackground(new Color(123, 173, 244));

        JLabel addConsultation = new JLabel("ADD CONSULTATION ");

        addConsultation.setFont(new Font("Times New Roman", Font.BOLD, 25));
        addConsultation.
                setBounds(630, 360, 300, 50);

        JLabel selectDocLabel = new JLabel("SELECT DOCTOR ");
        selectDocLabel.
                setBounds(1010, 430, 150, 35);
        selectDocLabel.
                setFont(new Font("Times New Roman", Font.BOLD, 17));

        JLabel labelForSpec = new JLabel("SPECIALIZATION");
        labelForSpec.
                setBounds(630, 430, 150, 35);
        labelForSpec.
                setFont(new Font("Times New Roman", Font.BOLD, 17));

        JLabel forDate = new JLabel("PICK A DATE ");
        forDate.
                setBounds(630, 510, 120, 35);
        forDate.
                setFont(new Font("Times New Roman", Font.BOLD, 17));

        label__ForDate = new JLabel();
        label__ForDate.
                setBounds(790, 510, 150, 35);
        label__ForDate.
                setFont(new Font("Times New Roman", Font.BOLD, 17));
        label__ForDate.
                setBackground(new Color(207, 205, 202));
        label__ForDate.
                setOpaque(true);

        JButton calenderBtn2 = new JButton();
        calenderBtn2.
                setBounds(945, 510, 50, 40);
        calenderBtn2.
                setIcon(new ImageIcon("calendar.png"));
        calenderBtn2.
                addActionListener(ae -> label__ForDate.setText(new DatePicker(this).setPickedDate()));

        JLabel labelForDuration = new JLabel("TIME SLOT ");

        labelForDuration.
                setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelForDuration.
                setBounds(1010, 510, 150, 35);



        textArea__ForNotes = new JTextArea();

        textArea__ForNotes.
                setLineWrap(true);
        textArea__ForNotes.
                setBackground(new Color(207, 205, 202));
        textArea__ForNotes.
                setFont(new Font("Times New Roman", Font.BOLD, 15));
        textArea__ForNotes.
                setOpaque(true);


        this.
                setTitle("WESTMINSTER SKIN CONSULTATION MANAGER ");
        this.
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.
                setSize(1440, 800);
        this.
                setResizable(false);
        this.
                setLayout(null);
        this.
                setVisible(true);
        this.
                add(LeftPanel());
        this.
                add(RightUpperPanel());
        this.
                add(textField__ForFName);
        this.
                add(patientDetails);
        this.
                add(forFirstName);
        this.
                add(textField__ForSurname);
        this.
                add(forSurName);
        this.
                add(forDOB);
        this.
                add(forMobile);
        this.
                add(textField__ForMobile);
        this.
                add(labelField__ForDOB);
        this.
                add(calender__Btn);
        this.
                add(jSeparator);
        this.
                add(addConsultation);
        this.
                add(selectDocLabel);
        this.
                add(DoctorNames());
        this.
                add(labelForSpec);
        this.
                add(forDate);
        this.
                add(label__ForDate);
        this.
                add(calenderBtn2);
        this.
                add(labelForDuration);
        this.
                add(Book());
        this.
                add(ResetButton());
        this.
                add(ListOfAppointments());
        this.
                add(RightDownPanel());
        this.
                add(gender);
        this.
                add(male);
        this.
                add(female);
        this.
                add(DoctorSpecialization());
        this.
                add(TimeSlot());
    }

    public static void SaveInFile() {
        try {
            FileOutputStream fo = new FileOutputStream
                    ("PatientList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);

            for (Patient patient : patient__List) {
                oos.
                        writeObject(patient);
            }
            fo.
                    close();
            oos.
                    close();


            FileOutputStream fo1 = new FileOutputStream("Consultation.txt");
            ObjectOutputStream oos1 = new ObjectOutputStream(fo1);

            for (Consultation consultation : consultation__List)
            {
                oos1.
                        writeObject(consultation);
            }
            fo1.
                    close();
            oos1.
                    close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void LoadFromFile(ArrayList<Patient> listOfPatients,
                                    ArrayList<Consultation> listOfConsultation) {
        try {
            FileInputStream fis = new FileInputStream("PatientList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileInputStream fis1 = new FileInputStream("Consultation.txt");
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            while (true) {
                try {
                    Patient patient = (Patient) ois.
                            readObject();
                    Consultation consultation = (Consultation) ois1.
                            readObject();
                    listOfPatients.add(patient);
                    listOfConsultation.
                            add(consultation);
                } catch (Exception e) {
                    break;
                }
            }
            fis1.
                    close();
            ois1.
                    close();
            fis.
                    close();
            ois.
                    close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel LeftPanel() {
        final JLabel jLabel = new JLabel();

        jLabel.
                setIcon(new ImageIcon("/res/ConsultationIcon.png"));
        jLabel.
                setBounds(0, 0, 600, 800);

        final JLabel createdWord = new JLabel("CREATED BY THALUJA ALWIS");
        createdWord.
                setBounds(300, 720, 300, 50);
        createdWord.
                setFont(new Font("Times New Roman", Font.BOLD, 15));

        final JPanel jPanel = new JPanel();
        jPanel.
                setBounds(0, 0, 600, 800);
        jLabel.
                add(createdWord);
        jPanel.
                add(jLabel);
        return jPanel;
    }

    private JPanel RightUpperPanel() {
        backTo__HomeBtn = new JButton();
        backTo__HomeBtn.
                setBounds(700, 5, 100, 50);
        backTo__HomeBtn.
                setIcon(new ImageIcon("HomeIcon.png"));
        backTo__HomeBtn.
                addActionListener(e ->
                {
                    if (e.getSource() == backTo__HomeBtn)
                    {
                        backTo__HomeBtn.
                                setBackground(new Color(224, 213, 247));
                        this.
                                dispose();
                        new HomePageGUI();
                    }
                });
        JLabel label = new JLabel("BOOK A CONSULTATION ");
        label.setIcon(new ImageIcon("ConsultationIcon.png"));

        label.
                setBounds(0, 5, 840, 50);
        label.
                setForeground(Color.BLACK);
        label.
                setFont(new Font("Times New Roman", Font.BOLD, 30));

        final JLabel jLabel = new JLabel();
        jLabel.
                setBounds(0, 0, 840, 70);
        jLabel.
                setIcon(new ImageIcon("RightUpperImage.jpeg"));
        jLabel.
                add(backTo__HomeBtn);

        final JPanel jPanel = new JPanel();
        jPanel.
                setBounds(600, 0, 840, 70);
        jPanel.
                add(jLabel);
        jLabel.
                add(label);
        return jPanel;
    }

    private JComboBox DoctorNames() {
        comboBoxFor__DocName = new JComboBox(doc__Names);
        comboBoxFor__DocName.
                setBounds(1190, 423, 200, 50);
        comboBoxFor__DocName.
                setFont(new Font("Times New Roman", Font.BOLD, 15));
        return comboBoxFor__DocName;
    }

    private JComboBox DoctorSpecialization() {
        int count = WestminsterSkinConsultationManager.
                list.
                size();

        String[] specialization = new String[count];

        int iteration = 0;

        for (Doctor doc : WestminsterSkinConsultationManager.list) {
            specialization[iteration] = doc.
                    getSpecialization();
            iteration++;
        }

        specialization__BoxModel.
                addElement(" SELECT ");
        doc__Names.
                addElement(" SELECT ");

        //removing all duplicate elements in the array

        for (int K = 0; K < count; K++) {
            int flag = 0;
            for (int j = 0; j < K; j++) {
                if (specialization[K].equals(specialization[j])) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                specialization__BoxModel.
                        addElement(specialization[K]);
            }
        }

        comboForThe__Specialization = new JComboBox(specialization__BoxModel);
        comboForThe__Specialization.
                setBounds(790, 423, 200, 50);
        comboForThe__Specialization.
                setFont(new Font("Times New Roman", Font.BOLD, 15));
        comboForThe__Specialization.
                addActionListener(ae -> {
                    if (ae.getSource() == comboForThe__Specialization) {
                        doc__Names.removeAllElements();
                        for (Doctor doctor : WestminsterSkinConsultationManager.list) {
                            if (doctor.getSpecialization().equals(comboForThe__Specialization.getSelectedItem())) {
                                doc__Names.addElement(doctor.getName() + " " + doctor.getSurname());
                            }
                        }
                    }
                });
        return comboForThe__Specialization;
    }

    private JButton Book() {
        JButton book = new JButton("Book Now");
        book.setForeground(Color.GREEN);
        book.setBounds(1050, 635, 140, 45);
        book.setFont(new Font("Times New Roman", Font.BOLD, 14));
        book.addActionListener(ae -> {
            if (ae.getSource() == book) {
                if (!textField__ForFName.
                        getText().
                        isEmpty()
                        && !textField__ForSurname.getText().
                        isEmpty()
                        && !labelField__ForDOB.getText().
                        isEmpty()
                        && !textField__ForMobile.getText().
                        isEmpty())
                {
                    String lName = textField__ForSurname.getText();
                    String fName = textField__ForFName.getText();

                    try {
                        dob = labelField__ForDOB.getText();
                        date = WestminsterSkinConsultationManager.
                                dateFormat.
                                parse(dob);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String mobile = textField__ForMobile.getText();

                    if (male.isSelected())
                    {
                        gender = "MALE";
                    } else {
                        gender = "FEMALE";
                    }

                    String specialization = (String) DoctorSpecialization().
                            getSelectedItem();
                    String doctorName = (String) DoctorNames().
                            getSelectedItem();
                    try {
                        picked__Date = label__ForDate.
                                getText();
                        picked__Date1 = WestminsterSkinConsultationManager.
                                dateFormat.parse(picked__Date);

                    } catch
                    (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String time = (String) TimeSlot().
                            getSelectedItem();
                    String notes = textArea__ForNotes.
                            getText();

                    int flag = 0;

                    for (Patient patient : patient__List) {
                        if (fName.equalsIgnoreCase(patient.getName())
                                && lName.
                                equalsIgnoreCase(patient.getSurname())) {
                            flag = 1;
                            break;
                        }
                    }
                    int yes_No;
                    if (flag == 1) {
                        yes_No = JOptionPane.showConfirmDialog(
                                this,
                                "CONSULTATION FEE = £25\nDO YOU WANT TO BOOK CONSULTATION ?",
                                "WESTMINSTER SKIN CONSULTATION MANAGER",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                new ImageIcon("Question.png"));

                        if (yes_No == 0) {
                            String consultationFee = "£25";
                            Consultation consultation = new Consultation(doctorName,
                                    specialization,
                                    picked__Date1,
                                    time,
                                    notes,
                                    consultationFee);

                            Patient patient = new Patient
                                    (
                                            fName,
                                            lName,
                                            date,
                                            mobile,
                                            gender
                                    );
                            patient__List.
                                    add(patient);
                            consultation__List.
                                    add(consultation);
                            JOptionPane.showMessageDialog
                                    (
                                            this,
                                            "CONSULTATION RESERVED SUCCESSFULLY !",
                                            "ALERT!",
                                            JOptionPane.INFORMATION_MESSAGE,
                                            new ImageIcon("confirm.png")
                                    );
                        }
                    }
                    else
                    {
                        yes_No = JOptionPane.
                                showConfirmDialog
                                        (
                                                this,
                                                "CONSULTATION FEE = £15\nDO YOU WANT TO BOOK CONSULTATION ?",
                                                "WESTMINSTER SKIN CONSULTATION MANAGER",
                                                JOptionPane.YES_NO_CANCEL_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE,
                                                new ImageIcon("Question.png")
                                        );

                        if (yes_No == 0) {
                            String consultationFee = "£15";
                            Consultation consultation = new Consultation(doctorName,
                                    specialization,
                                    picked__Date1,
                                    time,
                                    notes,
                                    consultationFee
                            );
                            Patient patient = new Patient
                                    (
                                            fName,
                                            lName,
                                            date,
                                            mobile,
                                            gender
                                    );
                            patient__List.
                                    add(patient);
                            consultation__List.
                                    add(consultation);
                            JOptionPane.
                                    showMessageDialog
                                            (
                                                    this,
                                                    " CONSULTATION RESERVED SUCCESSFULLY !",
                                                    "ALERT!", JOptionPane.INFORMATION_MESSAGE,
                                                    new ImageIcon("confirm.png")
                                            );
                        }
                    }
                    if (yes_No == 1) {
                        JOptionPane.
                                showMessageDialog
                                        (
                                                this,
                                                "CANCELED !",
                                                "ALERT!",
                                                JOptionPane.INFORMATION_MESSAGE,
                                                new ImageIcon("cross.png")
                                        );
                    }
                    SaveInFile();
                    Reset();

                }
                else
                {
                    JOptionPane.
                            showMessageDialog
                                    (
                                            this,
                                            "OOPS !!! YOU MUST FILL ALL FIELDS !!!",
                                            "ALERT!",
                                            JOptionPane.WARNING_MESSAGE,
                                            new ImageIcon("AlertIcon.png")
                                    );
                }
            }
        });
        return
                book;
    }

    private JComboBox TimeSlot() {
        ArrayList<String> doctors = new ArrayList<>();

        timeSlot__BoxModel.addElement(" SELECT FROM  ");
        timeSlot__BoxModel.addElement("8 AM - 9 AM");
        timeSlot__BoxModel.addElement("9 AM - 10 AM");
        timeSlot__BoxModel.addElement("10 AM - 11 AM");
        timeSlot__BoxModel.addElement("11 AM - 12 AM");
        timeSlot__BoxModel.addElement("2 PM - 3 PM");
        timeSlot__BoxModel.addElement("3 PM - 4 PM");
        timeSlot__BoxModel.addElement("4 PM - 5 PM");
        timeSlot__BoxModel.addElement("5 PM - 6 PM");

        jComboBoxFor__Time = new JComboBox(timeSlot__BoxModel);
        jComboBoxFor__Time.
                setBounds(1190, 503, 200, 50);
        jComboBoxFor__Time.
                setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jComboBoxFor__Time.
                addActionListener(aE -> {
                    if (aE.getSource() == jComboBoxFor__Time) {
                        if (!isDoctorAvailable()) {
                            int yes_No = JOptionPane.
                                    showConfirmDialog
                                            (
                                                    this,
                                                    "DOCTOR ISN'T AVAILABLE IN THAT DATE AND TIME." +
                                                            "\nDO YOU WANT ALLOCATE ANOTHER DOCTOR FOR SPECIFIC DATE AND TIME ?",
                                                    "ALERT!",

                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE,
                                                    new ImageIcon("bell.png")
                                            );
                            if (yes_No == 0) {
                                doc__Names.
                                        removeAllElements();
                                for (Doctor d_o_c : WestminsterSkinConsultationManager.list) {
                                    String name = d_o_c.
                                            getName() + " " + d_o_c.
                                            getSurname();

                                    if (
                                            d_o_c.getSpecialization().
                                                    equals(comboForThe__Specialization.
                                                            getSelectedItem())
                                                    && !name.
                                                    equalsIgnoreCase(nameOfTheSelected__Doctor)
                                    ){
                                        for (Consultation consultation : consultation__List) {
                                            if (name.
                                                    equalsIgnoreCase(consultation.
                                                            getName())
                                                    && Objects.
                                                    equals(
                                                            comboForThe__Specialization.
                                                                    getSelectedItem(),
                                                            consultation.
                                                                    getSpecialization()
                                                    )
                                            ){
                                                try {
                                                    if (!(consultation.
                                                            getTimeSlots().
                                                            equals(jComboBoxFor__Time.getSelectedItem())
                                                            && WestminsterSkinConsultationManager.
                                                            dateFormat.
                                                            parse(label__ForDate.
                                                                    getText()).
                                                            equals(consultation.getDate()))
                                                    ){
                                                        doctors.add(name);
                                                        break;
                                                    }
                                                }
                                                catch (ParseException e)
                                                {
                                                    throw new RuntimeException(e);
                                                }
                                            } else {
                                                doctors.
                                                        add(name);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
        for (
                String name :
                doctors) {
            for (Consultation consul :
                    consultation__List) {
                try {
                    if (!(name.equals(consul.getName())
                            && WestminsterSkinConsultationManager
                            .dateFormat.
                            parse(
                                    label__ForDate.
                                            getText()).
                            equals(consul.getDate())
                            && consul.getTimeSlots().
                            equals(
                                    jComboBoxFor__Time.
                                            getSelectedItem()))
                    ){
                        doc__Names.
                                addElement(name);
                    }
                } catch (ParseException e) {
                    throw new
                            RuntimeException(e);
                }
            }
        }
        return
                jComboBoxFor__Time;
    }

    private boolean isDoctorAvailable()
    {
        for (Consultation consultation : consultation__List) {
            try {
                if (consultation.getTimeSlots().
                        equals(jComboBoxFor__Time.
                                getSelectedItem())
                        && Objects.
                        equals(comboBoxFor__DocName.
                                        getSelectedItem(),
                                consultation.
                                        getDoctorName())
                        && Objects.equals
                        (
                                comboForThe__Specialization.
                                        getSelectedItem(),
                                consultation.getSpecialization())
                        && WestminsterSkinConsultationManager.
                        dateFormat.
                        parse(label__ForDate.
                                getText()).
                        equals(consultation.
                                getDate())
                ){
                    nameOfTheSelected__Doctor = (String) comboBoxFor__DocName.
                            getSelectedItem();
                    return
                            false;
                }
            } catch (ParseException e)
            {
                throw new
                        RuntimeException(e);
            }
        }
        return true;
    }

    private JPanel RightDownPanel()
    {
        final JPanel jPanel = new JPanel();
        jPanel.
                setBounds(600, 760, 840, 20);
        jPanel.
                setBackground(new Color(123, 173, 244));

        return jPanel;
    }

    private JButton ListOfAppointments()
    {
        JButton listOfAppointment = new JButton("LIST OF APPOINTMENTS ");
        listOfAppointment.
                setBounds(640, 705, 200, 35);
        listOfAppointment.
                setFont(new Font("Times New Roman", Font.BOLD, 12));
        listOfAppointment.addActionListener(ae -> {
            if (ae.getSource() == listOfAppointment) {
                new AppointmentsGUI();
            }
        });
        return listOfAppointment;
    }

    private JButton ResetButton() {
        JButton re_set = new JButton("RESET");
        re_set.
                setBounds(1050, 705, 140, 45);
        re_set.
                setFont(new Font("Times New Roman", Font.BOLD, 12));
        re_set.
                setForeground(Color.RED);
        re_set.
                addActionListener(ae -> {
                    if (ae.
                            getSource() == re_set) {
                        Reset();
                    }
                });
        return
                re_set;
    }

    private void Reset() {

        String def = "";

        textField__ForFName.
                setText(def);
        textField__ForSurname.
                setText(def);
        textField__ForMobile.
                setText(def);
        labelField__ForDOB.
                setText(def);
        label__ForDate.
                setText(def);
        textArea__ForNotes.
                setText(def);
        specialization__BoxModel.

                removeAllElements();
        DoctorSpecialization();
        DoctorNames();
        timeSlot__BoxModel.
                removeAllElements();

        TimeSlot();
        label__ForDate.
                setText(def);
        textArea__ForNotes.
                setText(def);
    }
}