package com.ykic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {


    static String dataPath = "";
    static int indexedColumnId = -1;
    static String inputFilePath = "";
    static String outputFilePath = "";

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

        dataPath = cmd.getOptionValue("data");
        indexedColumnId = Integer.parseInt(cmd.getOptionValue("indexed-column-id"));
        inputFilePath = cmd.getOptionValue("input-file");
        outputFilePath = cmd.getOptionValue("output-file");


        System.out.println(FileOperations.checkFileExists(dataPath));
        System.out.println(FileOperations.checkFileExists(inputFilePath));
        System.out.println(FileOperations.checkFileExists(outputFilePath));

        if (!validateInputs()) {
            System.exit(-1);
            return;
        }



    }
    public static boolean validateInputs() {
        return FileOperations.checkFileExists(dataPath) && FileOperations.checkFileExists(inputFilePath) && (indexedColumnId > 0 && indexedColumnId<15);
    }


}




