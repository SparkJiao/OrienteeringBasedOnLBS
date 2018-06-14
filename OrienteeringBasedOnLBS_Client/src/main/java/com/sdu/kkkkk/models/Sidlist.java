package com.sdu.kkkkk.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/6/12.
 */
public class Sidlist {

    private List<String> sidlist;

    public Sidlist(){
        sidlist = new ArrayList<>();
    }

    public List<String> getSidlist() {
        return sidlist;
    }

    public void setSidlist(List<String> sidlist) {
        this.sidlist = sidlist;
    }
}
