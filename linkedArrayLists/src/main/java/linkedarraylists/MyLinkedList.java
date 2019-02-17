package linkedarraylists;

public class MyLinkedList<T> implements MyList<T> {

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    @Override
    public T get(int index) {
        isLargerThanSize(index);
        Node<T> temp = first;
        for (int j = 0; j < index; j++) {
            temp = temp.next;
        }
        return temp.element;
    }

    private void isLargerThanSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(T element) {
        if (0 == size) {
            first = new Node<>(null, element, null);
            last = first;
            size++;

        } else {
            last = new Node<>(last, element, null);
            last.prev.next = last;
            size++;
        }
    }

    @Override
    public void remove(int index) {
        isLargerThanSize(index);

        Node<T> temp = first;
        for (int j = 0; j < index; j++) {
            temp = temp.next;
        }
        if (0 == index) {
            first = first.next;
            first.prev = null;
        } else if (index == size - 1) {
            last = last.prev;
            last.next = null;
        } else {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append(get(i));
            } else {
                sb.append(", ").append(get(i));
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
