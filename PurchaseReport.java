//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
import java.text.SimpleDateFormat;

import java.io.*;
class PurchaseReport 
{
 /*
 *Desc: Method prints all the paintings purchased after 'input'
 *  Method uses an iterator to get all paintings from sales Database
 *  the paintings purchased succseeding input are stored in vector'report'
 *  the report vector is broken up into classification vectors
 *  the 3 classification vectors are sorted by date 
 *  the sorted three classification vectors are merged in the 'out' vector
 *  the sold vetor is output keeping track of Acctual purchase price and Suggested purchase price selling price
 *output: Prompts for a date, this date has to be stord in 'input'
 *  based on input the following is generated and printed 
 *  Classification: 
 *  Date of purchase: 
 *  Artist Name: 
 *  Painting title:
 *  Suggested purchase price:
 *  Actual purchase price:  
 *  output dose not exeed 20 lines
 *  at the end of each report the average ratio is output(ratio accuracy depends on database)  
 *input: After prompt 'input' gets a value which has to be strictly in the format 'mm/dd/yyyy'
 */
 public static void printReport()throws Exception 
 {
  int count=0;
  double totalActualPurchasePrice=0; 
  double totalMaxPurchasePrice=0;
  Scanner keyboard =new Scanner (System.in);
  System.out.println("\t\t\tPurchase Reports");
  System.out.println("_____________________________________________________________________");
  System.out.println("Enter A year 'mm/dd/yyyy'");
  String input=keyboard.nextLine();
  while(!input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
  { 
    System.out.println("Input format error\n\tTry 'mm/dd/yyyy'");
    input=keyboard.nextLine();
  }
  Date currDate=makeDate(input);
  Vector<Paintings> report = new Vector<Paintings>();
  Iterator dataBaseIter= Osbert.galleryDatabase.iterator();
  while(dataBaseIter.hasNext())
  { 
   Paintings curr = (Paintings)dataBaseIter.next();
   Date purchaseDate = makeDate(curr.getDateOfPurchase()); 
   int dateDiff=diff(purchaseDate,currDate);
   
   if(dateDiff>0&& dateDiff<366)
   {
    { 
     report.add(curr);
    } 
   } 
  }
  Vector<Paintings> masterwork = new Vector<Paintings>();
  Vector<Paintings> masterpice= new Vector<Paintings>();
  Vector<Paintings> other= new Vector<Paintings>();
  Vector<Paintings> purchased =new Vector<Paintings>();
    
  for(int i=0;i<report.size();i++)
  {
   if( report.get(i).getClassification().equalsIgnoreCase("masterwork"))
   { 
    masterwork.add(report.get(i));
   } 
   else if ( report.get(i).getClassification().equalsIgnoreCase("masterpice"))
    masterpice.add(report.get(i));
   else if ( report.get(i).getClassification().equalsIgnoreCase("Other"))
    other.add(report.get(i));
    else
    System.out.print("Throw Error");   
  } 
  sortByDate(masterwork,purchased);
  sortByDate(masterpice,purchased);
  sortByDate(other,purchased);
  Iterator purchasedIter= purchased.iterator();
 /*
 * are question markes '?' printed if they ocuur in data base or just in general?
 */
  while(purchasedIter.hasNext())
  { 
   Paintings out= (Paintings)purchasedIter.next();
   totalActualPurchasePrice+= out.getActualPurchasePrice();
     totalMaxPurchasePrice += out.getMaxPurchasePrice();
   if(3 == count)
   {
    System.out.println("Press anything to view the next screen...");
    input=keyboard.nextLine();
    count=0;
   }
   if(out.getMaxPurchasePrice()<out.getActualSellingPrice())
    System.out.println("\tClassification:  * "+out.getClassification());
   else
    System.out.println("\tClassification: "+out.getClassification());
   System.out.println("\tDate of purchase: "+out.getDateOfPurchase());
   System.out.println("\tArtist Name: "+out.getLastName());
   System.out.println("\tPainting title ? :"+out.getTitle());
   System.out.println("\tSuggested purchase price:"+out.getMaxPurchasePrice());
   System.out.println("\tActual purchase price:"+out.getActualPurchasePrice());
   System.out.println();
   count++;
  } 
  if (totalMaxPurchasePrice  > 0)
     System.out.println("\n\nAverage ratio: " + (totalActualPurchasePrice /totalMaxPurchasePrice));
  else
     System.out.println("There have been no paintings bought within the past year or you have been over buying ."); 
 }
 public static void  sortByDate(Vector<Paintings> source,Vector<Paintings> destination)throws Exception
 { 
  for(int i=0;i<source.size();i++)
  {
   Date date1 = makeDate(source.get(i).getDateOfPurchase());
    Paintings greatest = source.get(i);
   for(int j=0; j< source.size();j++)
   { 
    Date date2 = makeDate(source.get(j).getDateOfPurchase());
    if(date1.compareTo(date2)<0)
    {
     greatest=source.get(j);
    }
   } 
   destination.add(greatest);
  }
 }
 //desc picks up a string in the format "MM/dd/yyyy" and returns a date
   //return: date object based on dateString
   //pre: dateString has to strictly be in (MM/dd/yyyy) format
   //throws: a shit tun of exceptions!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11################catch later 
   public static Date makeDate(String dateString) throws Exception 
   {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    return formatter.parse(dateString);
   }
 //Desc: finds the difference of two date objects 
 //return: int which is the number of days or interval of the 2 date objects
 //pre: date1,date2 must be valid Date types
 public static int diff(Date date1, Date date2) 
 {
     Calendar c1 = Calendar.getInstance();
     Calendar c2 = Calendar.getInstance();
 
     c1.setTime(date1);
     c2.setTime(date2);
     int diffDay = 0;
 
     if (c1.before(c2))
  {
      //will not use case here generic method 
   // unless user passed date1 that is before date2
   diffDay = countDayFrom(c1, c2);
     } 
  else 
  {
        diffDay = countDayFrom(c2, c1);
     }
     return diffDay;
   }
 //Desc: gives the number of days that between c1 and c2 by counting from c1 to c2+1
 //return:  an integer that is generated by countin from c1 to c2 
 public static int countDayFrom(Calendar c1, Calendar c2) 
 {
     int returnInt = 0;
   
    while (!c1.after(c2))
  {
        c1.add(Calendar.DAY_OF_MONTH, 1);
        returnInt++;
     }
  //the loop counts one more than need 
     if (returnInt > 0) 
  {
        returnInt = returnInt - 1;
     }
     return returnInt;
   }  
} 
 
