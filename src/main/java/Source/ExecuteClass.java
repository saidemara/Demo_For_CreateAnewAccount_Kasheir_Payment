package Source;

import java.util.List;

public class ExecuteClass {
    public static void main (String[] argu)
    {
        RestInterFace test= new ClassImplement();
        test.print();
       List<String>  Values =  test.GetListValues();
    }
}
