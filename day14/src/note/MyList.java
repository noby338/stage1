package note;

public class MyList {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        SingleList singleList1 = new SingleList();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        System.out.println("singleList = " + singleList);
        singleList.delete(2);
        System.out.println("singleList = " + singleList);


        singleList1.add(10);
        singleList1.add(20);
        singleList1.add(30);
        singleList1.add(40);
        System.out.println("singleList1 = " + singleList1);
        SingleList singleList2 = singleList.merge(singleList1);
        System.out.println("singleList2 = " + singleList2);

        singleList.reverse();
        System.out.println("singleList2 = " + singleList2);
    }
}


class SingleList {
    private Node head = null; // 指向第一个节点
    private int size; // 元素个数

    // 添加数据（20分）
    public void add(int data) {
        Node newNode = new Node(data, null);
        if (size == 0) {
            head = newNode;
        } else if (size == 1) {
            head.next = newNode;
        } else {
            Node thisNode = head;
            for (int i = 0; i < size - 1; i++) {
                thisNode = thisNode.next;
            }
            thisNode.next = newNode;
        }
        size++;
    }

    // 通过下标删除数据（20分）
    public void delete(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node thisNode = head;
            Node nextNode = head.next;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.next;
            }
            if (index != 1) {
                for (int i = 0; i < index - 1; i++) {
                    thisNode = thisNode.next;
                }
            }
            thisNode.next = nextNode;
        }
        size--;
    }

    // 反转当前链表（20分）
    public void reverse() {
        int[] ints = new int[this.size];
        Node thisNode = this.head;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = thisNode.data;
            thisNode = thisNode.next;
        }

        thisNode = this.head;
        for (int i = ints.length - 1; i >= 0; i--) {
            thisNode.data = ints[i];
            thisNode = thisNode.next;
        }
    }

    // 合并两个有序的链表，生成的新链表也是有序的（30分）
    public SingleList merge(SingleList other) {
//        SingleList newList = new SingleList();
//        newList.head = this.head;
        SingleList newList = this;
        Node thisNode = other.head;
        do {
            newList.add(thisNode.data);
        } while ((thisNode = thisNode.next) != null);
        return newList;
    }

    // toString方法完成单链表遍历输出（10分）
    @Override
    public String toString() {
        String str = "[";
        Node thisNode = head;
        do {
            str += thisNode.data + ",";
        } while ((thisNode = thisNode.next) != null);
        str = str.substring(0, str.length() - 1) + "]";
        return str;
    }

    // 节点内部类
    public static class Node {
        public int data; // 数据
        public Node next; // 指向下一个节点

        public Node(int data, Node next) {
            super();
            this.data = data;
            this.next = next;
        }

    }

}
