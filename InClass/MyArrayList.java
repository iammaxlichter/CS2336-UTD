package CS2336.InClass;

public class MyArrayList<E> {
    private E array[];
    private int numitems; //actual # of current items stored 

    private final int INCREMENTALCAPACITY = 5;

    public MyArrayList(){
        numitems = 0;
        array = (E[]) new Object [INCREMENTALCAPACITY];
    }

    //add new item at the end of array
    private void expand(){
        if(numitems == array.length){
            E temp[] = (E[]) new Object [array.length + INCREMENTALCAPACITY];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    
    public void add(E newItem){
        expand();
        //adding the new item at the end
        array[numitems++] = newItem;
    }

    //insert new item at specific index
    public void add(int index, E addItem){
        expand();

        System.arraycopy(array, index, array, index+1, numitems-index);
        array[index] = addItem;
    }

    public String toString(){
        if(numitems == 0){
            return "";
        }
        String result = array[0].toString();
        for(int i = 0; i<numitems; i++){
            result += ", " + array[i];
        }
        return result;
    }

    public int indexOf(Object searchItem){
        for(int i = 0; i<numitems ; i++){
            if(array[i].equals(searchItem)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object item){
        return indexOf(item) >= 0;
    }


    public boolean remove(Object item){
        //find first occurance and remove it
        int index = indexOf(item);
        if(index == -1)
            return false;
        return true;
    }

    public void clear(){
        numitems = 0;
        array = (E[]) new Object [INCREMENTALCAPACITY];
        
    }

    public int size(){
        return numitems;
    }



    

    public static void main(String[] args){
        MyArrayList<Integer> list1 = new MyArrayList<Integer>();
        list1.add(5);
        list1.add(10);
        list1.add(20);
        System.out.println(list1);

        MyArrayList<String> list2 = new MyArrayList<String>();
        list2.add("Hello");
        list2.add("World!");
        System.out.println(list2);
    }

    public boolean empty() {
        return false;
    }

    public E get(int i) {
        return null;
    }
}
