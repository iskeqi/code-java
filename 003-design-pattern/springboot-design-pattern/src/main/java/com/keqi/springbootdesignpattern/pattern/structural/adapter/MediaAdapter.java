package com.keqi.springbootdesignpattern.pattern.structural.adapter;

/**
 * 适配器类-这就是核心所在
 */
public class MediaAdapter implements MediaPlayer {

	/*
		这个类作为中间人，适配了MediaPlayer和AdvancedMediaPlayer接口

		让原本只能播放mp3的AudioPlayer持有了它之后，也能播放mp4、vlc了

		适配器模式就是让两个不兼容的接口变得兼容

		举个例子就是，一个中国人不懂英文，它现在需要和一个说英文的人打交道怎么办呢？

		它需要一个适配器来帮助它获得这种能力，也就是找一个翻译

		也就是说，适配器模式的核心就是找一个中间人，一个能够在两边沟通的中间人

		如果以后需要在两个系统之间做转换，那就是适配器模式了

	 */


	AdvancedMediaPlayer advancedMusicPlayer;

	public MediaAdapter(String audioType){
		if(audioType.equalsIgnoreCase("vlc") ){
			advancedMusicPlayer = new VlcPlayer();
		} else if (audioType.equalsIgnoreCase("mp4")){
			advancedMusicPlayer = new Mp4Player();
		}
	}

	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("vlc")){
			advancedMusicPlayer.playVlc(fileName);
		}else if(audioType.equalsIgnoreCase("mp4")){
			advancedMusicPlayer.playMp4(fileName);
		}
	}
}
