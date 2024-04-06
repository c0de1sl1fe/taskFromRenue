package com.ykic;

import org.apache.commons.cli.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    static String dataPath = "";
    static int indexedColumnId = -1;
    static String inputFilePath = "";
    static String outputFilePath = "";

    public static void main(String[] args) {
        Options options = getOptions();

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

        if (!validateInputs()) {
            System.exit(-1);
            return;
        }

        ReaderCSV readerCSV = new ReaderCSV(dataPath, indexedColumnId);
        ReaderTXT readerTXT = new ReaderTXT(inputFilePath);
        List<SearchItem> searchItems = new ArrayList<>();
        SearchResult searchResult = new SearchResult();
        Trie trie;

        long start = System.nanoTime();
        readerCSV.readData();
        long finish = System.nanoTime();
        long timeElapsed = (finish - start) / 1_000_000;
        searchResult.setInitTime(timeElapsed);



        trie = readerCSV.getData();

        readerTXT.readData();
        ArrayList<String> searchNames = readerTXT.getData();

        List<Integer> arr;


        for(String searchName : searchNames) {
            start = System.nanoTime();
            arr = trie.search(searchName);
            finish = System.nanoTime();
            timeElapsed = (finish - start) / 1_000_000;

            searchItems.add(new SearchItem(searchName, arr, timeElapsed));
        }

        searchResult.setResult(searchItems);

        FileOperations.serializeObj(outputFilePath, searchResult);




        arr = trie.search("Bow");
        Collections.sort(arr);


        System.out.println(timeElapsed);
        System.out.println(arr);
    }

    private static Options getOptions() {
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
        return options;
    }

    public static boolean validateInputs() {
        return FileOperations.checkFileExists(dataPath) && FileOperations.checkFileExists(inputFilePath) && (indexedColumnId > 0 && indexedColumnId<15);
    }


}




