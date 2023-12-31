package com.example.util;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;

import java.util.ArrayList;
import java.util.List;

public class GraphList<T> {
    private int amountV;
    private final List<Vertex<T>> list;

    private Integer[][] matrix;

    public Integer[][] getMatrix() {
        return matrix;
    }

    public int getAmountV() {
        return amountV;
    }

    public List<Vertex<T>> getList() {
        return list;
    }

    public GraphList(){
        this.amountV = 0;
        list = new ArrayList<Vertex<T>>();

    }

    public void fillMatrix(){
        this.matrix = new Integer[amountV][amountV];
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).getConnections().size(); j++){
                int temp = (Integer)list.get(i).getConnections().get(j).getVertex();
                matrix[i][temp-1] = list.get(i).getConnections().get(j).getWeight();
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
        for(int h = 0; h < 10; h++){
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

    public void deleteEdge(T vertex1, T vertex2){
        for(int i = 0; i < list.size(); i++){

            if(list.get(i).getVertex().equals(vertex1)){

                for(int j = 0; j < list.get(i).getConnections().size(); j++){

                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex2)){
                        list.get(i).getConnections().remove(j);
                        break;
                    }
                }


            }
        }

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).getVertex().equals(vertex2)){

                for(int j = 0; j < list.get(i).getConnections().size(); j++){

                    if(list.get(i).getConnections().get(j).getVertex().equals(vertex1)){
                        list.get(i).getConnections().remove(j);
                        break;
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

    public int dijkstra(T start, T destination) {

        int[] distances = new int[amountV];
        for (int i = 0; i < amountV; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getVertex().equals(start)){
                distances[i] = 0;
                break;
            }
        }


        ArrayList<Tupla<T>> nextToVisit = new ArrayList<>();
        Tupla<T> tupla = new Tupla<>(start, 0);
        nextToVisit.add(tupla);
        ArrayList<Integer> possibleRoads = new ArrayList<>();

        for (int i = 0; i < nextToVisit.size(); i++) {

            T actual = nextToVisit.get(i).getFirst();
            int acumDistance = nextToVisit.get(i).getSecond();

            if (actual.equals(destination)){
                possibleRoads.add(acumDistance);
            }

            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getVertex().equals(actual)){
                    for(int k = 0; k < list.get(j).getConnections().size();k++){
                        T neighbor = list.get(j).getConnections().get(k).getVertex();
                        int weight = list.get(j).getConnections().get(k).getWeight();
                        int newDistance = acumDistance + weight;

                        for(int h = 0; h < list.size(); h++){
                            if(list.get(h).getVertex().equals(neighbor)){
                                if(newDistance < distances[h]){
                                    distances[h] = newDistance;
                                    nextToVisit.add(new Tupla<>(neighbor, newDistance));
                                }
                            }
                        }
                    }
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
}

