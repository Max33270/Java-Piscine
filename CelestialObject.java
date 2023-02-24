import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class CelestialObject {
    public double x; 
    public double y; 
    public double z; 
    public String name; 
    public static double KM_IN_ONE_AU = 150000000; 
    private int mass; 

    public CelestialObject() {
        this.x = 0.0; 
        this.y = 0.0; 
        this.z = 0.0;
        this.name = "Soleil"; 
    }

    public CelestialObject(String Name, double X, double Y, double Z, int Mass) {
        this.name = Name; 
        this.x = X; 
        this.y = Y; 
        this.z = Z; 
        this.mass = Mass;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }

    public double getX() {
        return x;
    }
    
    public void setX(double X) {
        this.x = X;
    }

    public double getY() {
        return y;
    }
    
    public void setY(double Y) {
        this.y = Y;
    }

    public double getZ() {
        return z;
    }
    
    public void setZ(double Z) {
        this.z = Z;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int Mass) {
        this.mass = Mass; 
    }
    

    public static double getDistanceBetween (CelestialObject co1, CelestialObject co2) {
        return Math.sqrt(Math.pow(co1.x - co2.x, 2) + Math.pow(co1.y - co2.y, 2) + Math.pow(co1.z - co2.z, 2));
    }

    public static double getDistanceBetweenInKm (CelestialObject co1, CelestialObject co2) {
        return getDistanceBetween(co1, co2) * KM_IN_ONE_AU;
    }

    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.000");
        return String.format("%s is positioned at (%s, %s, %s)", name, formatter.format(x), formatter.format(y), formatter.format(z));
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CelestialObject)) {
            return false;
        }
        CelestialObject co = (CelestialObject) object;
        return co.name.equals(name) && co.x == x && co.y == y && co.z == z;
    }

    @Override
    public int hashCode () {
        return Objects.hash(name, x, y, z);
    }
}



