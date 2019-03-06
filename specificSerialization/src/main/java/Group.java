import java.util.ArrayList;
import java.util.List;

public class Group {
    private static StringBuilder sb = new StringBuilder();
    private List<Figure> figures = new ArrayList();
    private List<Group> childGroups = new ArrayList();

    public void addAll(Group... groups) {
        for (Group g : groups) {
            childGroups.add(g);
        }
    }

    public void addFigures(Figure... figures) {
        for (Figure f : figures) {
            this.figures.add(f);
        }
    }

    public void remove(Figure figure) {
        figures.remove(figure);
    }

    public static String getSb() {
        return sb.toString();
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public List<Group> getChildGroups() {
        return childGroups;
    }
}
