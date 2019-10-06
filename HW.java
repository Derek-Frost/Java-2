package TreadTest;

public class HW {

    static final int size = 10000000;
    static final int h = size / 2;
    synchronized static void Calculation(float[] arr){

        long time = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        for(int i = 0; i < h; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println(Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis() - time);
    }
   static void firstMethod() {
        float[] arr = new float[size];
        for(int i = 0; i < size; i++){
            arr[i] = 1;
        }
        long time = System.currentTimeMillis();

        for(int i = 0; i < size; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    static void secondMethod(){
        float[] arr = new float[size];

        for(int i = 0; i < size; i++){
            arr[i] = 1;
        }


        Runnable r = () -> Calculation(arr);

        new Thread(r, "Thread #1").start();
        new Thread(r, "Thread #2").start();




    }
    public static void main(String[] args) {
    firstMethod();

    secondMethod();
    }
}
