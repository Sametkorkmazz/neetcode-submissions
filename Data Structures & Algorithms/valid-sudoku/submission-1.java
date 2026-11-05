class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> rows =
            Stream.generate(HashSet<Character>::new).limit(board.length).toList();
        List<HashSet<Character>> columns =
            Stream.generate(HashSet<Character>::new).limit(board.length).toList();
        List<HashSet<Character>> squares =
            Stream.generate(HashSet<Character>::new).limit(board.length).toList();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char number = board[i][j];
                if (number != '.') {
                    HashSet<Character> column = columns.get(j);
                    HashSet<Character> row = rows.get(i);
                    HashSet<Character> square = squares.get((i / 3) * 3 + (j / 3));
                    if (column.contains(number)) {
                        return false;
                    }
                    column.add(number);
                    if (row.contains(number)) {
                        return false;
                    }
                    row.add(number);
                    if (square.contains(number)) {
                        return false;
                    }
                    square.add(number);
                }
            }
        }

        return true;
    }
}
