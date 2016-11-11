//raluces13@ole.augie.edu
//Roberto,Michael,Igor
import java.util.*;
/*This algorithm is used to compute the maximum price for an 'Other' the painting. It looks through a database that contains the fashionability
coefficient and procede to calculate the maximum price. It does that by multiplying the fashionability for the given artist and the area of 
his/her painting*/
public class ComputeOtherPaintingPriceClass 
{
 public static double computeMaxPrice(Paintings painting, Vector<Paintings>database,Vector<Paintings>fashionDatabase)
 {
  double fashionability=0.0;
  for(int i=0;i<fashionDatabase.size();i++) //Looks through the database
  {
    Paintings paint=fashionDatabase.get(i); //Gets a painting from database 
    if( paint.getFirstName().equalsIgnoreCase(painting.getFirstName())  && paint.getLastName().equalsIgnoreCase(painting.getLastName()))
      fashionability=paint.getFashionability(); //Cheks for a match in artists. If there is a match, then get the fashionability
  }
  double area = painting.getHeight() * painting.getWidth(); //Calculate the area of the painting
  return (fashionability*area); //Find the maximum price for the painting
 }
}