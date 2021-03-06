/*
 * Product Management
 * Handles products, location and barcodes
 *
 * OpenAPI spec version: 0.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Barcode;
import io.swagger.client.model.ProductArray;
import io.swagger.client.model.Token;
import java.io.IOException;

/**
 * EditListOfProductsRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-26T10:45:52.245Z")
public class EditListOfProductsRequest {
  @SerializedName("productList")
  private ProductArray productList = null;

  @SerializedName("newLocationBarcode")
  private Barcode newLocationBarcode = null;

  @SerializedName("token")
  private Token token = null;

  public EditListOfProductsRequest productList(ProductArray productList) {
    this.productList = productList;
    return this;
  }

   /**
   * Get productList
   * @return productList
  **/
  @ApiModelProperty(value = "")
  public ProductArray getProductList() {
    return productList;
  }

  public void setProductList(ProductArray productList) {
    this.productList = productList;
  }

  public EditListOfProductsRequest newLocationBarcode(Barcode newLocationBarcode) {
    this.newLocationBarcode = newLocationBarcode;
    return this;
  }

   /**
   * Get newLocationBarcode
   * @return newLocationBarcode
  **/
  @ApiModelProperty(value = "")
  public Barcode getNewLocationBarcode() {
    return newLocationBarcode;
  }

  public void setNewLocationBarcode(Barcode newLocationBarcode) {
    this.newLocationBarcode = newLocationBarcode;
  }

  public EditListOfProductsRequest token(Token token) {
    this.token = token;
    return this;
  }

   /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(value = "")
  public Token getToken() {
    return token;
  }

  public void setToken(Token token) {
    this.token = token;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditListOfProductsRequest editListOfProductsRequest = (EditListOfProductsRequest) o;
    return Objects.equals(this.productList, editListOfProductsRequest.productList) &&
        Objects.equals(this.newLocationBarcode, editListOfProductsRequest.newLocationBarcode) &&
        Objects.equals(this.token, editListOfProductsRequest.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productList, newLocationBarcode, token);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditListOfProductsRequest {\n");
    
    sb.append("    productList: ").append(toIndentedString(productList)).append("\n");
    sb.append("    newLocationBarcode: ").append(toIndentedString(newLocationBarcode)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

