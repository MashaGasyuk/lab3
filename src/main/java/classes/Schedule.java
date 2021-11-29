package classes;

import classes.trip.Trip;
import classes.trip.TripDateTimeComparator;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Клас маршрутів руху. Клас зберігає в собі маршрути. Видає інформацію про них
 */
public class Schedule implements Serializable {
    private List<Trip> trips;

    protected Schedule() {
        trips = new ArrayList<>();
    }

    /**
     * Повертає всі подорожі, де є вказана станція
     * @param name
     * @return
     */
    public List<Trip> haveTripStation(Station name){
        var res = new ArrayList<Trip>();
        for(var t: trips){
            if(t.getRoute().getStationsR().contains(name)){
                res.add(t);
            }
        }
        return res;
    }

    /**
     * Повертає всі подорожі в певний день
     * @param date
     * @return
     */
    public List<Trip> allTripsInDay(LocalDate date){
        var res = new ArrayList<Trip>();
        for(var t: trips){
            if(t.getStartTime().toLocalDate() == date){
                res.add(t);
            }
        }
        return res;
    }

    /**
     * сортує переданний список за датою та часом відправлення
     * @param tripList
     */
    public void sortByTime(List<Trip> tripList){
        tripList.sort(new TripDateTimeComparator());
    }

    public static class Builder{
        private Schedule schedule;

        public Builder() {
            schedule = new Schedule();
        }
        public Builder addTrip(Trip trip){
            assert (trip!=null);
            schedule.trips.add(trip);
            return this;
        }
        public Builder setTrips(List<Trip> trips){
            assert (trips!=null);
            schedule.trips = trips;
            return this;
        }
        public Schedule build(){
            assert (schedule.trips != null);
            assert (schedule.trips.size()!=0);
            return schedule;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(trips, schedule.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trips);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "trips=" + trips +
                '}';
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
