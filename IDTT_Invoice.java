/*
Problem:        Project 3_IDTT_Invoice
Date Written:   10/30/19
Written By:     Bradley Martinez
*/

import java.io.*;

public class IDTT_Invoice
{
    public static void main(String args[]) throws IOException
    {
        IDTT app;
        app = new IDTT();
        app.appMain();
    }   
}

class IDTT
{
   // Data (Field) Declaration, so declare all your variables HERE
	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));   // stdin will represent the keyboard
    
    String name;	//	Customer Name
	String date;	//	Date of the Order
	float tax;	//	Tax Rate
	char more;	//	Prompt and Response
	int itemNum;	//	Item Number
	int quan;	//	Quantity
	double price;	//	Price
	double extPrice;	//	Extended Price
	double disPrice;	//	Discounted Price	
	double totDisPriceb4Tax;	//	Total Discounted Price before tax
	double totDisPriceWTax;	//	Total Discounted Price with Tax
	float totTax;	//	Total Tax for Order
	double totDis;	//	Total Discount for Order
    double discount;	//	Discount for Individual item’s 
    double disPer;   // Discount to be applied to order
    
    // appMain is analogous to your Pseudocode Main
    public void appMain() throws IOException
    {
    System.out.println(" ");    
    System.out.print("CIS 2110 Project #3");
    System.out.println("\nSubmited by Bradley Martinez");
    details();
    initialize();
    System.out.print("\nStart an Order, Enter y for Yes and n for No: ");
    more = stdin.readLine().charAt(0);
    System.out.println(" ");  
	   while (more == 'Y' || more == 'y')
	   {
		  processItem();
		  System.out.print("Do you have more to Order? Enter y for Yes and n for No: ");
           more = stdin.readLine().charAt(0);
           System.out.println(" ");
	   }
	   calculate();
	   summary();
    }   // end of appMain
    
    void summary() throws IOException
    {
        System.out.println("\nSummary Report for customer " + name + " for " + date);
        
        System.out.println("\nAfter a discount of $" + totDis + " was applied, the total net charge was $" + totDisPriceb4Tax);
    
        System.out.println("\nThe tax due is $" + totTax + " brining the final price to $" + totDisPriceWTax);
        System.out.println(" ");  
    }
    
    void details() throws IOException
    {
        System.out.print("\nName for the Order: ");
        name = stdin.readLine();
        
        System.out.print("\nDate of the Order: ");
        date = stdin.readLine();
        
        System.out.print("\nTax Rate for the Order, as a whole number: ");
        tax = Float.parseFloat(stdin.readLine());
        
        tax = tax * (float).01;
    }
    
    void initialize() throws IOException
    {
	   totDisPriceb4Tax = 0; 
	   totDis = 0;
    }
    
    void processItem() throws IOException
    {
	   getItem();
	   extPrice = price * quan;
	   getDis();
	   disPrice = extPrice - discount;
	   accum();
	   outputOrder();
    }	
    
    void accum() throws IOException
    {
	   totDisPriceb4Tax = totDisPriceb4Tax + disPrice;
	   totDis = totDis + discount;
    }
    
    void getItem() throws IOException
    {
        System.out.print("Enter the Item Number: ");
		itemNum = Integer.parseInt(stdin.readLine());
        
        System.out.print("Enter the Quantity of the item: ");
		quan = Integer.parseInt(stdin.readLine());
        
        System.out.print("Enter the Price of the item: ");
		price = Double.parseDouble(stdin.readLine());
    }   
    
    void getDis() throws IOException
    {
	   if (quan < 100)
	   {	 
		  disPer = .0;
	   }
		  if (quan > 101)
		  {
			 disPer = .05;
		  }
			 if (quan > 300)
			 {
                 disPer= .1;
			 }
	   discount = extPrice * disPer;
    }
    
    void calculate() throws IOException
    { 
	   totTax = (float)totDisPriceb4Tax * tax;
	   totDisPriceWTax = totDisPriceb4Tax + totTax;
    }
        
    void outputOrder() throws IOException
    {
        System.out.println("\nFor item " + itemNum + " The extended price is $" + extPrice + " and the discounted price is $" + disPrice);
        System.out.println(" ");
    }
}  // this is the closing brace for appMain
    
    
