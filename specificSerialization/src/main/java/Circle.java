public class Circle extends AbstractFigure {

    public Circle(String color, int size) {
        super(color, size);
    }

    @Override
    public void draw() {
        System.out.println("imagine like we drawed a Circle!");
        System.out.println("Width is: " + getSize());
        System.out.println("radius is: " + (getSize() / 2));
    }

    @Override
    public void fill(String color) {
        System.out.printf("and we fill it with %s color", color);
        System.out.println("\n");
    }
}
