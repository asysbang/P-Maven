package com.asysbang.pmvn.window;

import com.asysbang.pmvn.test.action.module.ModuleInfo;
import com.asysbang.pmvn.test.TestUtil;
import com.asysbang.pmvn.test.action.module.ModuleManager;
import com.asysbang.pmvn.util.Log;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.List;

public class RemoteModulePanel extends JPanel {

    private static final int COLUMN_NUM = 4;
    private static final String[] COLUMN_NAMES = {"Name", "Api", "Version", "State"};
    private final ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };
    private BottomPanel mBottomPanel;
    private JTable dataTable;
    private ListSelectionListener selectionListener = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                Log.d("getValueIsAdjusting: ");
            } else {
                int selectedRow = dataTable.getSelectedRow();
                Log.d("selectedRow: "+selectedRow);
                mBottomPanel.setButtonState(0);
            }
        }
    };

    private List<ModuleInfo> infos;

    public RemoteModulePanel() {
        //this should be  shown in progressbar
        ModuleManager moduleManager = ModuleManager.getInstance();
        while (!moduleManager.isLoaded()) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        infos = ModuleManager.getInstance().getModules();
        initScrollTable();
    }

    private void initScrollTable() {
        dataTable = new JTable(dataModel) {
        };
        dataTable.setRowHeight(33);
        dataTable.setShowVerticalLines(false);
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dataTable.getSelectionModel().addListSelectionListener(selectionListener);
        setLayout(new BorderLayout());
        JScrollPane scroll = new JScrollPane(dataTable);
        add(scroll, BorderLayout.CENTER);
        mBottomPanel = new BottomPanel();
        add(mBottomPanel, BorderLayout.SOUTH);
    }

    AbstractTableModel dataModel = new AbstractTableModel() {
        @Override
        public int getRowCount() {
            return infos.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NUM;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ModuleInfo info = infos.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return info.getName();
                case 1:
                    return info.getApi();
                case 2:
                    return info.getVersion();
                case 3:
                    return info.getState();
                default:
                    return "NULL";
            }
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }
    };

    private class BottomPanel extends JPanel {
        private JButton mDownloadButton;
        private JButton mRemoveButton;
        public BottomPanel() {
            mDownloadButton = new JButton("Download");
            mDownloadButton.addActionListener(btnListener);
            mRemoveButton = new JButton("Remove");
            add(mDownloadButton);
            add(mRemoveButton);
            mDownloadButton.setEnabled(false);
            mRemoveButton.setEnabled(false);
            setBorder(new LineBorder(Color.darkGray));
        }
        public void setButtonState(int state) {
            boolean b1 = new Random().nextBoolean();
            boolean b2 = new Random().nextBoolean();
            mDownloadButton.setEnabled(b1);
            mRemoveButton.setEnabled(b2);
        }
    }
}
