package airPolution.test1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class test1 {
    public static void main(String[] args) {
        // 1. Create a simple dataset
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Java", 80);
        dataset.setValue("Python", 20);

        // 2. Create the chart
        JFreeChart chart = ChartFactory.createPieChart(
            "Programming Languages", // Title
            dataset,                 // Data
            true, true, false);

        // 3. Display it in a window
        ChartFrame frame = new ChartFrame("My First Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
