package linkedlist;

import java.util.Arrays;
import java.util.Collection;

public class MyLinkedList<E> {

    private class Element{
        E value = null;
         Element prev = null, next = null;
        private Element(E value, Element prev, Element next){
            this.value = value; this.prev = prev; this.next = next;
        }
    }

    private Element first = null;
    private Element end = null;
    private int size = 0;

    @Override
    public String toString() {
        Element element = first;
        StringBuilder result = new StringBuilder();
        while (element != null){
            result.append("["+element.value.toString()+"] ");
            element = element.next;
        }
        return result.toString();
    }

    public boolean add(E e){
        if(first == null){
            first = new Element(e,null,null);
            size++;
            return true;
        } else if(end == null){
            end = first;
            first = new Element(e, null, end);
            end.prev = first;
            size++;
        } else {
            first = new Element(e, null, first);
            first.next.prev = first;
            size++;
        }
        return false;
    }

    public E get(int index){
        if((index == 1) && (size == 1))
            return first.value;
        if((index <= size) && (index > 0))
            if(index <= size/2){
                Element element = first;
                for(int i = 1; i <= index; i++){
                    if(i == index) return element.value;
                    element = element.next;
            }
        } else {
                Element element = end;
                for(int i = 0; i <= size-index; i++){
                    if(i == size-index) return element.value;
                    element = element.prev;
                }
            }
        return null;
    }

    public boolean remove(E e){
        Element element;

        if(first.value == e){
            element = first;
            first = first.next;
            element.next = null;
            size--;
            return true;
        }

        if(end.value == e){
            element = end;
            end = end.prev;
            end.next = null;
            element.prev = null;
            size--;
            return true;
        }

        element = first;

        while (element != null){
            if(element.value == e){
                element.next.prev = element.prev;
                element.prev.next = element.next;
                size--;
                return true;
            }
            element = element.next;
        }

        return false;
    }

    public boolean addAll(Collection<E> e){
        if(!e.isEmpty()){
            for(Object i:e.toArray()){
                add((E) i);
            }
            return true;
        }
        return false;
    }

    public boolean addAll(E[] e){
        if(e.length != 0){
            for(E i:e){
                add(i);
            }
            return true;
        }
        return false;
    }
}
