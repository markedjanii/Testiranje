package org.example.testdome;

import java.util.*;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        if (!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false; // starting or destination position is not on a road
        }

        int numRows = mapMatrix.length;
        int numCols = mapMatrix[0].length;

        // create a queue of positions to explore
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{fromRow, fromColumn});

        // create a set to keep track of visited positions
        Set<String> visited = new HashSet<>();
        visited.add(fromRow + "," + fromColumn);

        // breadth-first search
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == toRow && col == toColumn) {
                return true; // destination found
            }

            // explore neighbors
            if (row > 0 && mapMatrix[row-1][col] && !visited.contains((row-1) + "," + col)) {
                queue.add(new int[]{row-1, col});
                visited.add((row-1) + "," + col);
            }
            if (row < numRows-1 && mapMatrix[row+1][col] && !visited.contains((row+1) + "," + col)) {
                queue.add(new int[]{row+1, col});
                visited.add((row+1) + "," + col);
            }
            if (col > 0 && mapMatrix[row][col-1] && !visited.contains(row + "," + (col-1))) {
                queue.add(new int[]{row, col-1});
                visited.add(row + "," + (col-1));
            }
            if (col < numCols-1 && mapMatrix[row][col+1] && !visited.contains(row + "," + (col+1))) {
                queue.add(new int[]{row, col+1});
                visited.add(row + "," + (col+1));
            }
        }

        return false; // destination not found
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
            {true,  false, false},
            {true,  true,  false},
            {false, true,  true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}