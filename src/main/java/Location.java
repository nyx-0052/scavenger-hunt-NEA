public class Location {
    private int locationID;
    private String name;
    private int xcoord;
    private int ycoord;
    private String descp;
    private String schoolLink;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int correctOption;

    // constructor
    public Location(int locationID, String name, int xcoord, int ycoord, String descp, String schoolLink, String question, int correctOption, String option1, String option2, String option3) {
        this.locationID = locationID;
        this.name = name;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.descp = descp;
        this.schoolLink = schoolLink;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctOption = correctOption;
    }

    // setters
    public int getLocationID() {
        return locationID;
    }
    public String getName() {
        return name;
    }
    public int getXcoord() {
        return xcoord;
    }
    public int getYcoord() {
        return ycoord;
    }
    public String getDescp() {
        return descp;
    }
    public String getSchoolLink() {
        return schoolLink;
    }
    public String getQuestion() {
        return question;
    }
    public String getOption1() {
        return option1;
    }
    public String getOption2() {
        return option2;
    }
    public String getOption3() {
        return option3;
    }
    public int getCorrectOption() {
        return correctOption;
    }

    // toString
    @Override
    public String toString() {
        return "Location{" +
                "locationID=" + locationID +
                ", name='" + name + '\'' +
                ", xcoord=" + xcoord +
                ", ycoord=" + ycoord +
                ", descp='" + descp + '\'' +
                ", schoolLink='" + schoolLink + '\'' +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", correctOption=" + correctOption +
                '}';
    }

    public String getOption(){
        String correctField = "option_" + correctOption;
        DBHandler db = new DBHandler();
        String correctAnswer = db.getCorrectAnswer(correctField, locationID);
        return correctAnswer;
    }
}
