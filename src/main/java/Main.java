import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int scelta;
        KeyGen k;
        do {
            System.out.println("""
                    KeyGen StarUML v4.0.1
                    Scegli tra le seguenti operazioni
                    1) Licenza Rapida
                    2) Licenza Personalizzata
                    3) Disattiva licenza e ripristina host
                    99) Esci
                    """
            );
            scelta = sc.nextInt();
            k = new KeyGen("Cracked :-)", LicenseTypeEnum.Commercial.value, "Unlimited", "11-08-2021");
            switch (scelta) {
                case 1 -> {
                    k.createLicenceFile();
                    KeyGen.blockHost();
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.println("Inserisci nome:\n");
                    String nome = sc.nextLine();
                    System.out.println("Inserisci quantità:\n");
                    String qty = sc.nextLine();
                    System.out.println("""
                            Inserisci Tipo di Licenza:
                            1) Personal
                            2) Commercial
                            3) Educational
                            4) Classroom
                            5) Site
                            6) Campus
                            """
                    );
                    LicenseTypeEnum lte = switch (sc.nextInt()) {
                        case 2 -> LicenseTypeEnum.Commercial;
                        case 3 -> LicenseTypeEnum.Educational;
                        case 4 -> LicenseTypeEnum.Classroom;
                        case 5 -> LicenseTypeEnum.Site;
                        case 6 -> LicenseTypeEnum.Campus;
                        default -> LicenseTypeEnum.Personal;
                    };
                    Calendar c = Calendar.getInstance();
                    String time = c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.YEAR);
                    k = new KeyGen(nome, lte.value, qty, time);
                    k.createLicenceFile();
                    KeyGen.blockHost();
                }
                case 3 -> {
                    KeyGen.deleteLicenceFile();
                    KeyGen.restoreHost();
                }
                case 99 -> {
                    sc.close();
                    System.exit(1);
                }
            }
            System.out.println("Operazioni Terminate... Buon Divertimento\n");
            Thread.sleep(1000);
        } while (true);
    }
}
