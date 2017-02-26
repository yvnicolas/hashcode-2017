package helpers;

import java.util.Comparator;

import entities.CacheServer;

/**
 * 
 * Stores a latency when going thru the cache when processing the videos
 * @author yves
 *
 */
public class CacheLatencyCorrespondance implements Comparable <CacheLatencyCorrespondance>{
	
	private CacheServer server;
	private int latency;
	public CacheServer getServer() {
		return server;
	}
	public void setServer(CacheServer server) {
		this.server = server;
	}
	public int getLatency() {
		return latency;
	}
	public void setLatency(int latency) {
		this.latency = latency;
	}
	public CacheLatencyCorrespondance(CacheServer server, int latency) {
		super();
		this.server = server;
		this.latency = latency;
	}
	
	
	public int compareTo(CacheLatencyCorrespondance arg0) {
		return this.getLatency() - arg0.getLatency();
	}
	
	

}
