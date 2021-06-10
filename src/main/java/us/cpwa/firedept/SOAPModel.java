package us.cpwa.firedept;

import java.io.PrintWriter;

public class SOAPModel {

    private static final String fileName = "SOAP.txt";

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
    public String report() {

        try {
            // Printing out the actual com.cp.firedept.SOAP
            PrintWriter writer = new PrintWriter(SOAPModel.fileName);

            // Subjective
            writer.print("S: " + dispatch + facility + age + "y/o " + gender + complaint + " " + report);

            // Objective
            writer.println();
            writer.println();
            writer.print("O: Upon arrival find Pt " + position
                    + ". CAOx" + caoValue + ". " + primary);

            // Assessment
            writer.println();
            writer.println();
            writer.print("A: " + assessment);

            // Plan
            writer.println();
            writer.println();
            writer.print("P: " + covidStatus + "ABCs, Pt Hx and initial assessment, vitals, CAOx"
                    + caoValue + " " + other + " " + transport + " Decontamination and call closed.");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return "";
    }
}
