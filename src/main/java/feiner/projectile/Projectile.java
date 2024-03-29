package feiner.projectile;

public class Projectile {
    // class is a way to organize code
    // private means not accessible outside the class, limited scope
    private double angle;
    private final double radians;
    private final double velocity;
    private double seconds;
    private static final double GRAVITY = 9.8;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds
                - (.5 * 9.8 * (seconds * seconds));
    }

    /**
     * @return the time when the Projectile is at its highest point.
     */
    public double getApexTime() {
        return velocity * Math.sin(radians) / 9.8;
    }

    /**
     * @return the highest Y value of projectile
     */
    public double getPeakY() {
        return (Math.sin(radians) * velocity) * (Math.sin(radians) * velocity) / (GRAVITY * 2);
    }

    /**
     * @return the formula for the X intercept
     */
    public double getInterceptX() {
        double time = 2 * (Math.sin(radians)) * velocity / GRAVITY;

        return Math.cos(radians) * velocity * time;
    }
}