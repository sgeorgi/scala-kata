/**
 * Created by sgeorgi on 28.11.14.
 */
trait FSM {
  var state: FSMState

  def coin() = state.coin(this)

  def pass() = state.pass(this)

  def setState(s: FSMState) {
    state = s
  }

  def lock()

  def unlock()

  def thankYou()

  def alarm()
}

trait FSMState {
  def coin(fsm: FSM)

  def pass(fsm: FSM)
}

object TurnstileFSMStates {

  object LOCKED extends FSMState {
    override def coin(fsm: FSM): Unit = {
      fsm.setState(UNLOCKED)
      fsm.unlock()
    }

    override def pass(fsm: FSM): Unit = {
      fsm.alarm()
    }
  }

  object UNLOCKED extends FSMState {
    override def coin(fsm: FSM): Unit = {
      fsm.thankYou()
    }

    override def pass(fsm: FSM): Unit = {
      fsm.setState(LOCKED)
      fsm.lock()
    }
  }

}


class TurnstileFSM extends FSM {
  override var state: FSMState = _

  override def unlock(): Unit = println("Turnstile unlocked!")

  override def thankYou(): Unit = println("Thank you!")

  override def lock(): Unit = println("Turnstile locked!")

  override def alarm(): Unit = println("ALARM!!!!!!")
}
