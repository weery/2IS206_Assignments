package assignment_2;

public class SingleLinkedList<T> implements ISingleLinkedList<T> {

    /**
     * Inner class to hold the structure objects
     */
    private class ListNode{
        private T mData = null;
        private ListNode mNextNode = null;
        public ListNode(T data){
            mData = data;
        }
        public void setData(T data){
            mData = data;
        }
        public T getData(){
            return mData;
        }
        public void setNextNode(ListNode nextNode){
            mNextNode = nextNode;
        }
        public ListNode getNextNode(){
            return mNextNode;
        }
    }

    private ListNode mHeadNode = null;

    @Override
    public void add(T element) {
        ListNode newNode = new ListNode(element);

        if (mHeadNode == null){
            mHeadNode = newNode;
        } else {
            getLastNode().setNextNode(newNode);
        }
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (!isValidAddIndex(index)){
            throw new IndexOutOfBoundsException("Unable to get index " + index +
                    " in a single linked list with  elements");
        }
        ListNode newNode = new ListNode(element);

        if (index == 0){
            newNode.setNextNode(mHeadNode);
            mHeadNode = newNode;
        }else {
            int currentIndex = index;
            ListNode currentNode = mHeadNode;
            while (currentIndex > 1){
                currentNode = currentNode.getNextNode();
                currentIndex--;
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
    }

    @Override
    public void clear() {
        mHeadNode = null;
    }

    private boolean isValidRemoveIndex(int index){
        boolean returnValue = true;
        int size = size();
        if (index >= size || index < 0){
            returnValue = false;
        }

        return returnValue;
    }

    private boolean isValidAddIndex(int index){
        boolean returnValue = true;
        int size = size();
        if (index > size || index < 0){
            returnValue = false;
        }

        return returnValue;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (!isValidRemoveIndex(index)){
            throw new IndexOutOfBoundsException("Unable to get index " + index +
                    " in a single linked list with  elements");
        }

        int currentIndex = index;
        ListNode currentNode = mHeadNode;
        while(currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getData();
    }

    @Override
    public int indexOf(T element) {
        int indexOf = -1;
        int currentIndex = 0;
        ListNode currentNode = mHeadNode;
        while (currentNode != null ){
            if (currentNode.getData().equals(element)){
                indexOf = currentIndex;
                break;
            }
            currentIndex++;
            currentNode = currentNode.getNextNode();
        }
        return indexOf;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (!isValidRemoveIndex(index)){
            throw new IndexOutOfBoundsException("Unable to remove index " +index);
        }

        T returnData;

        // if we want to remove the first index
        // we only need to repoint the head node
        // to the second index in the list
        if (index == 0){
            returnData = mHeadNode.getData();
            mHeadNode = mHeadNode.getNextNode();
        } else {
            ListNode currentNode = mHeadNode;
            int currentIndex = index;
            while(currentIndex - 1 > 0){
                currentNode = currentNode.getNextNode();
                currentIndex--;
            }
            returnData = currentNode.getNextNode().getData();
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        }
        return returnData;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        int size = size();
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException(" Unable to set index " + index +
                    " in a single linked list with " + size + " elements.");
        }

        T previousData;
        ListNode currentNode = mHeadNode;
        int currentIndex = index;
        while (currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        previousData = currentNode.getData();
        currentNode.setData(element);

        return previousData;
    }

    @Override
    public int size() {
        int size = 0;
        ListNode currentNode = mHeadNode;
        while (currentNode != null){
            size++;
            currentNode = currentNode.getNextNode();
        }
        return size;
    }

    @Override
    public T[] toArray() {
        int size = size();
        T[] returnArray;
        if (size == 0) {
            returnArray = null;
        } else {
         returnArray =(T[]) new Object[size];
            ListNode currentNode = mHeadNode;
            int currentIndex = 0;
            while (currentNode != null) {
                returnArray[currentIndex] = currentNode.getData();
                currentIndex++;
                currentNode = currentNode.getNextNode();
            }
        }
        return returnArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        ListNode currentNode = mHeadNode;
        while (currentNode != null){
            stringBuilder.append(currentNode.getData().toString());
            if (currentNode.getNextNode() != null){
                stringBuilder.append(", ");
            }
            currentNode = currentNode.getNextNode();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     *
     * @return returns the last node in the single linked list
     */
    private ListNode getLastNode(){
        ListNode nextNode = mHeadNode;
        while(nextNode.getNextNode() != null){
            nextNode = nextNode.getNextNode();
        }
        return nextNode;
    }
}
