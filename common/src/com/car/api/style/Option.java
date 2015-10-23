
package com.car.api.style;

import java.util.ArrayList;
import java.util.List;
 

 
public class Option {

    private String category;
    private List<Option_> options = new ArrayList<Option_>();

    /**
     * 
     * @return
     *     The category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 
     * @param category
     *     The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 
     * @return
     *     The options
     */
    public List<Option_> getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    public void setOptions(List<Option_> options) {
        this.options = options;
    }

}
