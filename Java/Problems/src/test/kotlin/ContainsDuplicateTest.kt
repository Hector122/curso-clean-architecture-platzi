import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ContainsDuplicateTest {
    private val containsDuplicate = ContainsDuplicate()

   @Test
   @DisplayName("Input: nums = [1,2,3,1]")
   fun test_duplicate_true(){
       //given
       val  given = intArrayOf(1,2,3,1)
       //then
       val result = containsDuplicate.containsDuplicate(given)

       //check
       assertTrue(result)
   }




}