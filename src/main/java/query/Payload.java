package query;

import java.util.Map;

/**
 * Created by mkhanwalkar on 10/31/15.
 */
public class Payload {

    Map<String,String>  propertyValues;

    public Map<String, String> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
