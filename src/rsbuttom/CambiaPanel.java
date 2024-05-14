package rsbuttom;

import java.awt.Dimension;
import javax.swing.JPanel;

public class CambiaPanel {
    private JPanel container;
    private JPanel content;

    public CambiaPanel() {
    }

    public CambiaPanel(JPanel container, JPanel content, int i2, int i3) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        Dimension desktopSize = this.container.getSize();
        
        this.content.setBounds(50, (desktopSize.height - i3) / 2, i2, i3);
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }

}
