package dk.aiae.handlers;

import dk.aiae.client.AuthManagementClient;
import dk.aiae.logic.TokenRegistry;
import io.swagger.client.ApiException;
import io.swagger.client.model.LoginRequest;
import io.swagger.client.model.Token;
import io.swagger.client.model.User;
import io.swagger.client.model.UserArray;
import io.swagger.client.model.UserRequest;

public class AuthManagementHandler {
    private static AuthManagementHandler instance;
    private static final Object threadLock = new Object();

    public static AuthManagementHandler getInstance() {
        if (instance == null) {
            synchronized (threadLock) {
                if (instance == null) {
                    instance = new AuthManagementHandler();
                }
            }
        }
        return instance;
    }

    private AuthManagementHandler() {
    }

    public UserRequest requestAccessToken(String username, String password) throws ApiException {
        LoginRequest request = new LoginRequest();
        request.setUsername(username.trim());
        request.setPassword(password.trim());
        return AuthManagementClient.getNewInstance().requestAccessToken(request);
    }

    public void setBasePath(String basePath) {
        AuthManagementClient.setBasePath(basePath);
    }

    public UserArray getAllUsers() throws ApiException {
        Token token = TokenRegistry.getToken();
        return AuthManagementClient.getNewInstance().getAllUsers(token);
    }

    public void createUser(String username, String password, Long rights) throws ApiException {
        Token token = TokenRegistry.getToken();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRights(rights);
        user.setId(1L);
        UserRequest userRequest = new UserRequest();
        userRequest.setToken(token);
        userRequest.setUser(user);
        AuthManagementClient.getNewInstance().createUser(userRequest);
    }

//    public void deleteUser(UserSimpleProperty deleteMe) throws ApiException {
//        Token token = TokenRegistry.getToken();
//        User user = new User();
//        user.setUsername(deleteMe.getName().getValue());
//        user.setPassword(deleteMe.getPassword().getValue());
//        user.setId(deleteMe.getId().getValue());
//        user.setRights(deleteMe.getRights().getValue());
//        UserRequest userRequest = new UserRequest();
//        userRequest.setToken(token);
//        userRequest.setUser(user);
//        AuthManagementClient.getNewInstance().deleteUser(userRequest);
//    }

    public void editUser(String username, String password, Long rights, Long id) throws ApiException {
        Token token = TokenRegistry.getToken();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRights(rights);
        user.setId(id);
        UserRequest userRequest = new UserRequest();
        userRequest.setToken(token);
        userRequest.setUser(user);
        AuthManagementClient.getNewInstance().editUser(userRequest);
    }

}
