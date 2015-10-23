
package com.car.api.style;

import java.util.ArrayList;
import java.util.List;
 

 
public class StyleApiResponse {

    private List<Style> styles = new ArrayList<Style>();
    private Integer stylesCount;

    /**
     * 
     * @return
     *     The styles
     */
    public List<Style> getStyles() {
        return styles;
    }

    /**
     * 
     * @param styles
     *     The styles
     */
    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    /**
     * 
     * @return
     *     The stylesCount
     */
    public Integer getStylesCount() {
        return stylesCount;
    }

    /**
     * 
     * @param stylesCount
     *     The stylesCount
     */
    public void setStylesCount(Integer stylesCount) {
        this.stylesCount = stylesCount;
    }

}
