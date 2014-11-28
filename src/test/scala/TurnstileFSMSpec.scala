import org.scalatest.{BeforeAndAfter, FunSpec}

/**
 * Created by sgeorgi on 28.11.14.
 */
class TurnstileFSMSpec extends FunSpec with BeforeAndAfter {

  class TestTurnstileFSM extends FSM {
    override var state: FSMState = TurnstileFSMStates.LOCKED

    override def unlock(): Unit = actions += "U"

    override def thankYou(): Unit = actions += "T"

    override def lock(): Unit = actions += "L"

    override def alarm(): Unit = actions += "A"

    var actions: String = ""
  }


  describe("The TurnstileFSM") {
    it("operates normally") {
      val testFSM = new TestTurnstileFSM
      testFSM.coin()
      testFSM.pass()
      assert(testFSM.actions == "UL")
    }

    it("is friendly") {
      val testFSM = new TestTurnstileFSM
      testFSM.coin()
      testFSM.coin()
      testFSM.pass()
      assert(testFSM.actions == "UTL")
    }

    it("is wary") {
      val testFSM = new TestTurnstileFSM
      testFSM.pass()
      assert(testFSM.actions == "A")
    }

    it("can operate through a complex sequence") {
      val testFSM = new TestTurnstileFSM
      testFSM.coin()
      testFSM.pass()
      testFSM.coin()
      testFSM.coin()
      testFSM.pass()
      testFSM.pass()
      assert(testFSM.actions == "ULUTLA")
    }
   }

}
