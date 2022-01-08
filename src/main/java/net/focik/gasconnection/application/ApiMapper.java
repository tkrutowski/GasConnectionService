package net.focik.gasconnection.application;

import net.focik.gasconnection.api.dto.GasConnectionTaskCalendarDto;
import net.focik.gasconnection.api.dto.IGasConnectionDto;
import net.focik.gasconnection.domain.GasConnection;
import net.focik.gasconnection.domain.share.DtoType;

public class ApiMapper {


    public static IGasConnectionDto toDto(GasConnection gasConnection, DtoType dtoType){

        IGasConnectionDto gasConnectionDto = null;
        switch (dtoType) {
            case TASK_CALENDAR:
                gasConnectionDto = buildTaskCalendarDto(gasConnection);
                break;
            case GAS_CONNECTION:
                break;
        }
        return gasConnectionDto;
    }

    private static IGasConnectionDto buildTaskCalendarDto(GasConnection gasConnection) {
        return GasConnectionTaskCalendarDto.builder()
                .idTask(gasConnection.getIdTask())
                .idCustomer(gasConnection.getIdCustomer())
                .idSurveyor(gasConnection.getIdSurveyor())
                .taskNo(gasConnection.getTaskNo())
                .address(gasConnection.getAddress().getCity() + ", ul. " + gasConnection.getAddress().getStreet())
                .isPgn(gasConnection.isPgn())
                .build();
    }
}
