/*
Problem:        HW9_Kicker Stats
Date Written:   10/22/19
Written By:     Bradley Martinez
*/

import java.io.*;

public class Kicker_Stats
{
    public static void main(String args[]) throws IOException
    {
        Kicker app;
        app = new Kicker();
        app.appMain();
    }   
}

class Kicker
{
   // Data (Field) Declaration, so declare all your variables HERE
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));   // stdin will represent the keyboard
    float perSKick;	//	Percentage of Short Kicks in Made
    float perLKick;	//	Percentage of Long Kicks in Made
    float avgGYrds;	    //	Average Yards of Good Kicks Made
    int maxGKick;	// 	Longest Kick
    char kickResult;	//	Kick is Good or not
    int kickYrds;	//	Length of Kick in Yards 
    String kickLS;		//	Determines a Long or Short Kick
	int kickAtt;	// 	The Number of Kick Attempts
	int maxSKick;	//	Longest Short Kick
    int kickCount;  //  Count 
    int sumGKick;   //  Good yards accum
    int totGKick;   //  Good kick accum
    int sumSKickMade;   //  Good short kick accum
    int totSKickAtt;    //  Short kick accum
    int sumLKickMade;   //  Good Long kick accum
    int totLKickAtt;    //  Long kick accum
    
    // appMain is analogous to your Pseudocode Main
    public void appMain() throws IOException
    {
    displayHeader();    
    getKicks();
    initRpt();		
		while (kickCount < kickAtt)
		{
            processKick();
		}
        calculate();
		outputRpt();
    }   //  end of app main

	void initRpt() throws IOException
	{
        kickCount = sumGKick = totGKick = sumSKickMade = totSKickAtt = sumLKickMade = totLKickAtt = maxGKick = 0;		
	}
    
    void displayHeader() throws IOException
	{
		System.out.println("\n*********************");
		System.out.println("Solution for Kicker Stats");
		System.out.println("prepared by Bradley Martinez");
        System.out.println("for CIS 2110 Homework 9");
		System.out.println("*********************\n");
	}

	void getKicks() throws IOException
	{
        System.out.print("Please enter number of attempts: ");
		kickAtt = Integer.parseInt(stdin.readLine());
        
        System.out.print("Please enter the maximum short kick: ");
		maxSKick = Integer.parseInt(stdin.readLine());
	}
    
	void outputKick() throws IOException
	{
        System.out.println("\nThe length for this attempt was " + kickYrds + " yards, and the result was " + kickResult);
        
		System.out.println("Based on the value of the cut-off between short vs long, this attempt was classified as " + kickLS + "\n");
	}

    void calculate() throws IOException
	{
		avgGYrds = sumGKick / (float)totGKick;
		perSKick = sumSKickMade / (float)totSKickAtt * 100;
		perLKick = sumLKickMade / (float)totLKickAtt * 100;
	}

	void getYrds() throws IOException
	{
        System.out.print("\nPlease enter the yardage of this attempt: ");
		kickYrds = Integer.parseInt(stdin.readLine());
        
        System.out.print("\nEnter the result of this attempt: G for a good kick, F for a failed attempt: ");
		kickResult = stdin.readLine().charAt(0);
	}

	void goodKick() throws IOException
	{
		if (kickYrds <= maxSKick)	
		{
			sumSKickMade = sumSKickMade + 1;
			totSKickAtt = totSKickAtt + 1;
			kickLS = "short";
		}
		else
		{	
			sumLKickMade = sumLKickMade + 1;
			totLKickAtt = totLKickAtt + 1;
			kickLS = "long";
		}
	}

	void outputRpt() throws IOException
	{
        System.out.println("\n\n");
		System.out.println("**********************");
        System.out.println("Summary report for this kicker\n");
		System.out.println("The average yardage for good kicks was: " + avgGYrds);
		System.out.println("The percentage of short kicks that were good was: " + perSKick);
		System.out.println("The percentage of long kicks that were good was: " + perLKick);
		System.out.println("The longest good kick was: " + maxGKick);
	System.out.println("************************************");
	}

    void processKick() throws IOException
	{
        getYrds();
        goodOrFail();
		outputKick();
		++kickCount;
	}
	
	void goodOrFail() throws IOException
	{
		if (kickResult == 'G' || kickResult == 'g')
		{	
			sumGKick = sumGKick + kickYrds;
			totGKick = totGKick + 1;
			goodKick();
			updateMax();
		}
		if (kickResult == 'F' || kickResult == 'f')  
		{		
			failedKick();
		}
	}

	void failedKick() throws IOException
	{
		if (kickYrds <= maxSKick)	
		{
			totSKickAtt = totSKickAtt + 1;
			kickLS = "short";
		}
		else
		{	
			totLKickAtt = totLKickAtt + 1;
			kickLS = "long";
		}
		
	}

	void updateMax() throws IOException
	{
		if (kickYrds > maxGKick)
		{
			maxGKick = kickYrds;
        }
	}
   
}  // this is the closing brace for appMain
    
    
