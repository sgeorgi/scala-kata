import org.scalatest.{BeforeAndAfter, FunSpec}

/**
 * Created by sgeorgi on 25.11.14.
 */
class CoinTurnstileFSMSpec extends FunSpec with BeforeAndAfter {

  class TestTurnstileFSM extends TurnstileFSM {
    override var state: TurnstileState = CoinTurnstileState.LOCKED

    override def unlock(): Unit = {
      actions += "U"
    }

    override def thankYou(): Unit = {
      actions += "T"
    }

    override def lock(): Unit = {
      actions += "L"
    }

    override def alarm(): Unit = {
      actions += "A"
    }

    def assertActions(expected: String) = assert(actions == expected)

    private var actions: String = ""

  }

  var fsm: TestTurnstileFSM = _

  before { fsm = new TestTurnstileFSM }

  it("is in the LOCKED state upon initialize") {
    val fsm = new TestTurnstileFSM
    assert(fsm.state == CoinTurnstileState.LOCKED)
  }

  describe("Actions") {
    it("Operates normally") {
      fsm.coin()
      fsm.assertActions("U")
      fsm.pass()
      fsm.assertActions("UL")
    }

    it("Calls thankYou() after given an additional coin") {
      fsm.coin()
      fsm.assertActions("U")
      fsm.coin()
      fsm.assertActions("UT")
    }
  }
}
