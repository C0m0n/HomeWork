
public class Racer4 extends GenericRacer {

	public Racer4(String inputName) {
		super(inputName);
	}
	
	// move method
	@Override
	public void move(int turn){
		int move = (int) (45 / (Math.pow(2, turn)));
		if (move < 1){
			move = 1;
		}
		setLocation(getLocation() + move);
	}
}
