public class Square extends AbstractFigure {

    public Square(String color, int size) {
        super(color, size);
    }

    @Override
    public void draw() {
        System.out.println("imagine like we drawed a Square!");
        System.out.println("size is:     " + getSize() + " x " + getSize());

    }

    @Override
    public void fill(String color) {
        System.out.printf("and we fill it with %s color", color);
        System.out.println("\n");
    }
}
