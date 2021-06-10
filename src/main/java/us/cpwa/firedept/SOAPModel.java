package us.cpwa.firedept;

public class SOAPModel {

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
        return "S: " + dispatch + facility + age + "y/o " + gender + complaint + " " + report
                + "\r\n\r\n" + "O: Upon arrival found Pt " + position + ". CAOx" + caoValue
                + ". " + primary + "\r\n\r\n" + "A: " + assessment + "\r\n\r\n" + "P: "
                + covidStatus + "ABCs, Pt Hx and initial assessment, vitals, CAOx" + caoValue
                + ", " + other + " " + transport + " Decontamination and call closed.";
    }
}
