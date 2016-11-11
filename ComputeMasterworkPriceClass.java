//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
import java.io.*;
/*This algorithm is used to compute the maximum price for a 'Masterwork' the painting. First it calculate the price as if it was a masterpiece.
Then, it will multiply by .25 if it is from this century. Otherwise, it will multiply by the resul of the formula: (21 -c)/(22 -c) where c is 
the century*/
public class ComputeMasterworkPriceClass 
{
 public static double computeMaxPrice(Paintings painting, Vector<Paintings>database, Vector<Paintings> auctionDatabase)
 {
  double price=0.0;
  double p=0.0;
  double aux=0.0;
  int year=0,c=0;
  String y;

  p = ComputeMasterpiecePriceClass.computeMaxPrice(painting,database,auctionDatabase);  //Calculate the price as if it where a Masterpiece
  if(p!=0.0)
  {
    
  y = painting.getYearOfWork(); //Get the year in which the painting was painted

  if (y.indexOf('?') > 0) //In case it is uncertain(contains '?')
  {
    y=y.substring(0,4); //Get the substring without the ?
  }
   year = Integer.parseInt(y); //Parse the year of work an integer

  if (year > 1999) //If the painting was painted in the 21 century
  {
   price = (p * 0.25); //Multiply the price by .25
  }
  else  /*In case it is not from the 21 century, gets the century it was made and multiply by the result of the formula: (21 -c)/(22 -c) 
  where c is the century*/
  {
   c = (year/100) + 1;
   aux = ((21 - (float)c)/(22 - (float)c));
   price = p * aux;
  }
  }
  else price=0.0;
  return price;
 }
}