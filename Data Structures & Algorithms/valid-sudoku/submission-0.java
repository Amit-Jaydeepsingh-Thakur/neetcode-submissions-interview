class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = 0, c = 0;

        // rows
        for (r = 0; r < 9; r++) {
            Set<Character> set = new HashSet<>();
            for (c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                if (!set.contains(board[r][c])) {
                    set.add(board[r][c]);
                } else {
                    return false;
                }
            }
        }


        // cols
        for (c = 0; c < 9; c++) {
            Set<Character> set = new HashSet<>();
            for (r = 0; r < 9; r++) {
                if (board[r][c] == '.') continue;
                if (!set.contains(board[r][c])) {
                    set.add(board[r][c]);
                } else {
                    return false;
                }
            }
        }

        // squares

        for (int squares = 0; squares < 9; squares++) {
            Set<Character> set = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (squares / 3) * 3 + i;
                    int col = (squares % 3) * 3 + j;

                    if (board[row][col] == '.') continue;
                    if (!set.contains(board[row][col])) {
                        set.add(board[row][col]);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
