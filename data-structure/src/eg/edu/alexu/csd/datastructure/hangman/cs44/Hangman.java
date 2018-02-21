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


	public String[] word  ;
	public String[] file_words ;
	public int i = 0;
	public String secretword;
	public int max_guesses;
	public String got_letters;
	public String solved="";
	public int counter = 0;
	public void readfile() {

		try {
			FileReader filereader =new FileReader("C:\\Users\\SHIKO\\git\\data-structure\\data-structure"
					+ "\\src\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs44\\words.txt");
			BufferedReader buffer = new BufferedReader(filereader);
			String line;
			while((line = buffer.readLine())!=null) {
				word[i]=line;

				i++;
			}}
		catch(IOException e) {
		}


		 setDictionary(word);

	}


	@Override
	public void setDictionary(String[] words) {
		file_words = words;
	}

	@Override
	public String selectRandomSecretWord() {

			Random number =new Random();

			secretword = file_words[number.nextInt(file_words.length)];
		if(secretword!=null){
			got_letters=secretword;
			return secretword;

		}

		return null;

	}

	@Override
	public String guess(final Character c) throws Exception {

	char input1 = Character.toLowerCase(c);
	char input2 = Character.toUpperCase(c);
	got_letters=secretword;
	if (counter < max_guesses) {

		if(c != null&& secretword != null){
			if((secretword.indexOf(c)>=0)||(secretword.indexOf(input2)>=0)||(secretword.indexOf(input1)>=0)) {
				for(i=0;i<secretword.length();i++)
				{		if(secretword.charAt(i) ==  c||secretword.charAt(i)==input2||secretword.charAt(i)==input1) {
							solved+=(secretword.charAt(i));

						}
						else if(solved == null) {
							got_letters=got_letters.replace(got_letters.charAt(i), '-');

						}
						else if(solved.indexOf(secretword.charAt(i)) < 0){

							got_letters=got_letters.replace(got_letters.charAt(i), '-');

						}
				}
			return got_letters;
			}
			else {

				counter++;
				return null;
			}
		}
		else if (c == null) {
			throw new Exception("");
		}
		}
		return null;
}

	@Override
	public void setMaxWrongGuesses(final Integer max) {
		if (max == null) {
			max_guesses = 1;
		}
		else {
			max_guesses = max;
		}

	}

}
