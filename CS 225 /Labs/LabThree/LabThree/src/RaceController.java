

public class RaceController {

	
	
	public static void main(String[] args) {
		
		// 1. Create a RaceController object
		RaceController raceController = new RaceController();
		// 2. Declare all racers and starting points
		int racer1Pos = 0;
		int racer2Pos = 0;
		int racer3Pos = 0;
		int racer4Pos = 0;
		int turnCounter = 0;
		// 3. While the any racer has not crossed the finish line
		while (racer1Pos < 100 && racer2Pos < 100 && racer3Pos < 100 && racer4Pos < 100){
			// 3-1. Move racer1, racer2, racer3, racer4
			racer1Pos += raceController.Racer1Move();
			racer2Pos += raceController.Racer2Move();
			racer3Pos += raceController.Racer3Move();
			racer4Pos += raceController.Racer4Move(turnCounter);
			turnCounter += 1;
		}
			
		// 4. Find out who won & print it out
		if (racer1Pos > racer2Pos && racer1Pos > racer3Pos && racer1Pos > racer4Pos){
			System.out.println("Racer 1 won. Its position was "+racer1Pos);
				
		}else if (racer2Pos > racer1Pos && racer2Pos > racer3Pos && racer2Pos > racer4Pos){
			System.out.println("Racer 2 won. Its position was "+racer2Pos);
		}else if (racer3Pos > racer1Pos && racer3Pos > racer2Pos && racer3Pos > racer4Pos){
			System.out.println("Racer 3 won. Its position was " + racer3Pos);
		}else if (racer4Pos > racer1Pos && racer4Pos > racer3Pos && racer4Pos > racer2Pos) {
			System.out.println("Racer 4 won. Its position was " + racer4Pos);
		} else{
			System.out.println("error");
		}
	}

	
	// example of a random number generator given a lower and higher bound
	public int randomBetween (int low, int high) {
		
		int randNum = 0;
		
		// (int) is casting since Math.random() return a double and randNum is an int
		randNum = (int) (Math.random()*(high-low) + low);
		
		return randNum;
	}
	
	
	// example for Racer1 
	public int Racer1Move() {
		
		// declare variables
		int move; 
		// flip a coin
		int randNum = randomBetween(0, 2);
		
		// if 1 move 4
		if (randNum == 1) {
			move = 4;
			
		// if 0 move 8
		} else {
			move = 8;
		}
		return move;
	}

	public int Racer2Move (){
		int move = randomBetween(2, 11);

		return move;
	}

	public int Racer3Move(){
		int choice = randomBetween(0, 2);
		int move;
		if (choice == 0){
			move = randomBetween(0, 11);
		} else {
			move = (int)(7 * Math.cos(7));
		}
		return move;
	}

	public int Racer4Move(int turn){
		int move = (int) (45 / (Math.pow(2, turn)));
		if (move < 1){
			move = 1;
		}
		return move;
	}
	
}
