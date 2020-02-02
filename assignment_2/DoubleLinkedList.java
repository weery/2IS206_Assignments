package assignment_2;

public class DoubleLinkedList<T> implements IDoubleLinkedList<T> {

    private class Node{
        private T mElement = null;
        private Node mNextNode = null;
        private Node mPrevNode = null;

        public Node(T element){
            mElement = element;
        }

        public T getData(){
            return mElement;
        }
        public void setData(T element){
            mElement = element;
        }

        public Node getNextNode() {
            return mNextNode;
        }

        public void setNextNode(Node nextNode) {
            mNextNode = nextNode;
        }

        public Node getPrevNode() {
            return mPrevNode;
        }

        public void setPrevNode(Node prevNode) {
            mPrevNode = prevNode;
        }
    }

    private Node mHeadNode = null;

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        addBeforeNode(mHeadNode, newNode);
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
        boolean shouldUpdateHead = index == 0;
        int size = size();
        if (index <= size && index >= 0){
            Node newNode = new Node(element);
            Node currentNode = mHeadNode;
            while (index > 0){
                currentNode = currentNode.getNextNode();
                index--;
            }
            addBeforeNode(currentNode, newNode);
            if (shouldUpdateHead){
                mHeadNode = newNode;
            }
        }
    }

    private void addBeforeNode(Node node, Node newNode){
        if (node == null){
            mHeadNode = newNode;
            newNode.setNextNode(newNode);
            newNode.setPrevNode(newNode);
        } else {
            newNode.setNextNode(node);
            newNode.setPrevNode(node.getPrevNode());
            node.getPrevNode().setNextNode(newNode);
            node.setPrevNode(newNode);
        }
    }

    @Override
    public void clear() {
        mHeadNode = null;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        T returnElement = null;

        int size = size();
        if (index < size && index >= 0){
            Node currentNode = mHeadNode;
            while (index > 0){
                currentNode = currentNode.getNextNode();
                index--;
            }
            returnElement = currentNode.getData();
        }
        return returnElement;
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        Node currentNode = mHeadNode;
        if (currentNode != null) {
            int currentIndex = 0;
            do {
                if (currentNode.getData().equals(element)) {
                    index = currentIndex;
                    break;
                }
                currentIndex++;
                currentNode = currentNode.getNextNode();
            } while (currentNode != mHeadNode);
        }
        return index;
    }

    @Override
    public int lastIndexOf(T element) {
        int index = -1;
        int size = size();
        Node currentNode = mHeadNode;
        int currentIndex = 0;
        if (currentNode != null) {
            do {
                currentIndex--;
                currentNode = currentNode.getPrevNode();
                if (currentNode.getData().equals(element)) {
                    index = currentIndex + size;
                    break;
                }
            } while (currentNode != mHeadNode);
        }
        return index;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        T returnElement;
        int size = size();
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Remove: index " + index);
        }
        int currentIndex = index;
        Node currentNode = mHeadNode;
        while (currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        returnElement = currentNode.getData();
        removeNode(currentNode);
        return returnElement;
    }

    public void removeNode(Node removeNode){
        if (removeNode.getNextNode() == removeNode){ // this should mean that it is both the head node and the only node in the list
            mHeadNode = null;
        } else {
            Node prevNode = removeNode.getPrevNode();
            Node nextNode = removeNode.getNextNode();
            prevNode.setNextNode(nextNode);
            nextNode.setPrevNode(prevNode);
            if (removeNode == mHeadNode){
                mHeadNode = nextNode;
            }
        }
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException {
        T returnElement;
        int size = size();
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Set: index " + index);
        }
        int currentIndex = index;
        Node currentNode = mHeadNode;
        while (currentIndex > 0){
            currentIndex--;
            currentNode = currentNode.getNextNode();
        }
        returnElement = currentNode.getData();
        currentNode.setData(element);
        return returnElement;
    }

    @Override
    public int size() {
        int size = 0;
        Node currentNode = mHeadNode;
        if (mHeadNode != null){
            do{
                size++;
                currentNode = currentNode.getNextNode();
            }while (currentNode != mHeadNode);
        }

        return size;
    }

    @Override
    public T[] toArray() {
        int size = size();

        T[] returnArray = null;
        if (size > 0){
            returnArray = (T[])new Object[size];
            int currentIndex = 0;
            Node currentNode = mHeadNode;
            do {
                returnArray[currentIndex] = currentNode.getData();
                currentNode = currentNode.getNextNode();
                currentIndex++;
            } while(currentNode != mHeadNode);

        }

        return returnArray;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        Node currentNode = mHeadNode;
        if (mHeadNode != null){
            while(currentNode.getNextNode() != mHeadNode){
                stringBuilder.append(currentNode.getData().toString() + ", ");
                currentNode = currentNode.getNextNode();
            }
            stringBuilder.append(currentNode.getData().toString());
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
