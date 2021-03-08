/*  CIS 2110 Sort example
Creating, Compiling, and Executing Java Programs

Source Name:	ArrayForAvg.java
Problem:	demo use of arrays for input, processing, and output using Decimal Format
Date Written:	6/23/2012
Date Revised:  4/30/2018
Written By:	Owen Herman
Purpose:	supplemental material for CIS 2110
*/

   import java.io.*;
   import java.text.DecimalFormat;
   
   public class ArrayForAvgVer1
   {
      public static void main(String args[]) throws IOException
      {
         AvgScore exercise;
         exercise = new AvgScore ();
         exercise.appMain();
      } 						// end main method
   }							// end ArrayForAvg class

   class AvgScore 
   {
   
   /* Class or Instance Declarations */
   
      int[] stuNr;		//declare a variable to hold an array of integer values named stuNr
      float[] scores;		//declare a variable to hold an array of float values named scores
      float[] deltaAvg;		//declare a variable to hold an array of float values named deltaAvg
      int size;			//size of all arrays
      float totScore = 0; 		// accumulator for total score
      float average;				//average of all scores
      BufferedReader stdin;	//define stdin for keyboard input
      DecimalFormat f1 = new DecimalFormat("###.00");  // limits decimals to 2 positions
   
   
   /* appMain module */
   
      public void appMain() throws IOException
      {
         stdin = new BufferedReader(new InputStreamReader(System.in));	// create input string object	
         System.out.println("Program author:  Owen Herman\n");
    
         arraySize();		//calls a method to prompt the user for the cardinality of the number of students
         stuNr = new int[size];		//creates an int array named stuNr of size specified by the user
         scores = new float[size];	//creates a float array named scores of size specified by the user
         deltaAvg = new float[size];	//creates a float array named deltaAvg of size specified by the user
			
			
         loadArray();		//reads values into the stuNr and scores arrays from keyboard
         calcAvg();				//calculates the average score
			calcDeltas();		// calculates the deviation (delta) of each score from the average
      	outRays();			//outputs the results using three arrays
         System.out.println("\n\n END OF PROGRAM");
      }								// end of appMain
   
     void arraySize() throws IOException
      {
         System.out.print("How many student scores will be entered?  ");
         size = (Integer.parseInt(stdin.readLine()));
      }
   
   
      void loadArray() throws IOException
      {
         System.out.println("\nLoad the " + size + " scores\n");
         for (int count=0; count <size; count++)
         {
            System.out.print("\nStudent ID for student "+ (count+1)+ "  ");
            stuNr[count] = Integer.parseInt(stdin.readLine());
            System.out.print("Test score for student "+ (count+1)+ "  ");
            scores[count] = Float.parseFloat(stdin.readLine());
         }
         System.out.println("\n\nInput complete\n\n");
      } 						// end of loadArray()
   
      void calcAvg()
		{
         /*  Two approaches to summing up the scores are shown.  The first 
         uses the traditional for loop with three components.  It looks like this:*/
                  
         for (int count=0; count<size; count++)
         {
            totScore += scores[count];			
         }

         
         /* The second approach shown below (commented out) uses the enhanced for loop
         for (float element : scores)
         {
            totScore += element;
         }*/
         
         average = totScore / size;
      }
   
   	void calcDeltas()
		{
		 for (int count=0; count<size; count++)
         {
            deltaAvg[count] = scores[count] - average;			
         }
		}

   
     	void outRays()throws IOException
 	   {
  	   	System.out.println("********************  Summary Report  ********************");
			System.out.println("Student Number \t\tScore \t\t Deviation from Average");
         System.out.println("**********************************************************");
			for (int count=0; count <size; count++)
   	   {
   		System.out.println("     " +stuNr[count] + "\t\t\t\t\t" + scores[count]+ "\t\t\t\t\t" + f1.format(deltaAvg[count]));
   	   }				// end of for loop
      }					// end of outRays*/
   
   }						//  end of AvgScore