/* MusicLibrary.java
 * Purpose: Manages the collection of songs and implement sthe binary search algorithm.
 * It will be used to demonstrate working with colleciton , file I/O, and algorithm implementation
 */
// Imports
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MusicLibrary {
	private List<Song> songs = new ArrayList<>(); // NEW: Adding the Arraylist for 'song'
	
	/* Recursion:
	 * 	Basically what's happening is that the public method 'displayAllSongsRecrusive' calls upon the private method 'displayAllSongsRecursive' with a starting index (0), as a starting point of where to begin showing all the songs.
	 *	The private method 'displayAllSongsRecursive' basically has a Recursive case that whenever the Base case isn't true, then it will proceed to call itself with a parameter of the next index until the the base case, which is the ending case is suffice (true)
	 *
	 *	Time Complexity: O(n)
	 *	Space Complexity: O(n)
	 */

	public void displayAllSongsRecursive() {
		displayAllSongsRecursive(0);
	}

	private void displayAllSongsRecursive(int index) {
		if (index >= songs.size()) {
			return; // The Base Case: End of the List
		}

		System.out.println(songs.get(index));
		displayAllSongsRecursive(index + 1); // Recursive Case: Keep recursiveness until Base Case is true.
	}

	/* Recursive Binary Search
	 *	- The same concept with 'displayAllSongsRecursive' but Binary Search is implemented aswell
	 *	the way it works is by checking on whether if the middle element has fit all conditions, if not, we compare to the left and right side, if either or fits the condition then it will recursively restart the same concept but on either the left/right side (a.k.a call itself but under different parameters to find the correct element)
	 *
	 * Time Complexity: O(log n) because it halfs the amount of space for each recursive call.
	 * Space Complexity: O(log n) because of the call stack (recursiveness - parent functions will pause until task is finished)
	 *
	 */
	
	public Song binarySearchRecursive(String title) {
		return binarySearchRecursive(title, 0, songs.size() - 1);
	}

	private Song binarySearchRecursive(String title, int left, int right) {
		if (left > right) {
			return null; // Base Case: N/A
		}

		int mid = (left + right) / 2;
		Song midSong = songs.get(mid);

		if (midSong.getTitle().equalsIgnoreCase(title)) {
			return midSong; // Best case scenario
		} else if (midSong.getTitle().compareTo(title) < 0) {
			return binarySearchRecursive(title, mid + 1, right); // Search the Right Half
		} else {
			return binarySearchRecursive(title, left, mid - 1); // Search  the Left Half
		}
	}



	public MusicLibrary(){
		// Using arraylist for storing `Song` objects
		this.songs = new ArrayList<>();
	}

	public void addSong(Song song) {
		songs.add(song);
		Collections.sort(songs);
	}

	/* Purpose: Apparently uses Gson to parse a JSON file that contains song data.
	 * It's a demonstration of file I/O and external libraries.
	 * The `try` statement is so that `FileReader` can be opened and closed properly.
	 */
	public void loadSongsFromFile(String filePath) {
		try(FileReader reader = new FileReader(filePath)) {
			Type mapType = new TypeToken<Map<String, List<Song>>>() { }.getType();
			Map<String, List<Song>> jsonMap = new Gson().fromJson(reader, mapType);
			List<Song> loadedSongs = jsonMap.get("songs");
			songs.addAll(loadedSongs);
			Collections.sort(songs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// calls the private `displaySongs` method, used for method overloading and encapsulation
	public void displayAllSongs() {
		displaySongs(songs);
	}

	// Formats the songs for terminal display
	private void displaySongs(List<Song> songs) {
		System.out.printf("%-25s %-20s %-5s %-10s %-12s %-10s %-10s %-8s%n",
			"Title", "Artist", "Score", "Genre", "Danceability", "Energy", "Valence", "Duration");
		System.out.println(new String(new char [110]).replace('\0', '-'));
		for(Song song: songs) {
			System.out.println(song);
		}
	}

	public Song binarySearch(String title) {
		int low = 0;
		int high = songs.size() - 1;

		while(low <= high) {
			int mid = (low + high) / 2;
			Song midSong = songs.get(mid);
			int comparison = midSong.getTitle().compareTo(title);
			if(comparison == 0) {
				return midSong;
			} else if(comparison < 0) {
				return midSong;
			} else if (comparison < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return null; // Not found
	}

}