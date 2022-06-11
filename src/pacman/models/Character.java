package pacman.models;

import java.util.Objects;

public class Character {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private int speed;


    public Character() {
    }


    public Character(int x, int y, int dx, int dy, int speed) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.speed = speed;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return this.dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Character x(int x) {
        setX(x);
        return this;
    }

    public Character y(int y) {
        setY(y);
        return this;
    }

    public Character dx(int dx) {
        setDx(dx);
        return this;
    }

    public Character dy(int dy) {
        setDy(dy);
        return this;
    }

    public Character speed(int speed) {
        setSpeed(speed);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Character)) {
            return false;
        }
        Character character = (Character) o;
        return x == character.x && y == character.y && dx == character.dx && dy == character.dy && speed == character.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dx, dy, speed);
    }

    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", dx='" + getDx() + "'" +
            ", dy='" + getDy() + "'" +
            ", speed='" + getSpeed() + "'" +
            "}";
    }

    

}
