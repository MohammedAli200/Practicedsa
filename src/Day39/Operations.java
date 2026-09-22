package Day39;

public class Operations {
   public static class Node{
       int data;
       Node next;
       Node(int data){
           this.data=data;
       }
   }
   public static class LinkedList{
       Node head=null;
       Node tail=null;
       public void insertAtEnd(int data){
           Node temp=new Node(data);
           if(head==null){
               head=temp;
           }
           else{
               tail.next=temp;
           }
           tail=temp;
       }
       public void insertAtBeg(int data){
           Node temp = new Node(data);
           if(head==null){
               head=temp;
               tail=temp;
           }else{
               temp.next=head;
               head=temp;
           }
       }
       public void insertAt(int idx,int data){
           Node t=new Node(data);
           Node temp=head;
           if(idx==size()){
               insertAtEnd(data);
               return;
           }else if(idx==0){
               insertAtBeg(data);
               return;
           } else if (idx<0||idx>size()) {
               System.out.println("you entered wrong index");
               return;
           }
           for (int i = 1; i <idx-1; i++) {
               temp=temp.next;
           }
           t.next=temp.next;
           temp.next=t;
       }
       public void display(){
           Node temp=head;
           while(temp!=null){
               System.out.print(temp.data+" ");
               temp=head.next;
           }
       }
       public int size(){
           Node temp=head;
           int len=0;
           while(temp!=null){
               len++;
               temp=temp.next;
           }
           return len;
       }
   }

    static void main() {
        LinkedList ll=new LinkedList();
        ll.insertAtEnd(1);
        ll.display();
    }
}
