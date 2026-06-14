class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int[] ans = new int[1];

        solve(0, board, ans);

        return ans[0];
    }

    private void solve(int r, char[][] board, int[] ans) {
        if (r == board.length) {
            ans[0]++;
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (isValid(r, c, board)) {
                board[r][c] = 'Q';
                solve(r + 1, board, ans);
                board[r][c] = '.';
            }
        }
    }

    private boolean isValid(int i, int j, char[][] board) {
        
        for (int r = i - 1; r >= 0; r--) {
            if (board[r][j] == 'Q') {
                return false;
            }
        }

        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        for (int r = i - 1, c = j + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}