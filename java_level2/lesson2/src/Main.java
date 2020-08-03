import exceptions.MyArrayDataException;
import exceptions.MyArraySizeException;

public class Main {

    private static final int ROWS_NUMBER = 4;
    private static final int COLUMNS_NUMBER = 4;

    private static int[][] intArray = new int[4][4];

    public static void main(String[] args) {

        String[][] stringArray1 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        String[][] stringArray2 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "1asd", "3", "4"},
                {"1", "2", "3", "4"},
        };
        String[][] stringArray3 = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
        };

        try {
            transformStringArrayToInt1(stringArray1);
            printArray(intArray);
            transformStringArrayToInt1(stringArray3);
            printArray(intArray);
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void transformStringArrayToInt1(String[][] stringArray)
            throws MyArrayDataException, MyArraySizeException {

        if (stringArray.length != ROWS_NUMBER) {
            throw new MyArraySizeException("There is an error with rows number!");
        }
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != COLUMNS_NUMBER) {
                throw new MyArraySizeException("There is an error with columns number in " + i + " row!");
            }

            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(stringArray[i][j]);
                } catch (Exception ex) {
                    throw new MyArrayDataException("There is not a number in cell " + i + " : " + j + "!");
                }
            }
        }
    }


    private static void printArray(int[][] array) {
        for (int[] anArray : array) {
            for (int anAnArray : anArray) {
                System.out.print(anAnArray + " ");
            }
            System.out.println();
        }
    }

}
