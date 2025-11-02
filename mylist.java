package aston;
import java.util.*;

public class mylist<A> extends ArrayList<A> {


    public void insert(A x) {
        super.add(x);
    }


    public A getElement(int index) {
        return super.get(index);
    }


    public void delete(int index) {
        super.remove(index);
    }


    public void insertAll(mylist<? extends A> other) {
        super.addAll(other);
    }

    public static void main(String[] args) {
        mylist<String> list = new mylist<>();

        list.insert("A");
        list.insert("B");
        list.insert("C");
        System.out.println("После insert: " + list);

        list.delete(2);
        System.out.println("После delete(1): " + list);

        System.out.println("Элемент с индексом 2: " + list.getElement(2));

        mylist<String> anotherList = new mylist<>();
        anotherList.insert("X");
        anotherList.insert("Y");

        list.insertAll(anotherList);
        System.out.println("После insertAll: " + list);
    }
}
