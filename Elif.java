import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class Elif {
    private static void errorMessage() {
        System.out.println("Ooops, something went wrong. Here is the error message: ");
    }

    public static String readLines(String fileName) {
        try {
            InputStream is = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            StringBuffer result = new StringBuffer("");
            String current = null;
            do {
                current = reader.readLine();
                if(current != null) {
                    if(result.isEmpty())
                        result.append(current);
                    else
                        result.append("\n"+current);
                }
            } while(current != null);
            return result.toString();
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
            return null;
        }
    }
    public static byte[] readBytes(String fileName) {
        try {
            File file = new File(fileName);
            byte[] arr = new byte[(int)(file.length())];
            FileInputStream fis = new FileInputStream(file);
            arr = fis.readAllBytes();
            return arr;
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
            return null;
        }
    }
    public static String readLinesNIO(String fileName) {
        try {
            Path filePath = Paths.get(fileName);
            List<String> res = Files.readAllLines(filePath);
            StringBuffer ans = new StringBuffer("");
            for(String line : res) {
                ans.append(line+"\n");
            }
            return ans.toString();
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
            return null;
        }
    }
    public static byte[] readBytesNIO(String fileName) {
        try {
            Path filePath = Paths.get(fileName);
            byte[] arr = Files.readAllBytes(filePath);
            return arr;
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
            return null;
        }
    }

    private static void writeLines(String fileName, String text, boolean append) {
        try {
            FileWriter fw = new FileWriter(fileName, append);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.flush();
            bw.close();
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
        }
    }
    public static void writeLines(String fileName, String text) {
        writeLines(fileName, text, false);
    }
    public static void appendLines(String fileName, String text) {
        writeLines(fileName, text, true);
    }
    public static void writeBytes(String fileName, byte[] text) {
        try {
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(text);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
        }
    }
    public static void writeLinesNIO(String fileName, String text) {
        try {
            Path filePath = Paths.get(fileName);
            Files.writeString(filePath, text);
        } catch (Exception e) {
            errorMessage();
            e.printStackTrace();
        }
    }
    public static void writeBytesNIO(String fileName, byte[] text) {
        try {
            Path filePath = Paths.get(fileName);
            Files.write(filePath, text);
        } catch(Exception e) {
            errorMessage();
            e.printStackTrace();
        }
    }
}
