import java.util.LinkedList;

//Create a cache that stores the key and value
public class Cache<K, V extends KeyInterface<K>> {
    //Create linked list to store values
    private K key;
    private V value;
    private LinkedList <V> myCache;
    private int max; //max size for cache list
    private LinkedList<Double> hits; // track number of hits
    private LinkedList<Double> references; // track number of references

    //Create a linked list to store cache
    public Cache(int max) {
        this.max = max; // set maximum size for cache list
        myCache = new LinkedList<>();
        hits = new LinkedList<>();
        references = new LinkedList<>();

        // Initialize reference count for each cache item to 0
        for (int i = 0; i < max; i++) {
            references.add(0.0);
            hits.add(0.0);
        }
    }

    // Get value from cache list and move to the front of the list
    public V get(K key) {
        int index = findIndexByKey(key);//find index by the key
        if (index != -1) {//if index is found in the cache list
            V val = myCache.get(index);//get the value for that index from the cache list
            increaseReferences(index);//increase the references to that value
            increaseHits(index);//increase the number of hits
            moveToFront(index);//move it to the front
//            System.out.println("key: "+val.getKey()+" references: "+references.get(0)+" hits: "+hits.get(0));
            return val;//return the found value
        }
        return null;//return null if not found
    }

    //Add value to front of myCache list. Remove last listing if max size reached.
    public V add(V value) {
        K key = value.getKey(); // Get key for associated value
        V removedVal=null;//removed value if cache limit is hit
        if (myCache.size() >= max) { // If the cache is greater than or equal to the max limit
            removedVal = myCache.removeLast(); // Remove the last value in the cache
        }
        myCache.addFirst(value); // Add the value to the front of the list
        references.addFirst(1.0); // Increment reference count for the added entry
        hits.addFirst(0.0); // Add a new hit count (initialized to 0) for the added entry
        if(removedVal!=null){
            return removedVal;//return value if last value removed from cache
        } else{
            return null;//otherwise return null
        }
    }

    //Remove key, value pair from myCache list
    public V remove(V value){
        K key = value.getKey(); //get the key for the value provided
        V val = findValueByKey(key);//check to see if the key is in the myCache list, assign key and value to pair if found
        if (val != null) { //if pair was found in the list
            myCache.remove(val); //remove from myCache list
            return val; //return pair if removed from list
        }
        return null; //return null of nothing is removed from the list
    }

    //Remove all pairs from myCache list
    public void clear(){
        myCache = new LinkedList<>(); //clear myCache list by creating new instance
    }

    //Create toString method to print statistics for cache
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        sb.append("Cache with ").append(max).append(" entries has been created\n");
        sb.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        // Calculate total references and hits
        double totalReferences = 0.0;
        double totalHits = 0.0;
        for (double reference : references) {
            totalReferences += reference;//increase total ref count for each reference in list
        }
        for (double hit : hits) {
            totalHits += hit;//increase total hit count for each hit in list
        }
        sb.append("Total number of references:        ").append(String.format("%.0f",totalReferences)).append("\n");
        sb.append("Total number of cache hits:        ").append(String.format("%.0f",totalHits)).append("\n");
        // Calculate hit ratio
        double hitRatio = totalHits / totalReferences;
        sb.append("Cache hit percent:                 ").append(String.format("%.2f", hitRatio * 100)).append("%\n");
        return sb.toString();
    }

    //Method to find value based on key
    private V findValueByKey (K key) {
        for (V val : myCache) { //for each key, value pair in myCache linked list
            if (val.getKey().equals(key)) {//check to see if key passed in matches current key from list
                return val; //return pair when matching key is found
            }
        }
        return null;//return null if no match is found
    }

    //Return the index from myCache
    public int findIndexByKey(K key) {
        int index = -1;//initialize  index to -1
        for (int i = 0; i < myCache.size(); i++) {//for each item in cache list
            V val = myCache.get(i);//get the value
            if (val != null && val.getKey().equals(key)) {//check if the key for the value in cache list is equal to key sent in
                index = i;//upon match, set index to match item from cache list
                break;
            }
        }
        if (index != -1) {
            return index;//return the index if found in cache list
        } else {
            return -1; // Key not found in cache list
        }
    }

    //Increase references count
    private void increaseReferences(int index) {
        if (index < references.size()) {//if index is less than the size of the references list
            double referencesCount = references.get(index);//get the value of that index
            references.set(index, referencesCount + 1);//increase the references count
        } else {
            references.add(1.0); // Add a new reference count to the end of the list
        }
    }

    //Increase hits count
    private void increaseHits(int index) {
        double hitsCount = hits.get(index);//get the value of that index
        hits.set(index, hitsCount + 1);//increase hit count
    }

    //Move item to the front of cache list
    private void moveToFront(int index) {
        V val = myCache.get(index);//get the value
        myCache.remove(index);//remove from current place
        myCache.addFirst(val);//add to front of list

        // Move corresponding hits and references
        double hitsCount = hits.remove(index);//remove hits from current place
        double referencesCount = references.remove(index);//remove references from current place
        hits.addFirst(hitsCount);//add hits to the front of the list
        references.addFirst(referencesCount);//add references to the front of the list
    }

    //Get number of references
    public double getReferences(int index){
        return references.get(index);
    }

    // Method to retrieve the cache list
    public LinkedList<V> getCacheList() {
        return myCache;//return the linked list
    }

}

