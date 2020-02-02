package assignment_2;

public class SingleLinkedList<T> implements ISingleLinkedList<T> {

    /**
     * Inner class to hold the structure objects
     */
    private class Node {
        private T mElement = null;
        private Node mNextNode = null;
        public Node(T element){
            mElement = element;
        }
        public void setElement(T element){
            mElement = element;
        }
        public T getElement(){
            return mElement;
        }
        public void setNextNode(Node nextNode){
            mNextNode = nextNode;
        }
        public Node getNextNode(){
            return mNextNode;
        }
    }

    private Node mHeadNode = null;
    private int mLength = 0;

    @Override
    public void add(T element) {
        Node newNode = new Node(element);

        if (mHeadNode == null){
            mHeadNode = newNode;
        } else {
            getLastNode().setNextNode(newNode);
        }

        mLength++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (!isValidAddIndex(index)){
            throw new IndexOutOfBoundsException("add: index = " + index);
        }
        Node newNode = new Node(element);

        if (index == 0){
            newNode.setNextNode(mHeadNode);
            mHeadNode = newNode;
        }else {
            int currentIndex = index;
            Node currentNode = mHeadNode;
            while (currentIndex > 1){
                currentNode = currentNode.getNextNode();
                currentIndex--;
            }
            newNode.setNextNode(currentNode.getNextNode());
            currentNode.setNextNode(newNode);
        }
        mLength++;
    }

    @Override
    public void clear() {
        mHeadNode = null;
        mLength = 0;
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
            throw new IndexOutOfBoundsException("get: index = " + index);
        }

        int currentIndex = index;
        Node currentNode = mHeadNode;
        while(currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getElement();
    }

    @Override
    public int indexOf(T element) {
        int indexOf = -1;
        int currentIndex = 0;
        Node currentNode = mHeadNode;
        while (currentNode != null ){
            if (currentNode.getElement().equals(element)){
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
            throw new IndexOutOfBoundsException("remove: index = " + index);
        }

        T returnData;

        // if we want to remove the first index
        // we only need to repoint the head node
        // to the second index in the list
        if (index == 0){
            returnData = mHeadNode.getElement();
            mHeadNode = mHeadNode.getNextNode();
        } else {
            Node currentNode = mHeadNode;
            int currentIndex = index;
            while(currentIndex - 1 > 0){
                currentNode = currentNode.getNextNode();
                currentIndex--;
            }
            returnData = currentNode.getNextNode().getElement();
            currentNode.setNextNode(currentNode.getNextNode().getNextNode());
        }
        mLength--;
        return returnData;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        int size = size();
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Set: index = " + index);
        }

        T previousData;
        Node currentNode = mHeadNode;
        int currentIndex = index;
        while (currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        previousData = currentNode.getElement();
        currentNode.setElement(element);

        return previousData;
    }

    @Override
    public int size() {
        return mLength;
    }

    @Override
    public T[] toArray() {
        int size = size();
        T[] returnArray;
        if (size == 0) {
            returnArray = null;
        } else {
         returnArray =(T[]) new Object[size];
            Node currentNode = mHeadNode;
            int currentIndex = 0;
            while (currentNode != null) {
                returnArray[currentIndex] = currentNode.getElement();
                currentIndex++;
                currentNode = currentNode.getNextNode();
            }
        }
        return returnArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node currentNode = mHeadNode;
        while (currentNode != null){
            stringBuilder.append(currentNode.getElement().toString());
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
    private Node getLastNode(){
        Node nextNode = mHeadNode;
        while(nextNode.getNextNode() != null){
            nextNode = nextNode.getNextNode();
        }
        return nextNode;
    }
}
