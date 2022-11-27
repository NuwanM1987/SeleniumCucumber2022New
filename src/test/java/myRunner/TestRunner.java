package myRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {".//Features/"},
        glue     =  "stepDefinitions" ,// need to give only package , test runner will select suitable step definitions
        dryRun = false, // this will check every steps in feaure files having corresponding step definition steps
        monochrome = true, //remove unneccessary characters from console window
        plugin = {
                "pretty",
                "html:test-output"
        },
        tags= "@sanity"

)
public class TestRunner {


}
