package code.snippet

import net.liftweb.http._
import org.rumtscho.litsuche.study._

class AddStudyForm extends LiftScreen {
  
  val reference = field("Reference", "", "placeholder" -> "Format: LastnameYYYY")
  val description = field("Description", "", "placeholder" -> "A human readable description of the paper")
  
  protected def finish() {
    S.notice("form submitted")
    Study.addStudy(reference, description)
  }

}