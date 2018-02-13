package todo.listeners;

import java.awt.event.ActionEvent;

public class DeleteRowListener extends AbstractActionListener {
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1 || table.isEditing()) {
            return;
        }
        list.remove(selectedRow);
        table.revalidate();
    }
}
