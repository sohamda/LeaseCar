
package com.car.api.make;

import java.util.ArrayList;
import java.util.List;

public class Year {

    private Integer id;
    private Integer year;
    private List<String> states = new ArrayList<String>();

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
     *     The year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     The states
     */
    public List<String> getStates() {
        return states;
    }

    /**
     * 
     * @param states
     *     The states
     */
    public void setStates(List<String> states) {
        this.states = states;
    }

}
