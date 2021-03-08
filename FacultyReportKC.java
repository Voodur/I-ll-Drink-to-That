/*
Source Name:    FacultyReportKC.java
Problem:        Faculty Report with Known Cardinality
Date Written:   6/30/19
Written By:     Owen Herman
*/

import java.io.*;
import java.text.DecimalFormat;

public class FacultyReportKC
{
    public static void main(String args[]) throws IOException
    {
        FacRpt app;
        app = new FacRpt();
        app.appMain();
    }   
} // end of class Hw09Driver

class FacRpt
{
    // Data/Field Declarations 
   BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));   // define and create stdin	
   String term;      // the school term being reported
   int numToProcess; // the number of faculty to process
   int[] facID = {11,22,33,44,55,66};   // the faculty id number
   int[] sects = {4,3,5,4,3,3};        // number of sections taught by a faculty member
   int[] studs = {150,90,100,85,30,20};      // number of students taught by a faculty member
   int totSects;     // total number of sections taught
   int totStuds;     // total number students taught
   int facCount;     // counter of number of faculty in report
   float avgStuds;   // average number of students (total students / number of faculty)
   int loSects;      //  lowest number of sections taught
   int loFacID;      //  faculty who taught the lowest number of sections

    /* 
    appMain module calls for initialization, user input, 
	 and the final output 
	*/
    public void appMain() throws IOException
    {
     initializeReport();
	  displayHeader();
	  getTerm();
     //getCard();
			procFaculty();
		calcAvg();
		displaySummary();
    }   // end of appMain


    void initializeReport()
    {
		facCount = totSects = totStuds = 0;
		loSects = 9999;
	 }
	
	void displayHeader()
	{
		System.out.println("\n*********************");
		System.out.println("Solution for Faculty Report Project #5");
		System.out.println("byBradley Martinez");
		System.out.println("*********************\n");
	}

	void getTerm() throws IOException
	{
		System.out.print("Please enter the semester term: ");
		term = stdin.readLine();
	}

  // void getCard() throws IOException

   //{
     // System.out.print("Enter the number of faculty //members to process:  ");
		//numToProcess= //Integer.parseInt(stdin.readLine());
 //  }
   
   void displayTerm()
   {
      System.out.println("SEMESTER: " + term + "\n");
   }
   
	void procFaculty() throws IOException
	{
        for (int count=0; count<facID.lenght; count++;)
        {
            //getFacNum();
            //getDetails();
            calcTotals();
            updateLow();
        }
	}
	
//	void getFacNum() throws IOException
//	{
	//	System.out.print("Enter the faculty number:  ");
	//	facID= Integer.parseInt(stdin.readLine());
//	}
	
//	void getDetails() throws IOException
//	{
//		System.out.print("Enter the number of sections: ");
//		sects = Integer.parseInt(stdin.readLine());
//
//		System.out.print("Enter the number of students: ");
//		studs = Integer.parseInt(stdin.readLine());
//	}
	
	void calcTotals()
	{
        for (int count=0; count<facID.length; count++)
         {
            totSects += sects[count];
            totStuds += studs[count]:
         }
	}  
	
	void updateLow()
	{
		if (sects < loSects)
		{
			loSects = sects;
			loFacID = facID;
		}
	}
	
	void displayFacDetails()
	{
		System.out.println("\n********** Faculty Details **********");
		System.out.println("Faculty ");
		System.out.println("Number \tSections \tStudents");
		System.out.print(facID + "\t\t\t" + sects);
		System.out.println("\t\t\t\t" + studs);
		System.out.println("*************************************\n\n");
	}
	
	void calcAvg()
	{
		avgStuds = (float) totStuds / facCount;   
				/*  Why the cast to (float) in the formula? 
	
					Since both totStuds & facCount are declared as an int 
					the division will produce an int value. And then 
					the int value will be assigned to "avgStuds which 
					is declared as a float". Hence the decimal 
					postitions will "always be .00" regardless of 
					the value.
			

			An alternative would be to "declare facCount as a float" 
			instead of an int. The reasons for this are:
			- then the above formula would do division with a float
				and an int, the result would then be a float

			- the facCount is not output so it would never be seen with
				the decimal positions
		 */

	}
	
	void displaySummary()
	{
		System.out.println("\n\n");
		System.out.println("********* Semester Summary *********");

		System.out.println("SEMESTER: " + term + "\n");
		System.out.println("Total Sections: " + totSects);
		System.out.println("Total Students: " + totStuds);
		System.out.println("Average Students per Faculty: " + avgStuds + "\n");
		System.out.println("The lowest number of sections assigned is: " + loSects);
		System.out.println("The FacultyID assigned least sections is: " + loFacID);
		System.out.println("************************************");
	}
} // end of class Hw09