package com.noobdev.gilang.model;

//Tanggal : 18 mei 2019
//NIM : 10116105
//Nama : Gilang M
//Kelas : AKB 3

import com.noobdev.gilang.R;

public enum  ModelObject {
    RED(R.string.red, R.layout.view_red),
    BLUE(R.string.blue, R.layout.view_blue),
    GREEN(R.string.green, R.layout.view_green);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
