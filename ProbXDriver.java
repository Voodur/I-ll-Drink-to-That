/*
Problem:        Homework/Project X
Date Written:   X/X/19
Written By:     XXXXXXXX
*/

import java.io.*;

public class ProbXDriver
{
    public static void main(String args[]) throws IOException
    {
        ProbX app;
        app = new ProbX();
        app.appMain();
    }   
}

class ProbX
{
   // Data (Field) Declaration, so declare all your variables HERE
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));   // stdin will represent the keyboard
	String exampleString; 	// a string variable for our examples
	int exampleInt;		// an integer variable for our examples
	float exampleFloat;		// a float variable for our examples
	double exampleDouble;	// a double variable for our examples
   	char exampleChar;      	// a char variable for our examples

    // appMain is analogous to your Pseudocode Main
    void appMain() throws IOException
    {

	// call other methods and loop as needed
      
      /* ************************************************************************************************
         The lines below are examples of how to input strings, integers, floats, doubles, and chars.
         Cut and paste them into your code as needed and then delete the examples from your final program
       ***************************************************************************************************/ 
		
      // This is an example of an int
      System.out.print("\nEnter an integer (like your lucky number): ");
		exampleInt = Integer.parseInt(stdin.readLine());
      
      if (exampleInt == 13)
      {
        System.out.println("\nMost folks would not consider that a lucky number! "); 
      }
      
      // This is an example of a float
		System.out.print("\nEnter a decimal number (like your GPA): ");
		exampleFloat = Float.parseFloat(stdin.readLine());
		
     // This is an example of a double
      System.out.print("\nEnter another decimal number (like the value of pi or something longer): ");
		exampleDouble = Double.parseDouble(stdin.readLine());
		
      // This is an example of a String
      System.out.print("\nEnter a literal string (like your name): ");
      exampleString = stdin.readLine();
      
       if (exampleString.equals("Owen Herman"))
       {
     	ystem.out.print("Come on now, I don't think your name is \"really\" Owen Herman");
       }
     
      // This is an example of a char
       System.out.print("\nEnter the letter grade you are aiming for in CIS 2110 ");
       exampleChar = stdin.readLine().charAt(0);
       
       if (exampleChar != 'A')
       {
          System.out.println("\nI think you should set a higher goal for yourself. "); 
       }
		
      // This is an example of a summary output statement with column headings
	System.out.println("\nThe values that were input for this test were: ");
	System.out.println("\tstring \t\t\tinteger \t\t\tfloat \t\tdouble \t\tchar" );
	System.out.println("\t" + exampleString + "\t\t\t" +exampleInt + "\t\t\t\t"+ exampleFloat + "\t\t\t" + exampleDouble + "\t\t\t" + exampleChar);
      
    }  // this is the closing brace for appMain
    
    // the other methods that you create will go in this area.
 
}  // this is the closing brace for ProbX