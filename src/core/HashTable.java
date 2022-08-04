package core;

/*
 * Implementation of hashtable class with AVL tree as key-value pair holder
 * Key is of integer(primitive) type and value can be any generic value
 * This implementation provides constant time performance for insert, search and remove operations
 */

public class HashTable <V extends Object> {
	AVLtree [] buckets=new AVLtree[10];
    public void put(int key, V value) throws Exception {
      int bi = hashFunction(key);
      if(buckets[bi]==null) {
    	  buckets[bi] = new AVLtree();		//AVL tree is initiated when bucket is empty
    	  buckets[bi].Insert(key, value);	//Insert function is called at newly created tree i.e. on root node data will be inserted
      }
      else {
    	  buckets[bi].Insert(key, value);	//If bucket is already acquired by tree then it will be insert as child of root node
      }
   
    }
    
/*
 *	get function will return a value for provided key
 *	Initially a bucket is identified with hash function and on that bucket id Search() method is called for further iteration
 *	Time complexity = log N 
 */
    @SuppressWarnings("unchecked")
	public V get(int key) throws Exception {
      int bi = hashFunction(key);
      if(bi<buckets.length && bi>=0) {
    	  Object val=buckets[bi].Search(key);
    	  return (V) val;
      }
      else {
    	  return null;
      }
    }
    
/*
*	Initially a bucket is identified with hash function and on that bucket id Delete() method is called for further iteration
*	Time complexity = log N 
*/    
    public void remove(int key) throws Exception {
      int bi = hashFunction(key);
      if(bi<buckets.length && bi>=0) {
    	  buckets[bi].Delete(key);
    	  return;
      }
      else {
    	  return;
      }
    }
/*
 * Returns bucket index for a key
 * Collision is taken care by AVL Tree
*/
 
    private int hashFunction(int key) {
      int bi = key % buckets.length;
      return bi;
    }
    
    public V PrintAll(int key) {
    	int bi=hashFunction(key);
    	buckets[bi].printInOrder();
		return null;
      }
    }                        