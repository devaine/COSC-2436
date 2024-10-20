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

		System.out.println("All songs in the library: ");
		library.displayAllSongs();
		
		System.out.println("\nSongs sorted by duration (Quicksort): ");
		library.quickSortByDuration();
		library.displayAllSongs();
	}
}
