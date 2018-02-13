package todo.listeners;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class AbstractActionListener implements ActionListener {
    protected JTable table;
    protected List<String> list;

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
