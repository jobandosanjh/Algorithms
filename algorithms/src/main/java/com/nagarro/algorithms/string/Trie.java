package com.nagarro.algorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.MoreObjects;

public class Trie {

    public static void main(final String[] args) {
        final Node node = new Node();
        add(node, "abc".toCharArray());
        add(node, "abgl".toCharArray());
        System.out.println(searchSubString(node, "ab"));
        System.out.println(searchSubString(node, "abgl"));
        System.out.println(searchWholeWord(node, "ab"));
        System.out.println(searchWholeWord(node, "abgl"));
        final String wordToBeDeleted = "abgl";
        System.out.println("Going To Delete :" + wordToBeDeleted);
        deleteWord(node, wordToBeDeleted);
        System.out.println("After Deleting :" + wordToBeDeleted);
        System.out.println(searchWholeWord(node, wordToBeDeleted));
        System.out.println(searchSubString(node, "ab"));
        System.out.println(searchSubString(node, "abg"));
        System.out.println(searchSubString(node, "abgl"));
        System.out.println(searchWholeWord(node, "abc"));
    }

    private static void add(final Node node, final char[] data) {
        Node currentNode = node;
        for (int i = 0; i < data.length; i++) {
            Map<String, Node> map = currentNode.getMap();
            final String element = String.valueOf(data[i]);
            if (map.containsKey(element)) {
                currentNode = map.get(element);
            } else {
                currentNode = new Node(new HashMap<>(), i + 1 == data.length);
                map.put(element, currentNode);
            }
        }
    }

    private static boolean searchSubString(final Node node, final String pattern) {
        Node currentNode = node;
        for (int i = 0; i < pattern.length(); i++) {
            final Map<String, Node> map = currentNode.getMap();
            if (!map.containsKey(String.valueOf(pattern.charAt(i)))) {
                return false;
            }
            currentNode = map.get(String.valueOf(pattern.charAt(i)));
        }
        return true;
    }

    private static boolean searchWholeWord(final Node node, final String word) {
        Node currentNode = node;
        for (int i = 0; i < word.length(); i++) {
            final Map<String, Node> map = currentNode.getMap();
            if (!map.containsKey(String.valueOf(word.charAt(i)))) {
                return false;
            }
            currentNode = map.get(String.valueOf(word.charAt(i)));
        }
        return currentNode.isEndOfWord();
    }

    private static void deleteWord(final Node node, final String word) {
        if (searchWholeWord(node, word)) {
            deleteRecursively(node, word, 0);
        }
    }

    private static boolean deleteRecursively(Node node, final String word, final int index) {
        final Map<String, Node> map = node.getMap();
        if (index < word.length() && map.containsKey(String.valueOf(word.charAt(index)))) {
            if (deleteRecursively(map.get(String.valueOf(word.charAt(index))), word, index + 1)) {
                map.remove(String.valueOf(word.charAt(index)));
                if (map.isEmpty()) {
                    node.setEndOfWord(true);
                }
            }
        }
        return node.isEndOfWord();
    }
}

class Node {

    private Map<String, Node> map;
    private boolean isEndOfWord;

    public Node() {
        map = new HashMap<>();
        isEndOfWord = false;
    }

    public Node(final Map<String, Node> map, final boolean isEndOfWord) {
        this.map = map;
        this.isEndOfWord = isEndOfWord;
    }

    public Map<String, Node> getMap() {
        return map;
    }

    public void setMap(final Map<String, Node> map) {
        this.map = map;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(final boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isEndOfWord ? 1231 : 1237);
        result = prime * result + ((map == null) ? 0 : map.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Node that = (Node) obj;
        return Objects.equals(this.isEndOfWord, that.isEndOfWord) && Objects.equals(this.map, that.map);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("isEndOfWord", this.isEndOfWord).add("map", this.map).toString();
    }

}
