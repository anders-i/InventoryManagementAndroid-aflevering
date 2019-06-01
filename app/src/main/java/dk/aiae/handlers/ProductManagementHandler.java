package dk.aiae.handlers;

import android.widget.EditText;

import dk.aiae.client.ProductManagementClient;
import dk.aiae.logic.TokenRegistry;
import io.swagger.client.ApiException;
import io.swagger.client.model.AllCategories;
import io.swagger.client.model.AllLocations;
import io.swagger.client.model.AllProductsOnLocationRequest;
import io.swagger.client.model.Barcode;
import io.swagger.client.model.CategoryRequest;
import io.swagger.client.model.EditListOfProductsRequest;
import io.swagger.client.model.EditProductRequest;
import io.swagger.client.model.GetProductRequest;
import io.swagger.client.model.Location;
import io.swagger.client.model.LocationRequest;
import io.swagger.client.model.LocationSearchRequest;
import io.swagger.client.model.Product;
import io.swagger.client.model.ProductArray;
import io.swagger.client.model.ProductRequest;
import io.swagger.client.model.SearchRequest;
import io.swagger.client.model.Token;

public class ProductManagementHandler {

    private static ProductManagementHandler instance;
    private static final Object threadLock = new Object();

    public static ProductManagementHandler getInstance() {
        if (instance == null) {
            synchronized (threadLock) {
                if (instance == null) {
                    instance = new ProductManagementHandler();
                }
            }
        }
        return instance;
    }

    private ProductManagementHandler() {
    }

    public void setBasePath(String basePath) {
        ProductManagementClient.setBasePath(basePath);
    }

    public void createProduct(String name, String category, String location, String color, int amount, long barcode, boolean mustBeRestocked, boolean canBeRestocked, int minAmount) throws ApiException {
        Product product = new Product();
        Token token = TokenRegistry.getToken();
        ProductRequest productRequest = new ProductRequest();

        product.setName(name);
        product.setLocation(location);
        product.setCategory(category);
        product.setColor(color);
        product.setAmount(amount);
        product.setBarcode(barcode);
        product.setMustBeRestock(mustBeRestocked);
        product.setCanBeRestock(canBeRestocked);
        product.setMinAmount(minAmount);
        productRequest.setProduct(product);
        productRequest.setToken(token);
        ProductManagementClient.getNewInstance().createProduct(productRequest);
    }

    public Product getProduct(Long barcode) throws ApiException {
        Barcode barcodeObject = new Barcode();
        barcodeObject.barcodeID(barcode);
        Token token = TokenRegistry.getToken();
        GetProductRequest getProductRequest = new GetProductRequest();
        getProductRequest.setProduct(barcodeObject);
        getProductRequest.setToken(token);
        return ProductManagementClient.getNewInstance().getProduct(getProductRequest);
    }

    public void editProduct(String name, String category, String location, String color, int amount, long barcode, boolean mustBeRestocked, boolean canBeRestocked, int minAmount, Long oldBarcode) throws ApiException {
        Product product = new Product();
        Barcode oldBarcodeObject = new Barcode();
        oldBarcodeObject.setBarcodeID(oldBarcode);
        Token token = TokenRegistry.getToken();
        EditProductRequest editProductRequest = new EditProductRequest();
        product.setName(name);
        product.setLocation(location);
        product.setCategory(category);
        product.setColor(color);
        product.setAmount(amount);
        product.setBarcode(barcode);
        product.setMustBeRestock(mustBeRestocked);
        product.setCanBeRestock(canBeRestocked);
        product.setMinAmount(minAmount);
        editProductRequest.setEditedProduct(product);
        editProductRequest.setOldBarcode(oldBarcodeObject);
        editProductRequest.setToken(token);
        ProductManagementClient.getNewInstance().editProduct(editProductRequest);
    }

    public void moveListOffProducts(ProductArray moveThisListOfProducts, long newLocationBarcodeLong) throws ApiException {
        Token token = TokenRegistry.getToken();
        Barcode newLocationBarcode = new Barcode();
        newLocationBarcode.setBarcodeID(newLocationBarcodeLong);
        EditListOfProductsRequest editListOfProductsRequest = new EditListOfProductsRequest();
        editListOfProductsRequest.setNewLocationBarcode(newLocationBarcode);
        editListOfProductsRequest.setProductList(moveThisListOfProducts);
        editListOfProductsRequest.setToken(token);
        ProductManagementClient.getNewInstance().moveListOffProducts(editListOfProductsRequest);
    }

