package com.company;

public class StringList {
    private StringNode head;

    public StringList() {
        this.head = null;
    }

    public StringList (StringNode head) {
        this.head = head;
    }

    public StringNode getHead() {
        return head;
    }
    public void setHead(StringNode head) {
        this.head = head;
    }

    public void printStringList(){
        StringNode nodeTmp = this.head;
        while (nodeTmp != null) {
            System.out.print(nodeTmp.getValue() + " ");
            nodeTmp = nodeTmp.getNextNode();
        }
    }

    public void push(String value) {
        StringNode nodeTmp = this.head;
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode (new StringNode(value));
    }
    public void push(String value, int index) {
        if (index == 0) {
            this.pushHead(value);
        } else {
            StringNode nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            StringNode newNode = new StringNode(value, nodeTmp.getNextNode());
            nodeTmp.setNextNode(newNode);
        }
    }

    private void pushHead(String value) {
        StringNode newNode = new StringNode(value, this.head);
        this.head = newNode;
    }
    public void pop(){
        StringNode nodeTmp = this.head;
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        nodeTmp.setNextNode(null);
    }
    public void pop(int index) {
        if (index == 0) {
            popHead();
        } else {
            StringNode nodeTmp = this.head;
            for (int i = 0; i < index - 1 && nodeTmp.getNextNode().getNextNode() != null; i++) {
                nodeTmp = nodeTmp.getNextNode();
            }
            nodeTmp.setNextNode(nodeTmp.getNextNode().getNextNode());
        }
    }

    private void popHead() {
        StringNode nodeTmp = this.head;
        this.head = this.head.getNextNode();
    }

}
