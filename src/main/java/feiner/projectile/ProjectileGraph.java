package feiner.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {
    private Projectile projectile = new Projectile(0, 0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());
        g.setColor(Color.BLACK);
        projectile.setSeconds(0);

        for (int i = 0; i <= projectile.getApexTime() * 2 + 1; i++) {
            int currX = (int) projectile.getX();
            int currY = (int) projectile.getY();
            projectile.setSeconds(i);
            g.drawLine(currX, -currY, (int) projectile.getX(), -(int) projectile.getY());
        }
        g.setColor(Color.BLUE);
        g.fillOval((int) projectile.getInterceptX() / 2 - 4, (int) -projectile.getPeakY() - 4, 8, 8);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        // this tells the operating system to call paintComponent() again.
        repaint();

    }
}
