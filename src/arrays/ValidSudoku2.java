package arrays;

import java.util.*;

/*
   @author Austin Oyugi
   @since 08/08/2024
   @mail austinoyugi@gmail.com
*/
public class ValidSudoku2 {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();  // key = (r / 3) * 3 + c / 3

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char cell = board[r][c];
                if (cell == '.') {
                    continue;
                }
                if (rows.getOrDefault(r, new HashSet<>()).contains(cell)
                        || cols.getOrDefault(c, new HashSet<>()).contains(cell)
                        || squares.getOrDefault((r / 3) * 3 + c / 3, new HashSet<>()).contains(cell)) {
                    return false;
                }
                cols.computeIfAbsent(c, k -> new HashSet<>()).add(cell);
                rows.computeIfAbsent(r, k -> new HashSet<>()).add(cell);
                squares.computeIfAbsent((r / 3) * 3 + c / 3, k -> new HashSet<>()).add(cell);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] sudoko1 =  new char[][]{
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] sudoko2 =  new char[][]{
                {'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','1','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        ValidSudoku2 validSudoku = new ValidSudoku2();

        // Expect true
        System.out.println("Is Valid:  " +  validSudoku.isValidSudoku(sudoko1));

        //Expect false
        System.out.println("Is Valid:  " +  validSudoku.isValidSudoku(sudoko2));
    }
}
