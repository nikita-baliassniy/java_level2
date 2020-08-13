public class Main {

    public static void main(String[] args) {

        CalculatorThreads calculatorThreads = new CalculatorThreads();
        calculatorThreads.recalculate();

        SimpleCalculator simpleCalculator = new SimpleCalculator();
        simpleCalculator.recalculate();

    }

}
