
public class Racer3 extends GenericRacer  {

	
	public Racer3(String inputName) {
		super(inputName);
	}
	
	
	// move method
	@Override 
	public void move(){
		int choice = randomFrom(0, 2);
		int move;
		if (choice == 0){
			move = randomFrom(0, 11);
		} else {
			move = (int)(7 * Math.cos(7));
		}
		setLocation(getLocation() + move);
	}

}
