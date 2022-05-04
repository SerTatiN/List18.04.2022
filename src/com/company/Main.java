package com.company;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[]{18, 43, 100, 4, 24, 6, 63};

        Node node1 = new Node(array[0]);
        List list = new List(node1);
        for (int i = 1; i < array.length; i++) {
            list.push(array[i]);
        }

        list.printList();
        System.out.println();
        System.out.println(Task18.sredArif(list));
        Task18.task041(list);
        list.printList();
        System.out.println();
        Task18.task2(list);
        list.printList();
        System.out.println(list.getLength());

        // String[] аrrayOfStrings = {"tube", "tube", "tube","alabama", "africa", "tube", "africau", "arctica", "arambler", "africa","tube"};
        String[] arrayOfStrings = {"банк", "", "Банка", "банка", "банкир", "баобаб","банкирша", "банк","банка"};
       // String[] arrayOfStrings = {"арахис","арбуз", "арбузный", "арбузы", "банан"};
        // String[] arrayOfStrings = {"станция", "стационар", "станционный"};
        StringNode head = new StringNode(arrayOfStrings[0]);
        StringList listSt = new StringList(head);
        for (int i = 1; i < arrayOfStrings.length; i++) {
            listSt.push(arrayOfStrings[i]);
        }
        listSt.printStringList();
        System.out.println();
        Task18.task05(listSt);
        Task18.task06(listSt);
        Task18.task07(listSt);
        Task18.task08(listSt);

        String[] arrayOfStrings2 = {"банк", ""};
        StringNode head2 = new StringNode(arrayOfStrings2[0]);
        StringList listSt2 = new StringList(head2);
        for (int i = 1; i < arrayOfStrings2.length; i++) {
            listSt2.push(arrayOfStrings2[i]);
        }
        Task18.task09(listSt2, listSt);

        String[] arrayOfStrings3 = {"банк", "краска", "кран", "колос", "вагон"};
        StringNode head3 = new StringNode(arrayOfStrings3[0]);
        StringList listSt3 = new StringList(head3);
        for (int i = 1; i < arrayOfStrings3.length; i++) {
            listSt3.push(arrayOfStrings3[i]);
        }
        Task18.task10(listSt3);
        listSt3.printStringList();
    }

}

