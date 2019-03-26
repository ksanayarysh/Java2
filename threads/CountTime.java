package threads;

public class CountTime {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public float[] getArr() {
        return arr;
    }

    public void oneThread(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }

        System.out.println("Время выполнения one thread: " + (System.currentTimeMillis() - startTime) + " ms");

    }

    public void multiThread(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        float[] first_part = new float[h];
        float[] second_part = new float[h];
        long startTime = System.currentTimeMillis();

        // Разбить массив на два массива
        System.arraycopy(arr, 0, first_part, 0, h);
        System.arraycopy(arr, h, second_part, 0, h);

        // Запустить два потока
        // Вычислить значения в новых потоках

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                first_part[i] = (float) (first_part[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                second_part[i] = (float) (second_part[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Склеить массивы

        System.arraycopy(first_part, 0, arr, 0, h);
        System.arraycopy(second_part, 0, arr, h, h);

        System.out.println("Время выполнения multi thread: " + (System.currentTimeMillis() - startTime) + " ms");
    }

}

class MainApp{
    public static void main(String[] args) {
        CountTime t = new CountTime();
        t.oneThread();
        t.multiThread();
    }
}