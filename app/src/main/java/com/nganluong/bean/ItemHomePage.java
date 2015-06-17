package com.nganluong.bean;

/**
 * Created by DucChinh on 6/17/2015.
 */
public class ItemHomePage {

    private String mNameItem;
    private int mIconItem;

    public ItemHomePage() {

    }

    public ItemHomePage(String mNameItem, int mIconItem) {
        this.mNameItem = mNameItem;
        this.mIconItem = mIconItem;
    }

    public void setNameItem(String mNameItem) {
        this.mNameItem = mNameItem;
    }

    public String getNameItem() {
        return mNameItem;
    }

    public void setIconItem(int mIconItem) {
        this.mIconItem = mIconItem;
    }

    public int getIconItem() {
        return mIconItem;
    }
}
