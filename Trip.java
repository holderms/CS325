import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trip 
{
    private List<City> trip = new ArrayList<>();
    private int distance = 0;

    @SuppressWarnings("unchecked")
    public Trip(ArrayList<City> trip)
    {
        this.trip = (List<City>) trip.clone();
    }

    public int calcDistance()
    {
        int tourDistance = 0;
        // Loop through our trip's cities
        for (int cityIndex = 0; cityIndex < tripSize(); cityIndex++) 
        {
            // Get city we're traveling from
            City fromCity = getCity(cityIndex);
            // City we're traveling to
            City destinationCity;
            // Check we're not on the trip's last city 
            // if so, set trip's final city to our starting city
            if(cityIndex + 1 < tripSize())
            {
                destinationCity = getCity(cityIndex+1);
            }
            else
            {
                destinationCity = getCity(0);
            }
            // Get the distance between the two cities
            tourDistance += fromCity.distanceTo(destinationCity);
        }
        distance = tourDistance;
        return distance;
    }

    public int getDistance()
    { return distance;}

    
    City getCity(int index) 
    {
        return (City) trip.get(index);
    }

    public int tripSize()
    {
        return trip.size();
    }

    public List<City> getTrip() 
    {
        return trip;
    }
    
    public void setCity(int cityIndex, City city) 
    {
        trip.set(cityIndex, city);
        distance = 0;
    }
	
    public void setTrip(List<City> trip) 
    {
        this.trip = trip;
    }
}