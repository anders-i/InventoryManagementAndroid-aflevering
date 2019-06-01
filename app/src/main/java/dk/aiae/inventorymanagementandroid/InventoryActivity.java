package dk.aiae.inventorymanagementandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dk.aiae.handlers.ProductManagementHandler;
import io.swagger.client.ApiException;
import io.swagger.client.model.ProductArray;

public class InventoryActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProducts;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ProductArray productArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory);
        layoutManager = new LinearLayoutManager(this);

        setAllProductsIntoList();

        ((Button) findViewById(R.id.searchButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchProducts();
            }
        });
    }

    private void searchProducts() {
        final EditText searchTextfield = (EditText) findViewById(R.id.searchTextField);
        if (!TextUtils.isEmpty(searchTextfield.getText())) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        productArray = ProductManagementHandler.getInstance().searchProducts(searchTextfield);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                recyclerViewProducts = (RecyclerView) findViewById(R.id.recyclerView);
                                recyclerViewProducts.setHasFixedSize(true);
                                recyclerViewProducts.setLayoutManager(layoutManager);
                                adapter = new ProductAdapter(productArray);
                                recyclerViewProducts.setAdapter(adapter);
                            }
                        });
                    } catch (ApiException e) {
                        e.printStackTrace();
                    }
                }
            });
            t1.setName("test search in products thread");
            t1.setDaemon(true);
            t1.start();
        } else {
            setAllProductsIntoList();
        }
    }

    private void setAllProductsIntoList() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    productArray = ProductManagementHandler.getInstance().getAllProducts();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerViewProducts = (RecyclerView) findViewById(R.id.recyclerView);
                            recyclerViewProducts.setHasFixedSize(true);
                            recyclerViewProducts.setLayoutManager(layoutManager);
                            adapter = new ProductAdapter(productArray);
                            recyclerViewProducts.setAdapter(adapter);
                        }
                    });
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setName("set all products thread");
        t1.setDaemon(true);
        t1.start();
    }
}
