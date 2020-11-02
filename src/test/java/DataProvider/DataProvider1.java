package DataProvider;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProvider1 {

@DataProvider (name = "data-provider", parallel = false)
public Object[][] dataProviderMethod(){
    return new Object[][]{
            {
                     "priyanandh06@gmail.com"
            },
            {
                "priyanandh061@gmail.com"
            },
            {
                    "priyanandh0612@gmail.com"
            }
    };
}

}
