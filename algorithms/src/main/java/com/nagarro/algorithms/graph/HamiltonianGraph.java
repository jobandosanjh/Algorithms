package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

import com.google.common.base.MoreObjects;

public final class HamiltonianGraph {

    public static void main(final String[] args) {
        final Collection<LinkedList<Hamiltonian>> list = new ArrayList<>(5);
        list.add(getEdge("1", "2"));
        list.add(getEdge("2", "3"));
        list.add(getEdge("2", "5"));
        list.add(getEdge("3", "4"));
        list.add(getEdge("4", "5"));
        list.add(getEdge("5", "1"));
        list.add(getEdge("5", "2"));

        final Collection<String> path = new ArrayList<>(5);

        final Stack<String> stack = new Stack<>();
        for (final LinkedList<Hamiltonian> input : list) {
            if (stack.isEmpty() || !stack.contains(input.peek().getName())) {
                stack.add(input.peek().getName());
            }
            while (!stack.isEmpty()) {
                final LinkedList<Hamiltonian> linkedList = list.stream()
                        .filter(i -> i.peek().getName().equals(stack.peek())).findFirst().get();
                for (final Hamiltonian node : linkedList) {
                    if (!node.isVisited()
                            && (!path.contains(node.getName()) || path.stream().findFirst().get()
                                    .equals(node.getName()))) {
                        path.add(node.getName());
                        stack.push(node.getName());
                        node.setVisited(true);
                    }
                }
                stack.pop();
            }
        }
        path.stream().forEach(System.out::println);
    }

    private static LinkedList<Hamiltonian> getEdge(final String source, final String destination) {
        final LinkedList<Hamiltonian> linkedList = new LinkedList<>();
        linkedList.addFirst(new Hamiltonian(destination));
        linkedList.addFirst(new Hamiltonian(source));
        return linkedList;
    }

}

class Hamiltonian {

    private String name;
    private boolean visited;

    public Hamiltonian(final String name) {
        this.name = name;
    }

    public void addEdge() {

    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(final boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Hamiltonian that = (Hamiltonian) obj;
        return Objects.equals(this.name, that.name) && Objects.equals(this.visited, that.visited);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.name).add("visited", this.visited).toString();
    }
}