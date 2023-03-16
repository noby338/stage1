package note;

/**
 * @Description 自定义实现LinkedList集合（双向链表集合）
 * @Author Noby
 * @Date 2023/3/16 22:01
 */
public class LinkedListNote3 {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println("list.getSize() = " + list.getSize());
        System.out.println("list.remove(2) = " + list.remove(2));
        System.out.println("list.getSize() = " + list.getSize());
        System.out.println(list);
        System.out.println("list.get(2) = " + list.get(2));

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.add(0);
        System.out.println("customLinkedList = " + customLinkedList);
    }
}

class CustomLinkedList {
    int size;
    Node first;
    Node last;

    boolean add(int data) {
        Node newNode = new Node(last, null, data);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    /**
     * 根据索引删除
     *
     * @param index
     * @return
     */
    boolean remove(int index) {
        Node thisNode = first;
        if ((index < 0 || index >= size)) {
            throw new NullPointerException();
        } else if (index == 0) {

        } else {
            for (int i = 0; i < index; i++) {
                thisNode = thisNode.next;
            }
        }

        thisNode.prev.next = thisNode.next;
        thisNode.next.prev = thisNode.prev;
        size--;
        return true;
    }

    @Override
    public String toString() {
        String str = "[";
        Node thisNode = first;
        do {
            str += thisNode.item + ",";
        } while ((thisNode = thisNode.next) != null);
        str = str.substring(0, str.length() - 1) + "]";
        return str;
    }

    static class Node {
        Node prev;
        Node next;
        int item;

        public Node(Node prev, Node next, int item) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    int get(int index) {
        Node thisNode = first;
        if (index == 0) {
            return thisNode.item;
        } else if (index >= size || index < 0) {
            throw new NullPointerException();
        } else {
            for (int i = 0; i < index; i++) {
                thisNode = thisNode.next;
            }
            return thisNode.item;
        }
    }

    public int getSize() {
        return size;
    }
}