package note;

/**
 * @Description 自定义实现单项链表集合
 * @Author Noby
 * @Date 2023/3/16 23:02
 */
public class LinkedListNote4 {
    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        System.out.println("singleList.add(1) = " + singleList.add(1));
        System.out.println("singleList.add(2) = " + singleList.add(2));
        System.out.println("singleList.add(3) = " + singleList.add(3));
        System.out.println("singleList.add(4) = " + singleList.add(4));
        System.out.println("singleList = " + singleList);
        System.out.println("singleList.delete(2) = " + singleList.delete(2));
        System.out.println("singleList = " + singleList);
        System.out.println("singleList.size() = " + singleList.size());
        singleList.reverse();
        System.out.println("singleList = " + singleList);

    }
}


class SingleList {
    private Node head = null; // 指向第一个节点
    private int size; // 元素个数

    // 添加数据（20分）
    public boolean add(int data) {
        boolean flag = false;
        Node newNode = new Node(data, null);
        if (size == 0) {
            head = newNode;
        } else {
            Node lastNode = head;
            for (int i = 0; i < size - 1; i++) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
        flag = true;
        return flag;
    }

    // 通过下标删除数据（20分）
    public Integer delete(int index) {
        Node lastNode2 = head;
        int data = 0;
        if (index < 0 || index >= size) {
            throw new NullPointerException();
        } else if (index == 0) {
            data = head.data;
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                lastNode2 = lastNode2.next;
            }
            data = lastNode2.next.data;
            if (index == size - 1) {
                lastNode2.next = null;
            } else {
                lastNode2.next = lastNode2.next.next;
            }
        }

        size--;
        return data;
    }

    // 反转当前链表（20分）
    public void reverse() {
        Node thisNode = head;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = thisNode.data;
            thisNode = thisNode.next;
        }

        thisNode = head;
        for (int i = 0; i < size; i++) {
            thisNode.data = arr[size - i - 1];
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


    public int size() {
        return this.size;
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
    static class Node {
        public int data; // 数据
        public Node next; // 指向下一个节点

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