    public ProductArray searchProducts(EditText editText) throws ApiException {
        Token token = TokenRegistry.getToken();
        SearchRequest sr = new SearchRequest();
        sr.setSearchString(editText.getText().toString());
        sr.setToken(token);
        return ProductManagementClient.getNewInstance().searchProduct(sr);
    }

//    public void deleteProduct(ProductSimpleProperty deleteMe) throws ApiException {
//        ProductRequest productRequest = new ProductRequest();
//        Token token = TokenRegistry.getToken();
//        Product product = new Product();
//        product.setName(deleteMe.getName().getValue());
//        product.setLocation(deleteMe.getLocation().getValue());
//        product.setCategory(deleteMe.getCategory().getValue());
//        product.setColor(deleteMe.getColor().getValue());
//        product.setAmount(deleteMe.getAmount().getValue());
//        product.setBarcode(deleteMe.getBarcode().getValue());
//        product.setMustBeRestock(deleteMe.getMustBeRestocked().getValue());
//        product.setCanBeRestock(deleteMe.getCanBeRestocked().getValue());
//        product.setMinAmount(deleteMe.getMinAmount().getValue());
//        productRequest.setProduct(product);
//        productRequest.setToken(token);
//        ProductManagementClient.getNewInstance().deleteProduct(productRequest);
//    }

    public void addNewCategory(CategoryRequest categoryRequest) throws ApiException {
        categoryRequest.setToken(TokenRegistry.getToken());
        ProductManagementClient.getNewInstance().addNewCategory(categoryRequest);
    }

    public AllCategories getAllCategories() throws ApiException {
        Token token = TokenRegistry.getToken();
        return ProductManagementClient.getNewInstance().getAllCategories(token);
    }

    public AllLocations getAllLocations() throws ApiException {
        Token token = TokenRegistry.getToken();
        return ProductManagementClient.getNewInstance().getAllLocations(token);
    }

    public Barcode generateBarcodeProduct() throws ApiException {
        Token token = TokenRegistry.getToken();
        return ProductManagementClient.getNewInstance().generateBarcodeProduct(token);
    }

    public ProductArray getAllProducts() throws ApiException {
        Token token = TokenRegistry.getToken();
        return ProductManagementClient.getNewInstance().getAllProducts(token);
    }

    public void addLocation(String locationName) throws ApiException {
        Location location = new Location();
        location.setName(locationName.trim());
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setLocation(location);
        locationRequest.setToken(TokenRegistry.getToken());
        ProductManagementClient.getNewInstance().addLocation(locationRequest);
    }

//    public void deleteLocation(LocationSimpleProperty deleteMe) throws ApiException {
//        LocationRequest locationRequest = new LocationRequest();
//        locationRequest.setString(deleteMe.getLocation().getValue());
//        locationRequest.setToken(TokenRegistry.getToken());
//        ProductManagementClient.getNewInstance().deleteLocation(locationRequest);
//    }

    public ProductArray getAllProductsOnLocation(Long locationBarcodeLong) throws ApiException {
        Token token = TokenRegistry.getToken();
        Barcode locationBarcode = new Barcode();
        locationBarcode.setBarcodeID(locationBarcodeLong);
        AllProductsOnLocationRequest allProductsOnLocationRequest = new AllProductsOnLocationRequest();
        allProductsOnLocationRequest.setLocation(locationBarcode);
        allProductsOnLocationRequest.setToken(token);
        return ProductManagementClient.getNewInstance().getAllProductsOnLocation(allProductsOnLocationRequest);
    }

    public AllLocations searchLocation(String searchString) throws ApiException {
        Token token = TokenRegistry.getToken();
        LocationSearchRequest lsr = new LocationSearchRequest();
        lsr.setString(searchString);
        lsr.setToken(token);
        return ProductManagementClient.getNewInstance().searchLocation(lsr);
    }
}
