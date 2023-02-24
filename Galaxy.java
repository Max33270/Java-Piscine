import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private List<CelestialObject> celestialObjects; 

    public Galaxy() {
        this.celestialObjects = new ArrayList<CelestialObject>(); 
    }

    public Galaxy(List<CelestialObject> celestialObjects) {
        this.celestialObjects = celestialObjects; 
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject (CelestialObject celestialObject) {
        this.celestialObjects.add(celestialObject);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> massRepartition = new HashMap<String, Integer>();
        int starboy = 0;
        int planetboy = 0; 
        int otherboy = 0; 

        for (CelestialObject celestialObject : celestialObjects) {
            if (celestialObject instanceof Star) {
                starboy += celestialObject.getMass();
            } else if (celestialObject instanceof Planet) {
                planetboy += celestialObject.getMass();
            } else {
                otherboy += celestialObject.getMass();
            }
        }
        massRepartition.put("Star", starboy);
        massRepartition.put("Planet", planetboy);
        massRepartition.put("Other", otherboy); 
        return massRepartition;
    }
}
