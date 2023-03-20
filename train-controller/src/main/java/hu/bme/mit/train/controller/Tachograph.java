package hu.bme.mit.train.controller;

import java.util.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Tachograph {
    private Table<Date, Integer, Integer> data;

    public Tachograph() {
        this.data = HashBasedTable.create();
    }

    public void addData(Date n_date, int jPos, int rSpd) {
        data.put(n_date, jPos, rSpd);
    }

    public int getLength() {
        return data.size();
    }

    public boolean isEmpty(){
        if (data.size()>0) return false;
        else return true;
    }

}
