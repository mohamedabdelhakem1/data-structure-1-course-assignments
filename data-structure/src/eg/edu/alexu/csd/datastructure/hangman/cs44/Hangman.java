package eg.edu.alexu.csd.datastructure.hangman.cs44;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
/**
 *
 * @author SHIKO
 *
 */


public class Hangman implements IHangman {

	public Scanner s;
	public String[] word=new String [1000] ;
	public String[] file_words=new String [1000];
	public int i=0;
	public String secretword;
	public int max_guesses;
	public String got_letters;
	public String solved;
	public void readfile() {

		try {
			s = new Scanner(new File("words.txt"));
		}
		catch(Exception e) {

		}
		 while(s.hasNext())
		 {
			 word[i]= s.next();
			 i++;
		}
		 setDictionary(word);
	}


	@Override
	public void setDictionary(String[] words) {
		file_words=words;
	}

	@Override
	public String selectRandomSecretWord() {
			Random number =new Random();
			for(i=0;file_words[i]!=null;i++)
			{

			}
			String secretword=file_words[number.nextInt(i-1)];
		if(secretword!=null) {

			return secretword;
		}
		else {
		return null;
		}
	}

	@Override
	public String guess(final Character c) throws Exception {
	int counter = 0;
	char input1 = Character.toLowerCase(c);
	char input2 = Character.toUpperCase(c);
	got_letters=secretword;

	if (counter <= max_guesses) {
		if(c != null){
			if(secretword.indexOf(c)>=0||secretword.indexOf(input2)>=0||secretword.indexOf(input1)>=0) {

				for(i=0;i<secretword.length();i++)
			{		if(secretword.charAt(i)==c||secretword.charAt(i)==input2||secretword.charAt(i)==input1) {
						solved+=(secretword.charAt(i));
						got_letters.replace(got_letters.charAt(i), c);
						}
					else if(solved.indexOf(secretword.charAt(i))<0){
								got_letters.replace(got_letters.charAt(i), '-');

					}
			}



			return got_letters;
			}
			else {
				counter++;
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
