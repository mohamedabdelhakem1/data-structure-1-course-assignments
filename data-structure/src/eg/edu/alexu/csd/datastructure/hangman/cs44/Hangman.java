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
	public String[] file_words;
	public int i = 0;
	public String secretword;
	public int max_guesses;
	public String got_letters;
	public String solved = "";
	public int counter = 0;
	public int flag = 0;
	public String unsolved_word = "";

	public void readfile() throws IOException {

		try {
			FileReader filereader = new FileReader("C:\\Users\\SHIKO\\git\\data-structur\\data-structure"
					+ "\\src\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs44\\words.txt");
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
		file_words = words;
	}

	@Override
	public String selectRandomSecretWord() {

		Random number = new Random();
		if (file_words == null || file_words.length == 0) {
			return null;
		} else {
			secretword = file_words[number.nextInt(file_words.length)];
		}
		if (secretword != null) {
			for (i = 0; i < secretword.length(); i++) {
				unsolved_word += "-";
			}
			got_letters = secretword;
			return secretword;

		} else {
			return null;

		}

	}

	@Override
	public String guess(final Character c) throws Exception {

		got_letters = secretword;
		if (c == null) {
			return unsolved_word;
		}

		else if (secretword == null) {
			throw new Exception();
		} else if (secretword == "" || secretword.charAt(0) == ' ') {
			throw new Exception();
		}

		else if (flag == 0) {
			throw new Exception();
		} else if (max_guesses == 0) {
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
						got_letters = got_letters.replace(got_letters.charAt(i), '-');

					} else if (solved.indexOf(secretword.charAt(i)) < 0) {

						got_letters = got_letters.replace(got_letters.charAt(i), '-');

					}
				}
				unsolved_word = got_letters;
				return got_letters;
			} else {
				for (i = 0; i < secretword.length(); i++) {
					if (solved == null) {
						got_letters = got_letters.replace(got_letters.charAt(i), '-');
					} else if (solved.indexOf(secretword.charAt(i)) < 0) {
						got_letters = got_letters.replace(got_letters.charAt(i), '-');
					}
				}
				max_guesses--;
				if (max_guesses == 0) {
					return null;
				}
				unsolved_word = got_letters;
				return got_letters;
			}
		}

	}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		flag = 1;
		if (max == null) {
			max_guesses = 1;
		} else {
			max_guesses = max;
		}

	}

}
