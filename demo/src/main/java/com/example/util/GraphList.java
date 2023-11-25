package com.example.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphList<T> {
    private int amountV;
    private List<Vertex<T>> list;

    private Integer[][] matrix;
    private Random ran;

    public Integer[][] getMatrix() {
        return matrix;
    }

    public int getAmountV() {
        return amountV;
    }

    public List<Vertex<T>> getList() {
        return list;
    }
/**
    public GraphList(int amountV) {
        ran = new Random();
        this.amountV = amountV;
        list = new ArrayList<>(amountV+1);
        for (int i = 1; i < amountV+1; i++) {
            list.add(new ArrayList<>(2));
        }
        matrix = new Integer[amountV][amountV];
    }
 */
    public GraphList(){
        this.amountV = 0;
        ran = new Random();
        list = new ArrayList<Vertex<T>>();
    }

    public void fillMatrix(){
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).getConnections().size(); j++){
                int temp = (Integer)list.get(i).getConnections().get(j).getVertex();
                matrix[i][temp] = list.get(i).getConnections().get(j).getWeight();
            }
        }

        for(int i = 0; i < matrix.length; i++){
            matrix[i][i] = 0;
            for (int j = 0; j < matrix.length; j++){

                if(matrix[i][j] == null){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void floydWarshall() {
        for (int k = 0; k < amountV; k++) {
            for (int i = 0; i < amountV; i++) {
                for (int j = 0; j < amountV; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
    }



    public void addVertex(T vertex1, T vertex2, int weight){

        Vertex<T> vertexFirst = new Vertex<>(vertex1);
        list.add(vertexFirst);
        Vertex<T> vertexSecond = new Vertex<>(vertex2,weight);
        list.get(list.size()-1).getConnections().add(vertexSecond);
        amountV++;

        Vertex<T> vertexFirst2 = new Vertex<>(vertex2);
        list.add(vertexFirst2);
        Vertex<T> vertexSecond2 = new Vertex<>(vertex1, weight);
        list.get(list.size()-1).getConnections().add(vertexSecond2);
        amountV++;

    }

    public void addVertexDirigido(T vertex1, T vertex2, int weight){
        Vertex<T> vertexFirst = new Vertex<>(vertex1);
        list.add(vertexFirst);
        Vertex<T> vertexSecond = new Vertex<>(vertex2,weight);
        list.get(list.size()-1).getConnections().add(vertexSecond);
        amountV++;
    }

    public String printMatrix(){
        String ans = "";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == Integer.MAX_VALUE){
                    ans += " | I | ";
                }else{
                    ans += " | " + matrix[i][j] + " | ";
                }

            }
            ans += "\n";
        }
        return ans;
    }

    public void printGraph(){

        for(int i = 0; i < amountV; i++){

            System.out.println("Vertex " + list.get(i).getVertex() + ": ");
            for(int j = 0; j < list.get(i).getConnections().size(); j++){
                int adjacent = (Integer)list.get(i).getConnections().get(j).getVertex();
                int weight = list.get(i).getConnections().get(j).getWeight();

                System.out.println(adjacent + " (" + weight + ") ");
            }
            System.out.println();
        }
    }

    public void deleteVertex(T vertex){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getVertex().equals(vertex)){
                list.remove(i);
            }else{
                for(int j = 0; j < list.get(i).getConnections().size(); j++){
                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex)){
                        list.get(i).getConnections().remove(j);
                    }
                }
            }
        }
    }
 /**
    public void deleteEdge(int edge1, int edge2){
        for (int i = 0; i < list.get(edge1).size(); i+=2){
            if(list.get(edge1).get(i) == edge2){
                list.get(edge1).remove(i+1);
                list.get(edge1).remove(i);
            }
        }
        for (int i = 0; i < list.get(edge2).size(); i+=2){
            if(list.get(edge2).get(i) == edge1) {
                list.get(edge2).remove(i + 1);
                list.get(edge2).remove(i);
            }
        }
    }
*/
    public void deleteEdge(T vertex1, T vertex2){
        for(int i = 0; i < list.size(); i++){

            if(list.get(i).getVertex().equals(vertex1)){

                for(int j = 0; j < list.get(i).getConnections().size(); j++){

                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex2)){
                        list.get(i).getConnections().remove(j);
                    }
                }

            }
        }

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).getVertex().equals(vertex2)){

                for(int j = 0; j < list.get(i).getConnections().size(); j++){

                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex1)){
                        list.get(i).getConnections().remove(j);
                    }
                }

            }
        }
    }

    public int getEdgeWeight(T vertex1, T vertex2){
        int ans = -1;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getVertex().equals(vertex1)){
                for(int j = 0; j < list.get(i).getConnections().size(); j++){
                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex2)){
                        return list.get(i).getConnections().get(j).getWeight();
                    }
                }
            }
        }

        return ans;
    }
    public boolean checkConnect(T vertex1, T vertex2){

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getVertex().equals(vertex1)){
                for(int j = 0; j < list.get(i).getConnections().size(); j++){
                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex2)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String getListVertex(int edge){
        String ans = "";

        for (int i = 0; i < list.get(edge).size(); i+=2){
            int adjacent = list.get(edge).get(i);
            int weight = list.get(edge).get(i + 1);
            ans = (adjacent + "(" + weight + ") ");
        }

        return ans;
    }

    public int dijkstra(int start, int destination) {

        int[] distances = new int[amountV + 1];
        for (int i = 1; i <= amountV; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[start] = 0;

        ArrayList<Tupla> nextToVisit = new ArrayList<>();
        Tupla tupla = new Tupla(start, 0);
        nextToVisit.add(tupla);
        ArrayList<Integer> possibleRoads = new ArrayList<>();

        for (int i = 0; i < nextToVisit.size(); i++) {

            int actual = nextToVisit.get(i).getFirst();
            int acumDistance = nextToVisit.get(i).getSecond();

            if (actual == destination) {
                //return acumDistance;
                possibleRoads.add(acumDistance);
            }

            for (int j = 0; j < list.get(actual).size(); j += 2) {
                int neighbor = list.get(actual).get(j);
                int weight = list.get(actual).get(j + 1);
                int newDistance = acumDistance + weight;

                if (newDistance < distances[neighbor]) {
                    distances[neighbor] = newDistance;
                    nextToVisit.add(new Tupla(neighbor, newDistance));
                }
            }

        }
        if(possibleRoads.isEmpty()){
            return -1;
        }else{
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < possibleRoads.size(); i++){
                if(possibleRoads.get(i) < min){
                    min = possibleRoads.get(i);
                }
            }
            return min;

        }


    }


    public static void main(String[] args) {
        int amountV = 51; // Número de vértices
        GraphList graph = new GraphList(amountV);

        //Horizontal

        //Fila uno
        graph.addVertex(1, 2, graph.ran.nextInt(1,6));
        graph.addVertex(2, 3, graph.ran.nextInt(1,6));
        graph.addVertex(3, 4, graph.ran.nextInt(1,6));
        graph.addVertex(4, 5, graph.ran.nextInt(1,6));
        graph.addVertex(5, 6, graph.ran.nextInt(1,6));
        graph.addVertex(6, 7, graph.ran.nextInt(1,6));
        graph.addVertex(7, 8, graph.ran.nextInt(1,6));
        graph.addVertex(8, 9, graph.ran.nextInt(1,6));
        graph.addVertex(9, 10, graph.ran.nextInt(1,6));

        graph.printGraph();
        //graph.getListVertex(1);

        System.out.println(graph.dijkstra(1, 2));

        graph.fillMatrix();
        //System.out.println(graph.printMatrix());
        graph.floydWarshall();
        System.out.println(graph.matrix[0][1]);
    }
}

