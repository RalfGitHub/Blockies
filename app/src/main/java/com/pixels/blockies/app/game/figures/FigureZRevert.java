package com.pixels.blockies.app.game.figures;

public class FigureZRevert extends AbstractFigure {

    private int[][][] figures = new int[][][]{
            {
                    {-1, 6},
                    {6, 6},
                    {6, -1}
            },
            {
                    {6, 6, -1},
                    {-1, 6, 6}
            }
    };

    @Override
    protected int getFigureCount() {
        return figures.length;
    }

    @Override
    public int[][] get() {
        return figures[getCurrentRotation()];
    }

    @Override
    public int[][] getNext() {
        return figures[getNextRotation()];
    }
}
