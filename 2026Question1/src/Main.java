import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String[] Names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] Sales = new int[3][3];

        Scanner in = new Scanner(System.in);

        for (int row = 0; row < 3; row ++)
            for (int clm = 0; clm < 3; clm ++) {
                System.out.print("Enter number of sales for month " + (clm +1) + " for " + Names[row] + " mattress: ");
                Sales[row][clm] = in.nextInt();

            }

        new PrintProduct().Print(new Product(Names, Sales));

    }
}