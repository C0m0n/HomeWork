
public class Racer4 {

	// declare location
	private int location;
	// declare name
	private String name;
	
	// constructor
	public Racer4(String name) {
		// set variables 
		location = 0;
		this.name = name;
	}
	
	// example of a random number generator given a lower and higher bound
	public int randomFrom (int low, int high) {

		int randNum = 0;

		// (int) is casting since Math.random() return a double and randNum is an int
		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}
	
	// move method
	public void move(int turn){
		int move = (int) (45 / (Math.pow(2, turn)));
		if (move < 1){
			move = 1;
		}
		this.location += move;
	}

	//get method for location
	public int getLocation() {
		return location;
	}
	
	//get method for name
	public String getName() {
		return name;
	}
	//set method for location
	public void setLocation(int location) {
		this.location = location;
	}
	//set method for name
	public void setName(String name) {
	this.name = name;
	}
}