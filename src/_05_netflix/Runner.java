package _05_netflix;

public class Runner {
public static void main(String[] args) {
	Movie m1 = new Movie("Harry Potter and the Sorcerer's Stone", 5);
	
	Movie m2 = new Movie("Twilight", 1);
	
	Movie m3 = new Movie("Spaceballs", 5);
	
	Movie m4 = new Movie("Parent Trap", 5);
	
	Movie m5 = new Movie("Frozen 2", 5);
	
	
	System.out.println(m1.getTicketPrice());
	
	
	
	NetflixQueue q1 = new NetflixQueue();
	
	
	
	
	q1.addMovie(m1);
	
	q1.addMovie(m2);
	
	q1.addMovie(m3);
	
	q1.addMovie(m4);
	
	q1.addMovie(m5);

	
	
	q1.printMovies();
	
}
}
