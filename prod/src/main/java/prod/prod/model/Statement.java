package prod.prod.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class Statement {
    @NotNull
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private String daterType;
    @NotNull
    private Integer value;
}


