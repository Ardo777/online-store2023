package util;

public class UUID {
    public static String idGenerate() {
        String uuidID = java.util.UUID.randomUUID().toString();
        String[] uuidSplit = uuidID.split("-");
        String id = uuidSplit[0];

        return id;
    }
}
