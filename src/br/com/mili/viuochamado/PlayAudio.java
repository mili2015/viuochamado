package br.com.mili.viuochamado;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayAudio
{

	private Clip clip = null;
	private PropertiesLoader props = new PropertiesLoader();
	
	public void play() throws Exception
	{
		String pathFile = props.getValue("prop.audio.path");
		
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(pathFile).getAbsoluteFile());

        // create clip reference
        Clip clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.start();
	}
	
	public void stop()
	{
		if (clip == null)
			return;
		
		clip.stop();
		clip.close();
	}
	
	public void sleep(int seconds)
	{
		try
		{
			Thread.sleep(seconds * 1000);
		}
		catch (InterruptedException e)
		{
			
			e.printStackTrace();
		}
	}
	
	public PlayAudio()
	{
	}

	
	public static void main(String[] args)
	{
		PlayAudio play = new PlayAudio();
		try
		{
			play.play();
			System.out.println("Tocando...");
			play.sleep(3);
			play.stop();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}