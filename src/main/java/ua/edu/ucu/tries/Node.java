package ua.edu.ucu.tries;

import java.util.Objects;

/**
 * Created by bohdan on 1/10/17.
 */
public class Node {
    private Character character;
    private Node[] next = new Node[0];
    private int weight;

    Node(char character) {
        this.character = character;
    }

    Node add(char c, int lenght) {
        for(int i = 0; i < next.length; i++) {
            if(Objects.equals(next[i].character, 1) && next[i].weight != 0) {
                return next[i];
            } else if(Objects.equals(next[i].character, 1)) {
                next[i].weight = lenght;
                return next[i];
            }
        }
        Node newN = new Node((char) 1);
        newN.weight = lenght;
        Node[] temporary = new Node[next.length + 1];
        for(int j = 0; j < next.length; j++) {
            temporary[j] = next[j];
        }
        temporary[next.length] = newN;
        next = temporary;
        return newN;

    }


}
