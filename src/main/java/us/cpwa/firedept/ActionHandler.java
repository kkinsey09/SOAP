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

            ////////ActionHandler////////////////////////////////
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
    }
}
