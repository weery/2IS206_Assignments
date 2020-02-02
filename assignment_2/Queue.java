package assignment_2;

public class Queue<T> implements IQueue<T> {

    private IDoubleLinkedList<T> mQueueList = new DoubleLinkedList<T>();

    @Override
    public void offer(T element) {
        mQueueList.add(element);
    }

    @Override
    public T peek() {
        T returnElement = null;
        try{
            returnElement = mQueueList.get(0);
        } catch (IndexOutOfBoundsException e){

        }
        return returnElement;
    }

    @Override
    public T poll() {
        T returnElement = null;
        try{
            returnElement = mQueueList.remove(0);
        } catch (IndexOutOfBoundsException ex){

        }

        return returnElement;
    }

    @Override
    public int size() {
        return mQueueList.size();
    }

    @Override
    public T[] toArray() {
        return mQueueList.toArray();
    }

    @Override
    public String toString(){
        return mQueueList.toString();
    }
}
