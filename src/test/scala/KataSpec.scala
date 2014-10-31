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
  }
}
