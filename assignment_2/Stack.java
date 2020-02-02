package assignment_2;

public class Stack<T> implements IStack<T>{

    private ISingleLinkedList<T> mNodeList = new SingleLinkedList<T>();

    @Override
    public T pop() {
        T returnElement = null;
        try{
            returnElement = mNodeList.remove(0);
        } catch (IndexOutOfBoundsException ex){
            // We do not consider this case, as we will return null if there is no
            // item to pop in the stack
        }
        return returnElement;
    }

    @Override
    public void push(T element) {
        mNodeList.add(0, element);
    }

    @Override
    public int search(T element) {
        return mNodeList.indexOf(element);
    }

    @Override
    public int size() {
        return mNodeList.size();
    }

    @Override
    public T[] toArray() {
        return mNodeList.toArray();
    }

    @Override
    public T top() {
        T returnElement = null;
        try{
            returnElement = mNodeList.get(0);
        }
        catch (IndexOutOfBoundsException ex){
            // We only need to make sure we return Null when there is no items in the stack
        }
        return returnElement;
    }

    @Override
    public String toString(){
        return mNodeList.toString();
    }
}
