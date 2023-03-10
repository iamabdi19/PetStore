
public class Elevator {

    private static int travelMeter;
    private int currentFloor;
    private int maxFloor;
    private int minFloor;
    private MyStack people;
    private int capacity;

    public Elevator() {
        people = new MyStack();
        currentFloor = 0;
        capacity = 4;
        minFloor = 0;
        maxFloor = 10;
    }

    public Elevator(int size, int minFloor, int maxFloor) {
        people = new MyStack();
        capacity = size;
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        currentFloor = 0;
    }

    public static int getTravelMeter() {
        return travelMeter;
    }
    public  MyStack getPeople(){
        return people;
    }

    public boolean enter(Person p, int target) {
        if (target < minFloor || target > maxFloor) {
            throw new IllegalArgumentException("target " + target + " out of bounds");
        }
        ElevatorPerson l = new ElevatorPerson(p, currentFloor, target);
        if (people.getSize() < capacity) {
            people.push(l);
            System.out.println(l.getPerson().getName() + " is in.");
            return true;
        } else {
            return false;
        }
    }

    public void goToFloor(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            throw new IllegalArgumentException("target " + floor + " out of bounds");
        }
        int previousFloor = currentFloor;
        currentFloor = floor;
        travelMeter += Math.abs(currentFloor - previousFloor);

        while (!people.isEmpty()) {
            ElevatorPerson p = ((ElevatorPerson) people.peek());
            boolean left = false;
            if (p.getTarget() == currentFloor) {
                people.pop();
                System.out.println(p.getPerson().getName() + " is out.");
                System.out.println(p);
            } else {
                break;
            }

        }

        System.out.println(this);

    }
    public void Up(){
        goToFloor(currentFloor + 1);
    }
    
    public void Down(){
        goToFloor(currentFloor - 1);
    }

    public void releaseEveryone() {
        while (!isEmpty()) {
            ElevatorPerson p = ((ElevatorPerson) people.peek());
            goToFloor((p.getTarget()));
        }

    }

    public boolean isFull() {
        if (!people.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return people.isEmpty();
    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }


    @Override
    public String toString() {
        return "Elevator is on floor: " + currentFloor + ", Number of people: " + people.getSize();
    }
}
