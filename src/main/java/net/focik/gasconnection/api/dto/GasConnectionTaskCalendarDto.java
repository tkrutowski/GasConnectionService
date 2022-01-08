package net.focik.gasconnection.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GasConnectionTaskCalendarDto implements IGasConnectionDto {
    private Integer idTask;
    private Integer idCustomer;
    private Integer idSurveyor;
    private String taskNo;
    private Boolean isPgn;
    private String gasCabinetProvider;
    private String address;
}
