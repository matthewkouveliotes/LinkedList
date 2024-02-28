public interface Node<T> {

  public Node<T> getNext();
  public void setNext(Node<T> newNext);
  public T getData();
  public void setData(T newData);

}