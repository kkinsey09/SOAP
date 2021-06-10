package us.cpwa.firedept;

// Graphics Libraries

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SOAP extends JFrame {
    // Constructor
    public SOAP() {
        super("Semi-Automated com.cp.firedept.SOAP Note Writer");

        SOAPModel model = new SOAPModel();

        setLayout(new FlowLayout());

        // Why do I change this? I will just change the format later?
        JLabel spacer1 = new JLabel("         ");
        JLabel spacer2 = new JLabel("                                                 ");

        //////////// Subjective /////////////
        JLabel dispatchMessage;
        dispatchMessage = new JLabel("How was this Dispatched: ");
        add(dispatchMessage);

        JButton nOO = new JButton("911");
        add(nOO);
        nOO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: 911 dispatch to a ";
            }
        });

        JButton law;
        law = new JButton("Law");
        add(law);
        law.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: Requested by law enforcement for a ";
            }
        });

        JButton landline;
        landline = new JButton("Landline");
        add(landline);
        landline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.dispatch = "S: landline dispatch to a ";
            }
        });

        JLabel facilityMessage;
        facilityMessage = new JLabel("From a facility: ");
        add(facilityMessage);

        JButton facilityYes;
        facilityYes = new JButton("Yes");
        add(facilityYes);
        facilityYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.facility = "facility with a ";
            }
        });

        JButton facilityNo;
        facilityNo = new JButton("No");
        add(facilityNo);
        facilityNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.facility = "";
            }
        });

        JLabel patientAge = new JLabel("Pt age: ");
        add(patientAge);
        JTextField ptAge = new JTextField("age", 3);
        add(ptAge);

        JLabel ptGender = new JLabel("Pt gender: ");
        add(ptGender);

        JButton male = new JButton("Male");
        add(male);
        male.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gender = "male";
            }
        });

        JButton female = new JButton("Female");
        add(female);
        female.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gender = "female";
            }
        });

        JLabel patientComplaint = new JLabel("Pt Complaint: ");
        add(patientComplaint);
        JTextField ptComplaint = new JTextField("complaint of ", 20);
        add(ptComplaint);

        JLabel patientReport = new JLabel("Pt Report: ");
        add(patientReport);
        JTextField ptReport = new JTextField("[Rest of the S]", 40);
        add(ptReport);

        //////////// Objective /////////////
        JLabel patientPosition = new JLabel("Position upon arrival: ");
        add(patientPosition);
        JTextField ptPosition = new JTextField("supine, etc", 5);
        add(ptPosition);

        JLabel CAOLabel = new JLabel("CAOx ");
        add(CAOLabel);

        JButton CAOx0 = new JButton("0");
        add(CAOx0);
        CAOx0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 0;
            }
        });

        JButton CAOx1 = new JButton("1");
        add(CAOx1);
        CAOx1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 1;
            }
        });

        JButton CAOx2 = new JButton("2");
        add(CAOx2);
        CAOx2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 2;
            }
        });

        JButton CAOx3 = new JButton("3");
        add(CAOx3);
        CAOx3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 3;
            }
        });

        JButton CAOx4 = new JButton("4");
        add(CAOx4);
        CAOx4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.caoValue = 4;
            }
        });

        add(spacer1); // add spacer to format

        JLabel patientPrimary = new JLabel("Primary Assessment: ");
        add(patientPrimary);
        JTextField ptPrimary = new JTextField("[Rest of the O]", 40);
        add(ptPrimary);

        //////////// Assessment /////////////
        JLabel patientAssessment = new JLabel("Assessment: ");
        add(patientAssessment);
        JTextField ptAssessment = new JTextField("[Assessment]", 10);
        add(ptAssessment);

        //////////// Plan /////////////
        JLabel patientCovid = new JLabel("COVID PPE: ");
        add(patientCovid);
        JButton yesCovid = new JButton("Yes");
        add(yesCovid);
        yesCovid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.covidStatus = "Wore PPE provided for COVID-19 calls, ";
            }
        });

        JButton noCovid = new JButton("No");
        add(noCovid);
        noCovid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.covidStatus = "";
            }
        });

        add(spacer2); // add spacer to format

        JLabel patientOther = new JLabel("Other Treatments: ");
        add(patientOther);
        JTextField otherTreatment = new JTextField("splint, etc.", 10);
        add(otherTreatment);

        JLabel patientTransport = new JLabel("Who transported: ");
        add(patientTransport);

        JButton medicTransport = new JButton("Medics");
        add(medicTransport);
        medicTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Medics recieved signature and transported to SMMC. ";
            }
        });

        JButton blsTransport = new JButton("CPFD");
        add(blsTransport);
        blsTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Received signature for transport, transferred Pt to cot and secured with straps, transferred cot to ambulance and secured with mechanical lock, transported to SMMC. Radio report to ER, transferred to ER, verbal report to nurse.";
            }
        });

        JButton noTransport = new JButton("None");
        add(noTransport);
        noTransport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.transport = "Pt refused transport. ";
            }
        });

        // Confirm Button
        JButton confirm = new JButton("Confirm");
        add(confirm);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.age = ptAge.getText();
                model.complaint = ptComplaint.getText();
                model.report = ptReport.getText();
                model.position = ptPosition.getText();
                model.primary = ptPosition.getText();
                model.assessment = ptAssessment.getText();
                model.other = otherTreatment.getText();
            }
        });

        // Close Button
        JButton close = new JButton("Exit");
        add(close);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}