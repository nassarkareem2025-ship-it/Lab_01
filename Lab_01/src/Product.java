public class Product
{
    private String ID;
    private String Name;
    private String Description;
    private Double Cost;

    //Constructor
    public Product(String ID, String Name, String Description, Double Cost)
    {
        this.ID = ID;
        this.Name = Name;
        this.Description = Description;
        this.Cost = Cost;
    }

    //Getters and Setters

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }
    //toString

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost=" + Cost +
                '}';
    }
    //toCSV
    public String toCSVRecord() {
        return this.ID + "," + this.Name + "," + this.Description + "," + this.Cost;
    }
    //toJson
    public String toJSONRecord() {
        String retString = "";
        char DQ = '\u0022';
        retString = "{" + DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + ","
                + DQ + "Name" + DQ + ":" + DQ + this.Name + DQ + ","
                + DQ + "Description" + DQ + ":" + DQ + this.Description + DQ + ","
                + DQ + "Cost" + DQ + ":" + DQ + this.Cost + DQ + "}";
        return retString;
    }
    //toXML
    public String toXML() {
        String retString = "";
        retString = "<Product>"
                + "<ID>" + ID + "</ID>"
                + "<Name>" + Name + "</Name>"
                + "<Description>" + Description + "</Description>"
                + "<Cost>" + Cost + "</Cost>"
                + "</Product>";
        return retString;
    }
}
