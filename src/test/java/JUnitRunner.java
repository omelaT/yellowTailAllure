import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DriverProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class JUnitRunner {


        @BeforeEach
        public void before() {

            String basicUrl = "https://www.yellowtailwine.com";
            DriverProvider.getDriver();
            //  System.setProperty( Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER );
            //  driver = new ChromeDriver();
            DriverProvider.getDriver().get(basicUrl);
            DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterEach
        public void after() {
            DriverProvider.getDriver().quit();
    }
   private void makeScreenshot() {
        Path target = Paths.get("results/temp.png");
        File source = ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(source.toPath(),target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }}
}
