package hexaware1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {

    private String productName;
    private Double up;
    private int stockQty;

    public Product(String productName, Double up, int stockQty) {
        this.productName = productName;
        this.up = up;
        this.stockQty = stockQty;
    }

    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUp() {
        return up;
    }

    public void setUp(Double up) {
        this.up = up;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    @Override
    public String toString() {
        return "Product [productName=" + productName + ", up=" + up + ", stockQty=" + stockQty + "]";
    }
}
