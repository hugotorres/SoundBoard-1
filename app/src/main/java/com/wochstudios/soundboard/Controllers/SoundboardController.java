package com.wochstudios.soundboard.Controllers;

import android.content.Context;

import com.wochstudios.soundboard.Models.Sound;
import com.wochstudios.soundboard.Models.Soundboard;
import com.wochstudios.soundboard.utils.RingtoneMaker;
import com.wochstudios.soundboard.utils.SoundPlayer;


public class SoundboardController {
	private SoundPlayer player = new SoundPlayer();
	private RingtoneMaker ringtoneMaker = new RingtoneMaker();
	private Context con;
	private Soundboard soundboard;
	

	
	public SoundboardController(Context c, Soundboard sb){
		this.con = c;
		this.soundboard = sb;
	}
	
	public void playSound(Sound sound){
        player.playSound(con,sound.getUri());
	}
	
	public void setSoundboard(Soundboard sb){
		this.soundboard = sb;
	}
	
	public void downloadRingtone(String key){
		for(Sound temp : soundboard.getSounds()){
			if(key.equals(temp.getTitle())){
				ringtoneMaker.setRingtone(key,temp.getUri(), con);
			}
		}
	}
}
