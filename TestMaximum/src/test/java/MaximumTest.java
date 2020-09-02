import com.generics.Maximum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumTest {
    Maximum maximum;
    @Test
    public void returnMaxInteger_if_largest_integer_at_begining(){
        ArrayList<Integer> elementsList=new ArrayList<Integer>(Arrays.asList(3,2,0,1));
        maximum=new Maximum(elementsList);
        Integer max= (Integer) maximum.findMaxOf();
        Assert.assertEquals(3,max.intValue());
    }
    @Test
    public void returnMaxInteger_if_largest_integer_at_middle(){
        ArrayList<Integer> elementsList=new ArrayList<Integer>(Arrays.asList(2,3,0,1));
        maximum=new Maximum(elementsList);
        Integer max= (Integer) maximum.findMaxOf();
        Assert.assertEquals(3,max.intValue());
    }
    @Test
    public void returnMaxInteger_if_largest_integer_at_end(){
        ArrayList<Integer> elementsList=new ArrayList<Integer>(Arrays.asList(2,0,1,3));
        maximum=new Maximum(elementsList);
        Integer max= (Integer) maximum.findMaxOf();
        Assert.assertEquals(3,max.intValue());
    }
    @Test
    public void returnMaxDouble_if_largest_float_at_begining(){
        ArrayList<Float> elementsList=new ArrayList<Float>(Arrays.asList(3.2f,1.0f,2.6f,0.2f));
        maximum=new Maximum(elementsList);
        Float max= (Float) maximum.findMaxOf();
        Assert.assertEquals(3.2f,max,0.0f);
    }
    @Test
    public void returnMaxDouble_if_largest_float_at_middle(){
        ArrayList<Float> elementsList=new ArrayList<Float>(Arrays.asList(1.6f,3.2f,1.0f,2.6f));
        maximum=new Maximum(elementsList);
        Float max= (Float) maximum.findMaxOf();
        Assert.assertEquals(3.2f,max,0.0f);
    }
    @Test
    public void returnMaxDouble_if_largest_float_at_end(){
        ArrayList<Float> elementsList=new ArrayList<Float>(Arrays.asList(3.2f,1.0f,2.6f,3.2f));
        maximum=new Maximum(elementsList);
        Float max= (Float) maximum.findMaxOf();
        Assert.assertEquals(3.2f,max,0.0f);
    }
    @Test
    public void returnMaxString_if_largest_String_at_begining(){
        ArrayList<String> elementsList=new ArrayList<String>(Arrays.asList("Peach","Apple","Banana","Mango"));
        maximum=new Maximum(elementsList);
        String max= (String) maximum.findMaxOf();
        Assert.assertEquals("Peach",max);
    }
    @Test
    public void returnMaxString_if_largest_String_at_middle(){
        ArrayList<String> elementsList=new ArrayList<String>(Arrays.asList("Apple","Banana","Peach","Mango"));
        maximum=new Maximum(elementsList);
        String max= (String) maximum.findMaxOf();
        Assert.assertEquals("Peach",max);
    }
    @Test
    public void returnMaxString_if_largest_String_at_end(){
        ArrayList<String> elementsList=new ArrayList<String>(Arrays.asList("Apple","Banana","Mango","Peach"));
        maximum=new Maximum(elementsList);
        String max= (String) maximum.findMaxOf();
        Assert.assertEquals("Peach",max);
    }
}
