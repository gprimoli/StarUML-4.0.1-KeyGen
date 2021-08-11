import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class HostsFile {

    private File originalHost;

    public HostsFile() throws IOException {
        originalHost = new File(System.getenv("WinDir") + "\\System32\\drivers\\etc\\hosts");
        File backUpHost = new File(System.getenv("WinDir") + "\\System32\\drivers\\etc\\hosts.bak");
        Files.copy(originalHost.toPath(), backUpHost.toPath());
    }

    public boolean search(String txt) {
        try {
            Scanner s = new Scanner(originalHost);
            while (s.hasNext()) {
                String tmp = s.nextLine();
                if (tmp.compareToIgnoreCase(txt) == 0)
                    return true;
            }
        } catch (Exception ignored) {}
        return false;
    }

    public void add(String intestazione, ArrayList<HostsRecord> records) throws IOException {
        FileWriter fw = new FileWriter(originalHost, true);
        fw.write("\n" + intestazione + "\n");
        for (HostsRecord el : records)
            fw.write(el.getLoopback() + "\t" + el.getIndirizzo() + "\n");
        fw.close();
    }

    public void addIfNotExist(String intestazione, ArrayList<HostsRecord> records) throws IOException {
        if (!search(intestazione))
            add(intestazione, records);
    }
}
