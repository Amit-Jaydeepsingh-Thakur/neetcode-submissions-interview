class Solution {
    public boolean exist(char[][] board, String word) {
        int i = 0, j = 0;

        for (i = 0; i < board.length; i++) {
            for (j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = solve(i, j, 0, word, board);

                    if (ans) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean solve(int i, int j, int idx, String word, char[][] board) {
        
        if (idx >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 
            || i >= board.length || j >= board[0].length
            || board[i][j] != word.charAt(idx) || board[i][j] == '*') {
            return false;
        }

        char org = board[i][j];
        
        board[i][j] = '*';
        
        boolean ans = solve(i + 1, j, idx + 1, word, board)
                        || solve(i - 1, j, idx + 1, word, board)
                        || solve(i, j + 1, idx + 1, word, board)
                        || solve(i, j - 1, idx + 1, word, board);
        
        board[i][j] = org;

        return ans;

    }
}
