package Leetcode;

import java.math.BigInteger;

public class Prob2 {

    public static void main(String[] args) {
        // 342 + 465 = 807
        System.out.println(linkListIntValue(addTwoNumbers(intToLinkList(BigInteger.valueOf(342)),
                intToLinkList(BigInteger.valueOf(465)))));
    }

    public static BigInteger linkListIntValue(ListNode l) {
        StringBuilder value = new StringBuilder();
        ListNode currentNode = l;
        while(currentNode.next != null) {
            value.append(currentNode.val);
            currentNode = currentNode.next;
        }
        value.append(currentNode.val);

        return new BigInteger(value.reverse().toString());
    }

    // This method create a linklist by appending the each int digit to the list.
    public static ListNode intToLinkList(BigInteger i){
        int lastInt = i.mod(BigInteger.valueOf(10)).intValue();
        BigInteger remInt = i.divide(BigInteger.valueOf(10));
        // LinkList head
        ListNode listNode = new ListNode(lastInt);
        // compare bi1 with bi2
        int res = remInt.compareTo(BigInteger.valueOf(0));
        while(res != 0) {
            lastInt = remInt.mod(BigInteger.valueOf(10)).intValue();
            ListNode tmpNode = listNode;
            while (tmpNode.next != null) {
                tmpNode = tmpNode.next;
            }
            tmpNode.next = new ListNode(lastInt);
            remInt = remInt.divide(BigInteger.valueOf(10));
            res = remInt.compareTo(BigInteger.valueOf(0));
        }
        return listNode;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger intValL1 = linkListIntValue(l1),
                intValL2 = linkListIntValue(l2),
                sum = intValL1.add(intValL2);
        ListNode linkListSum = intToLinkList(sum);

        return linkListSum;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}