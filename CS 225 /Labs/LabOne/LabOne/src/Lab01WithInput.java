/*************************************************************** 
Class: Lab01 
Author: David Greni
Created: 5/18/22
Modified: 5/18/22
Purpose: First programming example in CS 225L laboratory with input. 
Attributes: None 
Methods: +main(String[]): void 
**************************************************************/

import java.util.Scanner; 

public class Lab01WithInput {
    public static void main(String[] args) {  
        // Create a scanner for command line input  
        Scanner in = new Scanner(System.in);  
        // Prompt for, and store, the name  
        System.out.println("What is your name?");  
        String name = in.nextLine();  
        // Print the name back  
        System.out.println("Hello, " + name + "!\n");  
        // Close the scanner  
        in.close();  
    }  
}