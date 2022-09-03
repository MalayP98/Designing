package com.javatypes;

public class JavaTypeTester {

    public static void main(String[] args) {

        // testing ArrayList
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);

        // test LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println(linkedList);
        linkedList.delete();
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");
        System.out.println(linkedList);

        // testing HashMap
        HashMap<String, Integer> map = new HashMap<>(3);
        map.put("A", 1);
        map.put("B", 2);
        map.put("B", 21);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        System.out.println(map);
    }
}
