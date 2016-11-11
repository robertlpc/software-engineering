//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
import java.io.*;
public class DisplayMenus
{
  private static Scanner f=new Scanner(System.in);
  //Desc: GUI which prompts user for certain responses
  public static void mainMenu() throws Exception
  {
    int choice=1;    
    do{      
       System.out.println("\n      Osberts Awesome Program Main Menu\n-----------------------------");
       System.out.println("1.Buy a Painting Menu.");        
       System.out.println("2.Sell a Painting");
       System.out.println("3.Print a Report Menu"); 
       System.out.println("4.Update Fashionability"); 
       System.out.println("5.Quit");          
       choice=f.nextInt();          
       f.nextLine();          
       switch(choice)          
       {           
        case 1:displayBuyPaintingMenu();break;            
        case 2:Osbert.sellPainting();break;           
        case 3:displayReportMenu();break; 
        case 4:Osbert.updateFashionability();break;
        default:break;         
       }     
    }while(choice!=5); 
  }
  //Desc: Method that displays all the buy paintings options available
  public static void displayBuyPaintingMenu() throws Exception
  {
    int choice=1;    
    do{      
       System.out.println("\n      Buy a Painting Main Menu\n-----------------------------");
       System.out.println("1.Buy a Painting.");        
       System.out.println("2.Update Auction Database");
       System.out.println("3.Quit");          
       choice=f.nextInt();          
       f.nextLine();          
       switch(choice)          
       {           
        case 1:buyPaintingsMenu();break;            
        case 2:Osbert.updateAuctionDatabase();break;           
        default:break;         
       }     
    }while(choice!=3);  
  }
  //Desc: Method that displays all the types of Painitings a user can purchase.
  public static void buyPaintingsMenu() throws Exception
  {
    int choice=1;    
    do{      
       System.out.println("\n      Buy a Paintings Main Menu\n-----------------------------");
       System.out.println("1.Buy Masterpiece.");        
       System.out.println("2.Buy Masterwork");
       System.out.println("3.Buy Other Painting");     
       System.out.println("4.Quit"); 
       choice=f.nextInt();          
       f.nextLine();          
       switch(choice)          
       {           
        case 1:Osbert.buyPainting(choice,Osbert.galleryDatabase,Osbert.auctionDatabase);break;            
        case 2:Osbert.buyPainting(choice,Osbert.galleryDatabase,Osbert.auctionDatabase);break;   
        case 3:Osbert.buyPainting(choice,Osbert.galleryDatabase,Osbert.fashionDatabase);break; 
        default:break;         
       }     
    }while(choice!=4);  
  }
  //Desc: Method that displays all the report options available to the user.
  public static void displayReportMenu() throws Exception
  {
    int choice=1;    
    do{      
       System.out.println("\n      Display a Report Main Menu\n-----------------------------");
       System.out.println("1.Future Trends Report.");        
       System.out.println("2.Sales Report");
       System.out.println("3.Purchase Reports");    
       System.out.println("4.Previous Menu"); 
       System.out.println("5.Quit");  
       choice=f.nextInt();          
       f.nextLine();          
       switch(choice)          
       {           
        case 1:FutureTrendsReport.printReport();break;            
        case 2:PurchaseReport.printReport();break;   
        case 3:SalesReport.printReport();break;   
        default:break;         
       }     
    }while(choice!=5);
  }
}