/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        while(temp!=null){
            Node copyNode =new Node(temp.val);
            copyNode.next=temp.next;
            temp.next=copyNode;
            temp=temp.next.next;
        }
        temp=head;
      while(temp != null){
    Node copyNode = temp.next;

    if(temp.random != null){
        copyNode.random = temp.random.next;
    }

    temp = copyNode.next;
}

       Node dummy = new Node(-1);
Node res = dummy;
temp = head;

while(temp != null){

    Node copyNode = temp.next;

    res.next = copyNode;
    res = res.next;

    temp.next = copyNode.next;

    if(copyNode.next != null){
        copyNode.next = copyNode.next.next;
    }

    temp = temp.next;
}

return dummy.next;
    }
}