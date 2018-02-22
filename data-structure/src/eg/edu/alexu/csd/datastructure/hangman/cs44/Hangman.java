package eg.edu.alexu.csd.datastructure.hangman.cs44;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 *
 * @author SHIKO
 *
 */

public class Hangman implements IHangman {

	public String[] word;
	public String[] fileWords;
	public int i = 0;
	public String secretword;
	public int maxGuesses;
	public String gotLetters;
	public String solved = "";
	public int counter = 0;
	public int flag = 0;
	public String unsolvedWord = "";

	public void readfile() throws IOException {

		try {
			FileReader filereader = new FileReader(
					""
					+ "C:\\Users\\SHIKO\\git\\"
					+ "data-structure\\data-structure"
					+ "\\src\\eg\\edu\\alexu"
					+ "\\csd\\datastructure\\"
					+ "hangman\\cs44");
			BufferedReader buffer = new BufferedReader(filereader);
			String line;
			while ((line = buffer.readLine()) != null) {
				word[i] = line;

				i++;
			}
		} catch (IOException e) {
			throw new IOException();
		}

		setDictionary(word);

	}

	@Override
	public void setDictionary(final String[] words) {
		/**
		 * @param words : array of words
		 */
		fileWords = words;
	}

	@Override
	public String selectRandomSecretWord() {

		Random number = new Random();
		if (fileWords == null || fileWords.length == 0) {
			return null;
		} else {
			secretword = fileWords[number.nextInt(fileWords.length)];
		}
		if (secretword != null) {
			for (i = 0; i < secretword.length(); i++) {
				unsolvedWord += "-";
			}
			gotLetters = secretword;
			return secretword;

		} else {
			return null;

		}

	}

	@Override
	public String guess(final Character c) throws Exception {

		gotLetters = secretword;
		if (c == null) {
			return unsolvedWord;
		} else if (secretword == null) {
			throw new Exception();
		} else if (secretword == "" || secretword.charAt(0) == ' ') {
			throw new Exception();
		} else if (flag == 0) {
			throw new Exception();
		} else if (maxGuesses == 0) {
			return null;
		} else {
			char input1;
			char input2;

			input1 = Character.toUpperCase(c);
			input2 = Character.toLowerCase(c);

			if ((secretword.indexOf(c) >= 0) || (secretword.indexOf(input2) >= 0)
					|| (secretword.indexOf(input1) >= 0)) {
				for (i = 0; i < secretword.length(); i++) {
					if (secretword.charAt(i) == c || secretword.charAt(i) == input2 || secretword.charAt(i) == input1) {
						solved += (secretword.charAt(i));

					} else if (solved == null) {
						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');

					} else if (solved.indexOf(secretword.charAt(i)) < 0) {

						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');

					}
				}
				unsolvedWord = gotLetters;
				return gotLetters;
			} else {
				for (i = 0; i < secretword.length(); i++) {
					if (solved == null) {
						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');
					} else if (solved.indexOf(secretword.charAt(i)) < 0) {
						gotLetters = gotLetters.replace(gotLetters.charAt(i), '-');
					}
				}
				maxGuesses--;
				if (maxGuesses == 0) {
					return null;
				}
				unsolvedWord = gotLetters;
				return gotLetters;
			}
		}

	}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		flag = 1;
		if (max == null) {
			maxGuesses = 1;
		} else {
			maxGuesses = max;
		}

	}

}
