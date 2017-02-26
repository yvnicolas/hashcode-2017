package hashcode.yves;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.CacheServer;
import entities.Endpoints;
import entities.Requests;
import entities.Videos;
import helpers.CacheLatencyCorrespondance;

public class EnvironmentIOManager {
	
	public static Environment readFromFile(String filename) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		// get first line
		
		
		Scanner scanner = new Scanner(br.readLine());
		
		int V = scanner.nextInt();
		int E = scanner.nextInt();
		int R = scanner.nextInt();
		int C = scanner.nextInt();
		int X = scanner.nextInt();
		
		scanner.close();
		
		Environment toReturn = new Environment(V, E, R, C, X);
		
		// Reading the Videos
		Videos[] allVideos = new Videos[V];
		scanner = new Scanner(br.readLine());
		for (int i=0; i<V; i++)  {
			allVideos[i] = new Videos(scanner.nextInt(),i);
		}
		scanner.close();
		toReturn.setAllVideos(allVideos);
		
		// Creating the caches
		CacheServer[] allCacheServers = new CacheServer[C];
		for (int c=0; c<C; c++) {
			allCacheServers[c] = new CacheServer(X);
		}
		
		// Reading the Endpoint
		Endpoints[] allEndpoints = new Endpoints[E];
		for (int e=0; e<E; e++) {
			Endpoints beingProcessed = new Endpoints();
			
			// latency and cache number
			scanner = new Scanner(br.readLine());
			beingProcessed.setLatencyToServer(scanner.nextInt());
			int cacheConnected = scanner.nextInt();
			scanner.close();
			
			// get latencies to cache
			
			for (int k = 0; k < cacheConnected; k++) {
				scanner = new Scanner(br.readLine());
				beingProcessed.connectCacheServer(new CacheLatencyCorrespondance(allCacheServers[scanner.nextInt()], scanner.nextInt()));
				scanner.close();
			}
			
			allEndpoints[e] = beingProcessed;
		}
		toReturn.setAllEndpoints(allEndpoints);
		
		// Reading the Requests
		Requests[] allRequestsAsArrays = new Requests[R];
		for (int r=0; r<R; r++) {
			scanner = new Scanner(br.readLine());
			int Rv = scanner.nextInt();
			int Re = scanner.nextInt();
			int Rn = scanner.nextInt();
			scanner.close();
			allRequestsAsArrays[r] = new Requests(allVideos[Rv], Rn, allEndpoints[Re]);
			
		}
		
		toReturn.setAllRequestsAsArrays(allRequestsAsArrays);
		
		br.close();
		
		return toReturn;
	}
	
	public static void outputToFile (Environment environment, String filename) {
		CacheServer[] allCacheServers  = environment.getAllCacheServers();
		List<String> cacheLines = new ArrayList<String>();
		int lineNber = 0;
		for (CacheServer cache : allCacheServers) {
			if (cache.getStoredVideo().size()!=0) {
				lineNber+=1;
				cacheLines.add(String.format(arg0, arg1))
			}
		}
	}

}
