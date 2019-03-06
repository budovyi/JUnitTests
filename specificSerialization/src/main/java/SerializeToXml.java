import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeToXml {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private static final String TAB = "\t";
    private static final String NUW = "\n";
    private static String tabRepeat = String.join("", Collections.nCopies(count, TAB));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> figures = new ArrayList();

    public static String serialize(Group group) {
        toXml(group);
        return sb.toString();
    }

    private static void toXml(Group group) {
        tabRepeat = String.join("", Collections.nCopies(count, TAB));
        childGroups = group.getChildGroups();
        figures = group.getFigures();
        Class clazz = group.getClass();
        Class clazzTwo;

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.getName().equals("figures")) {
                sb.append(tabRepeat).append("<").append(field.getName()).append(">\n");
                count++;
                tabRepeat = String.join("", Collections.nCopies(count, TAB));

                for (Figure figure : figures) {
                    clazzTwo = figure.getClass();
                    sb.append(tabRepeat).append("<").append(clazzTwo.getName()).append(">\n");
                    count++;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));
                    for (Field f : clazzTwo.getDeclaredFields().length < clazzTwo.getSuperclass().getDeclaredFields().length ?
                            clazzTwo.getSuperclass().getDeclaredFields() :
                            clazzTwo.getDeclaredFields()) {
                        String fieldType = f.getAnnotatedType().getType().getTypeName()
                                .replaceFirst("java.lang.", "");
                        f.setAccessible(true);
                        String value = null;
                        try {
                            value = String.valueOf(f.get(figure));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                        sb.append(tabRepeat).append("<").append(fieldType).append(">\n");
                        sb.append(TAB).append(tabRepeat).append("<name>").append(f.getName()).append("</name>\n");
                        sb.append(TAB).append(tabRepeat).append("<value>").append(value).append("</value>\n");
                        sb.append(tabRepeat).append("</").append(fieldType).append(">\n");
                    }
                    for (Method met : clazzTwo.getDeclaredMethods()) {
                        sb.append(tabRepeat).append("<method>").append(met.getName()).append("</method>\n");
                    }
                    count--;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));
                    sb.append(tabRepeat).append("</").append(clazzTwo.getName()).append(">\n");
                }
                count--;
                tabRepeat = String.join("", Collections.nCopies(count, TAB));
                sb.append(tabRepeat).append("</").append(field.getName()).append(">\n");

            } else if (field.getName().equals("childGroups")) {
                sb.append(tabRepeat).append("<").append(field.getName()).append(">\n");

                if (!childGroups.isEmpty()) {
                    count++;
                    for (Group gr : childGroups) {
                        serialize(gr);
                    }
                    count--;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));
                    sb.append(tabRepeat).append("</").append(field.getName()).append(">\n");
                } else {
                    sb.append(tabRepeat).append("</").append(field.getName()).append(">\n");
                }
            }
        }
    }
}
