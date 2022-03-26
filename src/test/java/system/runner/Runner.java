package system.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/system/resources/features",
        glue = "system/stepDefinitions",
        plugin = {"pretty"},
        tags = "@buscarProduto",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        monochrome = false
)

public class Runner {

}
