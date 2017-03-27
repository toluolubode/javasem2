public class EmptyStackException extends NullPointerException{
  private Object elem;

  public EmptyStackException(Object elem){
    this.elem= elem;

    if (elem==null){
      System.out.println("This is null");
    }
  }
  public Object getElem(){
    return elem;
  }
}
