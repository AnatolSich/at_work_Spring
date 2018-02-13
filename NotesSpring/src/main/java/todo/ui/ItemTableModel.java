package todo.ui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {
    private List<String> itemList;

    public int getRowCount() {
        return itemList.size();
    }

    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        return "Items";
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return itemList.get(rowIndex);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        itemList.add(rowIndex,aValue.toString());
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }
}
