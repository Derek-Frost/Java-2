import java.util.concurrent.ExecutionException;

public class DArray<T> {

        private int size, capacity;
        private Object [] data;

        public DArray() {
            size = 0;
            capacity = 128;
            data = new Object[capacity];
        }

        public void shiftR(Object[] arr, int index, int size) {
            while (size > index) {
                arr[size] = arr[size + 1];
                size--;
            }
        }
        public void shiftL(Object[] arr, int index, int size) {
            while(index < size) {
                arr[index] = arr[index + 1];
                index++;
            }
            arr[size] = null;
        }

        private void reallocate(){
            System.err.println("array was reallocated " + capacity);
            capacity *= 2;
            Object [] tmp = new Object[capacity];
            // N
            if (size >= 0) {
                System.arraycopy(data, 0,
                        tmp, 0, size);
            }
            data = tmp;
        }

        public void add(T value){
            if(size < capacity) {
                data[size] = value;
                size++;
            } else {
                reallocate();
                data[size] = value;
                size++;
            }
        }

        public void add(int index, T value) {
            //Не стал писать отдельный класс для ошибок
            //Защита от дураков в случае если индекс будет лежать не в области допустимых значений
            try {
                if (size < capacity) {
                    shiftR(data, index, size);
                    data[index] = value;
                    size++;
                } else {
                    reallocate();
                    shiftR(data, index, size);
                    data[index] = value;
                    size++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void remove(int index) {
            try {
                shiftL(data, index, size);
                size--;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            String S, t;
            S = "[";
            for(int i = 0; i < size - 1; i++) {
                t = String.valueOf(data[i]);
                S += t;
                S+= ", ";
            }
            S += String.valueOf(data[size]);
            S+= "]";

            return S;
        }

        public void show(){
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }
        }

        public int size(){
            return size;
        }

        public void set(int index, T value){
            data[index] = value;
        }

        public T get(int index){
            return (T) data[index];
        }
    }
}
