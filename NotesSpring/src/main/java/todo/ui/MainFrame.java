package todo.ui;

import javax.swing.*;

public class MainFrame extends JFrame {
    public void init() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
        setState(NORMAL);

        show();
    }
}
