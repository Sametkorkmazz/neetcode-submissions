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
        this.head = new LinkedNode(-1);
        this.tail = head;
    }

    public int get(int index) {
        LinkedNode curr = head.next;
        int i = 0;

        while(i < index && curr != null) {
            curr = curr.next;
            i++;
        }
        
        return curr != null ? curr.val : -1;
    }

    public void insertHead(int val) {
        LinkedNode newHead = new LinkedNode(val);
        newHead.next = this.head.next;
        this.head.next = newHead;
        if(newHead.next == null){
            this.tail = newHead;
        }
    }

    public void insertTail(int val) {
        LinkedNode newTail = new LinkedNode(val);
        this.tail.next = newTail;
        this.tail = newTail;
        
    }

    public boolean remove(int index) {
       LinkedNode curr = this.head;
       int i = 0;
       while(i < index && curr != null) {
        i++;
        curr = curr.next;
       }

       if(curr != null && curr.next != null){
        if(curr.next == this.tail){
            this.tail = curr;
        }
         curr.next = curr.next.next;
         return true;
       }

        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedNode curr = this.head.next;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        return list;
    }
}
