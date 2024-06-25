package challenges;

public class SinglyLinkedListElements {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        for (int x = 0; x < 10; x++) {
            list.insertNode(x);
        }
        printLinkedList(list.head);
    }

    static void printLinkedList(SinglyLinkedListNode node) {
        SinglyLinkedListNode n = node;

        while (n.next != null) {
            System.out.println(n.data);

            n = n.next;
        }
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

}
