import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeToJson {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;
    private static final String TAB = "  ";
    private static String tabRepeat = String.join("", Collections.nCopies(count, TAB));
    private static List<Group> childGroups = new ArrayList();
    private static List<Figure> listFigures = new ArrayList();

    public static String serialize(Group group) {
        toJson(group);
        return sb.toString();
    }

    private static void toJson(Group group) {
        tabRepeat = String.join("", Collections.nCopies(count, TAB));
        childGroups = group.getChildGroups();
        listFigures = group.getFigures();
        Class clazz = group.getClass();
        Class clazzTwo;

        sb.append(tabRepeat).append("{\n");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.getName().equals("figures")) {
                sb.append(TAB).append(tabRepeat).append("\"").append(field.getName()).append("\": [\n");
                count++;

                tabRepeat = String.join("", Collections.nCopies(count, TAB));

                for (Figure figure : listFigures) {
                    clazzTwo = figure.getClass();

                    sb.append(TAB).append(tabRepeat).append("{\n");
                    count++;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));

                    for (Field fieldTwo : clazzTwo.getDeclaredFields().length < clazzTwo.getSuperclass().getDeclaredFields().length ?
                            clazzTwo.getSuperclass().getDeclaredFields() :
                            clazzTwo.getDeclaredFields()) {

                        fieldTwo.setAccessible(true);
                        String value = null;
                        try {
                            value = String.valueOf(fieldTwo.get(figure));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                        sb.append(TAB).append(tabRepeat)
                                .append("\"").append(fieldTwo.getName()).append("\": ")
                                .append("\"").append(value).append("\",\n");
                    }

                    for (Method met : clazzTwo.getDeclaredMethods()) {
                        sb.append(TAB).append(tabRepeat).append("\"")
                                .append(met.getName()).append("\": {},\n");
                    }
                    sb.append(tabRepeat).append("},\n");
                    count--;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));
                }
                sb.append(tabRepeat).append("], \n");
                count--;
                tabRepeat = String.join("", Collections.nCopies(count, TAB));


            } else if (field.getName().equals("childGroups")) {
                sb.append(TAB).append(tabRepeat).append("\"").append(field.getName()).append("\": [");

                if (!childGroups.isEmpty()) {
                    count += 2;
                    for (Group gr : childGroups) {
                        sb.append("\n");
                        toJson(gr);
                    }
                    count -= 2;
                    tabRepeat = String.join("", Collections.nCopies(count, TAB));
                    sb.append(TAB).append(tabRepeat).append("]\n");
                } else {
                    sb.append("]\n");
                }
            }
        }
        sb.append(tabRepeat).append("}\n");
    }
}
