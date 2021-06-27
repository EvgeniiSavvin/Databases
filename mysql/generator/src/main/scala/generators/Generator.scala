package generators

import java.sql.Timestamp
import java.time.LocalDateTime
import scala.util.Random

trait Generator {
  protected def StubId: Long = -1L;
  private def startDate: Timestamp = Timestamp.valueOf("2010-1-1 0:0:1")
  private def endDate: Timestamp = Timestamp.valueOf(LocalDateTime.now())

  protected def randomDate(): Timestamp = new Timestamp(Random.between(startDate.getTime, endDate.getTime))
  protected def randomNumber(num: Int) = Random.nextInt(num + 1)
  protected def randomElementOf[R](seq: Seq[R]): R = seq(Random.nextInt(seq.length))
  protected def someUniqueElementsFrom[R](seq: Seq[R], maxNumber: Int): Seq[R] =
    (for(_ <- 1 to maxNumber) yield randomElementOf(seq)).distinct
}
