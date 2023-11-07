package com.example.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GraphList {
    private int amountV;
    private List<List<Integer>> list;
    private Random ran;

    public int getAmountV() {
        return amountV;
    }

    public List<List<Integer>> getList() {
        return list;
    }

    public GraphList(int amountV) {
        ran = new Random();
        this.amountV = amountV;
        list = new ArrayList<>(amountV+1);
        for (int i = 1; i < amountV+1; i++) {
            list.add(new ArrayList<>(2));
        }
    }

    public void addEdge(int edge1, int edge2, int weight) {
        list.get(edge1).add(0,edge2);
        list.get(edge1).add(1,weight);
        list.get(edge2).add(0, edge1);
        list.get(edge2).add(1, weight);
    }

    public void printGraph() {
        for (int i = 1;  i < amountV; i++) {
            System.out.print("Vertex " + i + ": ");

            for (int j = 0; j < list.get(i).size(); j += 2) {

                int adjacent = list.get(i).get(j);
                int weight = list.get(i).get(j + 1);
                System.out.print(adjacent + "(" + weight + ") ");
            }
            System.out.println();
        }
    }
    public void deleteVertex(int vertex){
        for(int i = 1; i < amountV; i++){
            if(i == vertex){

                list.remove(vertex);

                list.add(vertex, new ArrayList<>());

            }else{

                for(int j = 0; j < (list.get(i)).size(); j+=2){

                    if(list.get(i).get(j) == vertex){
                        list.get(i).remove(j+1);
                        list.get(i).remove(j);

                    }
                }
            }

        }
    }

    public void deleteEdge(int edge1, int edge2){
        for (int i = 0; i < list.get(edge1).size(); i+=2){

            if(list.get(edge1).get(i) == edge2){

                list.get(edge1).remove(i+1);
                list.get(edge1).remove(i);

            }

        }

        for (int i = 0; i < list.get(edge2).size(); i+=2){

            if(list.get(edge2).get(i) == edge1){

                list.get(edge2).remove(i+1);
                list.get(edge2).remove(i);

            }

        }


    }

    public int getEdgeWeight(int edge1, int edge2){
        int ans = -1;
        for(int i = 0; i < list.get(edge1).size(); i+=2){
            if(list.get(edge1).get(i) == edge2){
                ans = list.get(edge1).get(i+1);
            }
        }
        return ans;
    }

    public boolean checkConnect(int edge1, int edge2){
        boolean ans = false;

        for(int i = 0; i < list.get(edge1).size(); i+=2){
            if(list.get(edge1).get(i) == edge2){
                ans = true;
            }
        }

        return ans;
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


}
