package by.it.shvedov.jd01_15;

import java.io.*;

public class TaskA {
    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir");
        path += File.separator + "src" + File.separator;
        path += cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path;
    }
    private static String getPath(Class<?> cl, String filename) {
        return getPath(cl) + filename;
    }
    public static void main(String[] args) {
        int[][] m=new int[6][4];
        String path=getPath(TaskA.class,"matrix.txt");
        try(PrintWriter printer= new PrintWriter(new FileWriter(path))){
        for (int i = 0; i <m.length ; i++) {
            for (int j = 0; j <m[i].length ; j++) {
                m[i][j] = (int) (-15 + Math.random() + 31);

            }
            printer.printf("%3d",m[i]);
            }

        }
        catch (IOException e){
           e.printStackTrace();
        }
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(path))) {
            for (int i = 0; i <m.length ; i++) {
                String[] line=bufferedReader.readLine().trim().split("\\s+");
                for (int j = 0; j <m[i].length ; j++) {
                 m[i][j]=Integer.parseInt(line[j]);
                    System.out.printf("%3d",m[i][j]);
                }
                System.out.println();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
