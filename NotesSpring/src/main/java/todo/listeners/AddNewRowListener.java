package todo.listeners;

import java.awt.event.ActionEvent;

public class AddNewRowListener extends AbstractActionListener {
    public void actionPerformed(ActionEvent e) {
        if (table.isEditing()) {
            return;
        }
        list.add("New item");
        table.revalidate();
    }
}
