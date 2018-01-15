package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    @RequestMapping("/score")
    public Score score(@RequestParam(value="word") String word) {
        return new Score(word);
    }
}
