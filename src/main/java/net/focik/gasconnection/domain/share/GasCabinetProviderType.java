package net.focik.gasconnection.domain.share;

//TODO jak się da to zmienić na PL
public enum GasCabinetProviderType {
    UNKNOW("Nieznane"),
    CUSTOMER("Klient"),
    PSG("PSG"),
    COMPANY("Progas");

    private String dbValue;

    GasCabinetProviderType(String dbValue) {
        this.dbValue = dbValue;
    }


    public String getDbValue() {
        return dbValue;
    }

    public void setDbValue(String dbValue) {
        this.dbValue = dbValue;
    }

    public static GasCabinetProviderType fromDbValue(String dbValue){
        switch (dbValue){
            case "Nieznane":
                return GasCabinetProviderType.UNKNOW;
            case "Klient":
                return GasCabinetProviderType.CUSTOMER;
            case "Progas":
                return GasCabinetProviderType.COMPANY;
            default:
                throw new IllegalArgumentException("Value [" + dbValue
                        + "] not supported.");
        }
    }
}
