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
    private static String tabRepeat = String.join("", Collections.nCopies(count, "\t"));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> list = new ArrayList();

    public static String serialize(Group group) {
        toXml(group);
        return sb.toString();
    }

    private static void toXml(Group group) {
        childGroups = group.getChildGroups();
        list = group.getList();
        Class clazz;

        Class clazzTwo = group.getClass();
        String brackets = "()";
        sb.append("\n<Group>");
        for (Field field : clazzTwo.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("list")) {

                sb.append("\n<").append(field.getName()).append(">");
                int i = 0;
                while (list.size() > i) {
                    sb.append(brackets);
                    i++;
                }
                sb.append("</").append(field.getName()).append(">");
                sb.append(" ");
            } else if (field.getName().equals("childGroups")) {
                sb.append("\n<").append(field.getName()).append(">");
                int t = 0;
                while (childGroups.size() > t) {
                    sb.append(brackets);
                    t++;
                }
                sb.append("</").append(field.getName()).append(">");

            } else {
                sb.append("\n<").append(field.getName()).append(">");
            }
        }
        sb.append("\n</Group>");






        for (Figure figure : list) {
            clazz = figure.getClass();
            String tabRepeat = String.join("", Collections.nCopies(count, TAB));

            sb.append(NUW).append(tabRepeat).append("<").append(clazz.getName()).append(">");
            for (Field f : clazz.getDeclaredFields().length < clazz.getSuperclass().getDeclaredFields().length ?
                    clazz.getSuperclass().getDeclaredFields() :
                    clazz.getDeclaredFields()) {
                String fieldType = f.getAnnotatedType().getType().getTypeName()
                        .replaceFirst("java.lang.", "");
                f.setAccessible(true);
                String value = null;
                try {
                    value = String.valueOf(f.get(figure));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                // xml build logic
                sb.append(NUW + TAB).append(tabRepeat).append("<").append(fieldType).append(">");
                sb.append(NUW + TAB + TAB).append(tabRepeat).append("<name>").append(f.getName()).append("</name>");
                sb.append(NUW + TAB + TAB).append(tabRepeat).append("<value>").append(value).append("</value>");
                sb.append(NUW + TAB).append(tabRepeat).append("</").append(fieldType).append(">");
            }
            for (Method met : clazz.getDeclaredMethods()) {
                sb.append(NUW + TAB).append(tabRepeat).append("<method>").append(met.getName()).append("</method>");
            }
            sb.append(NUW).append(tabRepeat).append("</").append(clazz.getName()).append(">");
        }

        if (!childGroups.isEmpty()) {
            count++;
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("<").append("InnerGroupLevel " + (count)).append(">");
            for (Group gr: childGroups) {
                serialize(gr);
            }
            tabRepeat = String.join("", Collections.nCopies((count - 1), "\t"));
            sb.append("\n" + tabRepeat).append("</").append("InnerGroupLevel " + (count)).append(">");
            count--;
        }
    }
}