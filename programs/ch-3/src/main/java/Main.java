/* Purpose: Demonstration of how to use the MusicLibrary class to:
 * 	- Load Songs
 * 	- Display Songs
 * 	- Perform a Binary Search on them
 * Includes test for both existing and non-existing songs.
 *
 */

public class Main {
	public static void main(String[] args) {
		MusicLibrary library = new MusicLibrary();
		library.loadSongsFromFile("src/main/java/songs.json");

		// Display All Songs Recursively
		System.out.println("All songs in the library (recursive display): ");
		library.displayAllSongsRecursive();
		
		// Test Recursive Binary Search
		String searchTitle = "Shape of You";

		Song result = library.binarySearchRecursive(searchTitle);
		
		if(result != null) {
			System.out.println("\nFound: " + result);
		} else {
			System.out.println("\n'" + searchTitle + "' not found recursively.");
		}
	}
}
