import app.StoreApplication;
import com.StoreModel;
import com.StoreService;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;

@Slf4j
public class StoreTest {

    @InjectMocks
    private StoreService service;
    private StoreModel productModel = StoreApplication.htmlToJson("../ProductStore/moreInfo/main.html");

    @Test
    @DisplayName("test_ID")
    public void test_ID() {
        Assertions.assertEquals("3", productModel.getId());
    }

    @Test
    @DisplayName("test_Title")
    public void test_Title() {
        Assertions.assertEquals("Nexus 6", productModel.getTitle());
    }

    @Test
    @DisplayName("test_Price")
    public void test_Price() {
        Assertions.assertEquals(650, productModel.getPrice());
    }

    @Test
    @DisplayName("test_NumOfItems")
    public void test_NumOfItems() {
        Assertions.assertEquals(1, productModel.getCnt());
    }

}
