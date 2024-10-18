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
	private List<Song> songs;

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

	public void sortByTitle() {
		Collections.sort(songs);
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
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return null; // Not found
	}


	/* Selection Sort Algorithm:
	 * 	- Basically what's happening is that whilst the for first for loop is iterating for 
	 *	all elements in the original list, there is another, temporary list that's being generated that's will have a new element added if its under a specific condtition ( check the 2nd for loop) thus by the end of it, the `temp` list is a unique list that is ordered under a specific condition.
	 */
	public void selectionSortByScore() {
		for(int i = 0; i < songs.size(); i++) {
			int maxIdx = i;
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getScore() > songs.get(maxIdx).getScore()) {
					maxIdx = j;
				}
			}

			Song temp = songs.get(maxIdx);
			songs.set(maxIdx, songs.get(i));
			songs.set(i, temp);
		}
	}

	public void selectionSortByDanceability() {
		for(int i = 0; i < songs.size() - 1;  i++) {
			int maxIdx = i;
			for(int j = i + 1; j < songs.size(); j++) {
				if(songs.get(j).getDanceability() > songs.get(maxIdx).getDanceability()){
					maxIdx = j;
				}
			}
			Song temp = songs.get(maxIdx);
			songs.set(maxIdx, songs.get(i));
			songs.set(i, temp);
		}
	}

}
