import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("https://www.demoblaze.com/")
public class StoreController {
    @Autowired
    private StoreService service;

    @GetMapping("/id")
    public String getId(@RequestParam String path){
        return service.getId(path);
    }

    @GetMapping("/parse-to-json")
    public List<StoreModel> getAllProducts(@RequestParam String path){
        return service.htmlToJson(path);
    }
}
