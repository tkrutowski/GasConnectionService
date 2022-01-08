package net.focik.gasconnection.infrastructure.dto;

import net.focik.addresses.domain.Address;
import net.focik.gasconnection.domain.GasConnection;

public class JpaMapper {

    public static GasConnection toDomain(GasConnectionDbDto dto){

        return GasConnection.builder()
                .idTask(dto.getIdTask())
                .idCustomer(dto.getIdCustomer())
                .idSurveyor(dto.getIdSurveyor())
                .isPgn(dto.getIsPgn())
                .taskNo(dto.getTaskNo())
                .address(new Address(dto.getIdAddress(),null, null, null, null, null))
                .build();
    }

    public static GasConnectionDbDto toDto(GasConnection gasConnection){
        return GasConnectionDbDto.builder().build();
    }
}
