public class LLNode_Kouveliotes<T> implements Node<T> {
  private T data;
  private LLNode_Kouveliotes<T> next;

  public LLNode_Kouveliotes(T data) {
    this.data = data;
    this.next = null;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> newNext) {
    next = (LLNode_Kouveliotes)newNext; 
  }

  public T getData() {
    return data;
  }

  public void setData(T newData) {
    data = newData;
  }
}