package com.company;

public class StringNode {
    private String value;
    StringNode nextNode;

    public StringNode() {
        this.value = "";
        this.nextNode = null;
    }
    public StringNode(String value) {
        this.value = value;
        this.nextNode = null;
    }
    public StringNode(String value, StringNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StringNode nextNode) {
        this.nextNode = nextNode;
    }

}
