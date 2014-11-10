import org.scalatest.FunSpec

/**
 * Created by sgeorgi on 31.10.14.
 */
class KataSpec extends FunSpec {
  describe("Kata Object") {
    describe(".testString") {
      it("returns the test String") {
        assert(Kata.testString == "test String")
      }
    }

    describe("fizzBuzz") {
      it("returns a number unless dividable by 3, 5 or 15") {
        assert(Kata.fizzBuzz(1) == 1)
        assert(Kata.fizzBuzz(2) == 2)
        assert(Kata.fizzBuzz(4) == 4)
        assert(Kata.fizzBuzz(7) == 7)
        assert(Kata.fizzBuzz(8) == 8)
      }

      it("returns fizz when diviable by 3") {
        assert(Kata.fizzBuzz(3) == "fizz")
        assert(Kata.fizzBuzz(6) == "fizz")
        assert(Kata.fizzBuzz(9) == "fizz")
        assert(Kata.fizzBuzz(12) == "fizz")
      }

      it("returns buzz when diviable by 5") {
        assert(Kata.fizzBuzz(5) == "buzz")
        assert(Kata.fizzBuzz(10) == "buzz")
        assert(Kata.fizzBuzz(20) == "buzz")
      }

      it("returns fizzbuzz when dividable by 15") {
        assert(Kata.fizzBuzz(15) == "fizzbuzz")
        assert(Kata.fizzBuzz(30) == "fizzbuzz")
      }
    }
  }
}
