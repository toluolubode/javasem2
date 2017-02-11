import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

import java.util.ArrayList;
import java.util.List;


public class PolyDataset extends AbstractXYDataset implements XYDataset {

   
    private List<Double> polyList;
    private List<Double> itemList;

    public PolyDataset(){
        super();
        polyList = new ArrayList<Double>();
    }

    public void addPolynome(double poly) {
        polyList.add(poly);
    }

    public void setItemList(List<Double> list){
        itemList = list;
    }
    /**
     * Returns the x-value for the specified series and item.  Series are 
     * numbered 0, 1, ...
     *
     * @param series  the index (zero-based) of the series.
     * @param item  the index (zero-based) of the required item.
     *
     * @return the x-value for the specified series and item.
     */
    public Number getX(int series, int item) {
 //       return new Double( item);
        return new Double( itemList.get(item));
    }

    /**
     * Returns the y-value for the specified series and item.  Series are 
     * numbered 0, 1, ...
     *
     * @param series  the index (zero-based) of the series.
     * @param item  the index (zero-based) of the required item.
     *
     * @return the y-value for the specified series and item.
     */
    public Number getY(int series, int item) {
        return new Double(Math.pow(itemList.get(item),polyList.get(series)));
    }

    /**
     * Returns the number of series in the dataset.
     *
     * @return the number of series in the dataset.
     */
    public int getSeriesCount() {
        return polyList.size();
    }

    /**
     * Returns the key for a series.
     *
     * @param series  the index (zero-based) of the series.
     *
     * @return The key for the series.
     */
    public Comparable getSeriesKey(int series) {
        return "k = " + polyList.get(series);
    }

    /**
     * Returns the number of items in the specified series.
     *
     * @param series  the index (zero-based) of the series.
     * @return the number of items in the specified series.
     *
     */
    public int getItemCount(int series) {
        return itemList.size();
    }

}







