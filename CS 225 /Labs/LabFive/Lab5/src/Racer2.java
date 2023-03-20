
public class Racer2 extends GenericRacer {


	public Racer2(String name) {
		super(name);
	}
	
	
	// move method
	@Override 
	public void move(){
		setLocation(getLocation() + randomFrom(2, 11));
	}
	
	
}
