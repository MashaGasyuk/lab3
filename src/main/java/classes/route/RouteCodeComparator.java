package classes.route;

import java.util.Comparator;

class RouteCodeComparator implements Comparator<Route> {
    @Override
    public int compare(Route o1, Route o2) {
        return o1.getCode().compareTo(o2.getCode());
    }
}

