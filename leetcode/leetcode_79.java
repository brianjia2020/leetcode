package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class leetcode_79 {
    @Test
    public void test(){
        char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(exist(board,word));
        System.out.println(board[1][0]==word.charAt(0));
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (foundPattern(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    public boolean foundPattern(char[][] board, int i,int j, String word, int index){

        if (i < 0 || i > board.length-1 || j<0 || j > board[0].length-1 || board[i][j] != word.charAt(index)) {
            return false;
        }

        if (index == word.length()-1) {
            return true;
        }

        char temp = board[i][j];
        board[i][j] = 0;
        boolean found = foundPattern(board, i+1, j, word, index+1)
                        || foundPattern(board, i-1, j, word, index+1)
                        || foundPattern(board,i,j+1,word,index+1)
                        || foundPattern(board,i,j-1,word,index+1);
        board[i][j] = temp;

        return found;
    }

}
