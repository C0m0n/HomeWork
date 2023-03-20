import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Acount {
    private Integer accountNumber;
    private FileReader file;
    private List<String> info = new ArrayList<String>();
    private double balance;
    private int pin; 
    
    

    public Acount(Integer accountNumber) throws IOException{
        //Change the account number
        this.accountNumber = accountNumber;
        String number = accountNumber.toString(); 

        //Create file object
        file = new FileReader("accounts/"+number+".txt");

        //Create the scanner
        Scanner reader = new Scanner(file);
        reader.useDelimiter(",\\s");

        //temp string
        String str;

        //While there are new lines
        while(reader.hasNext()){
            str = reader.next();
            info.add(str);
        }
        
        reader.close();
    }

    public Acount(Integer accountNumber, Integer pin) throws IOException{
        //Change the account number
        this.accountNumber = accountNumber;
        this.pin = pin;
        

        //Create file object
        

        writeToFile();
        addAccount();
    }

    public double getBalance(){
        balance = Double.parseDouble(info.get(2));
        return balance;
    }

    public int getPin(){
        pin = Integer.parseInt(info.get(1));
        return pin;
    }
    
    public Integer getAcountNumber(){
        Integer tempAN = 0;
        if (accountNumber == Integer.parseInt(info.get(0))){
            tempAN = accountNumber;
        } else {
            System.out.println("Error");
        }
        return tempAN;
    }

    //Method for closing out the file with no transaction
    private void writeToFile() throws IOException{
        FileWriter writer = new FileWriter(Constants.ACCOUNT_DIR + accountNumber + ".txt");
        writer.append(accountNumber + ", " + pin + ", " + balance + ", ");
        for (int i = 3; i < info.size(); i++){
            writer.append(info.get(i)+", ");
        }
        writer.close(); 
    }

    private void addAccount() throws IOException{
        FileWriter writer = new FileWriter(Constants.ACCOUNT_DIR + Constants.EAGLE_BANK, true);
        writer.append(accountNumber + ", " + pin + ", ");
        writer.close();
    }

    public List<String> getAcountHistory(){
        return info.subList(3, info.size());
    }

    public void deposit(double ammount){
        this.balance += ammount;
        try {
            info.add("Deposit");
            writeToFile();
        } catch (IOException e) {
            System.out.println("IOexception");
        }
    }
    public void withdraw(double ammount){
        this.balance -= ammount;
        try {
            info.add("Withdraw");
            writeToFile();
        } catch (IOException e) {
            System.out.println("IOexception");
        }
    }


}


