package classes.trip;

import classes.route.Route;

import java.time.LocalDateTime;
import java.util.Calendar;

public class TripBuilder {
    private Trip trip;

    public TripBuilder() {
        trip = new Trip();
    }

    public TripBuilder addRoute(Route route){
        assert (route!=null);
        trip.setRoute(route);

        return this;
    }
    public TripBuilder addStartTime(LocalDateTime start){
        assert (start!=null);
        trip.setStart(start);

        return this;
    }
    public TripBuilder addEndTime(LocalDateTime end){
        assert (end!=null);
        trip.setEnd(end);

        return this;
    }
    public Trip build(){
        assert (trip.getRoute()!=null);
        assert (trip.getStartTime()!=null);
        assert (trip.getEndTime()!=null);
        assert (trip.getStartTime().isBefore(trip.getEndTime()));

        return trip;
    }
}
