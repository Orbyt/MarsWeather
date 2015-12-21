
package orbyt.marsweather.models.picture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rover {

    private Integer id;
    private String name;
    private String landingDate;
    private Integer max_sol;
    private String maxDate;
    private Integer total_photos;
    private List<Camera_> cameras = new ArrayList<Camera_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The landingDate
     */
    public String getLandingDate() {
        return landingDate;
    }

    /**
     * 
     * @param landingDate
     *     The landing_date
     */
    public void setLandingDate(String landingDate) {
        this.landingDate = landingDate;
    }

    /**
     * 
     * @return
     *     The max_sol
     */
    public Integer getMaxSol() {
        return max_sol;
    }

    /**
     * 
     * @param maxSol
     *     The max_sol
     */
    public void setMaxSol(Integer maxSol) {
        this.max_sol = maxSol;
    }

    /**
     * 
     * @return
     *     The maxDate
     */
    public String getMaxDate() {
        return maxDate;
    }

    /**
     * 
     * @param maxDate
     *     The max_date
     */
    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    /**
     * 
     * @return
     *     The total_photos
     */
    public Integer getTotal_photos() {
        return total_photos;
    }

    /**
     * 
     * @param total_photos
     *     The total_photos
     */
    public void setTotal_photos(Integer total_photos) {
        this.total_photos = total_photos;
    }

    /**
     * 
     * @return
     *     The cameras
     */
    public List<Camera_> getCameras() {
        return cameras;
    }

    /**
     * 
     * @param cameras
     *     The cameras
     */
    public void setCameras(List<Camera_> cameras) {
        this.cameras = cameras;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
