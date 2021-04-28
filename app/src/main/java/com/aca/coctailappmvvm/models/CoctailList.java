package com.aca.coctailappmvvm.models;

import com.aca.coctailappmvvm.adapters.CoctailListJSONadapter;
import com.google.gson.annotations.JsonAdapter;

import java.util.ArrayList;
import java.util.List;

@JsonAdapter(CoctailListJSONadapter.class)
public class CoctailList {


    public List<Coctail> coctailList;


    public CoctailList() {
     coctailList = new ArrayList<>();
    }
}
