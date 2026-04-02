package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VelocityTest {
    private int normalize(int direction) {
        int d = direction % 360;
        return d < 0 ? d + 360 : d;
    }

    // reverseX = mirror across y-axis
    private int mirrorX(int direction) {
        return normalize(180 - direction);
    }

    @Test
    void setDirectionTest() {
        Velocity v = new Velocity(5, 0);   // speed=5, east/right

        v.setDirection(90);                // turn to north/up

        assertEquals(5, v.getSpeed());
        assertEquals(90, v.getDirection());
        assertEquals(0, v.getSpeedX());
        assertEquals(5, v.getSpeedY());
    }

    @Test
    void setSpeedTest() {
        Velocity v = new Velocity(3, 180); // speed=3, west/left

        v.setSpeed(7);

        assertEquals(7, v.getSpeed());
        assertEquals(180, v.getDirection());
        assertEquals(-7, v.getSpeedX());
        assertEquals(0, v.getSpeedY());
    }

    @Test
    void reverseTest_fromEast() {
        Velocity v = new Velocity(5, 0);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverse();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(normalize(oldDir + 180), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(-oldY, v.getSpeedY());
    }

    @Test
    void reverseTest_fromNorth() {
        Velocity v = new Velocity(6, 90);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverse();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(normalize(oldDir + 180), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(-oldY, v.getSpeedY());
    }

    @Test
    void reverseTest_fromWest() {
        Velocity v = new Velocity(7, 180);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverse();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(normalize(oldDir + 180), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(-oldY, v.getSpeedY());
    }

    @Test
    void reverseTest_fromSouth() {
        Velocity v = new Velocity(8, 270);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverse();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(normalize(oldDir + 180), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(-oldY, v.getSpeedY());
    }

    @Test
    void reverseTest_fromDiagonal45() {
        Velocity v = new Velocity(10, 45);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverse();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(normalize(oldDir + 180), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(-oldY, v.getSpeedY());
    }

    @Test
    void reverseXTest_fromEast() {
        Velocity v = new Velocity(5, 0);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverseX();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(mirrorX(oldDir), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(oldY, v.getSpeedY());
    }

    @Test
    void reverseXTest_fromWest() {
        Velocity v = new Velocity(5, 180);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverseX();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(mirrorX(oldDir), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(oldY, v.getSpeedY());
    }

    @Test
    void reverseXTest_fromNorth() {
        Velocity v = new Velocity(5, 90);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverseX();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(mirrorX(oldDir), v.getDirection());
        assertEquals(-oldX, v.getSpeedX()); // should still be 0
        assertEquals(oldY, v.getSpeedY());
    }

    @Test
    void reverseXTest_fromSouth() {
        Velocity v = new Velocity(5, 270);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverseX();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(mirrorX(oldDir), v.getDirection());
        assertEquals(-oldX, v.getSpeedX()); // should still be 0
        assertEquals(oldY, v.getSpeedY());
    }

    @Test
    void reverseXTest_fromDiagonal45() {
        Velocity v = new Velocity(10, 45);

        int oldSpeed = v.getSpeed();
        int oldDir = v.getDirection();
        int oldX = v.getSpeedX();
        int oldY = v.getSpeedY();

        v.reverseX();

        assertEquals(oldSpeed, v.getSpeed());
        assertEquals(mirrorX(oldDir), v.getDirection());
        assertEquals(-oldX, v.getSpeedX());
        assertEquals(oldY, v.getSpeedY());
    }
}
