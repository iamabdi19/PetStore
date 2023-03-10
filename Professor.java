
public class Professor extends Person {
    int employeeID;
    
    public Professor(String name, int employeeID){
        this(name,employeeID,0);
    }
    public Professor(String name, int employeeID, int money){
        super(name,money);
        this.employeeID = employeeID;
        updateFoodPrice(12);
    }

    //overrides toString method for Professor
    public String toString(){
        return "I am a professor. My name is " + getName() + ". My employee ID is " + employeeID + ".";
    }
}
