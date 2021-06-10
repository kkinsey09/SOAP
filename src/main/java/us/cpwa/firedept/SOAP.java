package us.cpwa.firedept;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class SOAP extends JFrame {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;

    // Constructor
    public SOAP() {
        super("Semi-Automated com.cp.firedept.SOAP Note Writer");

        SOAPModel model = new SOAPModel();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        // Set up Report Field
        JTextArea report = new JTextArea(10,10);

        //////////// Subjective /////////////
        JLabel dispatchMessage = new JLabel("How was this Dispatched: ");
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        add(dispatchMessage, c);

        JRadioButton nOO = new JRadioButton("911");
        nOO.setMnemonic(KeyEvent.VK_9);
        nOO.setActionCommand("911");
        nOO.setSelected(true);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        add(nOO, c);

        JRadioButton law = new JRadioButton("Law");
        nOO.setMnemonic(KeyEvent.VK_8);
        nOO.setActionCommand("Law");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        add(law, c);

        JRadioButton landline = new JRadioButton("Landline");
        nOO.setMnemonic(KeyEvent.VK_7);
        nOO.setActionCommand("Landline");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        add(landline, c);

        // Group the Dispatch Radio Buttons
        ButtonGroup dispatch = new ButtonGroup();
        dispatch.add(nOO);
        dispatch.add(law);
        dispatch.add(landline);

        // Dispatch Group Action Listener
        nOO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: 911 dispatch to a ";
                report.setText(model.report());
            }
        });
        law.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: Requested by law enforcement for a ";
                report.setText(model.report());
            }
        });
        landline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: landline dispatch to a ";
                report.setText(model.report());
            }
        });

        JLabel facilityMessage = new JLabel("From a facility: ");
        if (shouldFill) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
