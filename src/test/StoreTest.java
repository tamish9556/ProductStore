import org.junit.Test;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;

import java.util.List;

@Slf4j
public class StoreTest {

    @InjectMocks
    private StoreService service;
    private List<StoreModel> productModels = service.htmlToJson("C:/Users/Tami/Downloads/response.html");

    @Test
    @DisplayName("test_ID")
    public void test_ID() {
        Assertions.assertEquals("3", productModels.get(0).getId());
    }

    @Test
    @DisplayName("test_Title")
    public void test_Title() {
        Assertions.assertEquals("Nexus 6", productModels.get(0).getTitle());
    }

    @Test
    @DisplayName("test_Price")
    public void test_Price() {
        Assertions.assertEquals(650, productModels.get(0).getPrice());
    }

    @Test
    @DisplayName("test_NumOfItems")
    public void test_NumOfItems() {
        Assertions.assertEquals(1, productModels.size());
    }

}
