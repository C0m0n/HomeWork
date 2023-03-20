import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EagleBank {
    public String acountNumber = "0";
    private List<String> info = new ArrayList<String>();
    
    // public void setAcountNumber(int acountNumber){
    //     this.acountNumber = ;
    // }
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

        for(int i = 1; i < info.size(); i++){
            if ((Integer.parseInt(acountNumber) == Integer.parseInt(info.get(i-1)))&& Integer.parseInt(pin) == Integer.parseInt(info.get(i))){
                valid = true;
                this.acountNumber = acountNumber;
            }
        }
        reader.close();
        return valid;
    }
}
