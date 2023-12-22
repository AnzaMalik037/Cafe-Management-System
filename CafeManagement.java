package cafemanagement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class CafeManagement {
    public static void main(String[] args) {
         
     Scanner sc=new Scanner(System.in);
     Date Current =new Date();
     new image();
     
     //counting number of orders perday
     int n=80;  //n=number of items in the cafe
     int []in_stock={1000,1000,1000,1000,1000,1000,1000,1000,1000};
     int []daily_orders={0,0,0,0,0,0,0,0};
     int price[]={100,120,100,70,50,80,100,120};
     int []quantity=new int [n];
     String []Foods={"Drinks","Lunch","Coffee","Sandwich","Fries","Tea","Burger","Juice"};
   
//=============Start==============================================
     while(true) {
         
         int order_num=(int)(Math.random()*100);           
        line();    System.out.print(" \t\t\t_\tCafe Management System\t_\n");
         line();    System.out.println(); 
         
//===============Getting inputs====================================
        
        System.out.println("Enter the quantity of each item you would like to purchase.\n");
        System.out.print("\t\t|\tOrder No. : "+order_num+"\t|\n");line();
        
        for (int i=0; i<n; i++) {
            System.out.print("\t\t|\t"+Foods[i]+"     \t       |    \t");
            quantity[i]=sc.nextInt();
            daily_orders[i]+=quantity[i];
            out_of_stock(in_stock[i],quantity[i]);
        }
        line();System.out.println("\n");
        
        
//============================Receipt Generation==============================
        
        int payment,total=0;
        delay();    //introducing intentional delay
        
        System.out.print("\t\t|\tOrder No. : "+order_num+"\t|\n");
        line();
        System.out.println("\t\t|\tFood:\t\tQuantity\tPrice\t\t|");
        
        for (int i=0;i<n;i++) {
            if (quantity[i]!=0) {
                payment=price[i]*quantity[i];
                System.out.println("\t\t|\t"+Foods[i]+":\t\t"+quantity[i]+"\t\t"+payment+"\t\t|");
                total=total+payment;
            }       
        }
        line();
        
        //===Discount===
        int sum=0,paid=0;
        for (int i=0; i<n; i++) {
            sum+=quantity[i];
        }
        System.out.println("\t\t|\tTotal Price:\t"+total);
        if(sum>10) {
            System.out.println("*Number of Items purchased: "+sum+" *"); 
            System.out.println(" Discount: 30%");
            total=(int)(total*0.7);
            System.out.println("\t\t|\tNew Price:\t"+total);
        }

//==================Enter Payment=========================================        
        
        System.out.print("\t\t|\tEnter Payment:\t");
        do {
            System.out.print("Kindly Review the Price.");
            paid=sc.nextInt();
        }
        while(paid<total);
        System.out.println("\t\t|\tChange:\t"+(paid-total));
        line();line();
        
        
//==== closing time==============================================
        SimpleDateFormat time=new SimpleDateFormat("hh:mm");
        String T=time.format(Current);
        
         if ("01:11".equals(T)) {
             System.out.println("Closing time :) See you tomorrow");
             break;
         }
    }
     
     //orders of the day
     line();    System.out.println("Daily report:");    line();
     SimpleDateFormat date=new SimpleDateFormat("dd:MM:yyyy");
     
     System.out.println("Date: "+date.format(Current));
     System.out.println("Total Orders Today: ");
     orders_daily_report(daily_orders,Foods, n);
     line();line();line();
    }
  
    
    
    
    
    
    
    
    
    public static void line() {
        System.out.print("\t\t");
        for (int i=0;i<=60;i++) {
            System.out.print("_");
        }
        System.out.print("\n");
    }
    
     public static void delay() //for introducing delay
     {
        System.out.println("Generating Receipt...\nPlease wait....\n\n");
        try
        {
            Thread.sleep(2500); //2500 mili seconds=2.5 seconds
            System.out.println("Receipt:");
        }
        catch (InterruptedException e)
        {
            System.err.println(e.getMessage());
        }
     }
     
    public static void out_of_stock(int stock_left, int quant) {
        stock_left-=quant;
        if(stock_left==0) {
            System.out.print("Sorry Out of Stock");
            //Add exception handling here and make theprogram continue.. idk maybe..just see it
        }
    } 
    
    public static void orders_daily_report(int orders[], String Food[], int n) {
        System.out.print("Orders Daily Report");line();
        System.out.print("\t\t|\tItems\t       |\tSold\t|\tIn Stock\t|");
        for (int i=0; i<n; i++) {
            System.out.println("\t\t|\t"+Food[i]+"\t       |\t"+orders[i]+"\t|\t"+(1000-orders[i]));
        }
        line();   
    }
}