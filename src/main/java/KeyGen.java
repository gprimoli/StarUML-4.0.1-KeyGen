import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;

public class KeyGen {

    private static final String product = "STARUML.V4";
    private static final String SK = "DF9B72CC966FBE3A46F99858C5AEE";
    private final String name;
    private final String licenseType;
    private final String quantity;
    private final String timestamp;
    private String licenseKey;


    public static void main(String[] args) {
        KeyGen k = new KeyGen("Cracked :-)", LicenseTypeEnum.Commercial.value, "Unlimited", "11-08-2021");
        k.blockHost();
        k.createLicenceFile();
    }


    public KeyGen(String name, String licenseType, String quantity, String timestamp) {
        this.name = name;
        this.licenseType = licenseType;
        this.quantity = quantity;
        this.timestamp = timestamp;

        String tmp = SK
                + this.name + SK
                + product + '-' + this.licenseType + SK
                + this.quantity + SK
                + this.timestamp + SK;
        try {
            MessageDigest crypter = MessageDigest.getInstance("SHA-1");
            crypter.update(tmp.getBytes(StandardCharsets.UTF_8));
            this.licenseKey = byteToHex(crypter.digest()).toUpperCase();
        } catch (Exception e) {
            System.out.println("Impossibile :-O");
        }
    }

    public void blockHost() {
        try {
            HostsRecord record = new HostsRecord("127.0.0.1", "staruml.io");
            ArrayList<HostsRecord> records = new ArrayList<>();
            records.add(record);
            HostsFile h = new HostsFile();
            h.addIfNotExist("#StarUML Crack", records);
        } catch (Exception e) {
            System.out.println("Esegui il programma con i permessi di amministratore");
        }
    }

    public void createLicenceFile() {
        try {
            File licence = new File(System.getenv("APPDATA") + "\\StarUML\\license.key");
            FileWriter fw = new FileWriter(licence);
            fw.write("{\n" +
                    "\"product\":\"" + product + "\"\t\n" +
                    "\"name\":\"" + name + "\"\t\n" +
                    "\"licenseType\":\"" + licenseType + "\"\t\n" +
                    "\"quantity\":\"" + quantity + "\"\t\n" +
                    "\"timestamp\":\"" + timestamp + "\"\t\n" +
                    "\"licenseKey\":\"" + licenseKey + "\"\t\n" +
                    "}"
            );
        } catch (Exception e) {
            System.out.println("Impossibile creare il file license");
        }
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
            formatter.format("%02x", b);
        String result = formatter.toString();
        formatter.close();
        return result;
    }

}
