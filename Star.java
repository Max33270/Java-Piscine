import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude; 

    public double getMagnitude() {
        return magnitude; 
    }

    public void setMagnitude(double Magnitude) {
        this.magnitude = Magnitude; 
    }
    public Star() {
        super(); 
        this.magnitude = 0.0; 
    }

    public Star(String Name, double X, double Y, double Z, double Magnitude, int Mass) {
        super(Name, X, Y, Z, Mass);
        this.magnitude = Magnitude; 
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Star)) {
            return false;
        }
        Star star = (Star) object;
        return Objects.equals(name, star.name) && x == star.x && y == star.y && z == star.z && magnitude == star.magnitude;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, x, y, z, magnitude);
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.000");
        return String.format("%s shines at the %s magnitude", name, formatter.format((magnitude)));
    }
}


// In the Star class, let's add a new constructor with the following arguments :

// the name                 shines at the 0.400 magnitude
// the position x
// the position y
// the position z
// the magnitude
// It calls the constructor of the superclass CelestialObject.
// We will override the hashCode and equals, using the magnitude property.

// Finally, we rewrite the toString method. The returned String must 
// have the following format : <name> shines at the <magnitude> magnitude