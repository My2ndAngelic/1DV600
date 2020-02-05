package assign1;

import java.io.*;
import java.util.ArrayList;

public class FileHandle {
    static String[] read(String loc) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(loc));
        String line;
        ArrayList<String> arrlist = new ArrayList<>();
        while((line = in.readLine()) != null)
        {
            arrlist.add(line);
        }
         in.close();
        return arrlist.toArray(new String[0]);
    }

    static void write(String[] content, String loc) throws Exception {
        FileWriter fw = new FileWriter(loc);
        for (String s : content) {
            fw.write(s+"\n");
        }
        fw.close();
    }
}
