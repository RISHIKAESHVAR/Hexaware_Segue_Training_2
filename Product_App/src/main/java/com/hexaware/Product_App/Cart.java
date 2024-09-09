package com.hexaware.Product_App;

public class Cart {
    private Product product;
    private int qty;
    private double totalBill;

    public Cart() {
    }

    public Cart(Product product, int qty) {
        this.product = product;
        this.qty = qty;
        this.totalBill = product.getPrice() * qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        this.totalBill = product.getPrice() * qty;
    }

    public double getTotalBill() {
        return totalBill;
    }

    @Override
    public String toString() {
        return "Cart[product=" + product + ", qty=" + qty + ", totalBill=" + totalBill + "]";
    }
}

