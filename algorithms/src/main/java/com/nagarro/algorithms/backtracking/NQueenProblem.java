package com.nagarro.algorithms.backtracking;

import java.util.Arrays;

public final class NQueenProblem {

    public static void main(final String[] args) {
        final int queens = 4;
        final Position[] positions = new Position[queens];
        getPositions(queens, 0, positions);
        System.out.println(Arrays.asList(positions));
    }

    private static boolean getPositions(final int n, final int row, final Position[] positions) {
        if (n == row) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            boolean foundSafe = true;
            for (int queen = 0; queen < row; queen++) {
                if (positions[queen].getColumn() == col
                        || positions[queen].getRow() - positions[queen].getColumn() == row - col
                        || positions[queen].getRow() + positions[queen].getColumn() == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[row] = new Position(row, col);
                if (getPositions(n, row + 1, positions)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Position {

    private int x;
    private int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getRow() {
        return x;
    }

    public void setRow(final int x) {
        this.x = x;
    }

    public int getColumn() {
        return y;
    }

    public void setColumn(final int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position [Row=" + x + ", Column=" + y + "]";
    }

}
