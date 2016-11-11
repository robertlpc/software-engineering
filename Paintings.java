//raluces13@ole.augie.edu
//Roberto,Michael,Igor
//Painting.java
class Paintings
{
  private String firstName;
  private String lastName;
  private String title;
  private String yearOfWork;
  private String medium;
  private String subject;
  private double height;
  private double width;
  private String classification; 
  private String dateOfPurchase; 
  private String nameOfSeller; 
  private String addressOfSeller; 
  private double maxPurchasePrice; 
  private double actualPurchasePrice; 
  private double targetSellingPrice; 
  private String dateOfSale; 
  private String nameOfBuyer; 
  private String addressOfBuyer; 
  private double actualSellingPrice;
  private double fashionability;
  private String auctionDate;
  private double auctionPrice;
  //Desc: Constructor of painting class, initiliazes all Paintings' data fields
  public Paintings()
  {
   firstName="";
   lastName="";
   title="";
   yearOfWork="";
   medium="";
   subject="";
   height=0.0;
   classification="";
   dateOfPurchase="";
   nameOfSeller="";
   addressOfSeller="";
   actualPurchasePrice=0.0;
   maxPurchasePrice=0.0;
   targetSellingPrice=0.0;
   dateOfSale="";
   nameOfBuyer="";
   addressOfBuyer="";
   actualSellingPrice=0.0;
   fashionability=0.0;
   auctionDate="";
   auctionPrice=0.0;
  }
  //Desc: set the fashionability of class Painting to the value passed 
  public void setFashionability(double fashionability)
  {
    this.fashionability=fashionability;
  }
  //Return: Return fashionability of class Painting
  public double getFashionability()
  {
    return this.fashionability;
   }
  //Desc: set the maxPurchasePrice of class Painting to the value passed 
  public void setMaxPurchasePrice(double price)
  {
    maxPurchasePrice=price;
  }
  //Return: Return maxPurchasePrice of class Painting
  public double getMaxPurchasePrice()
  {
    return maxPurchasePrice;
  }
  //Return: Return height of class Painting
  public double getHeight() 
  {
    return height;
  }
  //Desc: set the height of class Painting to the value passed 
  public void setHeight(double height)
  {
    this.height=height;
  }
  //Desc: set the width of class Painting to the value passed 
  public void setWidth(double width)
  {
    this.width=width;
  }
  //Return: Return width of class Painting
  public double getWidth()
  {
    return width;
  }
  //Return: Return medium of class Painting
  public String getMedium() 
  {
    return medium;
  }
  //Desc: set the medium of class Painting to the value passed 
  public void setMedium(String medium)
  {
    this.medium=medium;
  }
  //Return: Return subject of class Painting
  public String getSubject() 
  {
    return subject;
  }
  //Desc: set the subject of class Painting to the value passed 
  public void setSubject(String subject)
  {
    this.subject=subject;
  }
  //Return: Return firstName of class Painting
  public String getFirstName() 
  {
    return firstName;
  } 
  //Desc: set the first name of class Painting to the value passed 
  public void setFirstName(String name)
  {
    this.firstName=name;
  }
  //Return: Return lastName of class Painting
   public String getLastName() 
  {
     return lastName;
  }
  //Desc: set the last name of class Painting to the value passed 
  public void setLastName(String name)
  {
    this.lastName=name;
  }
  //Return: Return title of class Painting
  public String getTitle() 
  {
     return this.title;
  }
  //Desc: set the title of class Painting to the value passed 
  public void setTitle(String title)
  {
    this.title=title;
  }
  //Return: Return yearOfWork of class Painting
  public String getYearOfWork() 
  {
     return yearOfWork;
  }
  //Desc: set the yearOfWork of class Painting to the value passed 
  public void setYearOfWork(String year)
  {
    this.yearOfWork=year;
  }
  //Return: Return classification of class Painting
  public String getClassification() 
  {
    return classification;
  }
  //Desc: set the classification of class Painting to the value passed 
  public void setClassification(String classification)
  {
    this.classification=classification;
  }
  //Return: Return dateOfPurchase of class Painting
  public String getDateOfPurchase()
  {
    return this.dateOfPurchase;
  }
  //Desc: set the dateOfPurchase of class Painting to the value passed 
  public void setDateOfPurchase(String date)
  {
    this.dateOfPurchase=date;
  }
  //Return: Return nameOfSeller of class Painting
  public String getNameOfSeller()
  {
    return nameOfSeller;
  }
  //Desc: set the nameOfSeller of class Painting to the value passed 
  public void setNameOfSeller(String name)
  {
    this.nameOfSeller=name;
  }
  //Return: Return actualPurchasePrice of class Painting
  public double getActualPurchasePrice()
  {
    return actualPurchasePrice;
  }
  //Desc: set the actualPurchasePrice of class Painting to the value passed 
  public void setActualPurchasePrice(double price)
  {
    actualPurchasePrice=price;
  }
  //Desc: compute the targetingSellingPrice of class Painting 
  public void findTargetSellingPrice()
  {
    targetSellingPrice=actualPurchasePrice*2.15;
  }
  //Return: Return targetSellingPrice of class Painting
  public double getTargetSellingPrice()
  {
    return targetSellingPrice;
  }
  //Desc: set the targetSellingPrice of class Painting to the value passed 
  public void setTargetSellingPrice(double price)
  {
    targetSellingPrice=price;
  }
  //Return: Return dateOfSale of class Painting
  public String getDateOfSale() 
  {
    return dateOfSale;
  }
  //Desc: set the dateOfSale of class Painting to the value passed 
  public void setDateOfSale(String date)
  {
    this.dateOfSale=date;
  }
  //Return: Return nameOfBuyer of class Painting
  public String getNameOfBuyer() 
  {
    return nameOfBuyer;
  }
  //Desc: set the nameOfBuyer of class Painting to the value passed 
  public void setNameOfBuyer(String name)
  {
    this.nameOfBuyer=name;
  }
  //Return: Return addressOfBuyer of class Painting
  public String getAddressOfBuyer()
  {
    return addressOfBuyer;
  }
  //Desc: set the addressOfBuyer of class Painting to the value passed 
  public void setAddressOfBuyer(String address)
  { 
    addressOfBuyer=address;
  }
  //Return: Return addressOfSeller of class Painting
  public String getAddressOfSeller()
  {
    return addressOfSeller;
  }
  //Desc: set the addressOfSeller of class Painting to the value passed 
  public void setAddressOfSeller(String address)
  {
    addressOfSeller=address;
  }
  //Return: Return actualSellingPrice of class Painting
  public double getActualSellingPrice()
  {
    return actualSellingPrice;
  }
  //Desc: set the actualSellingPrice of class Painting to the value passed 
  public void setActualSellingPrice(double price)
  {
    actualSellingPrice=price;
  }
  //Return: Return actionDate of class Painting
  public String getAuctionDate()
  {
   return this.auctionDate;
  }
  //Desc: set the auctionDate of class Painting to the value passed 
  public void setAuctionDate(String a)
  {
   this.auctionDate = a;
  }
  //Return: Return auctionPrice of class Painting
  public double getAuctionPrice()
  {
   return this.auctionPrice;
  }
  //Desc: set the auctionPrice of class Painting to the value passed 
  public void setAuctionPrice(double a)
  {
   this.auctionPrice = a;
  }
}