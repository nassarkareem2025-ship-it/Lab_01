

public class Person
{
    private String IDNum;
    private String firstName;
    private String lastname;
    private String title;
    private int YOB;

    //Constructor

    public Person(String IDNum, String firstName, String lastname, String title, int YOB) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastname = lastname;
        this.title = title;
        this.YOB = YOB;
    }

    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }
    public String toCSVRecord() {
        return this.IDNum + "," + this.firstName + "," + this.lastname + "," + this.title + "," + this.YOB;
    }
    public String toJSONRecord() {
        String retString = "";
        char DQ = '\u0022';

        retString = "{" + DQ + "IDNum" + DQ + ":" + DQ + this.IDNum + DQ + ","
                + DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ","
                + DQ + "lastname" + DQ + ":" + DQ + this.lastname + DQ + ","
                + DQ + "title" + DQ + ":" + DQ + this.title + DQ + ","
                + DQ + "YOB" + DQ + ":" + DQ + this.YOB + DQ + "}";
        return retString;
    }
    public String toXML() {
        String retString = "";
        retString = "<Person>" +
                "<IDNum>" + IDNum + "</IDNum>" +
                "<firstName>" + firstName + "</firstName>" +
                "<lastname>" + lastname + "</lastname>" +
                "<title>" + title + "</title>" +
                "<YOB>" + YOB + "</YOB></Person>";
        return retString;
    }

   public String fullName(){
       return firstName + " " + lastname;
    }

   public String FormalName(){
       return title + " " + fullName();
    }

   public int getAge(){
       return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - YOB;
    }

   public int getAge(int year) {
       return year - YOB;
    }
}
