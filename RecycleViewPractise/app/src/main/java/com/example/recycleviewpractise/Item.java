package com.example.recycleviewpractise;

public class Item {
    int itemIcon;
    String Primary, decription;

    public int getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(int itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getPrimary() {
        return Primary;
    }

    public void setPrimary(String primary) {
        Primary = primary;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Item(int itemIcon, String primary, String decription) {
        this.itemIcon = itemIcon;
        this.Primary = primary;
        this.decription = decription;
    }
}
