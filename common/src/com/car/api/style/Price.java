
package com.car.api.style;

 

 
public class Price {

    private Integer baseMSRP;
    private Boolean estimateTmv;

    /**
     * 
     * @return
     *     The baseMSRP
     */
    public Integer getBaseMSRP() {
        return baseMSRP;
    }

    /**
     * 
     * @param baseMSRP
     *     The baseMSRP
     */
    public void setBaseMSRP(Integer baseMSRP) {
        this.baseMSRP = baseMSRP;
    }

    /**
     * 
     * @return
     *     The estimateTmv
     */
    public Boolean getEstimateTmv() {
        return estimateTmv;
    }

    /**
     * 
     * @param estimateTmv
     *     The estimateTmv
     */
    public void setEstimateTmv(Boolean estimateTmv) {
        this.estimateTmv = estimateTmv;
    }

}
