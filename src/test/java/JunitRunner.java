import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
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
@ExtendWith(TestResultLoggerExtension.class)
public class JunitRunner {


        @BeforeEach
        public void before() {

            String basicUrl = "https://www.yellowtailwine.com";
            DriverProvider.INSTANCE.getDriver();
            //  System.setProperty( Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER );
            //  driver = new ChromeDriver();
            DriverProvider.INSTANCE.getDriver().get(basicUrl);
            DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterEach
        public void after() {
            DriverProvider.INSTANCE.getDriver().quit();
    }
   public void makeScreenshot() {
        Path target = Paths.get("results/temp.png");
        File source = ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(source.toPath(),target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file was not copied");
        }}
}
