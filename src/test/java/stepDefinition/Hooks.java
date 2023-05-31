package stepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import rootClass.Rootclass;
public class Hooks {

    @Before
    public void setup() {
        Rootclass.faker = new Faker();
    }

}
