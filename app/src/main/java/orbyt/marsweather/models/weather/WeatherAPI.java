package orbyt.marsweather.models.weather;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by orbyt on 12/9/2015.
 */

public class WeatherAPI {

    private Report report;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The report
     */
    public Report getReport() {
        return report;
    }

    /**
     *
     * @param report
     * The report
     */
    public void setReport(Report report) {
        this.report = report;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
