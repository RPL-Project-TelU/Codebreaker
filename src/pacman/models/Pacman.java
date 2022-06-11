package pacman.models;
import java.awt.Image;
import java.util.Objects;

public class Pacman extends Character {
    private Image up, down, left, right;


    public Pacman() {
    }


    public Pacman(Image up, Image down, Image left, Image right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public Image getUp() {
        return this.up;
    }

    public void setUp(Image up) {
        this.up = up;
    }

    public Image getDown() {
        return this.down;
    }

    public void setDown(Image down) {
        this.down = down;
    }

    public Image getLeft() {
        return this.left;
    }

    public void setLeft(Image left) {
        this.left = left;
    }

    public Image getRight() {
        return this.right;
    }

    public void setRight(Image right) {
        this.right = right;
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
        Pacman pacman = (Pacman) o;
        return Objects.equals(up, pacman.up) && Objects.equals(down, pacman.down) && Objects.equals(left, pacman.left) && Objects.equals(right, pacman.right);
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
