public class MainApp {

    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {


        String[][] arrCorrect = new String[][]{{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        String[][] arrWrongSize = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}};

        String[][] arrWrongData = new String[][]{{"1", "1", "a", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        System.out.println(sumMatrix(arrCorrect));
        System.out.println(sumMatrix(arrWrongData));
        //System.out.println(sumMatrix(arrWrongSize));






    }





    public static void checkSquareMatrixIsOfSize4(String[][] array) throws MyArraySizeException {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }

        }
    }


    //    }
//    public int sumMatrix(String[][]array) throws MyArrayDataException {
//        int sum = 0;
//        for (String[] row : array) {
//            for (String element : row) {
//                try {
//                    sum += Integer.parseInt(element);
//                } catch (NumberFormatException e) {
//                    throw new MyArrayDataException(
//                            String.format("'%s' is not integer", element)
//                    ) ;
//                }
//            }
//        }
//        return sum;


    public static int sumMatrix(String[][] array) throws MyArrayDataException, MyArraySizeException {
        checkSquareMatrixIsOfSize4(array);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            String.format("'%s' at position (%d,%d) is not integer", array[i][j], i, j)
                    );
                }
            }
        }
        return sum;
    }


}
