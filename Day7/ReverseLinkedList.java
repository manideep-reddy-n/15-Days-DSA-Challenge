package Day7;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode cur = head;
        ListNode l1 = null;
        for (int i = 1; i <= left - 1; i++) {
            l1 = cur;
            cur = cur.next;
        }
        ListNode prev = null;
        ListNode l2 = cur;
        cur = l2;

        for (int i = left; i <= right; i++) {
            ListNode og = cur.next;
            cur.next = prev;
            prev = cur;
            cur = og;
        }
        ListNode r1 = cur;
        if (l1 == null) {
            head = prev;
        } else {
            l1.next = prev;
        }
        if (r1 != null) {
            l2.next = r1;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode resultHead = solution.reverseBetween(head, left, right);

        // Print the reversed linked list
        ListNode current = resultHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
