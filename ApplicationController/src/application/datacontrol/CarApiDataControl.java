package application.datacontrol;

import application.RESTCallerUtil;

import com.car.api.make.Make;
import com.car.api.make.MakeApiResponse;
import com.car.api.make.Model;
import com.car.api.style.Style;
import com.car.api.style.StyleApiResponse;

import java.util.logging.Level;

import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.util.logging.Trace;

public class CarApiDataControl {
    
    Make[] makes;
    Style[] styles;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);
    
    public CarApiDataControl() {
        super();
    } 
    
    public void setMakes(Make[] makes) {
        Make[] oldMakes = this.makes;
        this.makes = makes;
        propertyChangeSupport.firePropertyChange("makes", oldMakes, makes);
    }

    public Make[] getMakes() {
        if(makes==null) {
            System.out.println("makes are empty ");
            allMakes();
        }
        return makes;
    }
    
    public void setStyles(Style[] styles) {
        Style[] oldStyles = this.styles;
        this.styles = styles;
        propertyChangeSupport.firePropertyChange("styles", oldStyles, styles);
    }

    public Style[] getStyles() {
        
        return styles;
    }
   
    // Call : http://api.edmunds.com/api/vehicle/v2/makes?fmt=json&api_key=ajbj59h95qs3pbuwb79fq2pz
    private void allMakes() {
        
        RESTCallerUtil restCallerUtil = new RESTCallerUtil();
        String restResponse = restCallerUtil.invokeMakeAPI();
        JSONBeanSerializationHelper jbsh = new JSONBeanSerializationHelper();
        MakeApiResponse makeAPIResponse = null;

        try {
            makeAPIResponse = (MakeApiResponse) jbsh.fromJSON(MakeApiResponse.class, restResponse);
        } catch (Exception e) {
            Trace.log("CarApiDataControl",Level.SEVERE, this.getClass(),"allMakes", e.getLocalizedMessage());
        }
        
        if(makeAPIResponse != null) {
            setMakes(makeAPIResponse.getMakes());
        }
        providerChangeSupport.fireProviderRefresh("makes");
    }
    
    // get the details of all the models inside a make
    public Model[] getModels(Make make) {
        
        return make.getModels();
    }
    
    // Call : https://api.edmunds.com/api/vehicle/v2/{make_nickname}/{model_nickname}/{model_year}/styles?fmt=json&api_key=ajbj59h95qs3pbuwb79fq2pz&view=full
    public void getDetailOfCar(String makeNickName, String modelNickName, Integer modelYear) {
               
        RESTCallerUtil restCallerUtil = new RESTCallerUtil();
        String restResponse = restCallerUtil.invokeStyleAPI("/"+makeNickName+"/"+modelNickName+"/"+modelYear);
        
        JSONBeanSerializationHelper jbsh = new JSONBeanSerializationHelper();
        StyleApiResponse styleAPIResponse = null;

        try {            
            styleAPIResponse = (StyleApiResponse) jbsh.fromJSON(StyleApiResponse.class, restResponse);
        } catch (Exception e) {
            Trace.log("CarApiDataControl",Level.SEVERE, this.getClass(),"getDetailOfCar", e.getLocalizedMessage());
        }
        
        if(styleAPIResponse != null) {            
            setStyles(styleAPIResponse.getStyles());
        }
        
        providerChangeSupport.fireProviderRefresh("styles");
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    public void  addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }
     
    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }
}
