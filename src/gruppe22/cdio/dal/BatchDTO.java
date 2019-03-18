package gruppe22.cdio.dal;

import java.time.LocalTime;

public class BatchDTO {
    private int batchNumber;
    private MaterialDTO material;
    private UserDTO operator;
    private double tareWeight;
    private double netWeight;
    private double grossWeight;
    private LocalTime dateTime;
    private boolean discarded;
}
