/*
Source Name:    FacultyReportKC.java
Problem:        Faculty Report with Array's
Date Written:   12/10/19
Written By:     Bradley Martinez
*/

import java.io.*;
import java.text.DecimalFormat;

public class FacultyReport5
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
   DecimalFormat f1 = new DecimalFormat("###.##");
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
	  getTerm();
        procFaculty();
		calcAvg();
		displaySummary();
    }   // end of appMain


    void initializeReport()
    {
		facCount = totSects = totStuds = 0;
		loSects = 9999;
    }

	void getTerm() throws IOException
	{
		System.out.print("Please enter the semester term: ");
		term = stdin.readLine();
	}
   
	void procFaculty() throws IOException
	{

        {
        
            calcTotals();
        }
	}

	void calcTotals()
	{
        for (int count=0; count<studs.length; count++)
        {
            totSects += sects[count];
            totStuds += studs[count];
        
            if (sects[count] < loSects)
            {
			     loSects = sects[count];
                loFacID = facID[count];
            }
        	         
        }
	}
	
	void calcAvg()
	{
		avgStuds = (float) totStuds / studs.length;  
	}
	
	void displaySummary()
	{
       	System.out.println("\n*********************");
		System.out.println("Solution for Faculty Report Project #5");
		System.out.println("by Bradley Martinez");
		System.out.println("*********************\n");
		System.out.println("Faculty ID \t\t\tSections \t\t\tStudents");
            for (int count=0; count <facID.length; count++)
   	            {
                System.out.print(facID[count] + "\t\t\t\t" + sects[count]);
                System.out.println("\t\t\t\t" + studs[count]);
                }
        System.out.println(" ");
        System.out.println("Term for Report: " + term);
        System.out.println("Total Sections: " + totSects);
		System.out.println("Total Students: " + totStuds);
		System.out.println("Average Students per Faculty: " + f1.format(avgStuds));
		System.out.println("The lowest number of sections assigned is: " + loSects);
		System.out.println("The FacultyID assigned least sections is: " + loFacID);
	}
} // end of class Hw09