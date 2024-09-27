import ShellSort.*;
import java.util.Scanner;

/*4. Задано матрицю дійсних чисел.
Впорядкувати (переставити) її стовпці за зростанням значень їх перших елементів.*/
public class Main
{
    public static void main(String[] args)
    {

        int sizeRow = 0, sizeColumn = 0;
        System.out.println("Enter size of row: ");
        Scanner scannerRow = new Scanner(System.in);
        sizeRow = scannerRow.nextInt();
        System.out.println("Enter size of column: ");
        Scanner scannerCol = new Scanner(System.in);
        sizeColumn = scannerCol.nextInt();

        UnsortedArray unsortedArray = new UnsortedArray(sizeRow, sizeColumn);
        SortedArray sortedArray = new SortedArray(unsortedArray);
        sortedArray.Sort(unsortedArray);
        sortedArray.IsSorted();
    }
}