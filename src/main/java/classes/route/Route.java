package classes.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import classes.Station;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Клас у якому описується маршрут для якогось транспорту.
 * Клас є набором точок між якими ходить транспорт
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Route implements Serializable {
    private String code;
    private List<Station> stationsR = new ArrayList<>();



    public Route(){
        //stations = new ArrayList<>();
    }


    public String getCode() {
        return code;
    }

    public List<Station> getStationsR() {
        return stationsR;
    }

    /**
     * З цієї станції траспорт починає рухатись. Початок Маршруту
     * @return
     */
    public Station getStartStation() {
        return stationsR.get(0);
    }

    public int getStationsCount(){
        return stationsR.size();
    }
    /**
     *Тут траспорт закінчує рухатись. Кінець маршруту
     * @return
     */
    public Station getEndStation() {
        return stationsR.get(stationsR.size()-1);
    }

    protected void setCode(String code) {
        this.code = code;
    }

    /**
     * Присвоює маршруту переданний список станцій
     * @param stationsR
     */
    protected void setStationsR(List<Station> stationsR) {
        this.stationsR = stationsR;
    }

    /**
     * Додає станцію до маршруту
     * @param station
     */
    protected void addStation(Station station){
        this.stationsR.add(station);
    }

    /**
     * Видаляє станцію з маршруту
     * @param station
     */
    protected void removeStation(Station station){
        this.stationsR.remove(station);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(code, route.code) && Objects.equals(stationsR, route.stationsR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, stationsR);
    }

    @Override
    public String toString() {
        return "Route{" +
                "code='" + code + '\'' +
                ", stations=" + stationsR +
                '}';
    }


}
