package us.cpwa.firedept;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ActionHandler implements ActionListener {
    private final SOAP soap;
    private static final String fileName = "SOAP.txt";

    ActionHandler(SOAP soap) {
        this.soap = soap;
    }

    public String dispatch = "[Dispatch Type]";
    public String facility = "[Facility Status]";
    public String age = "[Pt Age]";
    public String gender = "[Pt Gender]";
    public String complaint = "[Pt Complaint]";
    public String report = "[Pt Report]";

    public String position = "[Pt Position]";
    public int caoValue = 0;
    public String primary = "[Primary Assessment]";

    public String assessment = "[Assessment]";

    public String covidStatus = "[Covid Status] ";
    public String other = "[Other Treatments]";
    public String transport = "[Transport Status]";

    @Override
    public void actionPerformed(ActionEvent event) {
        // Dispatch From
        if (event.getSource() == soap.nOO) { //if button is clicked
            dispatch = "S: 911 dispatch to a "; // assert that message
        } else if (event.getSource() == soap.law) {
            dispatch = "S: Requested by law enforcement for a ";
        } else if (event.getSource() == soap.landline) {
            dispatch = "S: landline dispatch to a ";
        }

        // Facility Y/N
        if (event.getSource() == soap.facilityYes) {
            facility = "facility with a ";
        } else {
            facility = "";
        }

        // Pt Gender
        if (event.getSource() == soap.female) {
            gender = "female, ";
        } else {
            gender = "male, ";
        }

        // CAOx?
        if (event.getSource() == soap.CAOx0) {
            caoValue = 0;
        } else if (event.getSource() == soap.CAOx1) {
            caoValue = 1;
        } else if (event.getSource() == soap.CAOx2) {
            caoValue = 2;
        } else if (event.getSource() == soap.CAOx3) {
            caoValue = 3;
        } else if (event.getSource() == soap.CAOx4) {
            caoValue = 4;
        }

        // Plan
        // Covid PPE?
        if (event.getSource() == soap.yesCovid) {
            covidStatus = "Wore PPE provided for COVID-19 calls, ";
        } else if (event.getSource() == soap.noCovid) {
            covidStatus = "";
        }

        // Transport & Who?
        if (event.getSource() == soap.medicTransport) {
            transport = "Medics recieved signature and transported to SMMC. ";
        } else if (event.getSource() == soap.blsTransport) {
            transport = "Received signature for transport, transferred Pt to cot and secured with straps, transferred cot to ambulance and secured with mechanical lock, transported to SMMC. Radio report to ER, transferred to ER, verbal report to nurse.";
        } else if (event.getSource() == soap.noTransport) {
            transport = "Pt refused transport. ";
        }

        // Confirm Button
        if (event.getSource() == soap.confirm) {
            age = soap.ptAge.getText();
            complaint = soap.ptComplaint.getText();
            report = soap.ptReport.getText();
            position = soap.ptPosition.getText();
            primary = soap.ptPosition.getText();
            assessment = soap.ptAssessment.getText();
            other = soap.otherTreatment.getText();
        }

        try {
            ////////////////////////////////////////////
            ////////////////////////////////////////////
            /////// Printing out the actual com.cp.firedept.SOAP ///////
            ////////////////////////////////////////////
            ////////////////////////////////////////////
            //Scanner in = new Scanner(System.in); // Scanner to take commands in
            PrintWriter writer = new PrintWriter(ActionHandler.fileName);

            ////////////////////////////////////////
            /////// Subjective /////////////////////
            ////////////////////////////////////////
            writer.print("S: " + dispatch);
            writer.print(facility);
            writer.print(age + "y/o ");
            writer.print(gender);
            writer.print(complaint + " ");
            writer.print(report);

            ////////////////////////////////////////
            /////// Objective //////////////////////
            ////////////////////////////////////////
            writer.println();
            writer.println();
            writer.print("O: Upon arrival find Pt " + position
                    + ". CAOx" + caoValue + ". " + primary);

            ////////////////////////////////////////
            /////// Assessment /////////////////////
            ////////////////////////////////////////
            writer.println();
            writer.println();
            writer.print("A: " + assessment);

            ////////////////////////////////////////
            /////// Plan ///////////////////////////
            ////////////////////////////////////////
            writer.println();
            writer.println();
            writer.print("P: ");
            writer.print(covidStatus
                    + "ABCs, Pt Hx and initial assessment, vitals, CAOx"
                    + caoValue + " " + other + " "
                    + transport + " Decontamination and call closed.");
            writer.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(soap, ActionHandler.fileName + " not found.", "File Not Found", JOptionPane.WARNING_MESSAGE);
        }

        if (event.getSource() == soap.close) {
            System.exit(0);
        }
    }
}
