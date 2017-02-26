package hashcode.yves;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.CacheServer;
import entities.Endpoints;
import entities.Requests;
import helpers.CacheLatencyCorrespondance;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private  Environment environment;
	
	
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        
        //Lire l'environnement
        
        // processer
        
        // sortir l'output
      
        	
        }
        
    
 
        

	public void process() {
	     // On Ordonne les requetes pour imaginer celles qu'on essaye de traiter en prrmier
        for (Requests request : environment.prioritized()) {

			request.setActualLatency(request.getEndpoint().getLatencyToServer());
			
			// On essaye de mettre la video dans le best cache
			boolean videoInCache = false;
			for (CacheLatencyCorrespondance cacheLatency : request.getEndpoint().getLatenciesToCacheServers()) {
				if ((! videoInCache) && (cacheLatency.getLatency() < request.getEndpoint().getLatencyToServer())) {
					try {
						cacheLatency.getServer().storeVideo(request.getVideo());
						request.setActualLatency(cacheLatency.getLatency());
						videoInCache = true;
					} catch (Exception e) {
						// unable to store in cache...
					}
				}
			}
		} 
}



	
}