package Day39;

public class BasicsOfLl {
    public static class  Node{
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public static int display(Node head){
       int length=0;
       while(head!=null){
           length++;
           head=head.next;
       }
       return length;
    }

    static void main() {
        Node a = new Node(7);
        Node b = new Node(9);
        Node c = new Node(10);
        Node d = new Node(19);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(display(a));
    }
}
