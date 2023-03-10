
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;



public class HwJavafx extends Application{

    
    
    
    public static void setRec(Rectangle[] allB,int presentF)
    {
        for(int i = 0; i < allB.length ;i++)
        {
            
            allB[i].setStroke(Color.BLACK);
            allB[i].setFill(Color.WHITE);
        }
        
        allB[presentF].setFill(Color.BLACK.brighter());
        
        
    }
    

    @Override
    public void start(Stage primaryStage) {
      
        
        // initialise the ocuupants and the elevator
        ElevatorPerson ep = new ElevatorPerson(new Person("Ebru"), 2, 5);
        Elevator elevator = new Elevator(10, 0, 9);
        Person p1 = new Student("Hakan", 35);
        Person p2 = new Student("Abdi", 21);
        Person p3 = new Professor("Hamza", 2);
        Person p4 = new Professor("Ali", 35);
        Person p5 = new Student("Ahmet", 41);
        Person p6 = new Professor("Khalid", 39);
        Person p7 = new Student("Majid", 75);
        Person p8 = new Professor("Salim", 6);
        
        
        elevator.enter(p1, 3);
        elevator.enter(p2, 4);
        elevator.enter(p3, 2);
        elevator.enter(p4, 7);
        elevator.enter(p5, 9);
        elevator.enter(p6, 0);
        elevator.enter(p7, 8);
        elevator.enter(p8, 5);
        
        int size = elevator.getPeople().getSize();
        
       
        
        
        // buttons
        Button up = new Button("GO UP");
        Button down = new Button("GO DOWN");
        
        //text fields
        TextField floor = new TextField();
        TextField name = new TextField();
        TextField num = new TextField();
        TextField target = new TextField();
        TextField TargetReached = new TextField();
        TextField travelMeter = new TextField();
        
        
        // Create rectangles and set them all to black
        Rectangle r1 = new Rectangle(35, 10, 60, 30);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.WHITE);
        Rectangle r2 = new Rectangle(35,10, 60, 30);
        r2.setStroke(Color.BLACK);
        r2.setFill(Color.WHITE);
        Rectangle r3 = new Rectangle(35,10, 60, 30);
        r3.setStroke(Color.BLACK);
        r3.setFill(Color.WHITE);
        Rectangle r4 = new Rectangle(35, 10, 60, 30);
        r4.setStroke(Color.BLACK);
        r4.setFill(Color.WHITE);
        Rectangle r5 = new Rectangle(35, 10, 60, 30);
        r5.setStroke(Color.BLACK);
        r5.setFill(Color.WHITE);
        Rectangle r6 = new Rectangle(35, 10, 60, 30);
        r6.setStroke(Color.BLACK);
        r6.setFill(Color.WHITE);
        Rectangle r7 = new Rectangle(35,10, 60, 30);
        r7.setStroke(Color.BLACK);
        r7.setFill(Color.WHITE);
        Rectangle r8 = new Rectangle(35, 10, 60, 30);
        r8.setStroke(Color.BLACK);
        r8.setFill(Color.WHITE);
        Rectangle r9 = new Rectangle(35, 10, 60, 30);
        r9.setStroke(Color.BLACK);
        r9.setFill(Color.WHITE);
        Rectangle r10 = new Rectangle(35, 10, 60, 30);
        r10.setStroke(Color.BLACK);
        r10.setFill(Color.WHITE);
        
        
        
        
        
        // set text field to not editable
        num.setEditable(false);
        name.setEditable(false);
        floor.setEditable(false);
        floor.setEditable(false);
        target.setEditable(false);
        TargetReached.setEditable(false);
        travelMeter.setEditable(false);
        
        
        
        
        // set the buttons in panes
        HBox Buttonspane = new HBox();
        Buttonspane.setAlignment(Pos.CENTER);
        Buttonspane.getChildren().add(up);
        Buttonspane.getChildren().add(down);
        
        
   
        
        
        
        // include the rectangles to the pane
        VBox recPane = new VBox();
        recPane.getChildren().addAll(r1,r2,r3,r4,
        r5,r6,r7,r8,r9,r10);
        recPane.setAlignment(Pos.CENTER);
        
        //place all rectangle boxes in array
        Rectangle[] allB= new Rectangle[10];
        allB[0] = r10;
        allB[1] = r9;
        allB[2] = r8;
        allB[3] = r7;
        allB[4] = r6;
        allB[5] = r5;
        allB[6] = r4;
        allB[7] = r3;
        allB[8] = r2;
        allB[9] = r1;
        
        
        
