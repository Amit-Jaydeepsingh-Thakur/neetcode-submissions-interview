class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, 0, board, ans);

        return ans;
    }

    private void solve(int i, int j, char[][] board, List<List<String>> res) {
        if (i == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] s : board) {
                list.add(new String(s));
            }

            res.add(list);
            return;
        }

        for (int c = 0; c < board.length; c++) {
            if (isValid(i, c, board)) {
                board[i][c] = 'Q';
                solve(i + 1, j, board, res);
                board[i][c] = '.';
            }
        }
        
    }

    private boolean isValid(int r, int c, char[][] board) {
        
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
