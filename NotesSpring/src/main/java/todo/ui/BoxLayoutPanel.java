package todo.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BoxLayoutPanel extends JPanel {
    private List<Component> panelComponents;
    private int axis;

    public void setPanelComponents(List<Component> panelComponents) {
        this.panelComponents = panelComponents;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    public void init() {
        setLayout(new BoxLayout(this, axis));
        for (Component component : panelComponents
                ) {
            add(component);
        }
    }
}
