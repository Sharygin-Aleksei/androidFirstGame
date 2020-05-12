package com.example.gamefirst;

public class PlayField {
    int fieldSizeX;
    int fieldSizeY;
    int[][] field;

    public  PlayField(int fieldSizeX, int fieldSizeY) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        field = new int[fieldSizeX][fieldSizeY];

        for(int i = 0; i < (fieldSizeX * fieldSizeY) / 3; i++){
            int randomX = (int) (Math.random() * fieldSizeX);
            int randomY = (int) (Math.random() * fieldSizeY);

            if(field[randomX][randomY] == 0){
                field[randomX][randomY] = 2;
            }else {
                i--;
            }
        }
    }

    public void dig(int i, int j){
        if(i >= 0 && i < fieldSizeX && j >= 0 && j < fieldSizeY){
            field[i][j] = 1;
        }
    }


}
