import java.util.HashMap;

/* The `HashTable` class is just a wrapper around Java's `HashMap` class, allows simplification for hash table operations.
 * 	'table': A HashMap that stores 'Song' objects with titles as keys
 * 	'insert': Adds a new key-value pair to the hash table
 * 	'search': Retrieves a 'Song' object by its title
 * 	'displayAll': Prints all songs stored in the hash table
 */

public class HashTable {
	private HashMap<String, Song> table;

	public HashTable() {
		table = new HashMap<>();
	}

	public void insert(String key, Song value) {
		table.put(key, value);
	}

	public Song search(String key) {
		return table.get(key);
	}

	public void displayAll() {
		for(String key: table.keySet()) {
			System.out.println(table.get(key));
		}
	}
}
