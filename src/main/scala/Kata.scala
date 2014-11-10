/**
 * Created by sgeorgi on 31.10.14.
 */
object Kata {
  def testString: String = "test String"

  def apply(i: Int) = fizzBuzz(i)

  def fizzBuzz(i: Int) = {
    i match {
      case i if i % 15 == 0 => "fizzbuzz"
      case i if i % 5 == 0 => "buzz"
      case i if i % 3 == 0 => "fizz"
      case i => i
    }
  }
}