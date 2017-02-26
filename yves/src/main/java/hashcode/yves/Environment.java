/**
 * 
 */
package hashcode.yves;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import entities.CacheServer;
import entities.Endpoints;
import entities.Requests;
import entities.Videos;

/**
 * Singleton storing the all environment
 * @author yves
 *
 */
public class Environment {
	
	
	private int videoNumber;
	private int endpointsNumber;
	private int requestsNumber;
	private int cacheServerNumber;
	private int cacheServerIndivCapacity;
	
	private Videos[] allVideos;
	private CacheServer[] allCacheServers;
	private Endpoints[] allEndpoints;
	private Requests[] allRequestsAsArrays;
	
	private List<Requests> requestList;
	
	
	
	public Environment(int videoNumber, int endpointsNumber, int requestsNumber,
			int cacheServerNumber, int cacheServerIndivCapacity) {
		super();
		this.videoNumber = videoNumber;
		this.endpointsNumber = endpointsNumber;
		this.requestsNumber = requestsNumber;
		this.cacheServerNumber = cacheServerNumber;
		this.cacheServerIndivCapacity = cacheServerIndivCapacity;
	}

	
	


	public Videos[] getAllVideos() {
		return allVideos;
	}





	public void setAllVideos(Videos[] allVideos) {
		this.allVideos = allVideos;
	}





	public CacheServer[] getAllCacheServers() {
		return allCacheServers;
	}





	public void setAllCacheServers(CacheServer[] allCacheServers) {
		this.allCacheServers = allCacheServers;
	}





	public Endpoints[] getAllEndpoints() {
		return allEndpoints;
	}





	public void setAllEndpoints(Endpoints[] allEndpoints) {
		this.allEndpoints = allEndpoints;
	}





	public Requests[] getAllRequestsAsArrays() {
		return allRequestsAsArrays;
	}





	public void setAllRequestsAsArrays(Requests[] allRequestsAsArrays) {
		this.allRequestsAsArrays = allRequestsAsArrays;
		this.requestList = Arrays.asList(allRequestsAsArrays);
	}


	public List <Requests> prioritized () {
		 Collections.sort(requestList);
		 return requestList;
	}


	public int score() {
		int toReturn = 0;
		for (Requests request : requestList) {
			int savedLatency = request.getEndpoint().getLatencyToServer() - request.getActualLatency();
			toReturn += request.getNbre()*savedLatency;
			
		}
		return toReturn;
	}

}
