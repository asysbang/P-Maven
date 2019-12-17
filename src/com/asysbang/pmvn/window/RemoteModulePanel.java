package com.asysbang.pmvn.window;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class RemoteModulePanel extends JPanel {

    private static final int COLUMN_NUM = 4;
    private static final String[] COLUMN_NAMES = {"Name", "Api", "Version", "State"};
    public RemoteModulePanel() {
        initScrollTable();
    }

    private void initScrollTable() {
        JTable dataTable = new JTable(dataModel) {
        };
        dataTable.setRowHeight(33);
        dataTable.setShowVerticalLines(false);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(dataTable);
        add(scroll, BorderLayout.CENTER);
    }

    AbstractTableModel dataModel = new AbstractTableModel() {
        @Override
        public int getRowCount() {
            return 1110;
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NUM;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return "data:" + rowIndex;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }
    };
}
