package com.ykic;

import org.apache.commons.cli.*;

import java.util.Arrays;
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


//        ReadTXT readTXT = new ReadTXT("D:\\\\git\\\\courseGeekBrains\\\\src\\\\main\\\\resources\\\\test.txt");
//        readTXT.readData();
//        System.out.println(readTXT.getData());

        Options options = new Options();

        Option dataOption = new Option("d", "data", true, "path to data");
        dataOption.setRequired(true);
        options.addOption(dataOption);

        Option indexOption = new Option("i", "indexed-column-id", true, "column index");
        indexOption.setRequired(true);
        options.addOption(indexOption);

        Option inputFileOption = new Option("in", "input-file", true, "path to input file");
        inputFileOption.setRequired(true);
        options.addOption(inputFileOption);

        Option outputFileOption = new Option("out", "output-file", true, "path to output file");
        outputFileOption.setRequired(true);
        options.addOption(outputFileOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(-1);
            return;
        }

        String dataPath = cmd.getOptionValue("data");
        String indexedColumnId = cmd.getOptionValue("indexed-column-id");
        String inputFilePath = cmd.getOptionValue("input-file");
        String outputFilePath = cmd.getOptionValue("output-file");

        System.out.println("Путь к данным: " + dataPath);
        System.out.println("Индексированный ID колонки: " + indexedColumnId);
        System.out.println("Путь к входному файлу: " + inputFilePath);
        System.out.println("Путь к выходному файлу: " + outputFilePath);
    }
}




