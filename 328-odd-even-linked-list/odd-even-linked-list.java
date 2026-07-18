class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        List<Integer> list = new ArrayList<>();

        ListNode temp = head;

        // Odd positions
        while(temp != null){
            list.add(temp.val);
            if(temp.next == null)
                break;
            temp = temp.next.next;
        }

        // Even positions
        temp = head.next;
        while(temp != null){
            list.add(temp.val);
            if(temp.next == null)
                break;
            temp = temp.next.next;
        }

        temp = head;
        int i = 0;
        while(temp != null){
            temp.val = list.get(i++);
            temp = temp.next;
        }

        return head;
    }
}