package classes;

import classes.trip.Trip;
import classes.trip.TripDateTimeComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScheduleStreamAPI {
    private List<Trip> trips = new ArrayList<>();


    /**
     * Повертає всі подорожі, де є вказана станція
     * @param name
     * @return
     */
    public List<Trip> haveTripStation(List<Trip> list,Station name){
        return list.stream().filter(t-> t.getRoute().getStationsR().contains(name)).collect(Collectors.toList());
    }

    /**
     * Повертає всі подорожі в певний день
     * @param date
     * @return
     */
    public List<Trip> allTripsInDay(List<Trip> list,LocalDate date){
        return list.stream().filter(t->t.getStartTime().toLocalDate().equals(date)).collect(Collectors.toList());
    }

    /**
     * сортує переданний список за датою та часом відправлення
     * @param tripList
     */
    public List<Trip> sortByTime(List<Trip> tripList){
       return tripList.stream().sorted(Comparator.comparing(Trip::getStartTime)).collect(Collectors.toList());
    }

    public static class Builder{
        private ScheduleStreamAPI schedule;

        public Builder() {
            schedule = new ScheduleStreamAPI();
        }
        public ScheduleStreamAPI.Builder addTrip(Trip trip){
            assert (trip!=null);
            schedule.trips.add(trip);
            return this;
        }
        public ScheduleStreamAPI.Builder setTrips(List<Trip> trips){
            assert (trips!=null);
            schedule.trips = trips;
            return this;
        }
        public ScheduleStreamAPI build(){
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
        return Objects.equals(trips, ScheduleStreamAPI.class);
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
