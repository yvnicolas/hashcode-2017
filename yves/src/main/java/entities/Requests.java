package entities;

public class Requests implements Comparable<Requests>{
	private Videos video;
	private int nbre;
	private Endpoints endpoint;
	
	/**
	 * The latency that will be computed, to be used in final scoring
	 *
	 */
	private int actualLatency;
	

	
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public int getNbre() {
		return nbre;
	}
	public void setNbre(int nbre) {
		this.nbre = nbre;
	}
	public Endpoints getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(Endpoints endpoint) {
		this.endpoint = endpoint;
	}
	public int getActualLatency() {
		return actualLatency;
	}
	public void setActualLatency(int actualLatency) {
		this.actualLatency = actualLatency;
	}
	public Requests(Videos video, int nbre, Endpoints endpoint) {
		super();
		this.video = video;
		this.nbre = nbre;
		this.endpoint = endpoint;
		this.actualLatency = this.endpoint.getLatencyToServer();
	}
	
	// This is used to order the request to process : key to the algorithm with weight affected to requests.
	public int compareTo(Requests o) {
		return ((this.getNbre()*this.getEndpoint().getLatencyToServer()) - o.getNbre()*o.getEndpoint().getLatencyToServer());
	}

	
	
}
