
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.chart.renderer.category.StatisticalLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;

import java.util.*;

/**
 * The class  <b>ITI1121Chart</b> uses the library
 * <b>JFreeChart</b>. It can be used to create a chart
 * made of a series of points, each with a confidence
 * interval. It can also superimpose on the graph  
 * drawings of functions of the form y=x^k.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class ITI1121Chart extends ApplicationFrame {


    private YIntervalSeriesCollection dataset;
    private YIntervalSeries series;

    private PolyDataset polyDataset;

    private List<Double> itemList;

    /** 
     * Constructor.
     * 
     * @param title the title for the graph
     */
     public ITI1121Chart(String title) {
        super(title);
        dataset = new YIntervalSeriesCollection();
        series = new YIntervalSeries("Birthday Results");
        itemList =new ArrayList<Double>();
        polyDataset = new PolyDataset();
     }

    /** 
     * This method draws the graph. The method is to be called 
     * only once, after all the data has been added
     */
     public void render(){

        JPanel chartPanel = createPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
     }

    /** 
     * Adds a data point to the graph. A dot at the position
     * (x,y) will be added, and a vertical line of length
     * ``confidence'' centered on the point will also be drawn
     *
     * @param x the abscissa 
     * @param y the ordinate 
     * @param confidence the confidence interval 
     */

    public void addDataPoint(double x, double y, double confidence){
        series.add(x,y, y - confidence/2, y + confidence/2);
        itemList.add(x);
    }

   /** 
     * Adds a curve of the form y=x^k to the graph.
     *
     * @param k the polynomial degree    
     */
    public void addPolynome(double k){
        polyDataset.addPolynome(k);
    }

    private  JPanel createPanel() {
        Collections.sort(itemList);
        polyDataset.setItemList(itemList);
        JFreeChart chart = createChart(polyDataset);


        XYPlot plot = (XYPlot) chart.getPlot();
 
        dataset.addSeries(series);    
        plot.setDataset(1, dataset);
        XYErrorRenderer renderer = new XYErrorRenderer();
        renderer.setBaseLinesVisible(true);
        renderer.setBaseShapesVisible(false);
        plot.setRenderer(1, renderer);


        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }


    private  JFreeChart createChart(XYDataset dataset) {

        // create the chart...
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Birthday Paradox Experiments",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

       XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        plot.getDomainAxis().setLowerMargin(0.0);
        plot.getDomainAxis().setUpperMargin(0.0);
        plot.setDomainPannable(true);
        plot.setRangePannable(true);

        XYLineAndShapeRenderer renderer
                = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setLegendLine(new Rectangle2D.Double(-4.0, -3.0, 8.0, 6.0));
        return chart;
    }
   
}
