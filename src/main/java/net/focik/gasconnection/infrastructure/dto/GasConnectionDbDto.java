package net.focik.gasconnection.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "przylacze")
public class GasConnectionDbDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_przylacza")
    private Integer idTask;
    @Column(name = "id_klienta")
    private Integer idCustomer;
    @Column(name = "id_geodety_projekt")
    private Integer idSurveyor;
    @Column(name = "nr_zadania")
    private String taskNo;
    @Column(name = "czy_pgn")
    private Boolean isPgn;
//    @Convert(converter = GasCabinetProviderTypeConverter.class)
//    private GasCabinetProviderType gasCabinetProvider;
    @Column(name = "id_address")
    private Long idAddress;

}
