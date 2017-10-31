
package misc.graph;

import java.util.ArrayList;
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

	private Map<Vertex, Vertex> predecessorMap;

	private Map<Vertex, Integer> distanceMap;

	public DijkstraAlgorithm(Graph graph) {
		vertexesList = new ArrayList<>(graph.getVertexesList());
		edgesList = new ArrayList<>(graph.getEdgesList());
		// settledNodes = new HashSet<>();
		// unSettledNodes = new HashSet<>();
		// predecessors = new HashMap<>();
		// distance = new HashMap<>();
	}

	public void execute(Vertex source) {
		// Can we move it to constructor ?
		settledNodes = new HashSet<>();
		unSettledNodes = new HashSet<>();
		predecessorMap = new HashMap<>();
		distanceMap = new HashMap<>();
		// ---------------------------------------
		// Can we move it to constructor ?
		distanceMap.put(source, 0);
		unSettledNodes.add(source);
		// ---------------------------------------
		while (!unSettledNodes.isEmpty()) {
			Vertex node = getNodeWithMinimumDistance(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			evaludateNeibourNodes(node);
		}
	}

	private void evaludateNeibourNodes(Vertex node) {
		List<Vertex> adjacentNodes = getNeighbors(node);
		for (Vertex target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distanceMap.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessorMap.put(target, node);
				unSettledNodes.add(target);
			}
		}
	}

	private int getDistance(Vertex source, Vertex target) {
		for (Edge edge : edgesList) {
			if (edge.getSrc().equals(source) && edge.getDest().equals(target)) {
				// return edge.getDest();
			}
		}
		return 0;
	}

	private List<Vertex> getNeighbors(Vertex node) {
		List<Vertex> neighbours = new ArrayList<>();
		for (Edge edge : edgesList) {
			if (edge.getSrc().getId().equals(node.getId()) && !settledNodes.contains(edge.getDest())) {
				neighbours.add(edge.getDest());
			}
		}
		return neighbours;
	}

	private Vertex getNodeWithMinimumDistance(Set<Vertex> unSettledNodes) {
		Vertex minimum = null;
		for (Vertex vertex : vertexesList) {
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
		// TODO Auto-generated method stub
		return null;
	}
}
