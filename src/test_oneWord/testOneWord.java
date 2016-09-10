package test_oneWord;


import java.awt.EventQueue;

import oneWord.OneWord;

public class testOneWord {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
            public void run() {
            	 new OneWord();
            }
        });
	}
	
}
