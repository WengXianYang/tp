package seedu.traveltrio.model.trip;

import java.util.ArrayList;

/**
 * A list that manages multiple trips.
 * Provides operations to add, remove, retrieve, and search for trips.
 */
public class TripList {

    private final ArrayList<Trip> trips;

    /**
     * Constructs an empty TripList.
     */
    public TripList() {
        trips = new ArrayList<>();
    }

    /**
     * Adds a trip to the list.
     *
     * @param t the trip to add
     */
    public void add(Trip t) {
        trips.add(t);
    }

    /**
     * Removes and returns the trip at the specified index.
     *
     * @param index the index of the trip to remove
     * @return the removed trip
     */
    public Trip remove(int index) {
        return trips.remove(index);
    }

    /**
     * Returns the trip at the specified index.
     *
     * @param index the index of the trip to retrieve
     * @return the trip at the specified index
     */
    public Trip get(int index) {
        return trips.get(index);
    }

    /**
     * Returns the number of trips in the list.
     *
     * @return the size of the trip list
     */
    public int size() {
        return trips.size();
    }

    /**
     * Checks if the trip list is empty.
     *
     * @return true if the list contains no trips, false otherwise
     */
    public boolean isEmpty() {
        return trips.isEmpty();
    }

    /**
     * Finds all trips whose names contain the specified keyword (case-insensitive).
     *
     * @param keyword the keyword to search for
     * @return a list of matching trips
     */
    public ArrayList<Trip> findTrips(String keyword) {
        ArrayList<Trip> matchingTrips = new ArrayList<>();
        for (Trip t : trips) {
            if (t.getName().toLowerCase().contains(keyword.toLowerCase())) {
                matchingTrips.add(t);
            }
        }
        return matchingTrips;
    }

    /**
     * Checks if the list contains the specified trip.
     *
     * @param trip the trip to check for
     * @return true if the trip is in the list, false otherwise
     */
    public boolean contains(Trip trip) {
        return trips.contains(trip);
    }

}

