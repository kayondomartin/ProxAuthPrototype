package com.example.proxauthprototype.LineWorks;

public class Point {
    private double x;
    private double y;

    public Point(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public void setX(final double x){
        this.x = x;
    }

    public void setY(final double y){
        this.y = y;
    }

    public final double getX(){
        return x;
    }

    public final double getY(){
        return y;
    }

}
