import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EagleBank {
    public String acountNumber = "0";
    private List<String> info = new ArrayList<String>();
    public List<Object> logger = new ArrayList<Object>();
    
    FileReader fileReader;
    public boolean validLogin(String acountNumber, String pin) throws FileNotFoundException {
        boolean valid = false;
        
        fileReader = new FileReader(Constants.ACCOUNT_DIR+Constants.EAGLE_BANK);
        Scanner reader = new Scanner(fileReader);
        reader.useDelimiter(",\\s");

        String str;

        while(reader.hasNext()){
            str = reader.next();
            info.add(str);
        }
        
        for(int i = 1; i < info.size() - 1; i++){
            if ((Integer.parseInt(acountNumber) == Integer.parseInt(info.get(i-1)))&& Integer.parseInt(pin) == Integer.parseInt(info.get(i))){
                valid = true;
                this.acountNumber = acountNumber;
            }
        }
        reader.close();
        return valid;
    }

    public void printReceipt() throws IOException{
        FileWriter writer = new FileWriter("receipts/receipt-"+java.time.LocalDate.now()+".txt");
        for (int i = 0; i < logger.size(); i++){
            writer.append(logger.get(i)+", ");
        }
        writer.append("Session Closed");
        writer.close(); 
    }
}
