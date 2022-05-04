package com.company;

public class List {
    private Node head;
    private int length;

    public List() {
        this.head = null;
        this.length = 0;
    }

    public List (Node head) {
        this.head = head;
        this.length = 1;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public void printList(){
        Node nodeTmp = this.head;
        while (nodeTmp != null) {
            System.out.print(nodeTmp.getValue() + " ");
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public int getLength() {
        return length;
    }

    public void push(int value) {
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode (new Node(value));
        this.length++;
    }
    public void push(int value, int index) {
        if (index == 0) {
            this.pushHead(value);
        } else {
            Node nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            Node newNode = new Node(value, nodeTmp.getNextNode());
            nodeTmp.setNextNode(newNode);
        }
        this.length++;
    }

    private void pushHead(int value) {
        Node newNode = new Node(value, this.head);
        this.head = newNode;
        this.length++;
    }
    public void pop(){
        Node nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(null);
        this.length--;
    }
    public void pop(int index) {
        if (index == 0) {
            popHead();
        } else {
            Node nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
        }
        this.length--;
    }

    private void popHead() {
        Node nodeTmp = this.head;
        this.head = this.head.getNextNode();
    }

}
