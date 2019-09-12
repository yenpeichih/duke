package Model_Class;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class saves the to-do list into a text file using the PrintWriter class and checks for existing text files to
 * load into the program if there is any. The tasks in the list are converted to Strings to print into the file
 * and are converted back to Task class when being loaded into the program.
 */
public class Storage {

    public File listsFile;
    public ArrayList<String> toDoString;
    public ArrayList<Task> toDoList;

    /**
     * The constructor for this class.
     *
     * @param listsFile The path of the file to be saved.
     */
    public Storage(File listsFile) {
        this.listsFile = listsFile;
        this.toDoString = new ArrayList<>();
        this.toDoList = new ArrayList<>();
    }

    /**
     * Method to read the to-do list from the text file and convert each string into a Task class, before being inserted
     * into the ArrayList.
     *
     * @return The populated ArrayList of Tasks
     */
    public ArrayList loadFile() {
        if (listsFile.exists()) {
            try {
                Scanner readFile = new Scanner(listsFile);
                while (readFile.hasNextLine()) {
                    String tempLine = readFile.nextLine();
                    try {
                        toDoString.add(tempLine);
                    } catch (NullPointerException a) {
                        System.out.println("yo");
                    }
                }
                if (!toDoString.isEmpty()) {
                    for (String iterate : toDoString) {
                        // split each to do line here according to [ and determine class
                        String[] splitFileString = iterate.split("\\[");
                        String[] splitFileStringTwo = splitFileString[2].split("]");
                        if (splitFileString[1].equals("T]")) {
                            Todo fileTodo = new Todo(splitFileStringTwo[1]);
                            if (splitFileStringTwo[0].equals("\u2713")) {
                                fileTodo.setDone();
                                toDoList.add(fileTodo);
                            } else {
                                toDoList.add(fileTodo);
                            }
                        } else if (splitFileString[1].equals("E]")) {
                            Event fileEvent = new Event(splitFileStringTwo[1].stripTrailing(), splitFileString[3].strip().replaceAll("at: ", "").replaceAll("\\)", ""));
                            if (splitFileStringTwo[0].equals("\u2713")) {
                                fileEvent.setDone();
                                toDoList.add(fileEvent);
                            } else {
                                toDoList.add(fileEvent);
                            }
                        } else {
                            Deadline fileDeadline = new Deadline(splitFileStringTwo[1].stripTrailing(), splitFileString[3].strip().replaceAll("by: ", "").replaceAll("\\)", ""));
                            if (splitFileStringTwo[0].equals("\u2713")) {
                                fileDeadline.setDone();
                                toDoList.add(fileDeadline);
                            } else {
                                toDoList.add(fileDeadline);
                            }
                        }
                    }
                }
            } catch (FileNotFoundException f) {
                System.out.println(f);
            }
            return toDoList;
        } else {
            toDoList = new ArrayList<>();
            return toDoList;
        }
    }

    /**
     * This method converts the Tasks objects in the ArrayList into strings and print them out into a text file. The
     * text file is saved after the operation.
     */
    public void saveFile() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("DukeList.txt");
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        }
        for (Task fileList : toDoList) {
            String checkTaskType = fileList.toString();
            if (checkTaskType.charAt(1) == 'T') {
                printWriter.println(checkTaskType);
            } else if (checkTaskType.charAt(1) == 'E') {
                char[] convertToChar = checkTaskType.toCharArray();
                for (int i = 0; i < checkTaskType.length(); i += 1) {
                    if (convertToChar[i] == '(') {
                        convertToChar[i] = '[';
                    }
                }
                String newString = new String(convertToChar);
                printWriter.println(newString);
            } else {
                char[] convertToChar = checkTaskType.toCharArray();
                for (int i = 0; i < checkTaskType.length(); i += 1) {
                    if (convertToChar[i] == '(') {
                        convertToChar[i] = '[';
                    }
                }
                String newString = new String(convertToChar);
                printWriter.println(newString);
            }
        }
        printWriter.close();
    }

}
