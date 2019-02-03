package com.example.listviewtest;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String syamei;
    private String maker;
    private String spec;
    private String drive;


    public Item(Map<String,String> item){
        this.syamei = item.get("syamei");
        this.maker = item.get("maker");
        this.spec = item.get("spec");
        this.drive = item.get("drive");

    }


    public String getSyamei(){
        return this.syamei;
    }

    public String getMaker(){
        return maker;
    }

    public String getSpec(){
        return spec;
    }

    public String getDrive(){
        return drive;
    }

}
