
package misc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

	private final List<Vertex> vertexesList;

	private final List<Edge> edgesList;

	private Set<Vertex> settledNodes;

	private Set<Vertex> unSettledNodes;

	private Map<Vertex, Vertex> ancestorMap;

	private Map<Vertex, Integer> distanceMap;

	public DijkstraAlgorithm(Graph graph) {
		vertexesList = new ArrayList<>(graph.getVertexesList());
		edgesList = new ArrayList<>(graph.getEdgesList());
	}

	public void execute(Vertex source) {
		// Can we move it to constructor ?
		settledNodes = new HashSet<>();
		unSettledNodes = new HashSet<>();
		ancestorMap = new HashMap<>();
		distanceMap = new HashMap<>();
		distanceMap.put(source, 0);
		unSettledNodes.add(source);
		while (!unSettledNodes.isEmpty()) {
			Vertex node = getMinimum();
			unSettledNodes.remove(node);
			settledNodes.add(node);
			findMinimalDistances(node);
			// System.out.println("Size: " + unSettledNodes.size());
		}
	}

	private void findMinimalDistances(final Vertex sourceNode) {
		List<Vertex> adjacentNodes = getNeighbours(sourceNode);
		for (Vertex adjacentNode : adjacentNodes) {
			int sourceToAdjacentDistance = getShortestDistance(sourceNode) + getDistance(sourceNode, adjacentNode);
			if (getShortestDistance(adjacentNode) > sourceToAdjacentDistance) {
				distanceMap.put(adjacentNode, sourceToAdjacentDistance);
				ancestorMap.put(adjacentNode, sourceNode);
				unSettledNodes.add(adjacentNode);
			}
		}
	}

	private int getDistance(Vertex source, Vertex target) {
		for (Edge edge : edgesList) {
			if (edge.getSrc().equals(source) && edge.getDest().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Vertex> getNeighbours(Vertex node) {
		List<Vertex> neighbours = new ArrayList<>();
		for (Edge edge : edgesList) {
			if (edge.getSrc().getId().equals(node.getId()) && !settledNodes.contains(edge.getDest())) {
				neighbours.add(edge.getDest());
			}
		}
		return neighbours;
	}

	private Vertex getMinimum() {
		Vertex minimum = null;
		// for (Vertex vertex : vertexesList) {
		for (Vertex vertex : unSettledNodes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private int getShortestDistance(Vertex vertex) {
		Integer d = distanceMap.get(vertex);
		return d == null ? Integer.MAX_VALUE : d;
	}

	public LinkedList<Vertex> getPath(Vertex vertex) {
		if (null == ancestorMap.get(vertex)) {
			return null;
		}
		LinkedList<Vertex> path = new LinkedList<>();
		path.add(vertex);
		while (null != ancestorMap.get(vertex)) {
			path.add(ancestorMap.get(vertex));
		}
		Collections.reverse(path);
		return path;
	}
}
