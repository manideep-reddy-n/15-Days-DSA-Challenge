package Day12;

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

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        int pos = size - n;
        if (pos == 0) {
            return head.next;
        }
        ListNode prev = head;
        temp = head.next;
        while (pos-- > 1 && temp != null) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null)
            prev.next = temp.next;
        return head;
    }
}
