package misc.graph;

import java.util.List;

public class Graph {
	private List<Vertex> vertexesList;
	private List<Edge> edgesList;

	public Graph(List<Vertex> vertexesList, List<Edge> edgesList) {
		this.vertexesList = vertexesList;
		this.edgesList = edgesList;
	}

	public List<Vertex> getVertexesList() {
		return vertexesList;
	}

	public void setVertexesList(List<Vertex> vertexesList) {
		this.vertexesList = vertexesList;
	}

	public List<Edge> getEdgesList() {
		return edgesList;
	}

	public void setEdgesList(List<Edge> edgesList) {
		this.edgesList = edgesList;
	}

}
