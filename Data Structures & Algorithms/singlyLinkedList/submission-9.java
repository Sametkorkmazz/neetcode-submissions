class LinkedList {

    class LinkedNode {
        private int val;
        private LinkedNode next = null;

        public LinkedNode(int val){
            this.val = val;
        }
    }

    private LinkedNode head;
    private LinkedNode tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        LinkedNode curr = head;
        int i = 0;

        while(i < index && curr != null) {
            curr = curr.next;
            i++;
        }
        
        return curr != null ? curr.val : -1;
    }

    public void insertHead(int val) {
        LinkedNode newHead = new LinkedNode(val);
        if(this.head == null){
            newHead.next = this.tail;
            this.head = newHead;
            if(this.tail == null){
 this.tail = newHead;
            }
           
        } else {
            newHead.next = this.head;
            this.head = newHead;
        }
        

    }

    public void insertTail(int val) {
        LinkedNode newTail = new LinkedNode(val);
        if(this.tail == null){
            if(this.head == null){
                this.head = newTail;
            }
            this.tail = newTail;
        }else {
            this.tail.next = newTail;
            this.tail = newTail;
        }
        
        
    }

    public boolean remove(int index) {
       LinkedNode curr = this.head;
       int i = 0;
       while(i < index -1 && curr != null) {
        i++;
        curr = curr.next;
       }

       if(curr != null){
         if(index == 0){
            this.head = this.head.next;
         }else if(curr.next == null){
            return false;
         } else if(this.tail == curr.next){
            this.tail = curr;
            curr.next = null;
         }else {
            curr.next = curr.next.next;
         }
         return true;
       }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedNode curr = this.head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
