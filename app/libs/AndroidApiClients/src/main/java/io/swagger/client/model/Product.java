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
import java.io.IOException;

/**
 * Product
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-05-26T10:45:52.245Z")
public class Product {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Category")
  private String category = null;

  @SerializedName("Color")
  private String color = null;

  @SerializedName("CanBeRestock")
  private Boolean canBeRestock = null;

  @SerializedName("MustBeRestock")
  private Boolean mustBeRestock = null;

  @SerializedName("Location")
  private String location = null;

  @SerializedName("Amount")
  private Integer amount = null;

  @SerializedName("MinAmount")
  private Integer minAmount = null;

  @SerializedName("Barcode")
  private Long barcode = null;

  public Product name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The product name
   * @return name
  **/
  @ApiModelProperty(value = "The product name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Product category(String category) {
    this.category = category;
    return this;
  }

   /**
   * The product category
   * @return category
  **/
  @ApiModelProperty(value = "The product category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Product color(String color) {
    this.color = color;
    return this;
  }

   /**
   * The product main color
   * @return color
  **/
  @ApiModelProperty(value = "The product main color")
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Product canBeRestock(Boolean canBeRestock) {
    this.canBeRestock = canBeRestock;
    return this;
  }

   /**
   * If the product can be reordered &#x3D; true
   * @return canBeRestock
  **/
  @ApiModelProperty(value = "If the product can be reordered = true")
  public Boolean isCanBeRestock() {
    return canBeRestock;
  }

  public void setCanBeRestock(Boolean canBeRestock) {
    this.canBeRestock = canBeRestock;
  }

  public Product mustBeRestock(Boolean mustBeRestock) {
    this.mustBeRestock = mustBeRestock;
    return this;
  }

   /**
   * If the product can be reordered &#x3D; true
   * @return mustBeRestock
  **/
  @ApiModelProperty(value = "If the product can be reordered = true")
  public Boolean isMustBeRestock() {
    return mustBeRestock;
  }

  public void setMustBeRestock(Boolean mustBeRestock) {
    this.mustBeRestock = mustBeRestock;
  }

  public Product location(String location) {
    this.location = location;
    return this;
  }

   /**
   * The product location
   * @return location
  **/
  @ApiModelProperty(value = "The product location")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Product amount(Integer amount) {
    this.amount = amount;
    return this;
  }

   /**
   * The amount of the product
   * @return amount
  **/
  @ApiModelProperty(value = "The amount of the product")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Product minAmount(Integer minAmount) {
    this.minAmount = minAmount;
    return this;
  }

   /**
   * The min amount the product must be without notificaitons
   * @return minAmount
  **/
  @ApiModelProperty(value = "The min amount the product must be without notificaitons")
  public Integer getMinAmount() {
    return minAmount;
  }

  public void setMinAmount(Integer minAmount) {
    this.minAmount = minAmount;
  }

  public Product barcode(Long barcode) {
    this.barcode = barcode;
    return this;
  }

   /**
   * the product barcode
   * @return barcode
  **/
  @ApiModelProperty(value = "the product barcode")
  public Long getBarcode() {
    return barcode;
  }

  public void setBarcode(Long barcode) {
    this.barcode = barcode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.name, product.name) &&
        Objects.equals(this.category, product.category) &&
        Objects.equals(this.color, product.color) &&
        Objects.equals(this.canBeRestock, product.canBeRestock) &&
        Objects.equals(this.mustBeRestock, product.mustBeRestock) &&
        Objects.equals(this.location, product.location) &&
        Objects.equals(this.amount, product.amount) &&
        Objects.equals(this.minAmount, product.minAmount) &&
        Objects.equals(this.barcode, product.barcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, category, color, canBeRestock, mustBeRestock, location, amount, minAmount, barcode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    canBeRestock: ").append(toIndentedString(canBeRestock)).append("\n");
    sb.append("    mustBeRestock: ").append(toIndentedString(mustBeRestock)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    minAmount: ").append(toIndentedString(minAmount)).append("\n");
    sb.append("    barcode: ").append(toIndentedString(barcode)).append("\n");
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

