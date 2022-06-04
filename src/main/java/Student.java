public class Student {
    private String rollno;
    private String fName;
    private String lName;
    private String nickName;
    private int marks;

    public Student(String rollno, String fName, String lName, String nickName, int marks) {
        this.rollno = rollno;
        this.fName = fName;
        this.lName = lName;
        this.nickName = nickName;
        this.marks = marks;
    }

    public Student() {
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno='" + rollno + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", marks=" + marks +
                '}';
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
