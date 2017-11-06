
package misc.graph;

public class Edge {

	private String id;

	private Vertex src;

	private Vertex dest;

	private int weight;

	public Edge(String id, Vertex src, Vertex dest, int weight) {
		this.id = id;
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vertex getSrc() {
		return src;
	}

	public void setSrc(Vertex src) {
		this.src = src;
	}

	public Vertex getDest() {
		return dest;
	}

	public void setDest(Vertex dest) {
		this.dest = dest;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Edge other = (Edge) obj;
		if (dest == null) {
			if (other.dest != null) {
				return false;
			}
		} else if (!dest.equals(other.dest)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (src == null) {
			if (other.src != null) {
				return false;
			}
		} else if (!src.equals(other.src)) {
			return false;
		}
		if (weight != other.weight) {
			return false;
		}
		return true;
	}
}
