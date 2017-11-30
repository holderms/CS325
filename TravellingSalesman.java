import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TravellingSalesman
{
    private static int[][] cityMatrix;
    public static void main(String args[])
    {
        List<City> cityList = new ArrayList<>();

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

        // for(int i = 0; i < cityList.size(); i ++){
        // System.out.println(cityList.get(i).getCityCode());
        // }
        long temp = Long.MAX_VALUE;
        double fastRate = 0.000001;
        double slowRate = 0.0000001;

        // for(int i = 0; i < cityList.size(); i++){
        //     int d = cityList.get(i).distanceTo(cityList.get(0)); //distance to first city (random)
        //     cityList.get(i).setDistance(d);
        // }
        Collections.sort(cityList); //sort by xCoord to start
        Trip currentTrip = new Trip((ArrayList<City>) cityList);
        //currentTrip.generateTrip();
        System.out.println("Initial solution : " + currentTrip.calcDistance());
        System.out.println("Initial size : " + currentTrip.tripSize());

        Trip bestTrip = new Trip((ArrayList<City>) cityList);
        bestTrip = TSP(temp, fastRate, slowRate, currentTrip, bestTrip);

        System.out.println("Final solution distance : " + bestTrip.getDistance());
        System.out.println("End size : " + bestTrip.tripSize());
        for (City city : bestTrip.getTrip())
        {
            System.out.println(city.getCityCode());
        }
    }

    public static Trip TSP(long temp, double fastRate,double slowRate, Trip currentTrip, Trip bestTrip)
    {

        //Trip newTrip = new Trip((ArrayList<City>) currentTrip.getTrip()); // make a copy
        //Distances before loop are all equal
        int currentTripDistance, bestTripDistance = currentTrip.calcDistance();
        // int newTripDistance = newSolution.getDistance(cityMatrix);
        // int bestTripDistance = bestTrip.getDistance(cityMatrix);
        while (temp > 1)
        {
            //System.out.print("Enter while; ");
            //swap random city positions
            swapCities(currentTrip);

            // Get energy of solutions
            currentTripDistance = currentTrip.calcDistance();
            // Decide if we should accept the neighbor
            if (currentTripDistance < bestTripDistance)
            {
                bestTrip = new Trip((ArrayList<City>) currentTrip.getTrip());
                //System.out.println("Test in best if: " + bestTrip.getDistance());
                bestTripDistance = bestTrip.getDistance();
                temp *= (1-fastRate);
                //temp = Long.MAX_VALUE;
            }
            // Cool system
            else{ temp *= (1-slowRate);}
            //System.out.println("interim: " + currentTripDistance + "  best: " + bestTripDistance);
        }
        return bestTrip;
    }

    public static void swapCities(Trip newSolution)
    {
        int tripPos1 = ThreadLocalRandom.current().nextInt(0, newSolution.tripSize());// (int) (newSolution.tripSize() * Math.random());
        int tripPos2 = ThreadLocalRandom.current().nextInt(0, newSolution.tripSize());
        if (tripPos1 == tripPos2){
            tripPos2 = ThreadLocalRandom.current().nextInt(0, newSolution.tripSize());
        }
        // Get the cities at selected positions in the tour
        City citySwap1 = newSolution.getCity(tripPos1);
        City citySwap2 = newSolution.getCity(tripPos2);

        //System.out.printf("City matrix %d x %d = %d\n",citySwap1.getCityCode(), citySwap2.getCityCode(),cityMatrix[citySwap1.getCityCode()][citySwap2.getCityCode()]);
        // Swap them
        newSolution.setCity(tripPos2, citySwap1);
        newSolution.setCity(tripPos1, citySwap2);
    }
}
