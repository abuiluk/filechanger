import java.io.File;
import java.io.IOException;

public class NewApp {

    String pathToMainFolder;
    String targetFolder;

    public NewApp(String pathToMainFolder, String targetFolder){
        this.pathToMainFolder = pathToMainFolder;
        this.targetFolder = targetFolder;
    };


    public void main()
    {
        System.out.println("test");
        String[] directories = getSubFolders(pathToMainFolder);
        fullRename(directories);

    }

    public void fullRename(String[] directories){
        for (Object dir : directories){
            String path = pathToMainFolder + "\\" + dir;
            File[] listFiles = listFiles((path));
            allFilesRename(dir, listFiles);
        }
    }

    public void allFilesRename(Object dir, File[] files){
        for (Object file: files){
            String old = "" + file;
            String fileName = file.toString().replace(pathToMainFolder + "\\" + dir + "\\","");
            String newPath = pathToMainFolder +"\\"+  dir +"_"+ fileName;
            System.out.println(newPath);
            renameFiles(old, newPath);
        }

    }

    public String[] getSubFolders(String path){
        File file = new File(path);
        return file.list((current, name) -> new File(current, name).isDirectory());
    }

    public File[] listFiles(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File " + listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                System.out.println("Directory " + listOfFile.getName());
            }
        }
        return listOfFiles;
    }

    public void renameFiles(String oldPath, String newPath){

        File checkDirectory = new File(targetFolder);
        if (!checkDirectory.exists()) {
            if(checkDirectory.mkdir()){
                System.out.println("New folder created " + targetFolder);
            }
        }

        File file = new File(oldPath);

        File file2 = new File(newPath);

        if (file2.exists())
            try {
                throw new java.io.IOException("file exists");
            } catch (IOException e) {
                e.printStackTrace();
            }

        if (file.renameTo(file2)){
            System.out.println(newPath + " File renamed");
        }else {
            System.out.println("Error");
        };
    }

}
