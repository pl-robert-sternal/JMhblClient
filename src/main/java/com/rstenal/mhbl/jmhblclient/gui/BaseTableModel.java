package com.rstenal.mhbl.jmhblclient.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class BaseTableModel<T> extends AbstractTableModel {

    protected final List<T> dataQueue;

    public BaseTableModel() {
        this(null);
    }
    
    public BaseTableModel(List<T> data) {
        this.dataQueue = (data != null ? data : new ArrayList<>());
    }

    public void setData(List<T> data) {
        this.dataQueue.clear();
        dataQueue.stream().forEach((bp) -> {
            this.dataQueue.add(bp);
        });
    }
}
