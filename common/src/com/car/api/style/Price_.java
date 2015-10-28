
package com.car.api.style;


public class Price_ {

    private Integer baseMSRP;
    private Integer baseInvoice;
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
     *     The baseInvoice
     */
    public Integer getBaseInvoice() {
        return baseInvoice;
    }

    /**
     * 
     * @param baseInvoice
     *     The baseInvoice
     */
    public void setBaseInvoice(Integer baseInvoice) {
        this.baseInvoice = baseInvoice;
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
