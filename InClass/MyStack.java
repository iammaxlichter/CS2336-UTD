package CS2336.InClass;

public class MyStack<E> {
    private MyArrayList<E> list;

    public MyStack(){
        list = new MyArrayList<E>();
    }

    public boolean empty() {
        return list.empty();
    }

    public E peek() {
        return list.get(list.size()-1);
    }

    public E pop() {
        E last = list.get(list.size()-1);
        list.remove(list.size()-1);
        return last;
    }

    public E push(E item){
        list.add(item);
        return peek();
    }

    public int search(Object o){
        int index = list.indexOf(o);
        if(index < 0)
            return index;
        return list.size() - index;
    }
}
