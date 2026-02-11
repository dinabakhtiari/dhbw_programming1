package test1;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color; 

public class AirQualityChart {
    public static void main(String[] args) {
        

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        double[] pm25Values = {12.5, 15.2, 18.3, 11.4, 20.0, 25.3, 30.5};

    
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < days.length; i++) {
            dataset.addValue(pm25Values[i], "PM2.5", days[i]);
        }


        JFreeChart chart = ChartFactory.createBarChart(
            "Weekly Air Quality Report", 
            "Day of Week",              
            "PM2.5 (µg/m³)",        
            dataset,
            PlotOrientation.VERTICAL,     
            true,                         
            true,                       
            false                     
        );


        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(79, 129, 189)); 
        plot.setBackgroundPaint(Color.white); 


        ChartFrame frame = new ChartFrame("Air Quality Dashboard", chart);
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}