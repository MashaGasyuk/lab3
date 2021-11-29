package classes.trip;

import java.util.Comparator;

public class TripDateTimeComparator implements Comparator<Trip> {
    @Override
    public int compare(Trip o1, Trip o2) {
        return o1.getStartTime().compareTo(o2.getStartTime());
    }
}
