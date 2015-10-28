
package com.car.api.style;


public class Color {

    private String category;
    private Option__[] options;

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
    public Option__[] getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    public void setOptions(Option__[] options) {
        this.options = options;
    }
}
