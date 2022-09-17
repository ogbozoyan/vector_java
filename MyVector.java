public class MyVector<T> {

    private Object[] Array;
    private int size;
    private int oversize;

    public void grow(int size){
        if(size<=0){
            throw new IllegalArgumentException("Illegal size: "+
                    size);
        }
        var temArr = new Object[(this.size*2+10)+size];
        if (this.size >= 0) System.arraycopy(this.Array, 0, temArr, 0, this.size);
        this.Array = new Object[(this.size*2+10)+size];
        this.size = (this.size*2+10)+size;
        if (this.size >= 0) System.arraycopy(temArr, 0, this.Array, 0, this.size);
    }
    public MyVector(int size,int count) {
        if(size<0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    size);
        this.size = size*2+10;
        this.Array = new Object[size*2+10];
        this.oversize = count;
    }
    public MyVector(int size){this(size,0);}
    public MyVector(){this(10);}
    public boolean isEmpty() {
        return size == 0;
    }
    public void addTo(int index,T value){
        if(index > (size*2+10))
            throw new ArrayIndexOutOfBoundsException("Overflow");
        this.Array[index] = value;
    }
    public T getValue(int index){
        if(index > (size*2+10))
            throw new ArrayIndexOutOfBoundsException("Overflow");
        return (T) this.Array[index];
    }
    public void remTo(int index){
        if(index > (size*2+10))
            throw new ArrayIndexOutOfBoundsException("Overflow");
        this.Array[index] = null;
    }
    public void addEnd(T val){
        this.Array[size-1] = val;
    }
    public void remEnd(){
        this.Array[size-1] = null;
    }
    public void clear(){
        for(int i = 0;i<size;i++){
            this.remTo(i);
        }
    }
    public void getSize(){
        int buf = 0;
        System.out.println("Max size: "+size);
        for(int i=0;i<size;i++){
            if(this.getValue(i) == null){
                continue;
            }
            else buf += 1;
        }
        System.out.println("Current size: "+ buf);
    }
}



