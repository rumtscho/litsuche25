package code
package snippet

import org.rumtscho.litsuche.study._
import net.liftweb.util.BindHelpers._
import xml.Text

object StudyDisplayer {

  def showStudies = {
    val theStudies = Study.allStudies

    "li *" #> theStudies.map {
      s =>
//        ".id *" #> Text(s.id.toString) &
//          ".handmadeRef *" #> Text(s.handmadeAuthorRef) &
//          ".description *" #> Text(s.humanReadableDescription)
        ".id *" #> Text("no more IDs") &
        ".handmadeRef *" #> Text(s.reference) & 
        ".description *" #> Text(s.description)
    }
  }
}