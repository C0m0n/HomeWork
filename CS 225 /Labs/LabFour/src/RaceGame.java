
public class RaceGame {

	
	
	public static void main(String[] args) {
		
		// 1. declare all starting points
		int turn = 0;
		Racer1 r1 = new Racer1("Urza");
		Racer2 r2 = new Racer2("Fenix");
		Racer3 r3 = new Racer3("Drek");
		Racer4 r4 = new Racer4("Dijkstra");
		// 2. while the any racer has not cross the finish line
		while (r1.getLocation() < 100 && r2.getLocation() < 100 && r3.getLocation() < 100 && r4.getLocation() < 100 ){
			// 2-1. take a turn
			turn += 1;
			// 2-2. move racer1, racer2, racer3, racer4
			r1.move();
			r2.move();
			r3.move();
			r4.move(turn);
			System.out.println(r1.getName()+" is at "+ r1.getLocation());
			System.out.println(r2.getName()+" is at "+ r2.getLocation());
			System.out.println(r3.getName()+" is at "+ r3.getLocation());
			System.out.println(r4.getName()+" is at "+ r4.getLocation());
				// print out current location
		}
		if (r1.getLocation() > r2.getLocation() && r1.getLocation() > r3.getLocation() && r1.getLocation() > r4.getLocation()){
			System.out.println(r1.getName()+" won. Its position was "+r1.getLocation());
				
		}else if (r2.getLocation() > r1.getLocation() && r2.getLocation() > r3.getLocation() && r2.getLocation() > r4.getLocation()){
			System.out.println(r2.getName()+" won. Its position was "+r2.getLocation());
		}else if (r3.getLocation() > r1.getLocation() && r3.getLocation() > r2.getLocation() && r3.getLocation() > r4.getLocation()){
			System.out.println(r3.getName()+" won. Its position was " + r3.getLocation());
		}else if (r4.getLocation() > r1.getLocation() && r4.getLocation() > r3.getLocation() && r4.getLocation() > r2.getLocation()) {
			System.out.println(r4.getName()+" won. Its position was " + r4.getLocation());
		} else{
			System.out.println("error");
		}	
				
		// 3. find out who won
		
	}

	
	
}
