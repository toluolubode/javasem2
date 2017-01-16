public class A1Q1 {

    /**
     * Returns the number of strictly positive elements in elems.
     * We assume that the list is not null.
     *
     *   @param elems the list of integers
     *  @return the number of strictly positive elements in elems
     */

    private static int countPositive(int[] elems) {
      int counter = 0;
      for(int item : elems){
        if(item > 0){
          counter += 1;
        }
      }
      return counter;
    }

    public static void main(String[] args) {
      int[] result= new int [args.length];
      for (int i = 0; i < args.length; i++) {
        result[i] = Integer.valueOf(args[i]);
      }
      System.out.println(countPositive(result));

    }
}
