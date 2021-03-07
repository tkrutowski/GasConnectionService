package net.focik.gasconnection.infrastructure.dto;

import net.focik.gasconnection.domain.share.GasCabinetProviderType;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class GasCabinetProviderTypeConverter implements AttributeConverter<GasCabinetProviderType, String> {
    @Override
    public String convertToDatabaseColumn(GasCabinetProviderType gasCabinetProviderType) {
        int i=0;
        return gasCabinetProviderType.getDbValue();
    }

    @Override
    public GasCabinetProviderType convertToEntityAttribute(String s) {
        int i=0;
        return GasCabinetProviderType.fromDbValue(s);
    }
}
