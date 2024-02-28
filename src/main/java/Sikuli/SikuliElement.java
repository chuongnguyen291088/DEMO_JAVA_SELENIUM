package Sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

public class SikuliElement {
    private final String imagePath;

    public SikuliElement(String imagePath) {
        this.imagePath = imagePath;
    }

    public void click() {
        try {
            Screen s = new Screen();
            Pattern element = new Pattern(imagePath);
            Match match = s.find(element);
            System.out.println("Sikuli: " + match.isObserving());
            match.click();
        } catch (FindFailed e) {
            Assert.fail("No match image found ...");
        }
    }
}
