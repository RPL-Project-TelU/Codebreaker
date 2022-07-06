package pacman.models;

import java.awt.Image;
import java.util.Objects;

public class Ghost extends Character {
    public static Image image;

    public Ghost() {
    }

    public Ghost(int x, int y, int dx, int dy, int speed) {
        super(x, y, dx, dy, speed);
    }

    public Image getImage() {
        return Ghost.image;
    }

    public void setImage(Image image) {
        Ghost.image = image;
    }

    public Ghost image(Image image) {
        setImage(image);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ghost)) {
            return false;
        }
        return Objects.equals(image, Ghost.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(image);
    }

    @Override
    public String toString() {
        return "{" +
                " x='" + getX() + "'\n" +
                ", y='" + getY() + "'\n" +
                ", dx='" + getDx() + "'\n" +
                ", dy='" + getDy() + "'\n" +
                ", speed='" + getSpeed() + "'\n" +
                " image='" + getImage() + "'\n" +
                "}";
    }

}