//        c.ipadx = 1;
        c.gridx = 5;
        c.gridy = 0;
        add(facilityMessage, c);

        JCheckBox facilityYes = new JCheckBox();
        facilityYes.setMnemonic(KeyEvent.VK_Y);
        facilityYes.setSelected(false);
        facilityYes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                model.facility = e.getStateChange() == 1 ? "facility with a " : "";
                report.setText(model.report());
            }
        });
        c.weightx = 0;
        c.gridx = 6;
        c.gridy = 0;
        add(facilityYes, c);

        JLabel patientAge = new JLabel("Pt age: ");
        if (shouldFill) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        add(patientAge, c);

        JTextField ptAge = new JTextField("age", 3);
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(ptAge, c);

        ptAge.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                model.age = ptAge.getText();
                report.setText(model.report());
            }

            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }
        });

        JLabel ptGender = new JLabel("Pt gender: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        add(ptGender, c);


        JRadioButton male = new JRadioButton("Male");
        male.setMnemonic(KeyEvent.VK_M);
        male.setActionCommand("Male");
        male.setSelected(true);
        c.weightx = 0;
        c.gridx = 4;
        c.gridy = 1;
        add(male, c);

        JRadioButton female = new JRadioButton("Female");
        female.setMnemonic(KeyEvent.VK_F);
        female.setActionCommand("Female");
        c.weightx = 0;
        c.gridx = 5;
        c.gridy = 1;
        add(female, c);

        //Group the Gender Radio Buttons
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        // ActionListener for Radio Buttons
        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gender = "male";
                report.setText(model.report());
            }
        });
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gender = "female";
                report.setText(model.report());
            }
        });

        JLabel patientComplaint = new JLabel("Pt Complaint: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        add(patientComplaint, c);

        JTextField ptComplaint = new JTextField("complaint of ", 10);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 2;
        c.gridy = 3;
        add(ptComplaint, c);
        ptComplaint.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                model.complaint = ptComplaint.getText();
                report.setText(model.report());
            }

            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }
        });

        JLabel patientReport = new JLabel("Pt Report: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 4;
        add(patientReport, c);

        JTextArea ptReport = new JTextArea("[Rest of the S]", 10, 4);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 5;
        c.gridy = 4;
        add(ptReport, c);

        //////////// Objective /////////////
        JLabel patientPosition = new JLabel("Position upon arrival: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 5;
        add(patientPosition, c);

        JTextField ptPosition = new JTextField("supine, etc", 5);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 5;
        add(ptPosition, c);

        JLabel CAOLabel = new JLabel("CAOx ");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        add(CAOLabel, c);

        JRadioButton CAOx0 = new JRadioButton("0");
        CAOx0.setMnemonic(KeyEvent.VK_0);
        CAOx0.setActionCommand("0");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 6;
        add(CAOx0, c);

        JRadioButton CAOx1 = new JRadioButton("1");
        CAOx1.setMnemonic(KeyEvent.VK_1);
        CAOx1.setActionCommand("1");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 6;
        add(CAOx1, c);

        JRadioButton CAOx2 = new JRadioButton("2");
        CAOx2.setMnemonic(KeyEvent.VK_2);
        CAOx2.setActionCommand("2");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 6;
        add(CAOx2, c);

        JRadioButton CAOx3 = new JRadioButton("3");
        CAOx3.setMnemonic(KeyEvent.VK_3);
        CAOx3.setActionCommand("3");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 6;
        add(CAOx3, c);

        JRadioButton CAOx4 = new JRadioButton("4");
        CAOx4.setMnemonic(KeyEvent.VK_4);
        CAOx4.setActionCommand("4");
        CAOx4.setSelected(true);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 6;
        add(CAOx4, c);

        // Group for CAOx Radio Buttons
        ButtonGroup CAO = new ButtonGroup();
        CAO.add(CAOx0);
        CAO.add(CAOx1);
        CAO.add(CAOx2);
        CAO.add(CAOx3);
        CAO.add(CAOx4);

        // Action Listener for CAOx
        CAOx0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 0;
            }
        });
        CAOx1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 1;
            }
        });
        CAOx2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 2;
            }
        });
        CAOx3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 3;
            }
        });
        CAOx4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 4;
            }
        });

        JLabel patientPrimary = new JLabel("Primary Assessment: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        add(patientPrimary, c);

        JTextArea ptPrimary = new JTextArea("[Rest of the O]", 10, 4);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 5;
        c.gridy = 7;
        add(ptPrimary, c);

        //////////// Assessment /////////////
        JLabel patientAssessment = new JLabel("Assessment: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 1;
        c.gridy = 8;
        add(patientAssessment, c);

        JTextField ptAssessment = new JTextField("[Assessment]", 10);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridwidth = 2;
        c.gridy = 8;
        add(ptAssessment, c);

        //////////// Plan /////////////
        JLabel patientCovid = new JLabel("COVID PPE: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridwidth = 1;
        c.gridy = 8;
        add(patientCovid, c);

        JCheckBox yesCovid = new JCheckBox("Yes");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 8;
        add(yesCovid, c);
        yesCovid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                model.covidStatus = e.getStateChange() == 1 ? "Wore PPE provided for COVID-19 calls, " : "";
            }
        });

        JLabel patientOther = new JLabel("Other Treatments: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 9;
        add(patientOther, c);

        JTextField otherTreatment = new JTextField("splint, etc.", 10);
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 9;
        add(otherTreatment, c);

        JLabel patientTransport = new JLabel("Who transported: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 9;
        add(patientTransport, c);

        JRadioButton medicTransport = new JRadioButton("Medics");
        medicTransport.setMnemonic(KeyEvent.VK_W);
        medicTransport.setActionCommand("Medics");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridwidth = 1;
        c.gridy = 9;
        add(medicTransport, c);

        JRadioButton blsTransport = new JRadioButton("CPFD");
        blsTransport.setMnemonic(KeyEvent.VK_C);
        blsTransport.setActionCommand("CPFD");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridwidth = 1;
        c.gridy = 9;
        add(blsTransport, c);

        JRadioButton noTransport = new JRadioButton("None");
        noTransport.setMnemonic(KeyEvent.VK_N);
        noTransport.setActionCommand("None");
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridwidth = 1;
        c.gridy = 9;
        add(noTransport, c);

        // Create Group for Transport
        ButtonGroup transport = new ButtonGroup();
        transport.add(medicTransport);
        transport.add(blsTransport);
        transport.add(noTransport);

        // Action Listener for Transport
        medicTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Medics recieved signature and transported to SMMC. ";
            }
        });
        blsTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Received signature for transport, transferred Pt to cot and secured with straps, transferred cot to ambulance and secured with mechanical lock, transported to SMMC. Radio report to ER, transferred to ER, verbal report to nurse.";
            }
        });
        noTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Pt refused transport. ";
            }
        });

        // Adding the Report to the GUI
        c.weightx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridwidth = 6;
        c.gridy = 10;
        add(report, c);

        // Confirm Button
        JButton copy = new JButton("Copy");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridwidth = 1;
        c.gridy = 11;
        add(copy, c);
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                report.setText(model.report());
                report.selectAll();
                report.copy();
            }
        });

        // Close Button
        JButton close = new JButton("Exit");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridwidth = 1;
        c.gridy = 11;
        add(close, c);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.writeReport();
                System.exit(0);
            }
        });

        SOAP soap = this;
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(soap,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
    }
}