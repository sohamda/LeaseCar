package application;

import java.util.logging.Level;

import oracle.adfmf.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.util.logging.Trace;

public class RESTCallerUtil {
    
    private static final String CONNECTION = "EdmundAPI";
    private static final String PHOTO_SERVICE = "photoService";
    private static final String API_KEY = "&api_key=ajbj59h95qs3pbuwb79fq2pz";
    private static final String MAKE_API_URI = "/makes?fmt=json";
    private static final String STYLE_API_URI = "/styles?fmt=json";
    private static final String STYLE_API_VIEW_FULL = "&view=full";
    private static final String PHOTOS_API_URI = "/api/vehiclephoto/service/findphotosbystyleid?fmt=json&styleId=";
    
    public RESTCallerUtil() {
        super();
    }
    
    public String invokeMakeAPI() {
        return invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, MAKE_API_URI, CONNECTION);
    }
    
    public String invokeStyleAPI(String styleApiURI) {
        return invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, styleApiURI + STYLE_API_URI + STYLE_API_VIEW_FULL, CONNECTION);
    }
    
    public String invokePhotosAPI(String styleId) {
        return invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, PHOTOS_API_URI + styleId, PHOTO_SERVICE);
    }
    
    private String invokeRestRequest(String httpMethod, String requestURI, String connection){
            
        String restPayload = "";
        System.out.println("calling " + requestURI);
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        restServiceAdapter.setConnectionName(connection);
        
        //set GET, POST, DELETE, PUT
        restServiceAdapter.setRequestType(httpMethod);
        
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        restServiceAdapter.setRetryLimit(0);    
        restServiceAdapter.setRequestURI(requestURI + API_KEY);    
        
        //variable holding the response
        String response = "";

        try {    
            response = restServiceAdapter.send(restPayload);
        } catch (Exception e) {
            //log error
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", "Invoke of REST Resource failed for "+httpMethod+" to "+requestURI);
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", e.getLocalizedMessage());
        }
        System.out.println("rest response " + response.length());
        return response;
    }
}
