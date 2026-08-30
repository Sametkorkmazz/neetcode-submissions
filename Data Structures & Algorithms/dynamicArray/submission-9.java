class DynamicArray {
 
 private int capacity;
  private int lastElementIndex;
  private int[] array;
    public DynamicArray(int capacity) {
this.capacity = capacity;
this.lastElementIndex = 0;
this.array = new int[capacity];
    }

    public int get(int i) {
return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if(this.lastElementIndex  == this.capacity){
          this.capacity *= 2;
int[] temp = new int[this.capacity ];
for(int i=0 ;i < this.lastElementIndex;   i++){
    temp[i] = this.array[i];
}
this.array = temp;
        }

 this.array[this.lastElementIndex++] = n;
        
    }

    public int popback() {
        return this.array[--this.lastElementIndex];
    }

    private void resize() {
this.capacity *= 2;
int[] temp = new int[this.capacity *2 ];
for(int i=0 ;i <= this.lastElementIndex;   i++){
    temp[i] = this.array[i];
}
this.array = temp;
    }

    public int getSize() {
return this.lastElementIndex;
    }

    public int getCapacity() {
return this.capacity;
    }
}
