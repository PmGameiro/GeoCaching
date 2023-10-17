
import java.util.Comparator;
import java.io.Serializable;

public class ComparatorData implements Comparator<Atividade>, Serializable {
    public int compare(Atividade e1, Atividade e2) {
        return e1.getData().compareTo(e2.getData());
    }
}
