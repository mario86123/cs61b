import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hug.
 */
public class Experiments {
    public static void experiment1() {
        Random r = new Random();
        List<Double> yValues = new ArrayList<>();
        List<Double> y2Values = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        for (int x = 0; x < 100; x += 1) {
            BST<Integer> tree = new BST<>();
            for (int i = 0; i < 5000; i += 1) {
                tree.add(r.nextInt());
            }
            double thisY = tree.averageDepth();
            xValues.add(x);
            yValues.add(thisY);

            double thisY2 = ExperimentHelper.optimalAverageDepth(5000);
            y2Values.add(thisY2);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("number of items").yAxisTitle("y label").build();
        chart.addSeries("the average depth of your BST", xValues, yValues);
        chart.addSeries("the average depth of an optimal BST", xValues, y2Values);

        new SwingWrapper(chart).displayChart();
    }

    public static void experiment2() {
        Random r = new Random();
        List<Double> yValues = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 5000; i += 1) {
            tree.add(r.nextInt());
        }
        for (int x = 0; x < 100; x += 1) {
            for (int i = 0; i < 10; i += 1){
                tree.deleteTakingSuccessor(tree.getRandomKey());
                tree.add(r.nextInt());
            }
            double thisY = tree.averageDepth();
            xValues.add(x);
            yValues.add(thisY);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("number of items (asymmetric deletion)").yAxisTitle("y label").build();
        chart.addSeries("the average depth of your BST", xValues, yValues);

        new SwingWrapper(chart).displayChart();
    }

    public static void experiment3() {
        Random r = new Random();
        List<Double> yValues = new ArrayList<>();
        List<Integer> xValues = new ArrayList<>();
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 5000; i += 1) {
            tree.add(r.nextInt());
        }
        for (int x = 0; x < 100; x += 1) {
            for (int i = 0; i < 100; i += 1){
                tree.deleteTakingRandom(tree.getRandomKey());
                tree.add(r.nextInt());
            }
            double thisY = tree.averageDepth();
            xValues.add(x);
            yValues.add(thisY);
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).xAxisTitle("number of items (symmetric deletion)").yAxisTitle("y label").build();
        chart.addSeries("the average depth of your BST", xValues, yValues);

        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
//        experiment1();
        experiment2();
        experiment3();
        return;
    }
}
