package ShellSort;

import java.util.Arrays;
import java.util.Random;

public class UnsortedArray
{
    private final double[][] array;
    private final int rows;
    private final int columns;

    public UnsortedArray(int enteredSizeRows, int enteredSizeColumns)
    {
        array = new double[enteredSizeRows][enteredSizeColumns];
        rows = enteredSizeRows;
        columns = enteredSizeColumns;

        Random random = new Random();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                array[i][j] = random.nextDouble(20) - 10;
            }
        }
        System.out.println("Your array:\n");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    double[][] GetUnsortedArray()
    {
        return array;
    }
    int GetRow()
    {
        return rows;
    }
    int GetCol()
    {
        return columns;
    }
}

