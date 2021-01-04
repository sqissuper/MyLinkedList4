class Node{
    public Node next;
    public int val;
    //默认构造方法
    public Node(){

    }
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {
    //打印链表
    public void disPlay1(){
        Node ret = this.head;
        while(ret != null){

            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

    public void display2(){
        Node ret = this.head1;
        while(ret != null){

            System.out.print(ret.val + " ");
            ret = ret.next;
        }
    }

    //判断是链表空否
    public boolean isFull(){
        if(this.head == null){
            return true;
        }
        return false;
    }

//删除中间节点
    public void delMidNode(){
        Node fir = this.head;
        Node sec = this.head;
        while(fir.next != null){
            fir  =fir.next.next;
            sec = sec.next;
        }
        Node ret = this.head;
        while(ret != null){
            if(ret.next == sec){
                ret.next = sec.next;
            }
            ret = ret.next;
        }
    }

    //找倒数第k个节点
    public Node finBottomK(int k){
        if(this.head == null || k < 0){
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        while(k - 1 != 0){
            if(fast.next != null){
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //合并链表
    public Node mergeList(){
        Node newHead = new Node(0);
        Node tmp = newHead;
        while(this.head != null && this.head1 != null){
            if(this.head.val < this.head1.val){
                tmp.next = this.head;
                this.head = this.head.next;
            }else{
                tmp.next = this.head1;
                this.head1 = this.head1.next;
            }
            tmp = tmp.next;
        }
        if(this.head == null){
            tmp.next = this.head1;
        }
        if(this.head1 == null){
            tmp.next = this.head1;
        }
        return newHead.next;
    }

    public Node head;//头节点
    public Node head1;
    //创建链表
    public void creatList1(){
        this.head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(12);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    public void creatList2(){
        this.head1 = new Node(5);
        Node node2 = new Node(7);
        Node node3 = new Node(9);
        Node node4 = new Node(13);
        Node node5 = new Node(18);
        Node node6 = new Node(20);
        this.head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
    }

    public static void main(String[] args){
        MyLinkedList myList = new MyLinkedList();
        myList.creatList1();//创建链表
        myList.disPlay1();//打印链表
        System.out.println();//换行
        myList.creatList2();
        myList.display2();
        System.out.println();//换行
        myList.delMidNode();//删除中间值
        myList.disPlay1();
        Node ret = myList.finBottomK(3);//找倒数第k个值
        System.out.println(ret.val);
        Node ret = myList.mergeList();//拼接链表
        while(ret != null){
            System.out.print(ret.val + " ");
            ret = ret.next;
        }
        }
    }