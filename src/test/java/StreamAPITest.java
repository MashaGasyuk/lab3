import classes.Schedule;
import classes.ScheduleStreamAPI;
import classes.Station;
import classes.route.Route;
import classes.route.RouteBuilder;
import classes.trip.Trip;
import classes.trip.TripBuilder;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class StreamAPITest {
    @Test
    public void test(){
        Station station1 = new Station("a");
        Station station2 = new Station("b");
        Station station3 = new Station("c");
        Station station4 = new Station("d");
        Station station5 = new Station("e");
        Station station6 = new Station("f");

        Route route = new RouteBuilder()
                .addCode("a123")
                .addStation(station1)
                .addStation(station2)
                .addStation(station3)
                .build();
        Route route1 = new RouteBuilder()
                .addCode("b123")
                .addStation(station1)
                .addStation(station4)
                .addStation(station5)
                .addStation(station6)
                .build();
        Route route2 = new RouteBuilder()
                .addCode("c123")
                .addStation(station2)
                .addStation(station1)
                .addStation(station3)
                .build();
        Trip trip = new TripBuilder()
                .addStartTime(LocalDateTime.of(2020,12,12,9,0,0))
                .addEndTime(LocalDateTime.of(2020,12,12,11,0,0))
                .addRoute(route)
                .build();
        Trip trip1 = new TripBuilder()
                .addStartTime(LocalDateTime.of(2020,12,12,10,0,0))
                .addEndTime(LocalDateTime.of(2020,12,12,11,30,0))
                .addRoute(route1)
                .build();
        Trip trip2 = new TripBuilder()
                .addStartTime(LocalDateTime.of(2020,12,12,15,0,0))
                .addEndTime(LocalDateTime.of(2020,12,12,16,0,0))
                .addRoute(route2)
                .build();
        ScheduleStreamAPI schedule = new ScheduleStreamAPI.Builder()
                .addTrip(trip)
                .addTrip(trip1)
                .addTrip(trip2)
                .build();

        System.out.println(schedule.allTripsInDay(schedule.getTrips(),LocalDateTime.now().toLocalDate()));
        schedule.sortByTime(schedule.getTrips());
        System.out.println(schedule.getTrips());
        System.out.println(schedule.haveTripStation(schedule.getTrips(),station1));

    }
}
