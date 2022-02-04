import java.util.Enumeration;

public class TextStatement extends Statement {
   protected String getHeader(String name)
   {
     return "Rental Record for " + name +
      "\n";
   }

   protected String addRental(Rental each)
   {
     return "\t" + each.getMovie().getTitle()+ "\t" +
         String.valueOf(each.getCharge()) + "\n";
   }

   protected String formatFooter(double charge, double points)
   {
     return "Amount owed is " +
      String.valueOf(charge) + "\n" + 
      "You earned " +
      String.valueOf(points) +
      " frequent renter points";
   }
  
}