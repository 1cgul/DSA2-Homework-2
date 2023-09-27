package org.example;

interface PriorityQueue {
    /**
     * Add an Account object to the priority queue
     * @param a
     */
    void add(Account a);

    /**
     * Get the account with the highest priority. Uses the account’s balance to
     * determine priority. The item is removed from the priority queue.
     * @return Account with the highest balance
     */
    Account getMax();

    /**
     * Clears all items from the priority queue.
     */
    void clear();

    /**
     * Returns the number of accounts being stored in the priority queue.
     * @return Length of the queue
     */
    int getLength();

    /**
     * Returns based on whether the priority queue is empty
     * @return True if priority queue is empty, false if priority queue is not empty
     */
    boolean isEmpty();
}
