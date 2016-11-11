//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;
public class SalesReport 
{
 /*
 *Desc: Method prints all the paintings sold after 'input'
 *  Method uses a vector 'salesReport' to all paintings from sales Database
 *  the paintings sold succseeding input are stored in vector'report'
 *  the report vector is broken up into classification vectors
 *  the 3 classification vectors are sorted by date 
 *  the sorted three classification vectors are merged in the 'sold' vector
 *  the sold vetor is output keeping track of Acctual selling price and Target selling price
 *output: Prompts for a date, this date has to be stord in 'input'
 *  based on input the following is generated and printed 
 *   Classification:   
 *   Sale date:   
 *   Artist Name:    
 *   Painting title:   
 *   Target selling price:   
 *   Actual selling price:   
 *  output dose not exeed 20 lines
 *  at the end of each report the average ratio is output(The ratio depends on input  
 *input: After prompt 'input' gets a value which has to be strictly in the format 'mm/dd/yyyy'
 */
 public static void printReport()throws Exception 
 {
  int count=0;      
  double totalActualSellingPrice=0;   
  double totalTargetSellingPrice=0; 
  Scanner keyboard =new Scanner (System.in);
  System.out.println("\t\t\tSales Report");
  System.out.println("_____________________________________________________________________");  
  System.out.println("Enter date for report 'mm/dd/yyyy'");
  String input=keyboard.nextLine();
  while(!input.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
  {  
   System.out.println("Input format error\n\tTry 'mm/dd/yyyy'");
   input=keyboard.nextLine();
  }
  Date currDate=makeDate(input);
  Vector<Paintings> salesReport = Osbert.salesDatabase;
  Vector<Paintings> report=  new Vector<Paintings>();
  Iterator iter= salesReport.iterator();
  while(iter.hasNext())
  { 
   Paintings curr = (Paintings)iter.next();
   Date sellingDate = makeDate(curr.getDateOfSale());
   int dateDiff=diff(sellingDate,currDate);
   if(dateDiff>0&& dateDiff<366)
   {
    report.add(curr); 
   } 
  }
  Vector<Paintings> masterwork = new Vector<Paintings>();
  Vector<Paintings> masterpice= new Vector<Paintings>();
  Vector<Paintings> other= new Vector<Paintings>();
  Vector<Paintings> sold =new Vector<Paintings>();
  for(int i=0;i<report.size();i++)
  {
   if( report.get(i).getClassification().equalsIgnoreCase("masterwork"))
    masterwork.add(report.get(i));
   else if ( report.get(i).getClassification().equalsIgnoreCase("masterpice"))
    masterpice.add(report.get(i));
   else if ( report.get(i).getClassification().equalsIgnoreCase("Other"))
    other.add(report.get(i));
    else
    System.out.print("Throw Error");   
  } 
  sortByDate(masterwork, sold);
  sortByDate(masterpice, sold);
  sortByDate(other, sold); 
  Iterator soldIter= sold.iterator();
  while(soldIter.hasNext())
  { 
   Paintings out= (Paintings)soldIter.next();
   totalActualSellingPrice+= out.getActualPurchasePrice();
     totalTargetSellingPrice += out.getTargetSellingPrice();
   if(2 == count)
   {
    System.out.println("Press anything to view the next screen...");
    keyboard.nextLine();
    count=0;
   }
   System.out.println("\tClassification:"+out.getClassification());
   System.out.println("\tSale date:"+out.getDateOfSale());
   System.out.println("\tArtist Name: "+out.getLastName());
   System.out.println("\tPainting title:"+out.getTitle());
   System.out.println("\tTarget selling price:"+out.getTargetSellingPrice());
   System.out.println("\tActual selling price:"+out.getActualSellingPrice());
   if((out.getTargetSellingPrice())>(out.getActualSellingPrice()*1.05))
   {
    System.out.println("\t*Sold 5% or more below target");
   } 
   if((out.getTargetSellingPrice())<(out.getActualSellingPrice()*1.05))
   {
    System.out.println("\t*Sold 5% or more Above target");
   }
   System.out.println();
   count++;
  }
    System.out.println("\n\nAverage ratio: " + (totalActualSellingPrice /totalTargetSellingPrice));
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
