package linkedarraylists;

public class Demo {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(5));

        MyList<Integer> list2 = new MyLinkedList<>();

        list2.add(100);
        list2.add(200);
        list2.add(300);
        list2.add(400);

        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2.get(2));
        System.out.println(list2);
    }
}
