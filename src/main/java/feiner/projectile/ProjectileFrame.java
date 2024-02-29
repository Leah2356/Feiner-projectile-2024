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
    private ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        // tells the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(8, 2));

        angleSlider = new JSlider(JSlider.HORIZONTAL,
                ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(5);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        velocityField = new JTextField();
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        west.add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        west.add(angleSlider);

        secondsField = new JTextField("0");
        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        west.add(secondsField);

        calculatedLabelX = new JLabel();
        JLabel labelX = new JLabel("X");
        west.add(labelX);
        west.add(calculatedLabelX);

        calculatedLabelY = new JLabel();
        JLabel LabelY = new JLabel("Y");
        west.add(LabelY);
        west.add(calculatedLabelY);

        JLabel peakLabelY = new JLabel("Peak Y");
        peakY = new JLabel();
        west.add(peakLabelY);
        west.add(peakY);

        interceptX = new JLabel();
        JLabel interceptLabelX = new JLabel("Intercept X");
        west.add(interceptLabelX);
        west.add(interceptX);

        JLabel empty = new JLabel();
        JButton calculateButton = new JButton("Calculate");
        west.add(empty);
        west.add(calculateButton);

        velocityField.getDocument().addDocumentListener((SimpleDocumentListener)
                documentEvent -> createProjectile());

        angleSlider.addChangeListener(changeEvent -> createProjectile());

        calculateButton.addActionListener(actionEvent -> createProjectile());

        main.add(graph, BorderLayout.CENTER);

    }


    private void createProjectile() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(String.valueOf(velocityField.getText()))
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        calculatedLabelX.setText(Double.toString(projectile.getX()));
        calculatedLabelY.setText(Double.toString(projectile.getY()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }
}