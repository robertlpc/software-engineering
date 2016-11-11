//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
import java.io.*;
/*This algorithm is used to compute the maximum price for a 'Masterpiece' the painting. It finds the most similar painting in an auction
database and from there it gets the auction price for that painting and compound the price(add 8.5% of the painting auction price) every year
since that auction*/
public class ComputeMasterpiecePriceClass
{
 public static double computeMaxPrice(Paintings painting, Vector<Paintings>database, Vector<Paintings>auctionDatabase)
 { 
  Date date = new Date(); 
  Calendar calendar = new GregorianCalendar();
  calendar.setTime(date);
  int thisyear = calendar.get(Calendar.YEAR);

  Paintings current;
  String y;
  int s,index,year;
  double similarity,area,aux,higher,price,base;

  aux = 0.0;
  higher = 0.0;
  price = 0.0;
  index=0;

  for (int i = 0; i<auctionDatabase.size();i++) //Loop that will go through all instances
  {
   s = 0;
   current = auctionDatabase.get(i); //Get the current painting
   //Check if they are the same artists
   if (current.getLastName().equalsIgnoreCase(painting.getLastName()) && current.getFirstName().equalsIgnoreCase(painting.getFirstName())) 
   { //Analyze the medium and subject of the painting to find the similarity scores

    if (current.getMedium().equalsIgnoreCase(painting.getMedium())) //Score 1 for match on medium
    {
     s++;
    }
    if (current.getSubject().equalsIgnoreCase(painting.getSubject())) //Score 1 for match on subject
    {
     s++;
    }

    area = current.getHeight() * current.getWidth(); //Get the area of the current painting
    aux = painting.getHeight() * painting.getWidth(); //Get the area of the painting that the user wants to buy

    if (aux > area) //Check which one is smaller and procedes with the algorithm
    /*The algorithm is: multiply the painting with the highest area by the similarity scores and divide by the smallest area. The result is the
    coefficient of similarity*/
    {
     similarity = s*area;
     similarity = similarity/aux; 
    }
    else
    {
     similarity = s*aux;
     similarity = similarity/area;
    }

    if (similarity > higher) //Save the highest similarity and the index for the painting with that similarity
    {
     higher = similarity;
     index = i;
    }
   } 
  }
  if (higher != 0) //If the highest similarity it is not zero
  {
   current = auctionDatabase.get(index); //Get the painting with the higher similarity

   base = current.getAuctionPrice(); //Put an error if it is 0 email Brian - how does the auction price come to be

   price = base; //Base price of the painting

   y = current.getYearOfWork(); //Get the year of work

   if (y.indexOf('?') > 0) //If the year is uncertain( contains '?')
   {
     y=y.substring(0,4);  //Get the substring without the ? 
   }
    year = Integer.parseInt(y); //Parse the year of work to int

   int dif = (thisyear - year) ; //Calculates the difference of years 
   System.out.println("Dif:"+dif);

   for (int i = 0; i < dif ; i++) //For every year, compound the price
   {
    price = price * 1.085; /*Base price + 8.5%*/ 
   }
  }
  else price=0.0;
  return price;
 }
}