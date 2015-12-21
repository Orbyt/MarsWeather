
package orbyt.marsweather.models.picture;

import java.util.HashMap;
import java.util.Map;


public class Camera {

    private Integer id;
    private String name;
    private Integer roverId;
    private String full_name;
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
     *     The roverId
     */
    public Integer getRoverId() {
        return roverId;
    }

    /**
     * 
     * @param roverId
     *     The rover_id
     */
    public void setRoverId(Integer roverId) {
        this.roverId = roverId;
    }

    /**
     * 
     * @return
     *     The full_name
     */
    public String getFullName() {
        return full_name;
    }

    /**
     * 
     * @param fullName
     *     The full_name
     */
    public void setFullName(String fullName) {
        this.full_name = fullName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
