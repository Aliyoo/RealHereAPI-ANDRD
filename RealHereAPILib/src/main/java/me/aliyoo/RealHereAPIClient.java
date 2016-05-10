/*
 * RealHereAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 05/10/2016
 */
package me.aliyoo;

import me.aliyoo.controllers.*;
import me.aliyoo.http.client.HttpClient;

public class RealHereAPIClient {
    /**
     * Singleton access to UserOpt controller
     * @return	Returns the UserOptController instance 
     */
    public UserOptController getUserOpt() {
        return UserOptController.getInstance();
    }

    /**
     * Singleton access to Conference controller
     * @return	Returns the ConferenceController instance 
     */
    public ConferenceController getConference() {
        return ConferenceController.getInstance();
    }

    /**
     * Singleton access to SignOpt controller
     * @return	Returns the SignOptController instance 
     */
    public SignOptController getSignOpt() {
        return SignOptController.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public RealHereAPIClient() { }
}