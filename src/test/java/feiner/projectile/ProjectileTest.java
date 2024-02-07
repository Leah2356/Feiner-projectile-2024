package feiner.projectile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectileTest {

    @Test
    public void testGetX() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getX();

        // then
        assertEquals(150.43, actual, 0.01);
    }

    @Test
    public void testGetY() {
        // given
        Projectile projectile = new Projectile(31, 65);
        projectile.setSeconds(2.7);

        // when
        double actual = projectile.getY();

        // then
        assertEquals(54.66, actual, 0.01);
    }

    @Test
    public void testGetApexTime() {
        // given
        Projectile projectile = new Projectile(31, 65);


        // when
        double actual = projectile.getApexTime();

        // then
        assertEquals(3.41, actual, 0.01);
    }
    @Test
    public void testGetPeakY() {
        // given
        Projectile projectile = new Projectile(31, 65);


        // when
        double actual = projectile.getPeakY();

        // then
        assertEquals(57.18, actual, 0.01);
    }
}
