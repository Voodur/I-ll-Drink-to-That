/*
Problem:        Project 4C_IDTT_2
Date Written:   10/14/19
Written By:     Bradley Martinez 
*/

import java.io.*;

public class IDTT_2
{
    public static void main(String args[]) throws IOException
    {
        IDTT2 app;
        app = new IDTT2();
        app.appMain();
    }   
}

class IDTT2
{
   // Data (Field) Declaration, so declare all your variables HERE
	   BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));   // stdin will represent the keyboard
	   String date;	//	Date
	   float taxRate;	//	Tax Rate
	   String customer;	//	Customer
	   char disCat;	//	Discount Category
	   int itemNum;	//	Item Number
	   int qty;	//	Quantity
	   double listPrice;	//	List Price
        double extPrice;	//	Extended Price
	   double totExtPrice;	//	Total of the Extended Prices, Per Customer 
	   double discount;	//	Discount, Per Customer
	   double disPrice;	//	Discounted Price, Per Customer
	   double tax;	//	Tax Charge, Per Customer
	   double finalPrice;	//	Final Price, Per Customer
	   double sumExtPrice;	//	Total of all Extended Prices 
	   double sumDiscount;	//	Total of all Discounted Prices
	   double totFinalPrice;	//	Total Amount Billed
	   double maxDiscount;	//	Largest Discount 
	   String maxCustomer;	//	Customer with Largest Discount
        int abv; //  Discount Cutoff
        double disPer;  //  Discount Percentage

           // appMain is analogous to your Pseudocode Main
    void appMain() throws IOException
        {
            System.out.println("\n*CIS 2110 Project 4C - IDTT_2 Monthly Report*");
            System.out.println("*Submitted by Bradley Martinez*");
	       details();
	       initialize();
           System.out.print("\nEnter the Name of the First Customer: ");
            customer = stdin.readLine();
           
        while (!customer.equals("Done")) 
	       {	
                getDis();
                getItem();
                calc_2();
                accum_2();
                upMax();
                outputOrder();
                System.out.print("\nEnter enter the Name of the Next Customer: ");
                customer = stdin.readLine();
            }	
            summary();
        }   //  end of app main 
    
    void details() throws IOException
        {
	       System.out.print("\nDate of the Order: ");
            date = stdin.readLine();
        
            System.out.print("\nEnter the tax rate. For example, 4.5% would be entered as 4.5: ");
            taxRate = Float.parseFloat(stdin.readLine()); 
            taxRate /= 100;
        }
    
    void initialize()
        { 
	       sumExtPrice = 0;
	       sumDiscount = 0;
	       totFinalPrice = 0;
	       maxDiscount = 0;
        }
    
    void accum_1()
        {
	       totExtPrice += extPrice;
        }
    
    void getItem() throws IOException 
        {
	       totExtPrice = 0;
	       System.out.print("\nEnter the First Item Number for the Order: ");
		      itemNum = Integer.parseInt(stdin.readLine());
                while( itemNum != 9999)
		          {
                    calc_1();
                    accum_1();
			         outputItem();
                    System.out.print("\n");
			         System.out.print("\nEnter the Next Item Number (9999 to signal end of items): ");
		              itemNum = Integer.parseInt(stdin.readLine());
                    }
        }
    
    void getDis() throws IOException 
        {
            System.out.print("\nPlease enter the customer discount category: ");
           disCat = stdin.readLine().charAt(0);
	       switch(disCat)
            {
               case 'A':
                    disPer = 0.05;
                    abv = 1000;
                    break;
               case 'B':
                    disPer = 0.045;
			         abv = 5000;	
                    break;
               case 'C':
                    disPer = 0.035;
			         abv = 10000;
                    break;
		      default:
                    System.out.println("Invalid category code. Customer was processed with no discount");
                    abv = 9999999;
            }	 
        }
    
    void calc_1() throws IOException
        { 
            System.out.print("\nEnter the Quantity for this Item: ");
                qty = Integer.parseInt(stdin.readLine());
        
            System.out.print("\nEnter the List Price for this Item: ");
		      listPrice = Double.parseDouble(stdin.readLine());
               
            extPrice = listPrice*qty;
        }
    
    void outputItem()
        {
            System.out.printf("\nThe Extended Price for item " + itemNum + " is $%,.2f",extPrice);
        }
    
    void calc_2()
        {
	       if(totExtPrice > abv)
	       {
		      discount = (totExtPrice - abv) * disPer;
	       }
	       else 
	       {	
		      discount = 0;
	       }
	           disPrice = totExtPrice - discount;
	           tax = disPrice*taxRate;
	           finalPrice = disPrice + tax;
        }
    
    void accum_2()
        {
           sumExtPrice += totExtPrice;
	       sumDiscount += discount;
	       totFinalPrice += finalPrice;
        }	
    void upMax()
        {
	       if(discount > maxDiscount)
	       {
		      maxDiscount = discount;
		      maxCustomer = customer;
	       }
        }
    
    void outputOrder()
        {
	       System.out.printf("\nThe sum of the extended prices for items purchased by this customer is $%,.2f",totExtPrice);
            
            System.out.printf("\nThis qualifies them for a discount of $%,.2f",discount);
            System.out.printf(" resulting in a pre-tax charge of $%,.2f", disPrice);
               
            System.out.printf("\nTax on this amount is $%,.2f",tax);
            System.out.printf(" resulting in a final charge of $%,.2f",finalPrice);
            System.out.print("\n");
        }
    void summary() 
        { 
            System.out.println("\n*Summary Report for " + date + "*");
                
            System.out.printf("\nThe total pre-discount extended price charges for this report was $%,.2f",sumExtPrice);
            
            System.out.printf("\nAfter discounts of $%,.2f",sumDiscount);
            System.out.printf(" and the addition of tax, the resulting final charge for all customers was $%,.2f",totFinalPrice);
                
            System.out.print("\nCustomer " + maxCustomer);
            System.out.printf(" received the largest discount of $%,.2f",maxDiscount);
        }
}   // this is the closing brace for appMain
