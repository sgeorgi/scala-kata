/**
 * Created by sgeorgi on 31.10.14.
 */
object FizzBuzz {

  def run(number: Int) = {
    number match {
      case _ if number % 15 == 0 => "fizzbuzz"
      case _ if number % 5 == 0 => "buzz"
      case _ if number % 3 == 0 => "fizz"
      case n: Int => n
    }

  }

  def apply(number: Int) = run(number)
}
