package com.kassa.service;

import com.kassa.dto.CheckDTO;
import com.kassa.entity.Check;

import java.util.ArrayList;
import java.util.List;

public class CheckListWrapper {

    private List<CheckDTO> checkList;

    public CheckListWrapper(List<CheckDTO> checkList) {
        this.checkList = new ArrayList<>(checkList);
    }

    public CheckListWrapper() {
        checkList = new ArrayList<>();
    }

    public List<CheckDTO> getCheckList() {
        return checkList;
    }

    public void setCheckList(List<CheckDTO> productList) {
        this.checkList = checkList;
    }
}
