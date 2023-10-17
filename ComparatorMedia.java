
import java.util.Comparator;
import java.io.Serializable;

public class ComparatorMedia implements Comparator<Utilizador>, Serializable {
    public int compare(Utilizador e1, Utilizador e2) {
        return (e1.media()-e2.media());
    }
}
