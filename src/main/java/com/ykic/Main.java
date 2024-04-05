package com.ykic;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ReaderCSV readerCSV = new ReaderCSV("D:\\git\\courseGeekBrains\\src\\main\\resources\\test.csv", 2);
//        readerCSV.readData();
//        System.out.println("\n");
//        System.out.println(readerCSV.getData());

//        Trie trie = new Trie();
//
//        trie.insert(new Couple( 1, "apple kiwi"));
//        trie.insert(new Couple(2, "app"));
//        trie.insert(new Couple(3, "apricot"));
//        trie.insert(new Couple(4, "banana"));
//
//        List<Integer> foundIndexes = trie.search("apple");
//        System.out.println(foundIndexes);
//
        ReadTXT readTXT = new ReadTXT("D:\\\\git\\\\courseGeekBrains\\\\src\\\\main\\\\resources\\\\test.txt");
        readTXT.readData();
        System.out.println(readTXT.getData());

    }
}




