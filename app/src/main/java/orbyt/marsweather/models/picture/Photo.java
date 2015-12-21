
package orbyt.marsweather.models.picture;

import java.util.HashMap;
import java.util.Map;

public class Photo {

    private Integer id;
    private Integer sol;
    private Camera camera;
    private String img_src;
    private String earth_date;
    private Rover rover;
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
     *     The sol
     */
    public Integer getSol() {
        return sol;
    }

    /**
     * 
     * @param sol
     *     The sol
     */
    public void setSol(Integer sol) {
        this.sol = sol;
    }

    /**
     * 
     * @return
     *     The camera
     */
    public Camera getCamera() {
        return camera;
    }

    /**
     * 
     * @param camera
     *     The camera
     */
    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    /**
     * 
     * @return
     *     The img_src
     */
    //@SerializedName("img_src")
    public String getImg_src() {
        return img_src;
    }

    /**
     * 
     * @param img_src
     *     The img_src
     */
    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    /**
     * 
     * @return
     *     The earth_date
     */
    public String getEarth_date() {
        return earth_date;
    }

    /**
     * 
     * @param earth_date
     *     The earth_date
     */
    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }

    /**
     * 
     * @return
     *     The rover
     */
    public Rover getRover() {
        return rover;
    }

    /**
     * 
     * @param rover
     *     The rover
     */
    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
