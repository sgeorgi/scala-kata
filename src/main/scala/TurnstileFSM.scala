

/**
 * Created by sgeorgi on 25.11.14.
 */
trait TurnstileFSM {
  var state: TurnstileState

  def pass() = state.pass(this)

  def coin() = state.coin(this)

  def setState(state: TurnstileState) = this.state = state

  def alarm()

  def lock()

  def unlock()

  def thankYou()
}


trait TurnstileState {
  def coin(fsm: TurnstileFSM): Unit

  def pass(fsm: TurnstileFSM): Unit
}

class CoinTurnstileFSM extends TurnstileFSM {
  override var state: TurnstileState = CoinTurnstileState.LOCKED

  override def unlock(): Unit = println("Unlock Action executed")

  override def thankYou(): Unit = println("Thank You Action executed")

  override def lock(): Unit = println("Lock Action executed")

  override def alarm(): Unit = println("Alarm Action executed")
}

object CoinTurnstileState {

  object LOCKED extends TurnstileState {
    override def coin(fsm: TurnstileFSM): Unit = {
      fsm.setState(CoinTurnstileState.UNLOCKED)
      fsm.unlock()
    }

    override def pass(fsm: TurnstileFSM): Unit = {
      fsm.alarm()
    }
  }

  object UNLOCKED extends TurnstileState {
    override def coin(fsm: TurnstileFSM): Unit = {
      fsm.thankYou()
    }

    override def pass(fsm: TurnstileFSM): Unit = {
      fsm.setState(LOCKED)
      fsm.lock()
    }
  }

}
