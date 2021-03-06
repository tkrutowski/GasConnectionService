package net.focik.gasconnection.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import net.focik.customers.domain.ClientType;

//
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity
//@Table(name = "userbooks")
public class GasConnectionTaskCalendarDto implements IGasConnectionDto {
    private Integer idTask;
    private Integer idCustomer;
    private Integer idSurveyor;
    private String taskNo;
    private Boolean isPgn;
    private String gasCabinetProvider;
    private String address;
}
