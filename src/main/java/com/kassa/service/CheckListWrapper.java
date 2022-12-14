package com.kassa.service;

import com.kassa.entity.Check;

import java.util.ArrayList;
import java.util.List;

public class CheckListWrapper {

    private List<Check> checkList;

    public CheckListWrapper(List<Check> checkList) {
        this.checkList = new ArrayList<>(checkList);
    }

    public CheckListWrapper() {
        checkList = new ArrayList<>();
    }

    public List<Check> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<Check> productList) {
        this.checkList = checkList;
    }
}
