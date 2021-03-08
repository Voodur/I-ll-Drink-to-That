/*  CIS 2110 Sort example
Creating, Compiling, and Executing Java Programs

Source Name:	ArrayForAvg.java
Problem:	demo use of arrays for input, processing, and output
Date Written:	6/23/2012
Date Revised:  5/1/2018
Written By:	Owen Herman
Purpose:	supplemental material for CIS 2110
This version pre-loads the input arrays with five students worth of test data.
*/

   import java.io.*;
   import java.text.DecimalFormat;
   
   public class ArrayForAvgVer2
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
   
      int[] stuNr = {111, 222, 333, 444, 555};		//declare and initialize an an array of integer values named stuNr
      float[] scores = {75, 85, 90, 66, 87};		//declare and initialize an array of float values named scores
      float[] deltaAvg = new float[stuNr.length];		//declare and create an array of float values the same size as the stuNr array named deltaAvg
      float totScore = 0; 		// accumulator for total score
      float average;				//average of all scores
      BufferedReader stdin;	//define stdin for keyboard input
      DecimalFormat f1 = new DecimalFormat("###.##");
   
   /* appMain module */
      public void appMain() throws IOException
      {
         stdin = new BufferedReader(new InputStreamReader(System.in));	// create input string object	
         System.out.println("Program author:  Owen Herman\n");
         			
         calcAvg();				//calculates the average score
			calcDeltas();		// calculates the deviation (delta) of each score from the average
      	outRays();			//outputs the results using three arrays
         System.out.println("\n\n END OF PROGRAM");
      }								// end of appMain   
   
   
      void calcAvg()
		{
         /*  Two approaches to summing up the scores are shown.  The first 
         uses the traditional for loop with three components.  It looks like this:*/
                  
         for (int count=0; count<stuNr.length; count++)
         {
            totScore += scores[count];			
         }

         
         /* The second approach shown below (commented out) uses the enhanced for loop
         for (float element : scores)
         {
            totScore += element;
         }*/
         
         average = totScore / stuNr.length;
      }
   
   	void calcDeltas()
		{
		 for (int count=0; count<stuNr.length; count++)
         {
            deltaAvg[count] = scores[count] - average;			
         }
		}

   
     	void outRays()throws IOException
 	   {
  	   	System.out.println("********************  Summary Report  ********************");
			System.out.println("Student Number \t\tScore \t\t Deviation from Average");
         System.out.println("**********************************************************");
			for (int count=0; count <stuNr.length; count++)
   	   {
   		System.out.println("     " +stuNr[count] + "\t\t\t\t\t" + scores[count]+ "\t\t\t\t\t" + f1.format(deltaAvg[count]));
   	   }				// end of for loop
   	}					// end of outRays*/
   
   }						//  end of AvgScore