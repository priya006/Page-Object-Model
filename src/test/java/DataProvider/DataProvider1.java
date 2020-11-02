package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProvider1 {

@DataProvider (name = "data-provider")
public Object[][] dataProviderMethod(){
    return new Object[][]{
            {
                "priyanandh06@gmail.com"
            }
    };
}

}
