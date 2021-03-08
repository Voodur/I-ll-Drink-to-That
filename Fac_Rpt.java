/*
Problem:        Project 5
Date Written:   12/9/19
Written By:     Bradley Martinez
*/

import java.io.*;
import java.text.DecimalFormat;

public class Fac_Rpt
{
    public static void main(String args[]) throws IOException
    {
        Fac rpt;
        app = new Fac();
        rpt.appMain();
    }   
}

class Fac
{
   // Data (Field) Declaration, so declare all your variables HERE
    String term;
	int[] facID;   //declare a variable to hold an array of integer values named facID
    int[] sects;    //declare a variable to hold an array of integer values named sects
    int[] studs;    //declare a variable to hold an array of integer values named studs
    int size;   // declare the size of the each array
    float totStuds =0;
    float totSects =0;
    float avgStuds =0;
    int loSects =9999;
    int loFacID =9999;
    BufferedReader stdin;	//define stdin for keyboard input
    DecimalFormat f1 = new DecimalFormat("###.00");
    
    // appMain is analogous to your Pseudocode Main
    public void appMain() throws IOException
    {
        stdin = new BufferedReader(new InputStreamReader(System.in));	// create input string object	
         System.out.println("Program author: Bradley Martinez\n");
    
         arraySize();		//calls a method to prompt the user for the cardinality of the number of students
         facID = new int[size];		//creates an int array named facID of size specified by the user
         sects = new int[size];	    //creates a int array named sects of size specified by the user
         studs = new int[size];     //creates a int array named studs of size specified by the user	
        loadArray();		//reads values into the stuNr and scores arrays from keyboard
        calcAvg();				//calculates the average score
        calcDeltas();		// calculates the deviation (delta) of each score from the average
      	outRays();			//outputs the results using three arrays
    }								// end of appMain
    
	void arrarySize throws IOException
    {
        System.out.print("How many Sections are there? ");
         size = (Integer.parseInt(stdin.readLine()));
    }
    
    void loadArray() throws IOException
    {
         System.out.println("\nLoad the " + size + " sections\n");
         for (int count=0; count <size; count++)
         {
            System.out.print("\nEnter the Faculty ID "+ (count+1)+ "  ");
            facID[count] = Integer.parseInt(stdin.readLine());
            System.out.print("Enter the Sections "+ (count+1)+ "  ");
            scores[count] = Float.parseFloat(stdin.readLine());
         }
         
     } 					
    
    
    
    
    }