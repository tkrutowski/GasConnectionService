package net.focik.gasconnection.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.focik.addresses.domain.Address;

@Builder
@Getter
public class GasConnection {
    private Integer idTask;
    private Integer idCustomer;
    private Integer idSurveyor;
    private String taskNo;
    private boolean isPgn;
     @Setter private Address address;

}
