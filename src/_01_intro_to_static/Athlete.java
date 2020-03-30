package _01_intro_to_static;

public class Athlete {
    static int nextBibNumber;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    String name;
    int speed;
    int bibNumber;

    Athlete (String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    public static void main(String[] args) {
    	Athlete one = new Athlete("bob",  7);
    	Athlete two = new Athlete("john", 8);
    	System.out.println("Here comes "+ one +", with a "+raceStartTime+" start time, and from "+raceLocation+".");
    	System.out.println("Here comes "+ two +", with a "+raceLocation+" start time, and "+raceStartTime+".");
        //create two athletes
        //print their names, bibNumbers, and the location of their race. 
    }
}

