
public class ElevatorPerson{
    
    private int enterTime;
    private int initialPosition;
    private int target;
    private Person person;
    
    // constructor
    public ElevatorPerson(Person p,int ip,int t){
        this.person = p;
        this.initialPosition = ip;
        this.target = t;
        this.enterTime = Elevator.getTravelMeter();
    }

    // returns person
    public Person getPerson(){
        return person;
    }
    
    // returns the target 
    public int getTarget(){
        return target;
    }
    
    @Override
    public String toString(){
        if((Math.abs(target - initialPosition) >= Math.abs(Elevator.getTravelMeter() - enterTime)))
        {
            return "I am " +person.getName() + ". I traveled " +  Math.abs(Elevator.getTravelMeter() - enterTime) +" floors. I am happy.";
        }
        
        else{
            return "I am " +person.getName() + ". I traveled " + Math.abs(Elevator.getTravelMeter() - enterTime) +" floors. I am unhappy.";
        }
        
    }

    
    
}
