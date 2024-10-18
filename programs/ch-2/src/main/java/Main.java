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

		System.out.println("\nAll songs in the library:");
		library.displayAllSongs();

		System.out.println("\nTop songs by score: ");
		library.selectionSortByScore();
		library.displayAllSongs();

		System.out.println("\nTop songs by danceability:");
		library.selectionSortByDanceability();
		library.displayAllSongs();

		library.sortByTitle();

		String searchTitle = "Shape of You";
		Song result = library.binarySearch(searchTitle);
		if(result != null) {
			System.out.println("\nFound: " + result);
		} else {
			System.out.println("\n'" + searchTitle + "' not found.");
		}

		searchTitle = "Imaginary Song";
		result = library.binarySearch(searchTitle);
		if(result != null) {
			System.out.println("\nFound: " + result);
		} else {
			System.out.println("\n'" + searchTitle + "' not found.");
		}
	}
}
