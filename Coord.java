
/**
 * Escreva a descrição da classe Coord aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.io.Serializable;
public class Coord implements Serializable {
    private int latitude;
    private int longitude;
    
    public Coord() {
		this.latitude=0;
		this.longitude=0;
	}
	
    public Coord(int latitude, int longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Coord(Coord e) {
		this.latitude=e.getLatitude();
		this.longitude=e.getLongitude();
	}
	
	public int getLatitude() {
		return latitude;
	}
	
	public int getLongitude() {
		return longitude;
	}
	
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public Coord clone() {
		return new Coord(this);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (latitude != other.getLatitude())
			return false;
		if (longitude != other.getLongitude())
			return false;
		return true;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Latitude: ");
		builder.append(latitude);
		builder.append("\tLongitude: ");
		builder.append(longitude);
		return builder.toString();
	}
}
