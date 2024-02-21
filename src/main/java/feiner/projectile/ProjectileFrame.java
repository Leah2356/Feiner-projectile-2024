package feiner.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    static final int ANGLE_MIN = 0;
    static final int ANGLE_MAX = 90;
    static final int ANGLE_INIT = 45;
    private final JSlider angleSlider;
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JLabel calculatedLabelX;
    private final JLabel calculatedLabelY;
    private final JLabel peakY;
    private final JLabel interceptX;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(8, 2));
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");

        angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel secondsLabel = new JLabel("Seconds");
        JLabel XLabel = new JLabel("X");
        JLabel YLabel = new JLabel("Y");


        velocityField = new JTextField();
        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleSlider);

        secondsField = new JTextField("0");
        add(secondsLabel);
        add(secondsField);

        calculatedLabelX = new JLabel();
        add(XLabel);
        add(calculatedLabelX);

        calculatedLabelY = new JLabel();
        add(YLabel);
        add(calculatedLabelY);

        JLabel peakYLabel = new JLabel("Peak Y");
        peakY = new JLabel();
        add(peakYLabel);
        add(peakY);

        interceptX = new JLabel();
        JLabel interceptXLabel = new JLabel("Intercept X");
        add(interceptXLabel);
        add(interceptX);

        JLabel empty = new JLabel();
        JButton calculateButton = new JButton("Calculate");
        add(empty);
        add(calculateButton);

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update(DocumentEvent e) {
                createProjectile();
            }
        });

        angleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                createProjectile();
            }
        });

        calculateButton.addActionListener(e -> createProjectile());

    }

    private void createProjectile() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(String.valueOf(velocityField.getX()))
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        calculatedLabelX.setText(Double.toString(projectile.getX()));
        calculatedLabelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
    }
}