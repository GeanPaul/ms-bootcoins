package com.nttdata.app.documents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bootcoins")
public class BootcoinsRate {
    @Id
    private String id;
    private String description;
    private String typeOprations;
    private int minimumCoins;
    private int maximumCoins;
    private BigDecimal cost;
    private String status; //Valores: 1 = Activo | 0 = Inactivo
    public boolean isActive(){
        return this.status.equals("1");
    }
}

