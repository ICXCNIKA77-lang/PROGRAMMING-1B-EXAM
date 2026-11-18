public class PrintProduct {


     public void Print(IProducts p) {
         System.out.println("PRODUCT SALES REPORT - 2026");
         System.out.println("*****************************************************");
         System.out.println("TOTAL PRODUCT SALES: " + p.GetTotalProductsSold());
         System.out.println("AVERAGE PRODUCT SALES: " + p.GetAverageProductSold());
         System.out.println("MOST POPULAR PRODUCT: " + p.GetMostPopularProduct());
     }
}
