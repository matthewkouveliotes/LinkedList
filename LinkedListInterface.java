public interface LinkedListInterface<T> {

  public void add(int index, T element);
  public void add(T element);
  public T set(int index, T element);
  public T remove(int index);
  public boolean remove(T element);
  public T get(int index);
  public boolean contains(T element);
  public int size();
  public boolean isEmpty();
  public void clear();
  public int indexOf(T element);
  public int lastIndexOf(T element);
}