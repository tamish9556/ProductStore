import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreModel {
    private String id;
    private String title;
    private double price;
    private int cnt;
}
