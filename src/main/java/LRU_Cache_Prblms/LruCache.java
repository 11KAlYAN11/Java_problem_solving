package LRU_Cache_Prblms;

import java.util.*;

public class LruCache {
    /*
        Capacity = 3

        PUT A
        PUT B
        PUT C

        Cache:
        A  B  C

        GET A       ← A becomes recently used

        PUT D       ← cache full

        Who leaves?
        B           ← least recently used

        So the cache needs to maintain recency order.
     */

        class Node {
            int key;
            int val;
            Node prev;
            Node next;
            Node(int key, int val) {
                this.key = key;
                this.val = val;
                // making the null references may be optional
            }
        }

        private final int capacity;
        private final Map<Integer, Node> cache;

        private final Node head;
        private final Node tail;

        // Capacity initialization for cache

        public LruCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();

            head = new Node(0,0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Insert the new node just before the tail -> MostRecentlyUsed MRU
        public void insert(Node node) {
            Node previousNode = tail.prev;

            previousNode.next = node;
            node.prev = previousNode;

            node.next = tail;
            tail.prev = node;
        }

        // Delete the node from the DLL

        public void delete(Node node) {
            Node previousNode = node.prev;
            Node nextNode = node.next;

            previousNode.next = nextNode;
            nextNode.prev = previousNode;
        }

        // Get the key
        public int get(int key) {
            // If key dosn't exist
            if(!cache.containsKey(key)) return -1;

            // If the key contains we have to delete from the postion it has & move to MRU
            Node node = cache.get(key);
            delete(node);
            insert(node);

            return node.val;
        }

        // Put the key

        public void put(int key, int val) {
            // if key already contains update the value and insert to MRU
            if(cache.containsKey(key)) {
                Node node = cache.get(key);

                // remove the old pos
                delete(node);
                
                // Just update the value
                node.val = val;

                // Move to the MRU
                insert(node);

                return;
            }
            // If it is the new Key
            Node newNode = new Node(key, val);

            cache.put(key, newNode);
            insert(newNode);

            // If capacity has be increased after insertion Lets remove the LRU that why LRU cache
            if(cache.size() > capacity) {
                Node lru = head.next;
                delete(lru);
                cache.remove(lru.key);
            }

        }

    public static void main(String[] args) {

        LruCache cache = new LruCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30);
        // 2 is LRU → removed

        System.out.println(cache.get(2)); // -1

        cache.put(4, 40);
        // 1 is LRU → removed

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }


}
