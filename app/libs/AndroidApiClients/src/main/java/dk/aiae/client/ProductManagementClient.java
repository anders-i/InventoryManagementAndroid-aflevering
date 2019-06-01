/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.aiae.client;

import com.squareup.okhttp.OkHttpClient;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.api.BarcodeApi;
import io.swagger.client.api.LocationApi;
import io.swagger.client.api.ProductApi;
import io.swagger.client.model.AllCategories;
import io.swagger.client.model.AllLocations;
import io.swagger.client.model.AllProductsOnLocationRequest;
import io.swagger.client.model.Barcode;
import io.swagger.client.model.CategoryRequest;
import io.swagger.client.model.EditListOfProductsRequest;
import io.swagger.client.model.EditProductRequest;
import io.swagger.client.model.GetProductRequest;
import io.swagger.client.model.LocationRequest;
import io.swagger.client.model.LocationSearchRequest;
import io.swagger.client.model.Product;
import io.swagger.client.model.ProductArray;
import io.swagger.client.model.ProductRequest;
import io.swagger.client.model.SearchRequest;
import io.swagger.client.model.Token;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author As
 */
public class ProductManagementClient {

    private ApiClient client;
    private ProductApi productApi;
    private LocationApi locationApi;
    private BarcodeApi barcodeApi;
    private static String basePath;

    private ProductManagementClient(String basePath) {
        client = new ApiClient();
        client.setBasePath(basePath);
        OkHttpClient httpClient = client.getHttpClient();
        httpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        httpClient.setReadTimeout(60, TimeUnit.SECONDS);
        httpClient.setWriteTimeout(60, TimeUnit.SECONDS);
        productApi = new ProductApi(client);
        locationApi = new LocationApi(client);
        barcodeApi = new BarcodeApi(client);
    }
    
    public static void setBasePath(String newBasePath) {
        basePath = newBasePath;
    }

    public static ProductManagementClient getNewInstance() {
        return new ProductManagementClient(basePath);
    }

    public void createProduct(ProductRequest productRequest) throws ApiException{
        productApi.addProduct(productRequest);
    }
    
    public Product getProduct(GetProductRequest getProductRequest) throws ApiException {
        return productApi.getProduct(getProductRequest);
    }
    
    public void editProduct(EditProductRequest editProductRequest) throws ApiException {
        productApi.editProduct(editProductRequest);
    }
    
    public ProductArray searchProduct(SearchRequest searchRequest) throws ApiException {
        return productApi.searchProducts(searchRequest);
    }
    
    public void deleteProduct(ProductRequest productRequest) throws ApiException {
        productApi.deleteProduct(productRequest);
    }
    
    public void addNewCategory(CategoryRequest categoryRequest) throws ApiException {
        productApi.addCategory(categoryRequest);
    }
    
    public AllCategories getAllCategories(Token token) throws ApiException{
        return productApi.getAllCategories(token);
    }
    
    public ProductArray getAllProducts(Token token) throws ApiException {
        return productApi.getAllProducts(token);
    }
    
    public void moveListOffProducts(EditListOfProductsRequest editListOfProductsRequest) throws ApiException {
        productApi.editLocationOnMultipleProducts(editListOfProductsRequest);
    }

    public ProductArray getAllProductsOnLocation(AllProductsOnLocationRequest allProductsOnLocationRequest) throws ApiException {
        return productApi.getAllProductsOnLocation(allProductsOnLocationRequest);
    }
    
    public Barcode generateBarcodeProduct(Token token) throws ApiException{
        return barcodeApi.generateBarcodeProduct(token);
    }
    
    public AllLocations getAllLocations(Token token) throws ApiException {
        return locationApi.getAllLocations(token);
    }

    public void addLocation(LocationRequest locationRequest) throws ApiException {
        locationApi.addLocation(locationRequest);
    }
    
    public void deleteLocation(LocationRequest deleteMe) throws ApiException {
        locationApi.deleteLocation(deleteMe);
    }
    
    public AllLocations searchLocation(LocationSearchRequest locationSearchRequest) throws ApiException {
        return locationApi.searchLocation(locationSearchRequest);
    }
    
}