package code.snippet

import net.liftweb.http._
import org.rumtscho.litsuche.study._
import net.liftweb._
import http._
import util.BindHelpers._
import js.JsCmds

import net.liftweb.http.SHtml.{ text, ajaxSubmit }

class AddStudyForm {

  def form = {
    var reference = ""
    var description = ""

    def process() = {
      Study.addStudy(reference, description)

      JsCmds.Alert("Study created. Reference was " + reference + " and description was " + description) &
        JsCmds.SetValById("reference", "") &
        JsCmds.SetValById("description", "")
    }

    "#reference" #> SHtml.text(reference, reference = _, "id" -> "reference") &
      "#description" #> (SHtml.textarea(description, description = _, "id" -> "description") ++ SHtml.hidden(process))
  }
}