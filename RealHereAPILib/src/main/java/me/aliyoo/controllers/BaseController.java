/*
 * RealHereAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 06/02/2016
 */
package me.aliyoo.controllers;

import me.aliyoo.APIException;
import me.aliyoo.http.client.HttpClient;
import me.aliyoo.http.client.HttpContext;
import me.aliyoo.http.client.VolleyClient;
import me.aliyoo.http.response.HttpResponse;

public abstract class BaseController {
    /**
     * Private variable to keep shared reference of client instance
     */
    private static HttpClient clientInstance = null;
    private static Object syncObject = new Object();
    
    /**
     * Shared instance of the Http client
     * @return The shared instance of the http client 
     */
    public static HttpClient getClientInstance() {
        synchronized (syncObject) {
            if (null == clientInstance) {
                clientInstance = VolleyClient.getSharedInstance();
            }
        }
        return clientInstance;
    }

    /**
     * Shared instance of the Http client
     * @param	client	The shared instance of the http client 
     */
    public static void setClientInstance(HttpClient client) {
        synchronized (syncObject) {
            if (null != client) {
                clientInstance = client;
            }
        }
    }

    /**
     * Validates the response against HTTP errors defined at the API level
     * @param	response	The response recieved
     * @param	context		Context of the request and the recieved response 
     */
    protected void validateResponse(HttpResponse response, HttpContext context) 
            throws APIException {
        //get response status code to validate
        int responseCode = response.getStatusCode();
        if (responseCode == 500)
            throw new APIException("服务器错误", context);

        else if (responseCode == 404)
            throw new APIException("资源不存在", context);

        else if ((responseCode < 200) || (responseCode > 206)) //[200,206] = HTTP OK
            throw new APIException("HTTP Response Not OK", context);
    }
}
