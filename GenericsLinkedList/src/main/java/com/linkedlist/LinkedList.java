package com.linkedlist;

public class LinkedList<T extends Comparable> {
    private class Node{
         private T data;
         private Node nextNode;
         Node(){nextNode=null;}
    }
    private Node headNode;
    public LinkedList() {
        headNode=null;
    }
    public void add(T item) {
        Node newNode=new Node();
        newNode.data=item;
        newNode.nextNode=headNode;
        headNode=newNode;
    }
    public T getFirstElement() {
        return headNode.data;
    }
    public boolean search(T item) {
        Node node=headNode;
        while(node!=null) {
            if(node.data==item)
                return true;
            node=node.nextNode;
        }
        return false;
    }
    public void remove(T item) {
        if (headNode.data.compareTo(item)==0){
            headNode=headNode.nextNode;
            return;
        }
        Node node=headNode,prevNode=null;
        while(node!=null&&node.data.compareTo(item)!=0) {
            prevNode=node;
            node=node.nextNode;
        }
        prevNode.nextNode=node.nextNode;
        node.nextNode=null;
    }
    public boolean isEmpty() {
        return headNode==null;
    }
    public int size() {
        Node node=headNode;
        int size=0;
        while(node!=null) {
            size++;
            node=node.nextNode;
        }
        return size;
    }
    public void append(T item) {
        Node newNode=new Node();
        newNode.data=item;
        if(isEmpty()){
            headNode=newNode;
            return;
        }
        Node lastNode=headNode;
        while(lastNode.nextNode!=null){lastNode=lastNode.nextNode;}
        lastNode.nextNode=newNode;
    }
    public T getLastElement() {
        Node lastNode=headNode;
        while(lastNode.nextNode!=null){lastNode=lastNode.nextNode;}
        return lastNode.data;
    }
    public int index(T item) {
        Node node=headNode;
        int index=-1;
        while(node!=null) {
            index++;
            if(node.data==item)
                return index;
            node=node.nextNode;
        }
        return -1;
    }
    public void insert(int pos, T item) throws WrongIndexErrorException {
        if (pos<0){
            throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INVALID_INDEX,"Entered Index is Invalid");
        }else  if (pos>size()){
            throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INDEX_OUT_OF_BOUND,"Entered Index is Invalid");
        }else {
            if(pos==0){
                add(item);
            }
            Node oldNode = headNode;
            for(int i=0;i<pos-1;i++){
                oldNode=oldNode.nextNode;
            }
            Node newNode=new Node();
            newNode.data=item;
            newNode.nextNode=oldNode.nextNode;
            oldNode.nextNode=newNode;
        }
    }
    public T getElement(int pos) throws WrongIndexErrorException {
        if (pos<0) throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INVALID_INDEX,"Entered Index is Invalid");
        else if (pos>size()) throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INDEX_OUT_OF_BOUND,"Entered Index is Invalid");
        else {
            int index = 0;
            Node newNode = headNode;
            while (index < pos && newNode != null) {
                index++;
                newNode = newNode.nextNode;
            }
            return newNode.data;
        }
    }
    public void printList(){
        Node node=headNode;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.nextNode;
        }
    }
    void remove(int pos) {
        if(isEmpty())return;
        if(pos==0) {
            headNode=headNode.nextNode;
            return;
        }
        Node tempNode=headNode;
        for(int i=0;i<pos-1;i++) {
            if(tempNode!=null) {
                tempNode=tempNode.nextNode;
            }
        }
        if(tempNode==null) return;
        Node newNode=tempNode.nextNode.nextNode;
        tempNode.nextNode=newNode;
    }
    public T pop() throws WrongIndexErrorException {
        return pop(size()-1);
    }
    public T pop(int pos) throws WrongIndexErrorException {
        try {
            T data = getElement(pos);
            remove(pos);
            return data;
        }catch (NullPointerException e){
            if(pos<0) throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INVALID_INDEX,"Entered Index is invalid");
            else throw new WrongIndexErrorException(WrongIndexErrorException.ExceptionType.INDEX_OUT_OF_BOUND,"Entered Index is Out of Bound");

        }
    }
}
