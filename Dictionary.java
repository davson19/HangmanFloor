package HangmanFloor;

public class Dictionary {
	private static final String[] dictionary = new String[] {
			"area", "book", "business", "case", "child", "company", "country", "daybreak", "eyeball", "fact", "family", "government", "group", "hand", "home", "occupation", "life", "lottery", "man", "money", "month", "mother", "mister", "night", "number", "part", "people", "place", "point", "problem", "program", "question", "right", "room", "school", "state", "story", "student", "study", "system", "thing", "time", "water", "way", "week", "woman", "word", "work", "world", "year"
	};
	
	public static String getWord() {
		return dictionary[(int)(Math.random() * 50)];
	}

}
