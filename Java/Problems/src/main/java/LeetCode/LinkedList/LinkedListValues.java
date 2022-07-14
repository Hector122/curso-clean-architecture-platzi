package LeetCode.LinkedList;

import java.util.ArrayList;

public class LinkedListValues {

    public int [] getArrayIterative(ListNode head){
        ArrayList<Integer> values = new ArrayList<>();

        while (head != null){
            values.add(head.val);
            head = head.next;
        }

        int [] result = new int[values.size()];
        for(int i = 0; i < values.size(); i++){
            result[i] = values.get(i);
        }

        return result;
    }


    public int [] getArrayRecursive(ListNode head){
        ArrayList<Integer> values = new ArrayList<>();

        fillValues(head, values);

        int [] result = new int[values.size()];
        for(int i = 0; i < values.size(); i++){
            result[i] = values.get(i);
        }

        return result;
    }

    private void fillValues(ListNode head, ArrayList<Integer> values){
        if(head == null) return;
        values.add(head.val);
        fillValues(head.next, values);
    }

}
