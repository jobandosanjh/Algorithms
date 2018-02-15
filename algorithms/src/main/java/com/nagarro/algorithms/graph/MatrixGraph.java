package com.nagarro.algorithms.graph;

import java.util.Arrays;

public final class MatrixGraph {

    private boolean matrix[][];
    private int verticesCount;

    public MatrixGraph(final int verticesCount) {
        this.verticesCount = verticesCount;
        this.matrix = new boolean[this.verticesCount][this.verticesCount];
    }

    public void addEdge(final int source, final int destination) {
        if (source >= 0 && source <= this.verticesCount && destination >= 0 && destination <= this.verticesCount) {
            matrix[source][destination] = true;
            matrix[destination][source] = true;
        }
    }

    public void removeEdge(final int source, final int destination) {
        if (source >= 0 && source <= this.verticesCount && destination >= 0 && destination <= this.verticesCount) {
            matrix[source][destination] = false;
            matrix[destination][source] = false;
        }
    }

    public boolean isEdge(final int source, final int destination) {
        if (source >= 0 && source <= this.verticesCount && destination >= 0 && destination <= this.verticesCount) {
            return matrix[source][destination];
        }
        return false;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(final boolean[][] matrix) {
        this.matrix = matrix;
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public void setVerticesCount(final int verticesCount) {
        this.verticesCount = verticesCount;
    }

    @Override
    public String toString() {
        return "MatrixGraph [matrix=" + Arrays.toString(this.matrix) + ", verticesCount=" + this.verticesCount + "]";
    }

}
