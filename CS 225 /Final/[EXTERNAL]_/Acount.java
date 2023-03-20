import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessHandle.Info;
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

    public void testWrite() throws IOException{
        FileWriter writer = new FileWriter("accounts/1234566.txt");
        writer.write("Test");
        writer.close(); 
    
    }


    public List<String> getAcountHistory(){
        return info.subList(3, info.size());
    }
    public static void main(String[] args) {
        try{
        Acount pp = new Acount(1234567);
        System.out.println(pp.getBalance());
        System.out.println(pp.getPin());
        System.out.println(pp.getAcountNumber());
        System.out.println(pp.getAcountHistory());
        pp.testWrite();
        
        
        } catch (IOException e) {
            System.out.println("Error");
        }
        
    }

}


