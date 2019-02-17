import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private List<Figure> list = new ArrayList();
    private List<Group> childGroups = new ArrayList();

    public void addAll(Group... groups) {
        for (Group g : groups) {
            childGroups.add(g);
        }
    }

    public void addFigures(Figure... figures) {
        for (Figure f : figures) {
            list.add(f);
        }
    }

    public void remove(Figure figure) {
        list.remove(figure);
    }

    public static String getSb() {
        return sb.toString();
    }

    public List<Figure> getList() {
        return list;
    }

    public List<Group> getChildGroups() {
        return childGroups;
    }

}
