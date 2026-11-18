public class Product implements IProducts{
    private String[] Name;
    private int[][] Sales;

   public Product(String[] name, int[][] Sales) {
     this.Name = Name;
     this.Sales = Sales;
   }

   public String[] getName() {return Name;}
   public void setName(String[] name) {this.Name = name;}

    public int[][] getSales() {return Sales;}
    public void setSales(int[][] sales) {this.Sales = sales;}

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for(int row = 0; row < Sales.length; row ++) {
            for (int clm = 0; clm < Sales[row].length; clm ++){
                total += Sales[row][clm];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
       int total = 0;
       for (int row = 0; row < Sales.length; row ++) {
           total += Sales.length;
       }
       double average = Math.round((double)total / Sales.length);
       return average;
    }

    @Override
    public String GetMostPopularProduct() {
       int topProduct = -1;
       int best = 0;
       for (int row = 1; row < Sales.length; row ++) {
          int total = 0;
          for (int s : Sales[row]) {
              total += s;
          }
          if (total > best) {
              best = total;
              best = row;
          }
       }
       return Name[best] + "("+ topProduct +")";

    }
}

