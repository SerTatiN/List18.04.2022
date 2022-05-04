package com.company;

public class Task18 {
    //1.Найти среднее арифметическое значение элементов списка.
    public static double sredArif(List list) {
        Node nodeTmp = list.getHead();
        int sum = 0;
        int count = 0;
        while (nodeTmp != null) {
            sum += nodeTmp.getValue();
            count++;
            nodeTmp = nodeTmp.getNextNode();
            System.out.println(count + " " + sum);
        }
        return (double) sum / count;
    }

    //2. Перенести в начало списка его последний элемент.
    public static void task2(List list) {
        Node nodeTmp = list.getHead();
        while (nodeTmp.getNextNode().getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();
        }
        Node tmp = nodeTmp.getNextNode(); //последний
        tmp.setNextNode(list.getHead()); // последний ссылается на голову, которая теперь 2-ая
        list.setHead(tmp); // последний- теперь первый и голова
        nodeTmp.setNextNode(null); //предыдущий- теперь последний
    }

//4. Поменять местами первый и последний элементы списка.
    public static List task04(List list) {
        Node nodeTmp = list.getHead();//первый
        Node nodeTmp1 = list.getHead();
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();// предпоследний
        }
        list.push(nodeTmp.getValue(), 0);
        list.pop(1);
        list.pop();
        list.push(nodeTmp1.getValue());

        return list;
    }

    public static void task041(List list) {

        Node nodeTmp = list.getHead();
        while (nodeTmp.getNextNode() != null) {
            nodeTmp = nodeTmp.getNextNode();// последний
        }
        int tmp = list.getHead().getValue();
        list.getHead().setValue(nodeTmp.getValue());
        nodeTmp.setValue(tmp);
    }
//5. Определить количество слов в списке, которые начинаются и заканчиваются на одну букву.

    public static void task05(StringList list) {
        StringNode temp = list.getHead();
        int couter = 0;
        while (temp != null) {
            if (isChar(temp, temp)) {
                couter++;
            }
            temp = temp.getNextNode();
        }
        System.out.println("Количество слов в списке, которые начинаются и заканчиваются на одну букву = " + couter);
    }

    //6. Проверить, что каждое следующее слово в списке начинается с последней буквы предыдущего
    public static void task06(StringList list) {
        StringNode temp = list.getHead();
        boolean f = true;
        while (temp.getNextNode() != null) {
            if (!isChar(temp, temp.nextNode)) {
                f = false;
                break;
            }
            temp = temp.getNextNode();
        }
        if (f) {
            System.out.println("Да! Cледующее слово в списке начинается с последней буквы предыдущего!");
        } else {
            System.out.println("Нет! Cледующее слово в списке не начинается с последней буквы предыдущего!");
        }
    }

    private static boolean isChar(StringNode sp1, StringNode sp2) {
        if (!sp1.getValue().isEmpty() && !sp2.getValue().isEmpty()) {
            if (sp1.getValue().toLowerCase().charAt(sp1.getValue().length() - 1) == sp2.getValue().toLowerCase().charAt(0)) {
                return true;
            }
        }
        return false;
    }

// 7.Определить количество слов в списке, которые совпадают с первым (последним) словом списка

    public static void task07(StringList list) {
        StringNode tmp = list.getHead();
        int counter = 0;
        String fist = tmp.getValue();
        while (tmp.getNextNode() != null) {
            if (isWord(fist, tmp.getNextNode())) {
                counter++;
            }
            tmp = tmp.getNextNode();
        }
        System.out.println("Первое слово " + fist + " встречается " + counter + " раз(а)");

        String last = tmp.getValue();
        counter = 0;
        tmp = list.getHead();
        while (tmp.getNextNode().getNextNode() != null) {
            if (isWord(last, tmp)) {
                counter++;
            }
            tmp = tmp.getNextNode();
        }
        System.out.println("Последнее слово " + last + " встречается " + counter + " раз(а)");
    }

    private static boolean isWord(String sp1, StringNode sp2) {
        return sp1.equalsIgnoreCase(sp2.getValue());
    }

    // 8. Проверить, упорядочены ли элементы списка по алфавиту.
    public static void task08(StringList list) {
        StringNode temp = list.getHead();
        boolean f = true;
        while (temp.getNextNode() != null) {
            if (!isAbc(temp, temp.nextNode)) {
                f = false;
                break;
            }
            temp = temp.getNextNode();
        }
        if (f) {
            System.out.println("Да! Элементы списка упорядочены по алфавиту ");
        } else {
            System.out.println("Нет! Элементы списка не упорядочены по алфавиту ");
        }
    }

    private static boolean isAbc(StringNode sp1, StringNode sp2) {
        if (!isWord(sp1.getValue(), sp2)) {
            if (!isAbcString(sp1.getValue(), sp2.getValue())) {
               return false;
            }
        }
        return true;
    }

    private static boolean isAbcString(String st1, String st2) {
        int dl;
        if (st1.length() <= st2.length()) {
            dl = st1.length();
        } else {
            dl = st2.length();
        }
        int i = 0;
        while (i < dl) {
            if ((int) st1.toLowerCase().charAt(i) < (int) st2.toLowerCase().charAt(i)) {
                return true;
            } else {
                if ((int) st1.toLowerCase().charAt(i) > (int) st2.toLowerCase().charAt(i)) {
                    return false;
                }
            i++;
            }
        }
        if (i == dl && st1.length() >= st2.length()) {
            return false;
        }
        return true;
    }

    //9. Определить, входит ли список L1 в L2.
    public static void task09(StringList list1, StringList list2) {
        StringNode tmp1 = list1.getHead();
        StringNode tmp2 = list2.getHead();
        boolean f = true;
        while (tmp2 != null) {
            f = false;
            if (isImploz(tmp1, tmp2)) {
                f = true;
                break;
            }
            if (!f) {
                tmp2 = tmp2.getNextNode();
            }
        }
        if (f) {
            System.out.println("Да!  L1 входит в список  L2.");
        } else {
            System.out.println("Нет!  L1 не входит в список  L2.");
        }
    }

    private static boolean isImploz(StringNode tmp1, StringNode tmp2) {
        boolean f = true;
        while (tmp1 != null && tmp2 != null && f) {
            f = false;
            if (isWord(tmp1.getValue(), tmp2)) {
                f = true;
                tmp1 = tmp1.getNextNode();
                tmp2 = tmp2.getNextNode();
            }
        }
        if (f && tmp1 != null) {
            tmp1 = tmp1.getNextNode();
        }
        return f;
    }

    //10.  Перевернуть список наоборот.
    public static void task10(StringList list) {
        StringNode tmp = list.getHead();
        StringNode tmp1 = tmp.getNextNode();
        while (tmp1.getNextNode() != null) {
            StringNode tmp2 = tmp1.getNextNode();
            tmp1.setNextNode(tmp);
            tmp = tmp1;
            tmp1 = tmp2;
        }
        tmp1.setNextNode(tmp);
        list.getHead().setNextNode(null);
        list.setHead(tmp1);
    }
}