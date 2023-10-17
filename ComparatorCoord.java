
import java.util.Comparator;
import java.io.Serializable;

public class ComparatorCoord implements Comparator<Evento>, Serializable {
    public int compare(Evento e1, Evento e2) {
        return ((e1.getCoordEvento().getLatitude()+e1.getCoordEvento().getLongitude())-(e2.getCoordEvento().getLatitude()+e2.getCoordEvento().getLongitude()));
    }
}

