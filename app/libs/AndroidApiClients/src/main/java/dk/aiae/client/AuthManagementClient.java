/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.aiae.client;

import com.squareup.okhttp.OkHttpClient;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.DelegationProtocolApi;
import io.swagger.client.api.UserManagementApi;
import io.swagger.client.model.AccessTokenCheckResponse;
import io.swagger.client.model.LoginRequest;
import io.swagger.client.model.Token;
import io.swagger.client.model.UserArray;
import io.swagger.client.model.UserRequest;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author herin
 */
public class AuthManagementClient {
    private ApiClient client;
    private DelegationProtocolApi oauthApi;
    private UserManagementApi usersApi;
    private static String basePath;
    
    private AuthManagementClient(String basePath){
        client = new ApiClient();
        client.setBasePath(basePath);
        OkHttpClient httpClient = client.getHttpClient();
        httpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        httpClient.setReadTimeout(60, TimeUnit.SECONDS);
        httpClient.setWriteTimeout(60, TimeUnit.SECONDS);
        oauthApi = new DelegationProtocolApi(client);
        usersApi = new UserManagementApi(client);
    }
    
    public static void setBasePath(String newBasePath){
        basePath = newBasePath;
    }
    
    public static AuthManagementClient getNewInstance(){
        return new AuthManagementClient(basePath);
    }
    
    public UserRequest requestAccessToken(LoginRequest request) throws ApiException {
        return oauthApi.requestAccessToken(request);
    }
    
    public AccessTokenCheckResponse checkAccessToken(Token token) throws ApiException {
        return oauthApi.checkAccessToken(token);
    }

    public UserArray getAllUsers(Token token) throws ApiException {
        return usersApi.getAllUsers(token);
    }

    public void createUser(UserRequest userRequest) throws ApiException {
        usersApi.createUser(userRequest);
    }

    public void deleteUser(UserRequest userRequest) throws ApiException {
        usersApi.deleteUser(userRequest);
    }

    public void editUser(UserRequest userRequest) throws ApiException {
        usersApi.editUser(userRequest);
    }
}
