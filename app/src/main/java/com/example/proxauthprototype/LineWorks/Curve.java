package com.example.proxauthprototype.LineWorks;

import java.util.ArrayList;
import java.util.List;

public class Curve {
    private List<Point> points;

    public Curve(){
        points = new ArrayList<>();
    }

    public Curve(List<Point> points){
        this.points = points;
    }

    public final int length(){
        return points.size();
    }

    public final Point max(){
        int n = length();
        Point max = points.get(0);

        for(int i=1; i<n;i++){
            Point temp = points.get(i);
            if(max.getY()<temp.getY()){
                max = temp;
            }
        }

        return max;
    }

    public final Point min(){
        int n = length();
        Point min = points.get(0);

        for(int i=1; i<n;i++){
            Point temp = points.get(i);
            if(min.getY()>temp.getY()){
                min = temp;
            }
        }

        return min;
    }

    private int find(double x, int start, int end){
        Point startPoint = points.get(start);
        Point endPoint = points.get(end);

        if(startPoint.getX() == x) return start;
        else if(endPoint.getX() == x) return end-1;

        if(x> startPoint.getX() && x < endPoint.getX()){
           if((end-start) == 1 || end-start == 0) return start;
           else {
               int n = start + (end-start)/2;
              if( find(x,start,n) < 0){
                  return find(x,n,end);
              }
           }
        }
        return -1;
    }

    public final double gradient(double x){

        if(points.size() <=1 ) {
            return Double.NEGATIVE_INFINITY;
        }
        int index = find(x,0,points.size()-1);
        if(index == -1){
            return Double.POSITIVE_INFINITY;
        }

        double y1 = points.get(index).getY();
        double y2 = points.get(index+1).getY();
        double x1 = points.get(index).getX();
        double x2 = points.get(index+1).getX();

        return (y2-y1)/(x2-x1);
    }

    public final double intercept(double x){

        double m = gradient(x);
        if(m == Double.NEGATIVE_INFINITY) return m;

        int index = find(x,0,points.size()-1);
        if(index < 0) return Double.NEGATIVE_INFINITY;

        Point point = points.get(index);

        return point.getY()+x*point.getX();
    }

    public final double find(double x){
        if(points.size()>=1){
            int index = find(x,0,points.size()-1);
            if(points.size() == 1 && points.get(0).getX() == x){
                return points.get(0).getY();
            }else if(points.size() > 1){
                double m = gradient(x);
                double c = intercept(x);
                return m*x +c;
            }
        }

        return Double.NEGATIVE_INFINITY;
    }

    public final double mean(){
        double mean = 0;
        for(Point point: points){
            mean += point.getY();
        }

        return mean/points.size();
    }

    public Curve smooth(){
        if(points.size()<6) return new Curve(points);

        List<Point> smoothedPoints = new ArrayList<>();

        Point newPoint = points.get(1);

        for(int i = 2; i<points.size()-2;i++){

        }
    }

}
