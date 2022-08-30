package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        Post p1 = new Post(
                LocalDateTime.parse("29/08/2022 13:05:44", fmt1),
                "Travelling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        p1.addComment(c1);
        p1.addComment(c2);

        Comment c3 = new Comment("Good night!");
        Comment c4 = new Comment("May the force be with you.");
        Post p2 = new Post(
                LocalDateTime.parse("30/08/2022 00:05:21", fmt1),
                "Good night guys",
                "See you tomorrow",
                5);
        p2.addComment(c3);
        p2.addComment(c4);

        System.out.println(p1);
        System.out.println(p2);

    }
}
