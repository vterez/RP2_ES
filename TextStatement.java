import java.util.Enumeration;

public class TextStatement extends Statement {

  public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = getHeader(aCustomer.getName());
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         //show figures for this rental
         result += addRental(each);
      }
      //add footer lines
      return result + formatFooter(aCustomer.getTotalCharge(),aCustomer.getTotalFrequentRenterPoints());
   }
   private String getHeader(String name)
   {
     return "Rental Record for " + name +
      "\n";
   }

   private String addRental(Rental each)
   {
     return "\t" + each.getMovie().getTitle()+ "\t" +
         String.valueOf(each.getCharge()) + "\n";
   }

   private String formatFooter(double charge, double points)
   {
     return "Amount owed is " +
      String.valueOf(charge) + "\n" + 
      "You earned " +
      String.valueOf(points) +
      " frequent renter points";
   }
  
}