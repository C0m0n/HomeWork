import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileIO {

	private File labFile;
	private int count1;
	private int rows;
	private int dogs;
	private int cats;
	private int empty;
	private int color;
	public FileIO() {
		//  constructor 
		labFile = new File("Lab_Answers.csv");
	}

	public void parseFile() {
		// this will be to for the requirements

		try {
			FileReader fr = new FileReader(labFile);
			BufferedReader br = new BufferedReader(fr);
			// make a String called line
			String line;

			// read the header line in the file
			line = br.readLine();
			// print out header line 
			System.out.println(line);

			// while line is equal to the next line of the bufferedreader is not equal to null
			// this means read the next line in the file until there are not more line to read
			while (  ( line = br.readLine() ) != null     ) {

				// make an array to hold the columns 
				String[] lineColumns;
				// break the line up to columns. break on the comma and delete the comma
				lineColumns = line.split(",", -1);
				
				rows++;
				// print every line
				System.out.println(line);
				if (lineColumns[3].contains("Dog") || lineColumns[3].contains("dog") ){
					dogs++;
				}else if (lineColumns[3].contains("Cat") || lineColumns[3].contains("cat") ){
					cats++;
				}
				for (int i = 0; i < lineColumns.length; i++){
					if ("".equals(lineColumns[i])){
						empty++;
					}
				}
				if (lineColumns[5].contains("Red") || lineColumns[5].contains("Blue") || lineColumns[5].contains("Yellow")){
					color++;
				}
				try {  
					int num = Integer.parseInt(lineColumns[1]); 
					count1++;
					
				} catch(NumberFormatException e){  
					System.out.println("Error");
				}  

				

			}
			System.out.println("Total number of valid favorite numbers: " +count1);
			System.out.println("Total number of invalid favorite numbers: " + (rows -count1));
			System.out.println("Total number of favorits dog: " + dogs);
			System.out.println("Total number of favorits cats: " + cats);
			System.out.println("Total number of empty: " + empty);
			System.out.println("Total number of colors: " + color);


			// when completely done with reading close the Reader
			br.close();

		} catch (Exception e) {

			e.printStackTrace();
		}


	}

	public static void main(String[] args) {

		FileIO lab9 = new FileIO();
		lab9.parseFile();

	}

}
