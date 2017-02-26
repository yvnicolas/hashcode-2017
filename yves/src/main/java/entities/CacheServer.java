package entities;

import java.util.ArrayList;
import java.util.List;

public class CacheServer {
	
	private int totalSize;
	private List<Videos> storedVideo;
	private int remainingSize;

	
	
	
	public CacheServer(int totalSize) {
		super();
		this.totalSize = totalSize;
		this.remainingSize = totalSize;
		storedVideo = new ArrayList<Videos>();
	}



	/**
	 * Stores the video in the cache
	 * @param video
	 * @throws Exception if no more size in the
	 */
	public void storeVideo (Videos video) throws Exception {
		if (video.getSize() > this.remainingSize)
			throw new Exception("No More Room!");
		
		this.storedVideo.add(video);
		this.totalSize+= video.getSize();
		this.remainingSize-= video.getSize();
		
	}



	public List<Videos> getStoredVideo() {
		return storedVideo;
	}



	public void setStoredVideo(List<Videos> storedVideo) {
		this.storedVideo = storedVideo;
	}
	
	

}
