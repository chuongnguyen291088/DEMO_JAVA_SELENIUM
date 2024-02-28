import Core.Support.ReportGenerator;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;

@CucumberOptions(
        features = {"src/test/java/Features"},
        monochrome = false,
        strict = true,
        glue = {"Steps", "Core/Support"},
        tags = "@regression and not @skip",
        plugin = {
                "html:target/result",
                "pretty",
                "json:target/test-classes/reports/result.json",
                "rerun:target/rerun.txt"
        }
)

public class CucumberRunner extends AbstractTestNGCucumberTests {
        @AfterTest
        public void generateCucumberReport() {
                System.out.println("Generating cucumber report ...");
                ReportGenerator.generateCucumberReport();
        }
}