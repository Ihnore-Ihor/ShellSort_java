package ShellSort;

public class SortedArray {

    private double[][] array;
    private final int rows;
    private final int columns;
    private int comparisonCount = 0;

    String underlineOn = "\u001B[4m";
    String underlineOff = "\u001B[0m";


    public SortedArray(UnsortedArray unsortedArray) {
        rows = unsortedArray.GetRow();
        columns = unsortedArray.GetCol();
        array = new double[rows][columns];
    }

    void PrintArray(double[][] victims) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0, vj = 0; j < columns; j++) {
                if (vj < victims[i].length && array[i][j] == victims[i][vj])
                {
                    System.out.print(underlineOn + array[i][j] + underlineOff + " ");
                    vj++;
                }
                else
                    System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void Sort(UnsortedArray unsortedArray) {
        array = unsortedArray.GetUnsortedArray();
        System.out.println("\nSorting array...\n");
        long startTime = System.nanoTime();

        for (int l = 0; l < columns; l++) { //TODO: continue changing algo. I dont understand what i did, you should rewrite this
            int d0 = columns / 2;
            int victimsCount = (columns - 1) / d0 + 1;
            System.out.println("="+victimsCount+"=");
            if (columns % 2 != 0 && l > 0)
            {
                victimsCount = victimsCount - 1;
            }
            double[][] victims = new double[rows][victimsCount];
            for (; d0 < l; d0 = d0 / 2) {
                System.out.println("Gap = " + d0);
                for (int k = 0, i = 0; k < victimsCount && i < columns; k++, i += d0) {
                    for (int j = 0; j < rows; j++) {
                        victims[j][k] = array[j][i];
                    }
                }

                PrintArray(victims);

                InsertionSort(victims);

                for (int k = 0, i = 0; k < victimsCount && i < columns; k++, i += d0) {
                    for (int j = 0; j < rows; j++) {
                        array[j][i] = victims[j][k];
                    }
                }
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("\nSorted Array:\n");

        PrintArray(new double[rows][columns]);
        System.out.println("\nSorting took " + duration + "ns\n" + "Total comparisons: " + comparisonCount + "\n");
    }

    public void InsertionSort(double[][] arr) {
        int size = arr[0].length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                comparisonCount++;
                if (arr[0][j] > arr[0][i]) {
                    InsertColumn(arr, i, j);
                }
            }
        }
    }

    public void InsertColumn(double[][] arr, int fromIndex, int toIndex) {
        if (toIndex == fromIndex) {
            return;
        }
        if (fromIndex > toIndex) {
            for (int i = 0; i < arr.length; i++) {
                double temp = arr[i][fromIndex];
                for (int j = fromIndex; j > toIndex; j--) {
                    arr[i][j] = arr[i][j - 1];
                }
                arr[i][toIndex] = temp;
            }
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                double temp = arr[i][fromIndex];
                for (int j = fromIndex; j < toIndex; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                arr[i][toIndex] = temp;
            }
        }
    }

    public void IsSorted()
    {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                if (array[i][0] > array[i][0]) {
                    System.out.println("Array is not sorted");
                    return;
                }
            }
        }
        System.out.println("Array is sorted");
    }
}
