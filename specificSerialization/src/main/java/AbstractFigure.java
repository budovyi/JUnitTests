public abstract class AbstractFigure implements Figure {

    private String color;
    private int size;

    public AbstractFigure(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public abstract void draw();

    public abstract void fill(String color);

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
