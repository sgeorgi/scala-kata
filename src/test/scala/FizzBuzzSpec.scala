import org.scalatest.FunSpec

/**
 * Created by sgeorgi on 31.10.14.
 */
class FizzBuzzSpec extends FunSpec {
  describe("FizzBuzz") {
    it("returns a given number unless dividable by 3, 5, or 15") {
      assert(FizzBuzz(1) == 1)
      assert(FizzBuzz(2) == 2)
      assert(FizzBuzz(4) == 4)
    }

    it("returns 'fizz' for given number dividable by 3") {
      assert(FizzBuzz(3) == "fizz")
      assert(FizzBuzz(6) == "fizz")
      assert(FizzBuzz(12) == "fizz")
    }

    it("returns 'buzz' for given number dividable by 5") {
      assert(FizzBuzz(5) == "buzz")
      assert(FizzBuzz(10) == "buzz")
      assert(FizzBuzz(20) == "buzz")
      assert(FizzBuzz(25) == "buzz")
    }

    it("returns 'fizzbuzz' for given number dividable by 15") {
      assert(FizzBuzz(15) == "fizzbuzz")
      assert(FizzBuzz(30) == "fizzbuzz")
    }
  }

}
