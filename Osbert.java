//raluces13@ole.augie.edu
//Roberto,Michael,Igor
//Osbert.java
import java.util.*;
import java.io.*;
public class Osbert
{
  public static Vector<Paintings> salesDatabase=new Vector<Paintings>();
  public static Vector<Paintings> galleryDatabase=new Vector<Paintings>();
  public static Vector<Paintings> auctionDatabase=new Vector<Paintings>();
  public static Vector<Paintings> fashionDatabase=new Vector<Paintings>();
  protected static Scanner f=new Scanner(System.in);
  //Desc: Program that allows user to buy and sell paintings, print reports, and update databases
  public static void main(String[]args) throws Exception
  {
    readDatabase();
    DisplayMenus.mainMenu();  
    outputDatabases();
  }
  //Desc: Method that reads through all vectors in Osbert and prints them out to a specific file
  public static void outputDatabases() throws Exception
  {
      writer("SalesDatabase",salesDatabase);
      writer("GalleryDatabase",galleryDatabase);
      writer("AuctionDatabase",auctionDatabase);
      writer("FashionDatabase",fashionDatabase); 
      System.out.println("Databases have been succesfully updated");
  }
  //Desc: Method that reads through all known databases and puts every instance into a specific vector
  public static void readDatabase() throws Exception
  {
    salesDatabase=reader("SalesDatabase");
    galleryDatabase=reader("GalleryDatabase");
    auctionDatabase=reader("AuctionDatabase");
    fashionDatabase=reader("FashionDatabase");
  }
  //Desc:   Method that finds the target selling price of a painting.
  //Output: Target selling price of a Painting and whether a painting has already been sold or is non existent.
  public static void sellPainting()
  {
    int success=0;
    System.out.println("Input the first name of artist");
    String firstName=f.nextLine();
    System.out.println("Input the last name of artist");
    String lastName=f.nextLine();
    System.out.println("Please enter the title of painting you wish to sell");
    String title=f.nextLine();
    for(int i=0;i<galleryDatabase.size();i++)
    {
      Paintings paint=galleryDatabase.get(i);
      if(paint.getTitle().equalsIgnoreCase(title) && paint.getFirstName().equalsIgnoreCase(firstName)  && paint.getLastName().equalsIgnoreCase(lastName))
      {
        success=1;
        System.out.println("Painting exists in database");
        System.out.println("Painting Target Selling Price: $"+paint.getTargetSellingPrice());
        System.out.println("Do you wish to sell? (y/n)");
        char sell=f.nextLine().charAt(0);
        if(sell=='y'||sell=='Y')
        {
          System.out.println("Input the name of buyer (First and Last name)");
          paint.setNameOfBuyer(f.nextLine());
          System.out.println("Input the address of buyer");
          paint.setAddressOfBuyer(f.nextLine());
          System.out.println("Input the actual selling price");
          paint.setActualSellingPrice(f.nextDouble());
          salesDatabase.add(paint);
          galleryDatabase.remove(paint);
          break;
        }
      }
    }
    if(success==0)
    {
      int sold=0;
       for(int i=0;i<salesDatabase.size();i++)
       {
         Paintings paint=salesDatabase.get(i);
         if(paint.getTitle().equalsIgnoreCase(title) && paint.getFirstName().equalsIgnoreCase(firstName)  && paint.getLastName().equalsIgnoreCase(lastName))
         {
           sold=1;
           System.out.println("Painting has already been sold");
         }
       }
       if(sold==0) System.out.println("There is no record of painter as entered by the dealer");
    }
  }
  /* Description: buyPainting is a method to buy a painting. 
   * It receives an option for which type of painting the user wants to buy and procede to calculate
   * the maximum price the user should pay for that painting. After that, it will as the user if he wants to buy a painting and how much he actually
   * wants to pay for it. After that, the target selling is calculated and the date of purchase is asked. */
 public static void buyPainting(int option,Vector<Paintings> database, Vector<Paintings>otherDatabase) throws Exception
 {
   double price;
   char choice;
   Paintings painting = new Paintings();
   switch(option) //Check the type of painting he wants to buy
   {
     case 1:  //If it is Masterwork
       painting.setClassification("Masterwork");  //Set it's classification
       initializePainting(painting, f);
       price = ComputeMasterpiecePriceClass.computeMaxPrice(painting,database,otherDatabase); //Calculate the price
       if(price==0)
       {
         System.out.println("Price is $0.0, no offer will be made");
         break;
       }
       System.out.println("The Max price for the painting is : ");
       System.out.printf("%.2f\n",price);
       System.out.println("Do you want to buy it? (y/n)");
       choice = f.nextLine().charAt(0);//ask for actual price and set it
       if (choice == 'Y' || choice=='y')
       {
        painting.setMaxPurchasePrice(price);
        System.out.println("Enter the price you want to pay");
        price = f.nextDouble();
        f.nextLine();
        painting.setActualPurchasePrice(price);             
        painting.findTargetSellingPrice();        //calculate and set the target selling price
        System.out.println("Enter the date of Purchase (Ex, mm/dd/yyyy)");
        String year = f.nextLine();
        painting.setDateOfPurchase(year);
        galleryDatabase.add(painting);
       }
       else
        System.out.println("Returning...");
       break;
     case 2:  //If it is Masterpiece
       painting.setClassification("Masterpiece"); //Set it's classification
       initializePainting(painting, f);
       price = ComputeMasterworkPriceClass.computeMaxPrice(painting,database,otherDatabase);   //Calculate the price
       if(price==0)
       {
         System.out.println("Price is $0.0, no offer will be made");
         break;
       }
       System.out.println("The Max price for the painting is : ");
       System.out.printf("%.2f\n",price);
       System.out.println("Do you want to buy it? (y/n)");
       choice = f.nextLine().charAt(0);//ask for actual price and set it
       if (choice == 'Y' || choice =='y') 
       {
        painting.setMaxPurchasePrice(price);
        System.out.println("Enter the price you want to pay");
        price = f.nextDouble();
        f.nextLine();
        painting.setActualPurchasePrice(price);               
        painting.findTargetSellingPrice();      //calculate and set the target selling price
        System.out.println("Enter the date of Purchase (Ex, mm/dd/yyyy");
        String year = f.nextLine();
        painting.setDateOfPurchase(year);
        galleryDatabase.add(painting);
       }
       else
        System.out.println("Returning...");
       break;
     case 3:  //If it is Other
       painting.setClassification("OtherPainting");
       initializePainting(painting, f);
       price = ComputeOtherPaintingPriceClass.computeMaxPrice(painting,database,otherDatabase);  //Calculate the price
       if(price==0)
       {
         System.out.println("Price is $0.0, no offer will be made");
         break;
       }
       System.out.println("The Max price for the painting is : ");
       System.out.printf("%.2f\n",price);
       System.out.println("Do you want to buy it? (y/n)");
       choice = f.nextLine().charAt(0);//ask for actual price and set it
       if (choice == 'Y' || choice =='y') 
       {
        painting.setMaxPurchasePrice(price);  //Set it's classification
        System.out.println("Enter the price you want to pay");
        price = f.nextDouble();
        f.nextLine();
        painting.setActualPurchasePrice(price);               
        painting.findTargetSellingPrice();      //calculate and set the target selling price
        System.out.println("Enter the date of Purchase (Ex, mm/dd/yyyy");
        String year = f.nextLine();
        painting.setDateOfPurchase(year);
        galleryDatabase.add(painting);
       }
       else
        System.out.println("Returning...");
       break;
   }
  }
 //Desc:   Method that allows user to update the fashionability number of a painter, or add it to a database.
 //Input:  User prompted to enter First name, Last name, and Fashionability to be updated for the specified painter
 //Outpit: Whether the update is succesfull or not
 public static void updateFashionability()
 {
   int success=0;
   int fashionability=0;
   System.out.println("Input the first name of artist");
   String firstName=f.nextLine();
   System.out.println("Input the last name of artist");
   String lastName=f.nextLine();
   System.out.println("Input the fashionability (0-10000)"); 
   fashionability=f.nextInt();
   while(fashionability>10000)
   {
     System.out.println("Fashionability number must be between 0 and 10000 please re-enter");
     fashionability=f.nextInt();
   }
   f.nextLine();
   for(int i=0;i<fashionDatabase.size();i++)
   {
     Paintings paint=fashionDatabase.get(i);
     if(paint.getFirstName().equalsIgnoreCase(firstName)  && paint.getLastName().equalsIgnoreCase(lastName))
     {
       paint.setFashionability(fashionability);
       success=1;
       System.out.println("Fashionability Updated");
     }
   }
   if(success==0)
   {
     Paintings newPainting=new Paintings();
     newPainting.setFirstName(firstName);
     newPainting.setLastName(lastName);
     newPainting.setFashionability(fashionability);
     fashionDatabase.add(newPainting);
     System.out.println("Fashionability Updated");
   }
 }
 //Desc: Generic Method used to prompt and recieve responds from user for various tasks.
  public static void initializePainting(Paintings painting, Scanner input)
  {
      System.out.println("Input the first name of artist");
      painting.setFirstName(f.nextLine());
      System.out.println("Input the last name of artist");
      painting.setLastName(f.nextLine());
      System.out.println("Input the title of work");
      painting.setTitle(f.nextLine());
      System.out.println("Input the year work (Ex yyyy, yyyy?)");
      String year=input.nextLine();
      while(year.startsWith("?"))
      {
        System.out.println("Please enter year of work as yyyy or yyyy?");
        year=input.nextLine();
      }
      painting.setYearOfWork(year);
      System.out.println("Input the height (ex.50)");
      double height=input.nextDouble();
      while(height<=0)
      {
       System.out.println("Height cannot be 0 or negative, please re-enter");
       height=input.nextDouble();
       f.nextLine();
      }
      painting.setHeight(height);
      System.out.println("Input the width (ex.20)");
      double width=input.nextDouble();
      while(width<=0)
      {
       System.out.println("Width cannot be 0 or negative, please re-enter");
       width=input.nextDouble();
      }
      painting.setWidth(width);
      f.nextLine();
      System.out.println("Input the medium (oil, watercolor, other)"); 
      painting.setMedium(f.nextLine());
      System.out.println("Input the subject (portrait, still-life, landscape, other)"); 
      painting.setSubject(f.nextLine());
  }
  //Desc:  Method that updates users Auction Database
  //Input: User enters relevant information in order to update an auction record. 
  public static void updateAuctionDatabase() 
  {
    Paintings auction=new Paintings();
    initializePainting(auction,f);
    System.out.println("Input the auction Date(Ex. 2010)");
    auction.setAuctionDate(f.nextLine());
    System.out.println("Input the auction Price(Ex. 1200.4)");
    auction.setAuctionPrice(f.nextDouble());
    f.nextLine();
    int sucess=0;
    for(int i=0;i<auctionDatabase.size();i++)
    {
      Paintings paint=auctionDatabase.get(i);
      String firstName= auction.getFirstName();
      String lastName= auction.getLastName();
      String title= auction.getTitle();
      if(paint.getFirstName().equalsIgnoreCase(firstName)  && paint.getLastName().equalsIgnoreCase(lastName) && paint.getTitle().equalsIgnoreCase(title))
      {
        sucess=1;
        auctionDatabase.remove(i);
        auctionDatabase.add(auction);
      }
    }
    if(sucess==0)
    auctionDatabase.add(auction);
  }
  //Desc:   Method that reads in data from a file and inputs it into a specified vector
  //Return: A vector with all the information found in the file passed
  public static Vector<Paintings> reader(String fileName)throws Exception
 {
   File f=new File(fileName+".txt");
   if(!f.exists())
    f.createNewFile();
  Scanner inFile = new Scanner(f);
  Vector<Paintings> v =new Vector<Paintings>();
  while(inFile.hasNextLine())
  {  
    Paintings painting = new Paintings();
    painting.setFirstName(inFile.nextLine());
    painting.setLastName(inFile.nextLine());
    painting.setTitle(inFile.nextLine());
    painting.setYearOfWork(inFile.nextLine());
    painting.setMedium(inFile.nextLine());
    painting.setSubject(inFile.nextLine());
    painting.setHeight(Double.parseDouble(inFile.nextLine()));
    painting.setWidth(Double.parseDouble(inFile.nextLine()));
    painting.setClassification(inFile.nextLine()); 
    painting.setDateOfPurchase(inFile.nextLine()); 
    painting.setNameOfSeller(inFile.nextLine()); 
    painting.setAddressOfSeller(inFile.nextLine()); 
    painting.setMaxPurchasePrice(Double.parseDouble(inFile.nextLine()));
    painting.setActualPurchasePrice(Double.parseDouble(inFile.nextLine()));
    painting.setTargetSellingPrice(Double.parseDouble(inFile.nextLine()));
    painting.setDateOfSale(inFile.nextLine()); 
    painting.setNameOfBuyer(inFile.nextLine()); 
    painting.setAddressOfBuyer(inFile.nextLine()); 
    painting.setActualSellingPrice(Double.parseDouble(inFile.nextLine()));
    painting.setFashionability(Double.parseDouble(inFile.nextLine()));
    painting.setAuctionDate(inFile.nextLine());
    painting.setAuctionPrice(Double.parseDouble(inFile.nextLine()));
    v.add(painting);
   if(!inFile.nextLine().equals("***")) break;
  } 
  inFile.close();
  return v;
 } 
 //Desc: Method that outputs into a file everything contained in a specified vector
 public static void writer(String fileName, Vector<Paintings>database) throws Exception
 {
   File f=new File(fileName+".txt");
   if(f.exists()) f.delete();
   else f.createNewFile();
   PrintWriter file = new PrintWriter(f);
   for(int i=0;i<database.size();i++)
    {
     Paintings paint=database.get(i);
     file.println( paint.getFirstName());
     file.println( paint.getLastName());
     file.println( paint.getTitle());
     file.println( paint.getYearOfWork());
     file.println( paint.getMedium());
     file.println( paint.getSubject());
     file.println( paint.getHeight());
     file.println( paint.getWidth());
     file.println( paint.getClassification()); 
     file.println( paint.getDateOfPurchase()); 
     file.println( paint.getNameOfSeller()); 
     file.println( paint.getAddressOfSeller()); 
     file.println( paint.getMaxPurchasePrice()); 
     file.println( paint.getActualPurchasePrice()); 
     file.println( paint.getTargetSellingPrice()); 
     file.println( paint.getDateOfSale()); 
     file.println( paint.getNameOfBuyer()); 
     file.println( paint.getAddressOfBuyer()); 
     file.println( paint.getActualSellingPrice());
     file.println( paint.getFashionability());
     file.println( paint.getAuctionDate());
     file.println( paint.getAuctionPrice());
     file.println("***");
    }
  file.close();
 } 
}