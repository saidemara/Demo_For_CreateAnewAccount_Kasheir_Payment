package Source;

import java.util.ArrayList;
import java.util.List;

public class ClassImplement implements RestInterFace {


    RestInterFace RestInterFace;

    public RestInterFace print() {

        System.out.println("test");
        return RestInterFace;
    }

    public String PrintTwo() {
        String Test = "";
        return  Test;
    }

    public String GEtSecondIinterFace() {
        return null;
    }

    public List<String> GetListValues() {
        List<String> ListValues= new ArrayList<>();
        return  ListValues;
    }
}
