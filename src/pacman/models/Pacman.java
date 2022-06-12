package pacman.models;
import java.awt.Image;
import java.util.Objects;

public class Pacman extends Character {
    public static Image up, down, left, right;


    public Pacman() {
        super.setSpeed(6);
    }

    public Pacman(int x, int y, int dx, int dy, int speed){
        super(x, y, dx, dy, speed);
    }

    public Image getUp() {
        return Pacman.up;
    }

    public void setUp(Image up) {
        Pacman.up = up;
    }

    public Image getDown() {
        return Pacman.down;
    }

    public void setDown(Image down) {
        Pacman.down = down;
    }

    public Image getLeft() {
        return Pacman.left;
    }

    public void setLeft(Image left) {
        Pacman.left = left;
    }

    public Image getRight() {
        return Pacman.right;
    }

    public void setRight(Image right) {
        Pacman.right = right;
    }

    public Pacman up(Image up) {
        setUp(up);
        return this;
    }

    public Pacman down(Image down) {
        setDown(down);
        return this;
    }

    public Pacman left(Image left) {
        setLeft(left);
        return this;
    }

    public Pacman right(Image right) {
        setRight(right);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pacman)) {
            return false;
        }
        return Objects.equals(up, Pacman.up) && Objects.equals(down, Pacman.down) && Objects.equals(left, Pacman.left) && Objects.equals(right, Pacman.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(up, down, left, right);
    }

    @Override
    public String toString() {
        return "{" +
            " up='" + getUp() + "'" +
            ", down='" + getDown() + "'" +
            ", left='" + getLeft() + "'" +
            ", right='" + getRight() + "'" +
            "}";
    }


}
