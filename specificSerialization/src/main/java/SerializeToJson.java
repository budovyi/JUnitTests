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
        Class clazzTwo = group.getClass();
        String brackets = "{}";

        for (Field field : clazzTwo.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("list")) {

                sb.append(" \"").append(field.getName()).append("\": [");
                int i = 0;
                while (list.size() > i) {
                    sb.append(brackets);
                    i++;
                }
                sb.append("] ");
            } else if (field.getName().equals("childGroups")) {
                sb.append(" \"").append(field.getName()).append("\": [");
                int t = 0;
                while (childGroups.size() > t) {
                    sb.append(brackets);
                    t++;
                }
                sb.append("] ");


            } else {
                sb.append("\"").append(field.getName()).append("\"");
            }
            sb.append(", ");
        }
        sb.append(": ");

        for (Figure figure : list) {
            clazz = figure.getClass();

            String tabRepeat = String.join("", Collections.nCopies(count, TAB));
            sb.append(tabRepeat).append("\n").append("{");


            for (Field field : clazz.getDeclaredFields().length < clazz.getSuperclass().getDeclaredFields().length ?
                    clazz.getSuperclass().getDeclaredFields() :
                    clazz.getDeclaredFields()) {
                field.setAccessible(true);

                String value = null;
                try {
                    value = String.valueOf(field.get(figure));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                // json build logic
                sb.append("\"").append(field.getName()).append("\": ")
                        .append("\"").append(value).append("\",");
            }

            for (Method met : clazz.getDeclaredMethods()) {
                sb.append(tabRepeat).append(" \"")
                        .append(met.getName()).append("\" : {");
                sb.append(tabRepeat).append("}");
            }
            sb.append(tabRepeat).append("}\n");
        }
        if (!childGroups.isEmpty()) {
            for (Group gr : childGroups) {
                toJson(gr);
            }
        }
    }
}
