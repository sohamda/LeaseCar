
package com.car.api.style;


public class Option {

    private String category;
    private Option_[] options;

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
    public Option_[] getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    public void setOptions(Option_[] options) {
        this.options = options;
    }
}
