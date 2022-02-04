import java.util.Enumeration;

public class HtmlStatement extends Statement {
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
     return "<H1>Rentals for <EM>" + name +
      "</EM></H1><P>\n";
   }

   private String addRental(Rental each)
   {
     return each.getMovie().getTitle()+ ": " +
         String.valueOf(each.getCharge()) + "<BR>\n";
   }

   private String formatFooter(double charge, double points)
   {
     return "<P>You owe <EM>" +
      String.valueOf(charge) + "</EM><P>\n"+
      "On this rental you earned <EM>" + 
      String.valueOf(points) +
      "</EM> frequent renter points<P>";
   }
}