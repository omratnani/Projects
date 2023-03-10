import java.io.*;
import java.util.Scanner;

public class FileHandling {

    public Object ReadingObjectFromFile(){
        Object obj;
        try{
            FileInputStream fis = new FileInputStream(this.FileObj);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
            return obj;
        }catch (Exception e){
            System.out.print("Error Reading File");
        }
        return null;
    }

    public boolean WriteObjectOnFile(NewPerson persons)
    {
        boolean success = false;
        try {
            FileOutputStream fos = new FileOutputStream(this.FileObj);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persons);
        }catch (IOException e){
            System.out.print("Error Writing File");
        }
        return success;
    }

    private File FileObj;
    public boolean CreateFile(String FileName)
    {

        boolean success = false;
        FileObj = new File(FileName);
        try {
            if (FileObj.createNewFile()) {
                success = true;
            }
        }catch (IOException e){
            System.out.print("File Not Created");
        }
        return success;
    }

    public boolean WriteStringOnFile(String Data){

        boolean success = false;
        try {
            FileWriter fileWriter = new FileWriter(this.FileObj);
            fileWriter.write(Data);
            System.out.println("Data HAs Been written in file"+ this.FileObj.getName());
            success = true;
        }catch (IOException e){
            System.out.println("Error In Writing File");
        }
        return success;
    }

    public String ReadDataFromFile(){
        String Data = null;
        try {
            Scanner ReadingFile = new Scanner(this.FileObj);
            while (ReadingFile.hasNextLine()){
                Data = Data  + ReadingFile.nextLine();
            }
            ReadingFile.close();
        }catch (IOException e){
            System.out.println("Error In Reading File" + this.FileObj.getName());
        }
        return Data;
    }

}

