public class SimpleCalculator {

    private static final int size = 10000000;
    private volatile static float[] arr = new float[size];

    public void recalculate() {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Delta time simple calculate = " + (finishTime - startTime) + " ms");

    }
}
