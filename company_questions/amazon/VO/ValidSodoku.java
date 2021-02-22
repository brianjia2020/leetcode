package company_questions.amazon.VO;

import java.util.HashSet;
import java.util.Set;

public class ValidSodoku {
    public boolean isValidSodoku(char [][] board){
        //edge cases:
        if(board==null||board.length==0) return false;

        //solution:
        //O(n^2)
        //loop over each row then column(board[i][j]), each column then row(board[j][i]), each square
        //add to Set<String>, if it is in the set, then there is a duplicate, return false
        //return true if the whole loop completes
        Set<String> check = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                if(!check.add(board[i][j]+"row"+i)) return false;
                if(!check.add(board[j][i]+"col"+j)) return false;
                if(!check.add(board[i][j]+"sq"+i/3+""+j/3)) return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for(int i=0;i<board.length;i++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> square  = new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'&&!row.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!col.add(board[j][i])){
                    return false;
                }

                int newRow = i/3*3 + j/3;
                int newCol = i%3*3 + j%3;
                if(board[newRow][newCol]!='.'&&!square.add(board[newRow][newCol])){
                    return false;
                }
            }
        }
        return true;
    }
}
