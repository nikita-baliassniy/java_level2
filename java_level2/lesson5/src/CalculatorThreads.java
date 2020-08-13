public class CalculatorThreads {

    private static final int size = 10000000;
    private static final int h = size / 2;
    private volatile static float[] arr = new float[size];

    public void recalculate() {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        float[] array1 = new float[h];
        float[] array2 = new float[h];

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, array1, 0, h);
        System.arraycopy(arr, h, array2, 0, h);

        CalculateRunner calculateRunner1 = new CalculateRunner(array1);
        CalculateRunner calculateRunner2 = new CalculateRunner(array2);
        Thread thread1 = new Thread(calculateRunner1);
        Thread thread2 = new Thread(calculateRunner2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(calculateRunner1.getArray(), 0, arr, 0, h);
        System.arraycopy(calculateRunner2.getArray(), 0, arr, h, h);
        long finishTime = System.currentTimeMillis();
        System.out.println("Delta time in threads = " + (finishTime - startTime) + " ms");
    }
}

class CalculateRunner implements Runnable {

    private float[] array;

    public CalculateRunner(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArray() {
        return array;
    }
}