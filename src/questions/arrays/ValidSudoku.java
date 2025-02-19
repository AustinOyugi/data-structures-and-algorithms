package questions.arrays;

import java.util.*;

/*
   @author Austin Oyugi
   @since 08/08/2024
   @mail austinoyugi@gmail.com
*/
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] sudoko1 = new char[][]{
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] sudoko2 = new char[][]{
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku validSudoku = new ValidSudoku();

        // Expect true
        System.out.println("Is Valid:  " + validSudoku.isValidSudoku(sudoko1));

        //Expect false
        System.out.println("Is Valid:  " + validSudoku.isValidSudoku(sudoko2));
    }

    public boolean isValidSudoku(char[][] board) {

        /*

            1. Check if each row contains 1 - 9  without duplicates
            2.Check if each contains 1-9 without duplicates

            Iterate through the rows
               Store the row values in a sub array

         */

        //Stores the rows
        // This will act as the first step of validation
        Map<Integer, List<Character>> rows = new HashMap<>();

        // Store all the columns
        Map<Integer, List<Character>> columns = new HashMap<>();


        // Store all 3 * 3 sub boxes
        Map<String, List<Character>> squareSubBoxes = new HashMap<>();
        // To reduce complexity, we already know the grouping of the square boxes
        // To be truthful, I don't know the formula for this, but either way... there's never one solution
        // We can have a better solution @see ValidSudoku2
        squareSubBoxes.put("0,1,2:0,1,2", new ArrayList<>());
        squareSubBoxes.put("0,1,2:3,4,5", new ArrayList<>());
        squareSubBoxes.put("0,1,2:6,7,8", new ArrayList<>());
        squareSubBoxes.put("3,4,5:0,1,2", new ArrayList<>());
        squareSubBoxes.put("3,4,5:3,4,5", new ArrayList<>());
        squareSubBoxes.put("3,4,5:6,7,8", new ArrayList<>());
        squareSubBoxes.put("6,7,8:0,1,2", new ArrayList<>());
        squareSubBoxes.put("6,7,8:3,4,5", new ArrayList<>());
        squareSubBoxes.put("6,7,8:6,7,8", new ArrayList<>());

        // Prints rows
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char value = board[i][j];


                // The first step is to confirm that there is no duplicate in the rows
                List<Character> rowList = rows.getOrDefault(i, new ArrayList<>());
                // We do not need to proceed if the row storage fails
                if (value != '.' && rowList.contains(value)) return false;
                else {
                    rowList.add(value);
                    rows.put(i, rowList);
                }


                // The second step is to confirm that the columns have no duplicates
                /*e.g
                        Column1 :  1[0,0],  4[1,0] ,  .[2,0]
                 */
                List<Character> columnList = columns.getOrDefault(j, new ArrayList<>());
                if (value != '.' && columnList.contains(value)) return false;
                else {
                    columnList.add(value);
                    columns.put(j, columnList);
                }


                // The third step is to confirm that the 3*3 sub boxes have not duplicates
                /*e.g

                      1[0,0],  2[0,1],  .[0,2]
                      4[1,0]   .[1,1],  .[1.2]
                      .[2,0]   9[2,1],  8[2,2]

                      .[3,3], 6[3,4], .[3,5]
                      8[4,3], .[4,4], 3[4,5]
                      .[5,3], 2[5,4],  .[5,5]


                      All the squares indexes for all rows
                      j=0,1,2 :  3,4,5, : 6,7,8

                      All the square indexed for all rows and columns

                      i:j= 0,1,2:0,1,2    |    0,1,2:3,4,5    |  0,1,2:6,7,8
                            3,4,5:0,1,2   |    3,4,5:3,4,5   |  3,4,5:6,7,8
                            6,7,8:0,1,2   |   6,7,8:3,4,5   |   6,7,8:6,7,8
                 */

                int finalI = i;
                int finalJ = j;

                Optional<String> subBoxKey = squareSubBoxes.keySet().stream()
                        .filter(key -> {
                            /*
                                At this point we split the row and column keys
                                if the key is 0,1,2:3,4,5  we get 0,1,2 and  3,4,5
                             */
                            String[] keyParts = key.split(":");

                            String rowKeys = keyParts[0];
                            String columnKeys = keyParts[1];

                            // We know there will never be an overlap
                            return rowKeys.contains(String.valueOf(finalI)) &&
                                    columnKeys.contains(String.valueOf(finalJ));
                        }).findFirst();

                if (subBoxKey.isPresent()) {
                    List<Character> squareBoxList = squareSubBoxes.get(subBoxKey.get());

                    if (value != '.' && squareBoxList.contains(value)) return false;
                    else {
                        squareBoxList.add(value);
                        squareSubBoxes.put(subBoxKey.get(), squareBoxList);
                    }
                }
            }
        }

        return true;
    }
}
