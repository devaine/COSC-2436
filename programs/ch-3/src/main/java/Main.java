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
		library.loadSongsFromFile("songs.json");

		System.out.println("All songs in the library:");
		library.displayAllSongs();
		
		// Test cases
		String[] testCases = {
			"Shape of You",
			"Hotling Bling",
			"Blinding Lights",
			"AAA",
			"ZZZ",
			"Go Crazy",
			"Imaginary Song"
		};

		for(String title : testCases) {
			Song result = library.binarySearch(title);
			if(result != null) {
				System.out.println("\nFound: " + result);
			} else {
				System.out.println("\n'" + title + "'not found.");
			}
		}


		// Binary Search Test
		String searchTitle = "Go Crazy";
		Song result = library.binarySearch(searchTitle);
		
		if(result != null) {
			System.out.println("\nFound: " + result);
		} else {
			System.out.println("\n'" + searchTitle + "' not found.");
		}

		// Test with a song that doesn't exist
		searchTitle = "Imaginary Song";

		result = library.binarySearch(searchTitle);
		
		if(result != null) {
			System.out.println("\nFound: " + result);
		} else {
			System.out.println("\n'" + searchTitle + "' not found.");
		}
	}
}
