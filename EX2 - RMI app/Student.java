import java.io.Serializable;

public class Student implements Serializable {
    private int rollNum;
    private String name;
    private String mobileNum;
    private int yearOfStudy;

    public Student(int rollNum, String name, String mobileNum, int yearOfStudy) {
        this.rollNum = rollNum;
        this.name = name;
        this.mobileNum = mobileNum;
        this.yearOfStudy = yearOfStudy;
    }

    // Getters and toString() method
    public int getRollNum() { return rollNum; }
    public String getName() { return name; }
    public String getMobileNum() { return mobileNum; }
    public int getYearOfStudy() { return yearOfStudy; }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }
}
