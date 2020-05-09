package com.example.gamefirst;

public class PlayField {
    int fieldSizeX;
    int fieldSizeY;
    int[][] field;

    public  PlayField(int fieldSizeX, int fieldSizeY) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        field = new int[fieldSizeX][fieldSizeY];
    }


}
