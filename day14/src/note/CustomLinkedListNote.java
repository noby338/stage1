package note;

public class CustomLinkedListNote {//自定义LinkedList

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(5);
        System.out.println(list);
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

    boolean remove(int data) {
        Node thisNode = first;
        do {
            if (thisNode.itme == data) {
                if (thisNode == first) {
                    thisNode.next.prev = null;
                } else if(thisNode == last){
                    thisNode.prev.next = null;
                } else {
                    thisNode.prev.next = thisNode.next;
                    thisNode.next.prev = thisNode.prev;
                }
            }
        } while ((thisNode = thisNode.next) != null);
        return true;
    }

    @Override
    public String toString() {
        String str = "[";
        Node thisNode = first;
        do {
            str += thisNode.itme + ",";
        } while ((thisNode = thisNode.next) != null);
        str = str.substring(0, str.length() - 1) + "]";
        return str;
    }

    static class Node {
        Node prev;
        Node next;
        int itme;

        public Node(Node prev, Node next, int itme) {
            this.prev = prev;
            this.next = next;
            this.itme = itme;
        }
    }
}