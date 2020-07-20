package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskInstallation {
    private final String PATH = "D://Games";
    private StringBuilder strBuilder = new StringBuilder();

    public void start(){
        File dirGames = new File(PATH);
        if (!dirGames.exists())
            dirGames.mkdir();

        File dirSrc = createDir(dirGames, "src");
        File dirRes = createDir(dirGames, "res");
        File dirSaveGames = createDir(dirGames, "savegames");
        File dirTemp = createDir(dirGames, "temp");

        File dirMain = createDir(dirSrc, "main");
        File dirTest = createDir(dirSrc, "test");
        File fileMain = createFile(dirMain, "Main.java");
        File fileUtils = createFile(dirMain, "Utils.java");

        File dirDrawables = createDir(dirRes, "drawables");
        File dirVectors = createDir(dirRes, "vectors");
        File dirIcons = createDir(dirRes, "icons");
        File fileTemp = createFile(dirTemp, "temp.txt");

        writeFile(fileTemp);
    }

    private void writeFile(File fileTemp) {
        try (FileWriter writer = new FileWriter(fileTemp, false)){
            writer.write(strBuilder.toString());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private File createDir(File parent, String name){
        File dir= new File(parent.getPath() + "//" + name);
        dir.mkdir();
        strBuilder.append("Directory " + dir.getPath() + " created\n");
        return dir;
    }

    private File createFile(File parent, String name){
        File file = new File(parent.getPath() + "//" + name);
        try {
            if (file.createNewFile()) {
                strBuilder.append("File " + file.getPath() + " created\n");
                return file;
            }
            else
                throw new IOException("Something went wrong");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}

