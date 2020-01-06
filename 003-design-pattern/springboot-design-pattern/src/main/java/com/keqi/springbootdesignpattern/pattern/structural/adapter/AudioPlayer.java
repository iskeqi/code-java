package com.keqi.springbootdesignpattern.pattern.structural.adapter;

/**
 * 这个音频播放器原本是只能播放map3文件的
 */
public class AudioPlayer implements MediaPlayer {

	/*
		这个音频播放器原本是只能播放map3文件的

		但是，现在需求希望它能够播放mp4、vlc视频文件，怎么办呢？


		通过持有适配器类来适配AdvancedMediaPlayer接口，来拥有播放mp4、vlc视频的能力

	 */



	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {

		//播放 mp3 音乐文件的内置支持
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("Playing mp3 file. Name: "+ fileName);
		}

		//mediaAdapter 提供了播放其他文件格式的支持
		else if(audioType.equalsIgnoreCase("vlc")
				|| audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}

		else {
			System.out.println("Invalid media. "+
					audioType + " format not supported");
		}
	}
}
