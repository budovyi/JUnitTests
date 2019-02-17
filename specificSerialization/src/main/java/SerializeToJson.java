import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeToJson {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private static final String TAB = "\t";
    private static final String NUW = "\n";
    private static String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> list = new ArrayList();

    public static String serialize(Group group) {
        toJson(group);
        return sb.toString();
    }

    private static void toJson(Group group) {
        childGroups = group.getChildGroups();
        list = group.getList();
        Class clazz;

        for (Figure figure : list) {
            clazz = figure.getClass();
            String tabRepeat = String.join("", Collections.nCopies(count, TAB));

            sb.append(tabRepeat).append("{\n");
            sb.append(tabRepeat).append("\"").append(clazz.getName()).append("\" : ").append("{");
            for (Field f : clazz.getDeclaredFields().length < clazz.getSuperclass().getDeclaredFields().length ?
                    clazz.getSuperclass().getDeclaredFields() :
                    clazz.getDeclaredFields()) {
                f.setAccessible(true);
                String value = null;
                try {
                    value = String.valueOf(f.get(figure));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                // json build logic
                sb.append(NUW + TAB).append(tabRepeat)
                .append("\"").append(f.getName()).append("\": ")
                .append("\"").append(value).append("\",");
            }

            for (Method met : clazz.getDeclaredMethods()) {
                sb.append(NUW + TAB).append(tabRepeat).append("\"")
                .append(met.getName()).append("\" : {");
                sb.append(NUW + TAB).append(tabRepeat).append("}\n");
            }
            sb.append(tabRepeat).append("}\n");
        }
        if (!childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            for (Group gr : childGroups) {
                toJson(gr);
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            count--;
        }
    }
}
