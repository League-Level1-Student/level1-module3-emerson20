package _03_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;
	
/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/
	
public class Jukebox implements Runnable {
	public static void main(String[] args) {
		Jukebox box = new Jukebox();
	}
    public void run() {
    	
		// 1. Find an mp3 on your computer or on the Internet.
    	//done
		// 2. Create a Song object for that mp3
    	Song s = new Song("C:\\Users\\ralph\\Downloads\\Death Grips - Guillotine.mp3");
		// 3. Play the Song
    	s.play();
		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */
    	
    	
    }
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		return new JLabel();
	}				
	
}
	
class Song {
	
	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;
	
	
//	Song tong = new Song("everywhere.mp3"); 
//	Song bong = new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3.http");
//
//	public void setTong(Song tong) {
//		this.tong = tong;
//	}public void setBong(Song bong) {
//		this.bong = bong;
//	}
	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3");
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code> 
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}
	
	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
		                                                                             
//		tong.loadFile();
//		bong.loadFile();
//		tong.loadPlayer();
//		bong.loadPlayer();
//		tong.startSong();
//		bong.startSong();
	}
	
	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}
	
	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}
	
	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}
	
	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}
	
	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}
	
	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}
	
	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
	}
																								                                           