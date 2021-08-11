public enum LicenseTypeEnum {
    Personal("PS"),
    Commercial("CO"),
    Educational("ED"),
    Classroom("CR"),
    Site("SITE"),
    Campus("CAMPUS");

    public String value;

    LicenseTypeEnum(String value) {
        this.value = value;
    }
}
