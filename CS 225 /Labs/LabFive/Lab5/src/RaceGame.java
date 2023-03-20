import java.util.Arrays;

public class RaceGame {

	
	
	public static void main(String[] args) {
		
		int turn = 0; 
		// 1. declare all starting points
		// array of GanericRacer with 4 slots
		GenericRacer[] racers = new GenericRacer[4];
		racers[0] = new Racer1("Urza"); 
		racers[1] = new Racer2("Fenix");
		racers[2] = new Racer3("Drek");
		racers[3] = new Racer4("Dijkstra");
		// 2. while the any racer has not cross the finish line
		while ( racers[0].getLocation() < 100 && racers[1].getLocation() < 100 && racers[2].getLocation() < 100 && racers[3].getLocation() < 100 ){
			// 2-1. take a turn
			turn += 1;
			// 2-2. move racer1, racer2, racer3, racer4
			for (int i = 0; i < 4; i++){
				racers[i].move(turn);
			}
			for (int i = 0; i < 4; i++){
				System.out.println(racers[i].getName()+" is at "+ racers[i].getLocation());
			}
				// print out current location
		}

		Arrays.sort(racers, (r1, r2) -> r2.getLocation() - r1.getLocation());
		System.out.println(racers[0].getName()+" won. Its position was " + racers[0].getLocation());
		
		
	}


	
	
}