        GridPane gridPane = new GridPane();
        gridPane.add(new Text("Floor:"), 0, 0);
        gridPane.add(new Text("Name:"), 0, 1);
        gridPane.add(new Text("No. of people:"), 0, 2);
        gridPane.add(new Text("Targetfloor:"), 0, 3);
        gridPane.add(new Text("People who reached their targets:"),0,4);
        gridPane.add(new Text("Travel meter:"), 0, 5);
        gridPane.add(floor, 1, 0);
        gridPane.add(name, 1, 1);
        gridPane.add(num, 1, 2);
        gridPane.add(target, 1, 3);
        gridPane.add(TargetReached, 1, 4);
        gridPane.add(travelMeter, 1, 5);
        gridPane.add(Buttonspane, 1, 6);
        gridPane.setAlignment(Pos.CENTER);
        
        
        // set and manage last pane
        HBox allPane = new HBox();
        allPane.getChildren().add(gridPane);
        allPane.getChildren().add(recPane);
        allPane.setAlignment(Pos.CENTER);
        allPane.setSpacing(20);
        
       
        
        
        //set the pane 
        Scene scene = new Scene(allPane,600,500);
        primaryStage.setTitle("Elevator Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        // if button GO UP is pressed
        up.setOnAction(e ->{
            
            
            
            if(elevator.getPeople().getSize() == 1){
    
                elevator.Up();
                int d =  elevator.getCurrentFloor();
                setRec(allB,d);
                travelMeter.setText(String.valueOf(elevator.getTravelMeter()));
                floor.setText(String.valueOf(elevator.getCurrentFloor()));
                num.setText(String.valueOf(elevator.getPeople().getSize()));
                TargetReached.setText(String.valueOf(size - elevator.getPeople().getSize()));
                System.out.println(elevator.getPeople().getSize());
            }
            
            
            //if elevator is empty it is going to display a new scene and disable the buttons
            if(elevator.getPeople().getSize() == 0)
            {
                down.setDisable(true);
                up.setDisable(true);
                
                Stage exitStage = new Stage();
                exitStage.setTitle("Elevator's empty");
                exitStage.setScene(new Scene(new Button("Elevator's empty"),300,400));
                exitStage.show();
            }
            
            
            // if peak isnt equal to -1
            else
            {
                elevator.Up();
                num.setText(String.valueOf(elevator.getPeople().getSize()));
                name.setText(((ElevatorPerson)elevator.getPeople().peek()).getPerson().getName());
                floor.setText(String.valueOf(elevator.getCurrentFloor()));
                target.setText(String.valueOf(((ElevatorPerson)elevator.getPeople().peek()).getTarget()));
                travelMeter.setText(String.valueOf(elevator.getTravelMeter()));
                TargetReached.setText(String.valueOf(size - elevator.getPeople().getSize()));
                int d=  (elevator.getCurrentFloor());
                setRec(allB,d);
            }
        });
        
        
        
        
        // if button down is pressed
        down.setOnAction(e ->{
            
            
            
            if(elevator.getPeople().getSize() == 1)
            {
                elevator.Down();
                int d =  elevator.getCurrentFloor();
                setRec(allB,d);
                travelMeter.setText(String.valueOf(elevator.getTravelMeter()));
                floor.setText(String.valueOf(elevator.getCurrentFloor()));
                num.setText(String.valueOf((char) elevator.getPeople().getSize()));
                TargetReached.setText(String.valueOf(size - elevator.getPeople().getSize()));
            }
            
            
            //if elevator is empty it is going to display a new scene and disable the buttons
            if(elevator.getPeople().getSize() == 0)
            {
                down.setDisable(true);
                up.setDisable(true);
                
                Stage exitStage = new Stage();
                exitStage.setTitle("Elevator's empty");
                exitStage.setScene(new Scene(new Button("Elevator's empty"),300,400));
                exitStage.show();
            }
            
            
            // if peak != -1
            else
            {
            elevator.Down();
            num.setText(String.valueOf(elevator.getPeople().getSize()));
            name.setText(((ElevatorPerson)elevator.getPeople().peek()).getPerson().getName());
            floor.setText(String.valueOf(elevator.getCurrentFloor()));
            target.setText(String.valueOf(((ElevatorPerson)elevator.getPeople().peek()).getTarget()));
            travelMeter.setText(String.valueOf(elevator.getTravelMeter()));
            TargetReached.setText(String.valueOf(size - elevator.getPeople().getSize()));
            int d =  elevator.getCurrentFloor();
            setRec(allB,d);
            }
        });
        
    } 

    public static void main(String[] args) {
        launch(args);
    }
        
        
        
    
    
}

