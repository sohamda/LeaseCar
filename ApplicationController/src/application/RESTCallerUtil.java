package application;

import com.car.api.make.Make;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import oracle.adfmf.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.util.logging.Trace;

public class RESTCallerUtil {
    
    private static final String CONNECTION = "EdmundAPI";
    private static final String API_KEY = "&api_key=ajbj59h95qs3pbuwb79fq2pz";
    private static final String MAKE_API_URI = "/makes?fmt=json";
    private static final String STYLE_API_URI = "/styles?fmt=json";
    private static final String STYLE_API_VIEW_FULL = "&view=full";
    
    public RESTCallerUtil() {
        super();
    }
    
    public String invokeMakeAPI() {
        return invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, MAKE_API_URI);
    }
    
    public String invokeStyleAPI(String styleApiURI) {
        return invokeRestRequest(RestServiceAdapter.REQUEST_TYPE_GET, styleApiURI + STYLE_API_URI + STYLE_API_VIEW_FULL);
    }
    
    private String invokeRestRequest(String httpMethod, String requestURI){
            
        String restPayload = "";
        System.out.println("calling " + requestURI);
        RestServiceAdapter restServiceAdapter = Model.createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        //set URL connection defined for this sample. In this sample, the "hrresrconn" connection resolves 
        //to http://127.0.0.1:7101/hrrest/resources/hrappsrvc . The connection has been created for this 
        //sample choosing File | New | From Gallery | General | Connections | URL connection from the JDeveloper menu
        restServiceAdapter.setConnectionName(CONNECTION);
        
        //set GET, POST, DELETE, PUT
        restServiceAdapter.setRequestType(httpMethod);
        
        //this sample uses JSON only. Thus the media type can be hard-coded in this class
        //the content-type tells the server what format the incoming payload has
        restServiceAdapter.addRequestProperty("Content-Type", "application/json");
        //the accept header indicates the expected payload fromat to the server
        restServiceAdapter.addRequestProperty("Accept", "application/json; charset=UTF-8");
        restServiceAdapter.setRetryLimit(0);    
        restServiceAdapter.setRequestURI(requestURI + API_KEY);    
        
        //variable holding the response
        String response = "";

        try {    
            response = restServiceAdapter.send(restPayload);
        } catch (Exception e) {
            //log error
            System.out.println("exception " + e.getMessage());
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", "Invoke of REST Resource failed for "+httpMethod+" to "+requestURI);
            Trace.log("REST_JSON",Level.SEVERE, this.getClass(),"invokeRestRequest", e.getLocalizedMessage());
        }
        System.out.println("rest response " + response.length());
        return response;
    }
    
    public static void main(String[] args) {
        
        RESTCallerUtil restCallerUtil = new RESTCallerUtil();
        String restResponse = restCallerUtil.invokeMakeAPI();
        System.out.println(restResponse);
    }
}
