package company_questions.amazon.VO;

public class WordSearch {
    public boolean exist(char[][] board, String word){
        //edge cases:
        if(board==null||board.length==0||word==null||word.length()==0) return false;
        //solution:
        //depth first search
        //for loop to loop over every row by every col of the board
        //we initiate the search at very position and if found we return true
        //search in four directions
        //after the loop, return false
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        board[i][j] = ' ';
        boolean res =  dfs(board,word,index+1,i,j-1)||dfs(board,word,index+1,i,j+1)||dfs(board,word,index+1,i-1,j)||dfs(board,word,index+1,i+1,j);
        board[i][j] = word.charAt(index);
        return res;
    }
}
