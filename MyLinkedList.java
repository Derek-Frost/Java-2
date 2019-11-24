import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator(){

        iteratorNode = head;

        return new Iterator<T>() {

            public void remove(){
                iteratorNode.value = null;
                iteratorNode = iteratorNode.next;
                size--;
                //TODO
                //удаляем текущий,
                //следующий становится текущим
            }

            @Override
            public boolean hasNext() {

                return iteratorNode.next != null;
                //TODO
                //проверка не ссылаемся ли мы на null

            }

            @Override
            public T next() {
                iteratorNode = iteratorNode.next;

                //TODO
                //возвращаем текущий
                // и переходим к следющему
                return (T) iteratorNode.prev;
            }
        };
    }

    void sortedAdd(T element){

        //TODO
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
    }

    public T first() {
        return head.value;
    }


    public T last() {
        return tail.value;
    }

    void add(T element){

        while(iterator.hasNext()) iterator.next();
        iteratorNode.value = element;
        size++;
        // TODO: 21.11.2019
    }

    void add(int index, T element){
        iteratorNode = tail;
        //сдвиг
        for (int i = 0; i < size - index; i++) {
            iteratorNode.next.value = iteratorNode.value;
            iteratorNode = iteratorNode.prev;
        }
        iteratorNode.value = element;
        //TODO
    }

    void remove(){
        iteratorNode = tail;
        iterator.remove();
        //TODO
    }

    int size(){
        return size;
    }

    void remove(int index){
        iteratorNode = head;
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        iterator.remove();
        while(iterator.hasNext()) iteratorNode.value = iteratorNode.next.value;

        //TODO
    }

    T get(int index){

        for (int i = 0; i < size; i++)
           iterator.next();

        //TODO
        return iteratorNode.value;
    }

    void set(int index, T value){
        iteratorNode = head;
        for (int i = 0; i < size; i++) {
            iterator.next();
        }
        iteratorNode.value = value;
        //TODO
    }

    @Override
    public String toString() {
        //TODO
        //format: [1, 2, 3, 4, 5]
        return "";
    }

}
