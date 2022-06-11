package pacman.models;
import java.awt.Image;
import java.util.Objects;

public class Ghost extends Character{
    private Image image;


    public Ghost() {
    }

    public Ghost(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
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
        Ghost ghost = (Ghost) o;
        return Objects.equals(image, ghost.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(image);
    }

    @Override
    public String toString() {
        return "{" +
            " image='" + getImage() + "'" +
            "}";
    }

}
