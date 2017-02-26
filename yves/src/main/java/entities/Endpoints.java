package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import helpers.CacheLatencyCorrespondance;

public class Endpoints {
	
	
	public Endpoints() {
		super();
		this.latenciesToCacheServers = new ArrayList<CacheLatencyCorrespondance>();
	}


	private List <CacheServer> conntectedServers;
	
	private int latencyToServer;
	
	private List <CacheLatencyCorrespondance> latenciesToCacheServers;
	
	
	public List<CacheServer> getConntectedServers() {
		return conntectedServers;
	}
	

	public void setConntectedServers(List<CacheServer> conntectedServers) {
		this.conntectedServers = conntectedServers;
	}

	public int getLatencyToServer() {
		return latencyToServer;
	}

	public void setLatencyToServer(int latencyToServer) {
		this.latencyToServer = latencyToServer;
	}


	public List<CacheLatencyCorrespondance> getLatenciesToCacheServers() {
		// sort at this stage, not the best
		return latenciesToCacheServers;
	}


	public void setLatenciesToCacheServers(List<CacheLatencyCorrespondance> latenciesToCacheServers) {
		this.latenciesToCacheServers = latenciesToCacheServers;
	}
	
	public  void connectCacheServer (CacheLatencyCorrespondance cacheLatency) {
		this.latenciesToCacheServers.add(cacheLatency);
	}
	
//	A l'init 
//	// sort latencies Compute
//	Collections.sort(latenciesCompute);

}
