package com.example.recycle_app.Model;

public class ItemData {
    private String itemName;
    private String itemOwner;
    private int itemImage;

    public ItemData(String itemName, String itemOwner, int itemImage){
        this.itemName = itemName;
        this.itemOwner = itemOwner;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }
}
