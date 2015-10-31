package query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class Payload {

    Map<String,String>  propertyValues = new HashMap<>();

    public Map<String, String> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void set(String key,String value)
    {
        propertyValues.put(key,value);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "propertyValues=" + propertyValues +
                '}';
    }
}
