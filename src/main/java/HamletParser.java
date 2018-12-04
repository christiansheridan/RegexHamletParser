import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public void toLeon() {

        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Leon");

    }

    public boolean findHamlet() {

        return hamletData.toLowerCase().contains("hamlet");
    }

    public boolean findHoratio() {
        return hamletData.toLowerCase().contains("horatio");
    }

    public void toTariq() {

        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        hamletData = matcher.replaceAll("Tariq");

    }
}
