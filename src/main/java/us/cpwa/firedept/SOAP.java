package us.cpwa.firedept;

// Graphics Libraries
import java.awt.FlowLayout;
import javax.swing.*;


public class SOAP extends JFrame {

    // Setup all the variables we will need
    public JLabel spacer1;
    public JLabel spacer2;

    // Confirm Button
    public JButton confirm;

    // Subjective
    public JLabel dispatchMessage;
    public JButton nOO;
    public JButton law;
    public JButton landline;
    public JLabel facilityMessage;
    public JButton facilityYes;
    public JButton facilityNo;
    public JLabel patientAge;
    public JTextField ptAge;
    public JLabel ptGender;
    public JButton male;
    public JButton female;
    public JLabel patientComplaint;
    public JTextField ptComplaint;
    public JLabel patientReport;
    public JTextField ptReport;

    // Objective
    public JLabel patientPosition;
    public JTextField ptPosition;
    public JLabel CAOLabel;
    public JButton CAOx0;
    public JButton CAOx1;
    public JButton CAOx2;
    public JButton CAOx3;
    public JButton CAOx4;
    public JLabel patientPrimary;
    public JTextField ptPrimary;


    // Assessment
    public JLabel patientAssessment;
    public JTextField ptAssessment;

    // Plan
    public JLabel patientCovid;
    public JButton yesCovid;
    public JButton noCovid;
    public JLabel patientOther;
    public JTextField otherTreatment;
    public JLabel patientTransport;
    public JButton medicTransport;
    public JButton blsTransport;
    public JButton noTransport;

    // Close Button
    public JButton close;

    // Constructor
    public SOAP() {
        super("Semi-Automated com.cp.firedept.SOAP Note Writer");
        setLayout(new FlowLayout());

        // Declare a spacer to format
        spacer1 = new JLabel("         ");
        spacer2 = new JLabel("                                                 ");

        //////////// Subjective /////////////
        dispatchMessage = new JLabel("How was this Dispatched: ");
        add(dispatchMessage);
        nOO = new JButton("911");
        add(nOO);
        law = new JButton("Law");
        add(law);
        landline = new JButton("Landline");
        add(landline);

        facilityMessage = new JLabel("From a facility: ");
        add(facilityMessage);
        facilityYes = new JButton("Yes");
        add(facilityYes);
        facilityNo = new JButton("No");
        add(facilityNo);

        patientAge = new JLabel("Pt age: ");
        add(patientAge);
        ptAge = new JTextField("age", 3);
        add(ptAge);

        ptGender = new JLabel("Pt gender: ");
        add(ptGender);
        male = new JButton("Male");
        add(male);
        female = new JButton("Female");
        add(female);

        patientComplaint = new JLabel("Pt Complaint: ");
        add(patientComplaint);
        ptComplaint = new JTextField("complaint of ", 20);
        add(ptComplaint);

        patientReport = new JLabel("Pt Report: ");
        add(patientReport);
        ptReport = new JTextField("[Rest of the S]", 40);
        add(ptReport);

        //////////// Objective /////////////
        patientPosition = new JLabel("Position upon arrival: ");
        add(patientPosition);
        ptPosition = new JTextField("supine, etc", 5);
        add(ptPosition);

        CAOLabel = new JLabel("CAOx ");
        add(CAOLabel);
        CAOx0 = new JButton("0");
        add(CAOx0);
        CAOx1 = new JButton("1");
        add(CAOx1);
        CAOx2 = new JButton("2");
        add(CAOx2);
        CAOx3 = new JButton("3");
        add(CAOx3);
        CAOx4 = new JButton("4");
        add(CAOx4);

        add(spacer1); // add spacer to format

        patientPrimary = new JLabel("Primary Assessment: ");
        add(patientPrimary);
        ptPrimary = new JTextField("[Rest of the O]", 40);
        add(ptPrimary);

        //////////// Assessment /////////////
        patientAssessment = new JLabel("Assessment: ");
        add(patientAssessment);
        ptAssessment = new JTextField("[Assessment]", 10);
        add(ptAssessment);

        //////////// Plan /////////////
        patientCovid = new JLabel("COVID PPE: ");
        add(patientCovid);
        yesCovid = new JButton("Yes");
        add(yesCovid);
        noCovid = new JButton("No");
        add(noCovid);

        add(spacer2); // add spacer to format

        patientOther = new JLabel("Other Treatments: ");
        add(patientOther);
        otherTreatment = new JTextField("splint, etc.", 10);
        add(otherTreatment);
        patientTransport = new JLabel("Who transported: ");
        add(patientTransport);
        medicTransport = new JButton("Medics");
        add(medicTransport);
        blsTransport = new JButton("CPFD");
        add(blsTransport);
        noTransport = new JButton("None");
        add(noTransport);

        // Confirm Button
        confirm = new JButton("Confirm");
        add(confirm);

        // Close Button
        close = new JButton("Exit");
        add(close);

        // Action Listener
        // Subjective
        ActionHandler handler = new ActionHandler(this);
        nOO.addActionListener(handler);
        law.addActionListener(handler);
        landline.addActionListener(handler);
        facilityYes.addActionListener(handler);
        facilityNo.addActionListener(handler);
        ptAge.addActionListener(handler);
        male.addActionListener(handler);
        female.addActionListener(handler);
        ptComplaint.addActionListener(handler);
        ptReport.addActionListener(handler);

        // Objective
        ptPosition.addActionListener(handler);
        CAOx0.addActionListener(handler);
        CAOx1.addActionListener(handler);
        CAOx2.addActionListener(handler);
        CAOx3.addActionListener(handler);
        CAOx4.addActionListener(handler);
        ptPrimary.addActionListener(handler);

        // Assessment
        ptAssessment.addActionListener(handler);

        // Plan
        yesCovid.addActionListener(handler);
        noCovid.addActionListener(handler);
        otherTreatment.addActionListener(handler);
        medicTransport.addActionListener(handler);
        blsTransport.addActionListener(handler);
        noTransport.addActionListener(handler);

        // Confirm Button
        confirm.addActionListener(handler);

        // Close Button
        close.addActionListener(handler);

    }
}