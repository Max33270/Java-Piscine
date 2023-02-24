import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Planet extends CelestialObject{
    private Star centerStar; 

    public Planet() {
        super(); 
        this.centerStar = new Star(); 
    }

    public Planet (String Name, double X, double Y, double Z, Star cStar, int Mass) {
        super(Name, X, Y, Z, Mass); 
        this.centerStar = cStar; 
    }

    public Star getCenterStar() {
        return centerStar;
    }
    
    public void setCenterStar(Star cStar) {
        this.centerStar = cStar;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Planet)) {
            return false;
        }
        Planet planet = (Planet) object;
        return Objects.equals(name, planet.name) && x == planet.x && y == planet.y && z == planet.z && Objects.equals(centerStar, planet.centerStar);
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, x, y, z, centerStar);
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.000");
        return String.format("%s circles around %s at the %s AU", name, centerStar.name, formatter.format((Planet.getDistanceBetween(this, centerStar))));
    }

}

