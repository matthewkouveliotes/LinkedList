import java.lang.*; 
public class LL_Kouveliotes<T> implements LinkedListInterface<T> {
  private LLNode_Kouveliotes<T> first;

  public LL_Kouveliotes() {
    first = null;
  }

  public boolean contains(T element) {
    LLNode_Kouveliotes<T> current = first; 
    // continue going through the L.L until null
    while(current != null) {
      // check if the current is the element
      if(current.getData().equals(element))
        return true;
      // continue through LL
      current = (LLNode_Kouveliotes) current.getNext(); 
    }
    // the elelment is not in the list
    return false; 
  }

  public int indexOf(T element) {
    int index = 0;
    LLNode_Kouveliotes<T> current = first;
    // continue through list until null
    while(current != null) {
      // if we reach the element, return the index
      if(current.getData().equals(element))
        return index;
      // continue
      current = (LLNode_Kouveliotes) current.getNext();
      index++;
    }
    // item isn't in the list
    return -1; 
  }

  public int lastIndexOf(T element) {
    int currIndex = 0;
    int lastIndex = -1; 
    LLNode_Kouveliotes<T> current = first;
    // continue through the list until null 
    while(current != null) {
      // if match, record the index
      if(current.getData().equals(element))
        lastIndex = currIndex;
      // continue
      currIndex++;
      current = (LLNode_Kouveliotes) current.getNext(); 
    }
    return lastIndex; 
  }

  public int size() {
    int index = 0;
    LLNode_Kouveliotes<T> current = first;
    // continue through LL until null
    while(current != null) {
      index++;
      // count and continue
      current = (LLNode_Kouveliotes) current.getNext(); 
    }
    return index; 
  }

  public boolean isEmpty() {
    return first == null; 
  }

  public T get(int index) {
    if(index < 0) 
      throw new IndexOutOfBoundsException(); 
    int currIndex = 0;
    LLNode_Kouveliotes<T> current = first;
    while(current != null) {
      if(currIndex == index) {
        return current.getData();
      }
      current = (LLNode_Kouveliotes) current.getNext();
      currIndex++;
    }
    throw new IndexOutOfBoundsException();
  }

  public T set(int index, T element) {
    // check if requested index is below 0
    if(index < 0) 
      throw new IndexOutOfBoundsException(); 
    int currIndex = 0;
    LLNode_Kouveliotes<T> current = first;
    // continue through list until null
    while(current != null) {
      // once we get to the index, store old data, set new data, return old data
      if(currIndex == index) {
        T oldData = current.getData();
        current.setData(element);
        return oldData; 
      }
      // continue through list
      current = (LLNode_Kouveliotes) current.getNext();
      currIndex++;
    }
    // if this is reached then the index is out of bounds
    throw new IndexOutOfBoundsException();
  }

  public void clear() {
    first = null; 
  }

  public void add(T element) {
    LLNode_Kouveliotes<T> newNode = new LLNode_Kouveliotes<T>(element);
    // check if first doesn't exist
    if(first == null) {
      first = newNode;
      return;
    }
    LLNode_Kouveliotes<T> prev = null;
    LLNode_Kouveliotes<T> next = first;
    // go through list until next is null
    while(next != null) {
      // continue through the list
      prev = next;
      next = (LLNode_Kouveliotes) next.getNext();
    }
    // link nodes
    prev.setNext(newNode); 
    
  }

  public void add(int index, T element) {
    // check if less than 0
    if(index < 0 || (first == null && index > 0))
      throw new IndexOutOfBoundsException();
    LLNode_Kouveliotes<T> newNode = new LLNode_Kouveliotes<T>(element);
    // check if trying to add to first 
    if(index == 0) {
      if(first == null) {
        first = newNode; 
      }
      else {
        newNode.setNext(first);
        first = newNode; 
      }
      return;
    }
    LLNode_Kouveliotes<T> prev = null;
    LLNode_Kouveliotes<T> next = first;
    int currIndex = 0; 
    // go until end of list
    while(next != null) {
      // check if before target index
      if(currIndex == index) {
        // link the nodes
        prev.setNext(newNode);
        newNode.setNext(next);
        return;
      }
      // continue through the list
      currIndex++;
      prev = next;
      next = (LLNode_Kouveliotes) next.getNext();
      // deals with trying to add at last index
      if(next == null && currIndex == index) {
        prev.setNext(newNode);
        return;
      }
    }
    // if this is reached, then index was out of bounds, so send exception
    throw new IndexOutOfBoundsException();
  }

  public T remove(int index) {
    if(index < 0) 
      throw new IndexOutOfBoundsException();
    // check if trying to set 0 and its empty
    if(index == 0 && first != null) {
      T oldData = first.getData();
      first = (LLNode_Kouveliotes) first.getNext();
      return oldData;
    }
    LLNode_Kouveliotes<T> prev = null;
    LLNode_Kouveliotes<T> next = first; 
    int currIndex = 0;
    // go through entire list
    while(next != null) {
      if(currIndex == index) {
        T oldData = prev.getNext().getData();
        prev.setNext(next.getNext());
        return oldData;
      }
      prev = next;
      next = (LLNode_Kouveliotes) next.getNext();
      currIndex++;
    }
    throw new IndexOutOfBoundsException();
  }

  public boolean remove(T element) {
    // check if empty
    if(first == null) return false;
    LLNode_Kouveliotes<T> prev = null;
    LLNode_Kouveliotes<T> next = first;
    // go through entire list
    while(next != null) {
      if(next.getData().equals(element)) {
        if(prev == null) {
          first = (LLNode_Kouveliotes) next.getNext();
          return true;
        }
        prev.setNext(next.getNext());
        return true;
      }
      prev = next;
      next = (LLNode_Kouveliotes) next.getNext();
    }
    return false;
  }

  public String toString() {
    String c = "[";
    if(first == null) return "[]";
    LLNode_Kouveliotes<T> curr = first;
    while(curr != null) {
      if(curr.getNext() == null) {
        c += curr.getData().toString() + "]";
        return c;
      }
      c += curr.getData().toString() + ", ";
      curr = (LLNode_Kouveliotes) curr.getNext();
    }
    return c + "]";
  }


}