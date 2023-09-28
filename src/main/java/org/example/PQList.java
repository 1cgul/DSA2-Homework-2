package org.example;

public class PQList implements PriorityQueue{
    private class Node{
        Account account;
        Node next;
        Node(Account account){
            this.account=account;
            this.next = null; //null because we do not know what the next node is
        }
    }

    private Node head;
    private int size; //creating a 'size' variable will save us from having to loop through the size of the array later to get the length
    public PQList(){ //nothing in the list upon instantiation
        this.head = null;
        size = 0;
    }
    public PQList(PQList other){
        this.head = other.head;
        this.size = other.size;
    }

    PQList deepCopy(){
        PQList copiedList = new PQList();

        if(this.head == null) //if the head is empty, then there are no values in the PQList
            return copiedList;

        copiedList.head = this.head; //copy the head to the new list
        Node current = this.head.next; //current node set to node after head
        Node currentCopied = copiedList.head; //the current copied node is set to the head

        while(current != null){ //while the current node is not null
            currentCopied.next = current; //set the copied list's next node to the original list's next node
            current = current.next; // set the current node to the next node in the list
            currentCopied = currentCopied.next; //set the currently copied node to the next node to continue the loop
        }
        copiedList.size = this.size; //copy the size of the original list to the new list
        return copiedList; // return the new list
    }

    /**
     * Add an Account object to the priority queue
     *
     * @param a
     */
    @Override
    public void add(Account a) {
        Node node = new Node(a); //create a new node to put in the pqlist
        node.next = this.head; //make the nodes next pointer point to the current head
        this.head = node;  //the new head is now the new node
        size++; //increment the size by one since we're adding a new node to the list
    }
    /**
     * Get the account with the highest priority. Uses the account’s balance to
     * determine priority. The item is removed from the priority queue.
     *
     * @return Account with the highest balance
     */

    @Override
    public Account getMax() {
        Account highest = head.account;
        Node node = head;
        Node lastHighest = null;

        if(head == null){ //if head is null then there shouldnt be anything in the list
            return null;
        }

        if(head.next == null || head.account.getBalance() >= head.next.account.getBalance()){ //if the head balance is already the highest balance
            head = head.next;
            size--;
            return highest;
        }

        while(node.next != null){ //sorting
            if(highest.getBalance() < node.next.account.getBalance()){
                highest = node.next.account;
                lastHighest = node;
            }
            node = node.next;
        }
        if(lastHighest!=null){ //removing node from list
            lastHighest.next = lastHighest.next.next;
            size--;
        }
        return highest; //returns the account with the highest balance
    }

    /**
     * Clears all items from the priority queue.
     */
    @Override
    public void clear() {

    }

    /**
     * Returns the number of accounts being stored in the priority queue.
     *
     * @return Length of the queue
     */
    @Override
    public int getLength() {
        return 0;
    }

    /**
     * Returns based on whether the priority queue is empty
     *
     * @return True if priority queue is empty, false if priority queue is not empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

}
