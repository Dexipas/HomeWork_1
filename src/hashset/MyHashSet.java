package hashset;

import java.util.LinkedList;

public class MyHashSet<V> {

    private LinkedList<V>[] buckets;
    private int size;

    public MyHashSet() {
        size = 10;
        buckets = new LinkedList[size];
    }
    public MyHashSet(int size) {
        this.size = size;
        buckets = new LinkedList[size];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++) {
//            result.append("["+i+"] "+buckets[i].toString()+"\n");
            result.append("["+i+"] "+buckets[i]+"\n");
        }
        return result.toString();
    }

    public boolean add(V v){
        if(v == null) return false;
        int key = v.hashCode() % size;
        if(buckets[key] == null){
            buckets[key] = new LinkedList<>();
            buckets[key].add(v);
            return true;
        }  else {
            for(V i:buckets[key]){
                if(i.hashCode() == v.hashCode())
                    if(i.equals(v)){
                        i = v;
                        return false; //пусть пока будет false, так как мы добавляем имеющийся объект
                    }
            }
            buckets[key].add(v);
            return true;
        }
    }

    public boolean remove (V v){
        if(v == null) return false;
        int key = v.hashCode() % size;
        for(V i:buckets[key]){
            if(i.hashCode() == v.hashCode())
                if(i.equals(v)){
                    buckets[key].remove(i);
                    return true;
                }
        }
        return false; //объект удаления не найден
    }

}
