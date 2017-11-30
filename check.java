
/**
 * Write a description of class check here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.*;
public class check
{
    public static void main(String args[])
    {
        List<City> cityList = new ArrayList<>();
        int totalD = 0;
        try(Scanner scanner = new Scanner(new File("tsp_example_1.txt")))
        {
            while(scanner.hasNext())
            {
                cityList.add(new City(scanner.nextInt(),scanner.nextInt(), scanner.nextInt()));
            }
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        try(Scanner scanner2 = new Scanner(new File("solution.txt")))
        {
            while(scanner2.hasNext())
            {
                City city1 = cityList.get(scanner2.nextInt());
                if(scanner2.hasNext()){
                    City city2 = cityList.get(scanner2.nextInt());
                    totalD += city1.distanceTo(city2);
                } else {
                    totalD += city1.distanceTo(cityList.get(0));
                }
            } 
            System.out.println(totalD);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
