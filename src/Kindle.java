public class Kindle {
   private int currentPage, numberOfPages;

   public Kindle(int numberOfPages) {
      this.numberOfPages = numberOfPages;
      currentPage = 1;
   }

   public String toString() {
      return "Pages " + currentPage + " of " + numberOfPages;
   }

   public void turnPages() {
      turnPages(1);
   }
   public void turnPages(int pages) {
      if (currentPage + pages > numberOfPages) {
         System.out.print("You were on                : ");
         System.out.println(this);
         System.out.println("Turning " + pages + " pages would take you past the last page.");
         currentPage = numberOfPages;
         System.out.print("You are now on             : ");
         System.out.print(this);
      } else {
         currentPage+=numberOfPages;
      }
   }
}