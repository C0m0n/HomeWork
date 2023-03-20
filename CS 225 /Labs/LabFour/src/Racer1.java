
public class Racer1 {
	
	// declare location
	private int location;
	// declare name
	private String name;
	
	// constructor 
	public Racer1(String name) {
		//set location to zero when racer1 is made
		location = 0;
		//set name to inputed name
		this.name = name;
	}

	// example of a random number generator given a lower and higher bound
	public int randomFrom (int low, int high) {

		int randNum = 0;

		// (int) is casting since Math.random() return a double and randNum is an int
		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}
	
	// example for Racer1 move method
	public void move() {

		// declare variables
		int move; 
		// flip a coin
		int randNum = randomFrom(0, 2);

		// if 1 move 4
		if (randNum == 1) {
			move = 4;

		// if 0 move 8
		} else {
			move = 8;
		}
		location = location + move; 
	}
	
	// get the location of racer 1
	public int getLocation() {
		return location;
	}
	// set the location of racer 1
	public void setLocation(int location) {
		this.location = location;
	}
	// get the name of Racer 1
	public String getName() {
		return name;
	}
	// set the name of Racer 1
	public void setName(String name) {
		this.name = name;
	}
}
