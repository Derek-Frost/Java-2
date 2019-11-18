
import java.lang.Object;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MyArray<T extends Comparable<T>> {

    private Object[] data;
    private int size, capacity;

    public MyArray() {
        size = 0;
        capacity = 128;
        data = new Integer[capacity];
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void add(T element){
        if(size < capacity){
            data[size] = element;
            size++;
        }
        else {
            reallocate();
            data[size] = element;
            size++;
        }
    }
    private void swap(int[] data, int ind1, int ind2) {
        int tmp = data[ind1];
        data[ind1] = data[ind2];
        data[ind2] = tmp;
    }
    public void set(int index, T value){
        data[index] = value;
    }

    public T get(int index){
        return (T) data[index];
    }

    public int size(){
        return size;
    }

    public void add(int index, T element){
        if(size < capacity){
            if (size - index >= 0) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = element;
            size++;
        }
        else {
            reallocate();
            if (size - index >= 0) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = element;
            size++;
        }
    }

    private void reallocate(){
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    public boolean remove(){
        size--;
        return size >= 0;

    }

    public boolean remove(int index){
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        size--;
        return true;
    }

    /*
     * Метод должен возвращать массив размером size
     * */
    public T [] toArray(){
        //TODO
        return null;
    }

    /*
     * Метод должен возвращать индекс первого найденного элемента
     * или -1, если такого нет
     * */
    public int linearSearch(T element){
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == element) index = i;
        }
        return index;
    }

    /*
     * Тип data - Object, но для сортировки нам нужен сравнимый тип
     * мы именного его передаем внутрь
     * Поскольку класс Объект родитель всего
     * справедлива следующая запись: ((T)arrayElement).compareTo(T otherElement)
     * Объект приведенный к типу Т, будет иметь метод сравнения
     * */
    public void insertSort(int[] data){
        for (int left = 0; left < data.length; left++) {
            // Вытаскиваем значение элемента
            int value = data[left];
            // Перемещаемся по элементам, которые перед вытащенным элементом
            int i = left - 1;
            for (; i >= 0; i--) {
                // Если вытащили значение меньшее — передвигаем больший элемент дальше
                if (value < data[i]) {
                    data[i + 1] = data[i];
                } else {
                    // Если вытащенный элемент больше — останавливаемся
                    break;
                }
            }
            // В освободившееся место вставляем вытащенное значение
            data[i + 1] = value;
        }
        System.out.println(Arrays.toString(data));
    }

    static class Pair<T> {
        T element;
        Integer counter;

        public Pair(T element, Integer counter) {
            this.element = element;
            this.counter = counter;
        }
    }

    /*
     * Метод должен вернуть пару из значения элемента
     * и количества раз, которое он встретился в массиве data
     * вернуть нужно пару, элемент которой встретился наибольшее количество раз
     * А если таквых элементов много, то нужно вернуть тот, у которого значение наибольшее
     * Пусть data = [1, 3, 1, 5, 1, 4] тогда ответ new Pair<Integer>(1, 3)
     * Пусть data = [1, 2, 1, 2, 1, 2] тогда ответ new Pair<Integer>(2, 3)
     * Пусть data = [1, 2, 3, 4, 5, 6] тогда ответ new Pair<Integer>(6, 1)
     * Пусть data = [1, 1, 3, 4, 5, 6] тогда ответ new Pair<Integer>(1, 2)
     * */
    public Pair<T> taskMaxCount(){
        int data[] = {1, 2, 3, 4, 4, 5 ,6, 1, 1, 2};
        int MaxCount = 0;
        int key = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < data.length; i++){
            if(map.containsKey(data[i])) map.put(data[i], map.get(data[i])+1);
            else map.put(data[i], 1);
        }
        for (int i = 0; i < data.length; i++) {
            if(map.get(data[i]) > MaxCount) {
                MaxCount = data[i];
                key = i;
            }
        }
        System.out.println("(" + data[key] + ", " + MaxCount + ")");
        return null;
    }
    //К сожалению, все писал в блокноте на ipad в дороге, поэтому не смог проверить работоспособность :(

    public void bubbleSort(int[] data){
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < data.length; i++) {
                if (data[i] < data[i - 1]) {
                    swap(data, i, i-1);
                    needIteration = true;
                }
            }
        }
        System.out.println(Arrays.toString(data));
    }
    /*
     * Задача под звездочкой
     * решается опционально, кому интересно
     * */
    public void quickSort(){
        //TODO
    }

    private void quickSort(T [] data, int left, int right) {
        //TODO
    }

    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 10; i++) {
            arr.add(i+1);
        }
        arr.add(3, 100);
        arr.show();
        System.out.println(Arrays.toString(arr.toArray()));
    }

}
