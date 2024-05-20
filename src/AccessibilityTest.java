import com.deque.html.axecore.playwright.*; // 1
import com.deque.html.axecore.results.AxeResults;

import com.microsoft.playwright.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AccessibilityTest {

    @ParameterizedTest
    @ValueSource(strings = {"https://www.airbnb.com/", "https://www.airbnb.com/rooms/894001995907424641?adults=1&category_tag=Tag%3A8186&children=0&enable_m3_private_room=true&infants=0&pets=0&photo_id=1654463603&search_mode=flex_destinations_search&check_in=2024-06-16&check_out=2024-06-21&source_impression_id=p3_1715849050_IwqW5BAtOuyC%2FLAl&previous_page_section_name=1000&federated_search_id=1eaff732-35bc-4a12-8bd1-25e68764f51c"})
    void shouldNotHaveAutomaticallyDetectableAccessibilityIssues(String url) throws Exception {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate(url); // 3

        AxeResults accessibilityScanResults = new AxeBuilder(page)
                .withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"))
                .analyze();

        assertEquals(Collections.emptyList(), accessibilityScanResults.getViolations());
    }
}
