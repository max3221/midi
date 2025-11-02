package aston;

import java.util.*;

public class myhash<A> extends HashSet<A> {


    public void insert(A x) {
        super.add(x);
    }


    public void delete(A x) {
        super.remove(x);
    }

    public static void main (String[] args) {
        myhash<String> set = new myhash<>();

        set.insert("10");
        set.insert("20");
        set.insert("30");
        System.out.println("После вставки: " + set);

        set.delete((String)"20");
        System.out.println("После удаления: " + set);
    }
}