public class HostsRecord {
    private String loopback;
    private String indirizzo;

    public HostsRecord(String loopback, String indirizzo) {
        this.loopback = loopback;
        this.indirizzo = indirizzo;
    }

    public String getLoopback() {
        return loopback;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String toString() {
        return "HostsRecord{" +
                "loopback='" + loopback + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
