
public class GenericRacer {

	// declare location
	private int location;
	// declare name
	private String name;

	public GenericRacer(String name) {
		//set location to zero when GenericRacer is made
		location = 0;
		//set name to inputed name
		this.name = name;
	}
	
	public void move() {
		//do nothing
	}

	public void move(int turn){
		move();
	}
	
	// get the location of GenericRacer
	public int getLocation() {
		return location;
	}
	// set the location of GenericRacer
	public void setLocation(int location) {
		this.location = location;
	}
	// get the name of GenericRacer
	public String getName() {
		return name;
	}
	// set the name of GenericRacer
	public void setName(String name) {
		this.name = name;
	}
	// example of a random number generator given a lower and higher bound
	public int randomFrom (int low, int high) {

		int randNum = 0;

		// (int) is casting since Math.random() return a double and randNum is an int
		randNum = (int) (Math.random()*(high-low) + low);

		return randNum;
	}
	 
}
