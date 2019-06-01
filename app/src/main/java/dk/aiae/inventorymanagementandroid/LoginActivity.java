package dk.aiae.inventorymanagementandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dk.aiae.handlers.AuthManagementHandler;
import dk.aiae.handlers.ProductManagementHandler;
import dk.aiae.logic.TokenRegistry;
import io.swagger.client.ApiException;
import io.swagger.client.model.UserRequest;


public class LoginActivity extends AppCompatActivity {

    private EditText passwordTextField;
    private EditText userNameTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        AuthManagementHandler.getInstance().setBasePath("http://192.168.0.166:30000/authenticationManagement"); // if servers are running local network change this ip to your ipv4 address
        ProductManagementHandler.getInstance().setBasePath("http://192.168.0.166:31000/productManagement"); // if servers are running local network change this ip to your ipv4 address
        userNameTextField =(EditText)findViewById(R.id.userNameTextField);
        passwordTextField =(EditText)findViewById(R.id.passwordTextField);

        ((Button) findViewById(R.id.loginButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    redirectToInventoryPage();
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void redirectToInventoryPage() throws ApiException {
        final Intent intent = new Intent(this, InventoryActivity.class);
        if(!TextUtils.isEmpty(userNameTextField.getText())&& !TextUtils.isEmpty(passwordTextField.getText())) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        UserRequest userRequest = AuthManagementHandler.getInstance().requestAccessToken(userNameTextField.getText().toString().trim(), passwordTextField.getText().toString().trim());
                        TokenRegistry.addToken(userRequest.getToken());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(intent);
                            }
                        });
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.setName("Login thread");
            t1.setDaemon(true);
            t1.start();
        }
    }
}
