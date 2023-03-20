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
    private double withdrawn = 0;
    
    

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
        

        //Use writetoFile and add account methods for creating the new account
        writeToFile();
        addAccount();
    }

    //Change pin method
    public void changePin(Integer pin) throws IOException{
        this.pin = pin;
        writeToFile();
        String numberOfTransactions;
        List<String> transaction = new ArrayList<String>();
        FileReader fileReader = new FileReader("accounts/EagleBank.txt");
        Scanner scanReader = new Scanner(fileReader);

        scanReader.useDelimiter(",\\s");

        String str;

        while(scanReader.hasNext()){
            str = scanReader.next();
            transaction.add(str);
        }

        FileWriter tempwriter = new FileWriter("accounts/EagleBank.txt");
        transaction.set((transaction.indexOf(String.valueOf(accountNumber))+1), String.valueOf(pin));

        numberOfTransactions = transaction.get(transaction.size()- 1);
        Integer tempNumOfTransactions = Integer.parseInt(numberOfTransactions);
        for(int i = 0; i < transaction.size() - 1; i++){
            tempwriter.append(transaction.get(i) + ", ");
        }
        tempwriter.append(tempNumOfTransactions.toString() + ", ");

        scanReader.close();
        tempwriter.close();
    }

    //Get balance method
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
        String numberOfTransactions;
        List<String> transaction = new ArrayList<String>();
        FileReader fileReader = new FileReader("accounts/EagleBank.txt");
        Scanner scanReader = new Scanner(fileReader);

        scanReader.useDelimiter(",\\s");

        String str;

        while(scanReader.hasNext()){
            str = scanReader.next();
            transaction.add(str);
        }

        FileWriter tempwriter = new FileWriter("accounts/EagleBank.txt");
        transaction.add(0, String.valueOf(accountNumber));
        transaction.add(1, String.valueOf(pin));
        numberOfTransactions = transaction.get(transaction.size()- 1);
        Integer tempNumOfTransactions = Integer.parseInt(numberOfTransactions);
        for(int i = 0; i < transaction.size() - 1; i++){
            tempwriter.append(transaction.get(i) + ", ");
        }
        tempwriter.append(tempNumOfTransactions.toString() + ", ");

        scanReader.close();
        tempwriter.close();
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
        try {
            addTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void withdraw(double ammount){
        
        this.balance -= ammount;

        try{
            info.add("Withdraw");
            withdrawn = withdrawn + ammount;
            writeToFile();
        } catch (IOException e) {
            System.out.println("IOexception");
        }
        try {
            addTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public boolean validWithdrawl(double ammount){
        double tempBal = getBalance() - ammount;
        boolean valid = false;
        if (tempBal > 0 && tempBal > (getBalance() * .25) && ammount < 1000 && withdrawn < 1000){
            System.out.println(withdrawn);
            valid = true;

        }   else {
            valid = false; 
        
        }
        return valid;
    }

    private void addTransaction() throws IOException{
        String numberOfTransactions;
        List<String> transaction = new ArrayList<String>();
        FileReader fileReader = new FileReader("accounts/EagleBank.txt");
        Scanner scanReader = new Scanner(fileReader);
        scanReader.useDelimiter(",\\s");
        String str;
        while(scanReader.hasNext()){
            str = scanReader.next();
            transaction.add(str);
        }
        FileWriter tempwriter = new FileWriter("accounts/EagleBank.txt");
        numberOfTransactions = transaction.get(transaction.size()- 1);
        Integer tempNumOfTransactions = Integer.parseInt(numberOfTransactions) + 1;
        for(int i = 0; i < transaction.size() - 1; i++){
            tempwriter.append(transaction.get(i) + ", ");
        }
        tempwriter.append(tempNumOfTransactions.toString() + ", ");

        scanReader.close();
        tempwriter.close();
    }


}


