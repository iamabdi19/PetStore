
public class Student extends Person {
    int studentID;
    public Student(String name, int studentID){
        this(name,studentID,0);
    }
    public Student(String name, int studentID, int money){
        super(name,money);
        this.studentID = studentID;
        updateFoodPrice(6);
    }

    public int getStudentID(){
        return studentID;
    }

    //overrides toString method for student
    public String toString(){
        return "I am a student. My name is " + getName() + ". My student ID is " + studentID + ".";
    }

    public boolean equals(Object o){
        if(o instanceof Student) {
            Student s = (Student) o;
            return s.getName().equals(getName()) && s.getStudentID() == studentID;

        }
        return false;

    }


}
