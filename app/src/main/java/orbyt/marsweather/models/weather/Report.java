package orbyt.marsweather.models.weather;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by orbyt on 12/9/2015.
 */

public class Report {

    private String terrestrial_date;
    private Integer sol;
    private Double ls;
    private Double min_temp;
    private Double min_temp_fahrenheit;
    private Double max_temp;
    private Double max_temp_fahrenheit;
    private Double pressure;
    private String pressure_string;
    private Object abs_humidity;
    private Object wind_speed;
    private String wind_direction;
    private String atmo_opacity;
    private String season;
    private String sunrise;
    private String sunset;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The terrestrial_date
     */
    public String getTerrestrial_date() {
        return terrestrial_date;
    }

    /**
     *
     * @param terrestrial_date
     * The terrestrial_date
     */
    public void setTerrestrial_date(String terrestrial_date) {
        this.terrestrial_date = terrestrial_date;
    }

    /**
     *
     * @return
     * The sol
     */
    public Integer getSol() {
        return sol;
    }

    /**
     *
     * @param sol
     * The sol
     */
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    /**
     *
     * @return
     * The ls
     */
    public Double getLs() {
        return ls;
    }

    /**
     *
     * @param ls
     * The ls
     */
    public void setLs(Double ls) {
        this.ls = ls;
    }

    /**
     *
     * @return
     * The min_temp
     */
    public Double getMin_temp() {
        return min_temp;
    }

    /**
     *
     * @param min_temp
     * The min_temp
     */
    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    /**
     *
     * @return
     * The min_temp_fahrenheit
     */
    public Double getMin_temp_fahrenheit() {
        return min_temp_fahrenheit;
    }

    /**
     *
     * @param min_temp_fahrenheit
     * The min_temp_fahrenheit
     */
    public void setMin_temp_fahrenheit(Double min_temp_fahrenheit) {
        this.min_temp_fahrenheit = min_temp_fahrenheit;
    }

    /**
     *
     * @return
     * The max_temp
     */
    public Double getMax_temp() {
        return max_temp;
    }

    /**
     *
     * @param max_temp
     * The max_temp
     */
    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    /**
     *
     * @return
     * The max_temp_fahrenheit
     */
    public Double getMax_temp_fahrenheit() {
        return max_temp_fahrenheit;
    }

    /**
     *
     * @param max_temp_fahrenheit
     * The max_temp_fahrenheit
     */
    public void setMax_temp_fahrenheit(Double max_temp_fahrenheit) {
        this.max_temp_fahrenheit = max_temp_fahrenheit;
    }

    /**
     *
     * @return
     * The pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     *
     * @return
     * The pressure_string
     */
    public String getPressure_string() {
        return pressure_string;
    }

    /**
     *
     * @param pressure_string
     * The pressure_string
     */
    public void setPressure_string(String pressure_string) {
        this.pressure_string = pressure_string;
    }

    /**
     *
     * @return
     * The abs_humidity
     */
    public Object getAbs_humidity() {
        return abs_humidity;
    }

    /**
     *
     * @param abs_humidity
     * The abs_humidity
     */
    public void setAbs_humidity(Object abs_humidity) {
        this.abs_humidity = abs_humidity;
    }

    /**
     *
     * @return
     * The wind_speed
     */
    public Object getWind_speed() {
        return wind_speed;
    }

    /**
     *
     * @param wind_speed
     * The wind_speed
     */
    public void setWind_speed(Object wind_speed) {
        this.wind_speed = wind_speed;
    }

    /**
     *
     * @return
     * The wind_direction
     */
    public String getWind_direction() {
        return wind_direction;
    }

    /**
     *
     * @param wind_direction
     * The wind_direction
     */
    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    /**
     *
     * @return
     * The atmo_opacity
     */
    public String getAtmo_opacity() {
        return atmo_opacity;
    }

    /**
     *
     * @param atmo_opacity
     * The atmo_opacity
     */
    public void setAtmo_opacity(String atmo_opacity) {
        this.atmo_opacity = atmo_opacity;
    }

    /**
     *
     * @return
     * The season
     */
    public String getSeason() {
        return season;
    }

    /**
     *
     * @param season
     * The season
     */
    public void setSeason(String season) {
        this.season = season;
    }

    /**
     *
     * @return
     * The sunrise
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     *
     * @param sunrise
     * The sunrise
     */
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    /**
     *
     * @return
     * The sunset
     */
    public String getSunset() {
        return sunset;
    }

    /**
     *
     * @param sunset
     * The sunset
     */
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
