/*
 * RealHereAPILib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 06/02/2016
 */
package me.aliyoo.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import me.aliyoo.http.client.HttpClient;
import me.aliyoo.http.client.HttpContext;
import me.aliyoo.http.request.HttpRequest;
import me.aliyoo.http.response.HttpResponse;
import me.aliyoo.http.response.HttpStringResponse;
import me.aliyoo.http.client.APICallBack;
import me.aliyoo.*;
import me.aliyoo.models.*;

public class ConferenceController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static ConferenceController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the ConferenceController class 
     */
    public static ConferenceController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new ConferenceController();
            }
        }
        return instance;
    }

    /**
     * 活动详情
     * @param    confcID    Required parameter: 系统生成的活动ID
     * @return	Returns the void response from the API call 
     */
    public void getConferenceInfoAsync(
                final int confcID,
                final APICallBack<String> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/conference/detail");

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4984374007638384652L;
            {
                    put( "confcID", confcID );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5513185434286070154L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //Error handling using HTTP status codes
                            int _responseCode = _response.getStatusCode();
                            if (_responseCode == 404)
                                throw new APIException("此活动详情不存在", _context);

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _result = ((HttpStringResponse)_response).getBody();
                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * 筛选查找活动
     * @param    size    Required parameter: 单次获取数据的最多条数
     * @param    ogrerWords    Optional parameter: 组织者包含字
     * @param    titleWords    Optional parameter: 活动名称包含字
     * @return	Returns the void response from the API call 
     */
    public void getFilterConferencesAsync(
                final String size,
                final String ogrerWords,
                final String titleWords,
                final APICallBack<String> callBack
    ) {
        //validating required parameters
        if (null == size)
            throw new NullPointerException("The parameter \"size\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/conference");

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5223155993154882157L;
            {
                    put( "size", size );
                    put( "ogrerWords", (null != ogrerWords) ? ogrerWords : "whole" );
                    put( "titleWords", (null != titleWords) ? titleWords : "whole" );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5155417286220038829L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _result = ((HttpStringResponse)_response).getBody();
                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * 组织者修改活动
     * @param    apikey    Required parameter: 密钥
     * @param    confcID    Required parameter: 活动ID
     * @param    email    Required parameter: 活动添加者标识
     * @param    confcDetail    Optional parameter: 活动详细介绍
     * @param    confcDuration    Optional parameter: 活动时长
     * @param    confcLocation    Optional parameter: 活动地点
     * @param    confcOrger    Optional parameter: 活动组织者
     * @param    confcTime    Optional parameter: 活动开始时间
     * @param    confcTitle    Optional parameter: 活动标题
     * @return	Returns the void response from the API call 
     */
    public void modifyConferenceAsync(
                final String apikey,
                final int confcID,
                final String email,
                final String confcDetail,
                final Double confcDuration,
                final String confcLocation,
                final String confcOrger,
                final Date confcTime,
                final String confcTitle,
                final APICallBack<String> callBack
    ) {
        //validating required parameters
        if (null == apikey)
            throw new NullPointerException("The parameter \"apikey\" is a required parameter and cannot be null.");

        if (null == email)
            throw new NullPointerException("The parameter \"email\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/conference/modify");

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4778157430712913088L;
            {
                    put( "confcID", confcID );
                    put( "confcDuration", confcDuration );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5601322937664508389L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "apikey", apikey );
                    put( "email", email );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5106453091960139734L;
            {
                    put( "confcDetail", confcDetail );
                    put( "confcLocation", confcLocation );
                    put( "confcOrger", confcOrger );
                    put( "confcTime", confcTime );
                    put( "confcTitle", confcTitle );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _result = ((HttpStringResponse)_response).getBody();
                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * 组织者添加一项活动
     * @param    apikey    Required parameter: API密钥
     * @param    confcDetail    Required parameter: 活动详细介绍
     * @param    confcDuration    Required parameter: 活动时长
     * @param    confcLocation    Required parameter: 活动地点
     * @param    confcOrger    Required parameter: 活动组织者
     * @param    confcTime    Required parameter: 活动开始时间
     * @param    confcTitle    Required parameter: 活动标题
     * @param    email    Required parameter: 活动添加者标识
     * @return	Returns the void response from the API call 
     */
    public void addConferenceAsync(
                final String apikey,
                final String confcDetail,
                final double confcDuration,
                final String confcLocation,
                final String confcOrger,
                final Date confcTime,
                final String confcTitle,
                final String email,
                final APICallBack<String> callBack
    ) {
        //validating required parameters
        if (null == apikey)
            throw new NullPointerException("The parameter \"apikey\" is a required parameter and cannot be null.");

        if (null == confcDetail)
            throw new NullPointerException("The parameter \"confcDetail\" is a required parameter and cannot be null.");

        if (null == confcLocation)
            throw new NullPointerException("The parameter \"confcLocation\" is a required parameter and cannot be null.");

        if (null == confcOrger)
            throw new NullPointerException("The parameter \"confcOrger\" is a required parameter and cannot be null.");

        if (null == confcTime)
            throw new NullPointerException("The parameter \"confcTime\" is a required parameter and cannot be null.");

        if (null == confcTitle)
            throw new NullPointerException("The parameter \"confcTitle\" is a required parameter and cannot be null.");

        if (null == email)
            throw new NullPointerException("The parameter \"email\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/conference");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5142753436504457249L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "apikey", apikey );
                    put( "email", email );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 5248597885384921561L;
            {
                    put( "confcDetail", confcDetail );
                    put( "confcDuration", confcDuration );
                    put( "confcLocation", confcLocation );
                    put( "confcOrger", confcOrger );
                    put( "confcTime", confcTime );
                    put( "confcTitle", confcTitle );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _result = ((HttpStringResponse)_response).getBody();
                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * 删除一条活动
     * @param    apikey    Required parameter: 密钥
     * @param    confcID    Required parameter: 系统生成的活动ID
     * @param    email    Required parameter: 用户唯一标识email
     * @return	Returns the void response from the API call 
     */
    public void createDeleteConferenceAsync(
                final String apikey,
                final int confcID,
                final String email,
                final APICallBack<Object> callBack
    ) {
        //validating required parameters
        if (null == apikey)
            throw new NullPointerException("The parameter \"apikey\" is a required parameter and cannot be null.");

        if (null == email)
            throw new NullPointerException("The parameter \"email\" is a required parameter and cannot be null.");

        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/conference/delete");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5364849333079917784L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "apikey", apikey );
                    put( "email", email );
            }
        };

        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>() {
            private static final long serialVersionUID = 4787512910252575276L;
            {
                    put( "confcID", confcID );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //let the caller know of the success
                            callBack.onSuccess(_context, _context);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}