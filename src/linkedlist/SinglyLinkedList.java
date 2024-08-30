package linkedlist;

import java.util.ArrayList;

/*
   @author Austin Oyugi
   @since 29/08/2024
   @mail austinoyugi@gmail.com
*/
public class SinglyLinkedList {

    private static class Node {
        int data;
        Node nextNode;

        public Node(int data, Node nextNode){
            this.data = data;
            this.nextNode = nextNode;
        }

        public Node(){

        }

        public void setNextNode(Node node){
            this.nextNode = node;
        }
    }

    private Node firstNode;

    public SinglyLinkedList() {
    }

    public int get(int index) {

        int currentIndex = 0;
        Node currentNode = firstNode;

        while(currentNode != null){
            if(currentIndex == index) return currentNode.data;
            currentNode = currentNode.nextNode;
            currentIndex++;
        }

        return -1;
    }

    public void insertHead(int val) {
        firstNode = new Node(val, firstNode);
    }

    public void insertTail(int val) {
        Node lastNode = firstNode;

        if(lastNode == null) {
            insertHead(val);
        }

        while(lastNode != null){
            if(lastNode.nextNode == null) break;
            else lastNode = lastNode.nextNode;
        }

        if(lastNode == null) return;

        lastNode.setNextNode(new Node(val,null));
    }

    public boolean remove(int index) {

        Node previousNode = null;
        Node currentNode = firstNode;

        if(currentNode == null) return false;

        int currentIndex = 0;

        while(currentNode != null){
            if (currentIndex == index) break;
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            currentIndex ++;
        }

        if(previousNode == null) {
            firstNode = currentNode.nextNode;
            return true;
        }else{
            if(currentNode != null){
                previousNode.setNextNode(currentNode.nextNode);
                return true;
            }
        }

        return false;
    }

    public ArrayList<Integer> getValues() {

        ArrayList<Integer> values = new ArrayList<>();

        Node currentNode = firstNode;

        while(currentNode != null){
            values.add(currentNode.data);
            currentNode = currentNode.nextNode;
        }

        return values;
    }

    public static void main(String[] args){

        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.insertHead(1);
        linkedList.insertHead(2);
        linkedList.insertTail(3);
        linkedList.insertTail(4);
        linkedList.insertHead(5);

        linkedList.remove(2);
        linkedList.remove(0);

        linkedList.insertHead(6);
        linkedList.insertTail(7);

        System.out.println(linkedList.getValues());
    }
}
