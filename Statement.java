import java.util.Enumeration;

public abstract class Statement {
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
   protected abstract String getHeader(String name);
   protected abstract String addRental(Rental each);
   protected abstract String formatFooter(double charge, double points);
}