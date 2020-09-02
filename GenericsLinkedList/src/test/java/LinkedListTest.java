import com.linkedlist.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LinkedListTest {
    @Test
    public void checkElementIsAddedOrNot(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("2");
        String firstElement= linkedList.getFirstElement();
        Assert.assertEquals("2",firstElement);
    }
    @Test
    public void should_return_true_if_list_contains_given_element(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        Assert.assertTrue(linkedList.search("A"));
    }
    @Test
    public void should_return_false_if_list_not_contains_given_element(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("B");
        Assert.assertFalse(linkedList.search("b"));
    }
    @Test
    public void checkElementEnteredIsRemovedOrNot(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Ashwin");
        linkedList.remove("Ashwin");
        Assert.assertFalse(linkedList.search("Ashwin"));
    }
    @Test
    public void should_return_true_if_linked_list_is_Empty(){
        LinkedList<String> linkedList = new LinkedList<>();
        Assert.assertTrue(linkedList.isEmpty());
    }
    @Test
    public void should_return_size_of_the_linkedlist_if_not_empty(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        int size= linkedList.size();
        Assert.assertEquals(3,size);
    }
    @Test
    public void should_return_zero_if_list_is_Empty(){
        LinkedList<String> linkedList = new LinkedList<>();
        int empty=0;
        Assert.assertEquals(empty,linkedList.size());
    }
    @Test
    public void checkAppendElementToListSuccesfully(){
       LinkedList<String> linkedList = new LinkedList<>();
       linkedList.append("last");
       Assert.assertEquals("last", linkedList.getLastElement());
    }
    @Test
    public void should_return_index_of_the_given_element(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        int index= linkedList.index("0");
        Assert.assertEquals(0,index);
    }
    @Test
    public void checkInsertElementInTheGivenIndex() throws WrongIndexErrorException {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        int position=3;
        String data="three";
        linkedList.insert(3,data);
        String value=linkedList.getElement(position);
        Assert.assertEquals(data,value);
    }
    @Test
    public void should_throw_WrongIndexError_if_index_to_be_inserted_is_out_of_Bound(){
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            int position = 3;
            String data = "three";
            linkedList.insert(position, data);
        }catch(WrongIndexErrorException e) {
            Assert.assertEquals(WrongIndexErrorException.ExceptionType.INDEX_OUT_OF_BOUND,e.type);
        }
    }
    @Test
    public void should_throw_WrongIndexError_if_index_to_be_inserted_is_invalid(){
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            int position = -5;
            String data = "three";
            linkedList.insert(position, data);
        }catch(WrongIndexErrorException e) {
            Assert.assertEquals(WrongIndexErrorException.ExceptionType.INVALID_INDEX,e.type);
        }
    }
    @Test
    public void should_return_data_of_last_node() throws WrongIndexErrorException {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.append("last");
        Assert.assertEquals("last",linkedList.pop());
    }
   @Test
    public void should_pop_data_of_given_index() throws WrongIndexErrorException {
       LinkedList<String> linkedList = new LinkedList<>();
       linkedList.add("0");
       linkedList.add("1");
       linkedList.add("2");
       linkedList.append("last");
       linkedList.insert(1,"1");
       Assert.assertEquals("1",linkedList.pop(1));
   }
     @Test
    public void should_throw_Exception_if_index_entered_is_out_of_bound(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        linkedList.add("1");
        linkedList.add("2");
        linkedList.append("last");
        try {
            Assert.assertEquals("1",linkedList.pop(8));
        }catch (WrongIndexErrorException e){
            Assert.assertEquals(WrongIndexErrorException.ExceptionType.INDEX_OUT_OF_BOUND,e.type);
        }

    }
    @Test
    public void should_throw_Exception_if_index_entered_is_invalid(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        try {
               linkedList.pop(-1);
        }catch (WrongIndexErrorException e){
            Assert.assertEquals(WrongIndexErrorException.ExceptionType.INVALID_INDEX,e.type);
        }

    }
}
