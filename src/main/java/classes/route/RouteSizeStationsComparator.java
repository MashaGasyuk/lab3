package classes.route;

import java.util.Comparator;

public class RouteSizeStationsComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        if(o1.getStationsCount()> o2.getStationsCount()){
            return 1;
        }else if(o1.getStationsCount()> o2.getStationsCount()){
            return  -1;
        }
        else{
            return 0;
        }
    }
}

