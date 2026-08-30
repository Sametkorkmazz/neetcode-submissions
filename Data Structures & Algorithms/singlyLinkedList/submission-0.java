class LinkedList {
    private final List<Integer> values;

    public LinkedList() {
        values = new ArrayList<>();
    }

    public int get(int index) {
        if(index >= values.size()){
                return -1;
        }
        return values.get(index);
    }

    public void insertHead(int val) {
        values.add(0, val);
    }

    public void insertTail(int val) {
        values.add(val);
    }

    public boolean remove(int index) {
       if(index >= values.size()){
                return false;
        }
         values.remove(index);
         return true;
    }

    public ArrayList<Integer> getValues() {
        return new ArrayList<>(values);
    }
}
