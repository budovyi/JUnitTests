package other;

import java.util.ArrayList;
import java.util.List;

public class ImmutableExample {
    private List<String> list;

    public static void main(String[] args) {
       new ImmutableExample().demo();
    }

    private void demo() {
        list = new ArrayList();
        list.add("line 1");
        list.add("line 2");

        ImmutableClass ic = new ImmutableClass("Vaska", 5, list);

        for (String string : ic.getList()) {
            System.out.println(string);
        }
    }
}
