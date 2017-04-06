import java.util.Arrays;

/**
 * Created by tbee on 4/5/17.
 */
public class myTester {

    public static void main(String[] args) {
        LinearFrequencyTable l = new LinearFrequencyTable();
        l.init("tbee");
        l.init("Jesus");
        l.init("Family");
        l.init("MUFC");
        l.init("CODE");
        l.init("Zebra");

        l.update("MUFC");

        for (int i = 0; i < 45; i++){
            l.update("Jesus");
        }
        LinkedList<String> keys =  l.keys();

        long[] vals = l.values();

        System.out.println(l);
        System.out.println(keys.size());
        System.out.println(keys);
        System.out.println(Arrays.toString(vals));
    }
}
