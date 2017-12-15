package edu.dlsu.mobapde.mobapdetugmenot;

import android.graphics.Bitmap;

public class Rope {

    private int x;
    private int y;
    private Bitmap rop;
    private int pace;

    public Rope(int x, int y, Bitmap rop, int pace) {
        this.x = x;
        this.y = y;
        this.rop = rop;
        this.pace = pace;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveDown(){
        this.y+=this.pace;
    }

    public Bitmap getBitmap() {
        return rop;
    }

    public void setBitmap(Bitmap rop) {
        this.rop = rop;
    }
}

