/**
 * Group 17 Final Project
 *
 * @author David Asuncion; Samantha Holderman; Jacob Sapaugh
 * @version 11/24/17
 */
import java.util.*;
public class City implements Comparable<City>
{
    // instance variables - replace the example below with your own
    private int cityCode, xCoordinate, yCoordinate, distance, key;
    private City parent;
    private boolean visited;
    City(int code, int x, int y)
    {
        this.cityCode = code;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.distance = 0;
        // this.key = Integer.MAX_VALUE; //positive infinity
        // this.parent = null;
        // this.visited = false; //false
    }

    public boolean getVisited(){
     return visited;
    }

    public void setVisited(boolean v){
        this.visited = v;
    }

    public int getKey(){
        return key;}

    public void setKey(int val){
        this.key = val;}

    public City getParent(){
        return parent;
    }

    public void setParent(City p){
        this.parent = p;
    }

    public int getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(int cityCode)
    {
        this.cityCode = cityCode;
    }

    public int getXCoordinate()
    {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate()
    {
        return yCoordinate;
    }

    public int getDistance()
    {
        return distance;
    }

    public void setDistance(int d)
    {
        this.distance = d;
    }

    public void setYCoordinate(int yCoordinate)
    {
        this.yCoordinate = yCoordinate;
    }

    public int distanceTo(City other)
    {
        double val = Math.sqrt((Math.pow(this.xCoordinate - other.getXCoordinate(), 2) + (Math.pow(this.yCoordinate - other.getYCoordinate(), 2))));
        return (int) Math.round(val);
    }

    // public int compareTo(City other)
    // {
    //     return this.distance - other.getDistance();
    // }
    public int compareTo(City other)
    {
        int x =this.xCoordinate - other.xCoordinate;
        int y =this.yCoordinate - other.yCoordinate;
        if(x < 0 && y < 0) return x;
        if(x > 0 && y > 0) return x;
        return 0;

    }

}
