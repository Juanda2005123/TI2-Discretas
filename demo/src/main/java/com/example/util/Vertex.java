package com.example.util;

import java.util.ArrayList;

public class Vertex<T> {
    private T vertex;
    private int weight;
    private ArrayList<Vertex<T>> connections;

    public Vertex(T vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }

    public Vertex(T vertex){
        this.vertex = vertex;
        this.connections = new ArrayList<>();
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ArrayList<Vertex<T>> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Vertex<T>> connections) {
        this.connections = connections;
    }
}
