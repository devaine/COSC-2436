public class Song implements Comparable<Song> {
	/* All below is encapsulation:
	 * 	* initializes private variables
	 *
	 * 	Usually by using getters (get info) and setters (set info)
	 * For more info: https://www.geeksforgeeks.org/encapsulation-in-java/
	 */
	private String title;
	private String artist;
	private int score;
	private String genre;
	private double danceability;
	private double energy;
	private double valence;
	private int duration;
	
	/* The contructor, Song() (not the class) is just a method that initializes (starts)
	 * the `Song` object and it's DEFAULT values.
	 *
	 * Note: Must NOT have any return type
	 */
	public Song(String title, String artist, int score, String genre, double danceability, double energy, double valence, int duration){
		// `this` is a keyword is to indicate the private variables of the `Song` class so the contrcutor can assign values when it's instantiated
		this.title = title;
		this.artist = artist;
		this.score = score;
		this.genre = genre;
		this.danceability = danceability;
		this.energy = energy;
		this.valence = valence;
		this.duration = duration;
	}
	

	// Getter (Accessor) methods
	// Allows read access to the `Song` data
	public String getTitle() {
		return title;
	}

	public int getScore() {
		return score;
	}

	public double getDanceability() {
		return danceability;
	}
	
	// Adding 'getDuration()'
	public int getDuration() {
		return duration;
	}

	@Override
	public int compareTo(Song otherSong) {
		return this.title.compareTo(otherSong.title);
	}

	/* truncate() a helper method
	 * ensures that longs strings are shortened for display purposes
	 */
	private String truncate(String value, int maxLength) {
		return value.length() > maxLength ? value.substring(0, maxLength - 3) + "..." : value;
	}

	@Override
	public String toString() {
		return String.format("%-25s %-20s %-5d %-10s %-12.2f %-10.2f %-10.2f %-8d",
				truncate(title, 25), truncate(artist, 20), score, truncate(genre, 10),
				danceability, energy, valence, duration);
	}

}

