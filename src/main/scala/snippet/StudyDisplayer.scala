package code
package snippet

import org.rumtscho.litsuche._
import net.liftweb.util.BindHelpers._
import xml.Text

import net.liftweb.sitemap._

object StudyDisplayer {

  def showStudies = {
    val theStudies = Study.findAll

    "li *" #> theStudies.map {
      s =>
        ".id *" #> Text(s.id.toString) &
        ".handmadeRef *" #> Text(s.reference) & 
        ".description *" #> Text(s.description) & 
        ".editStudyButton" #> <button class="editStudyButton" onclick={"location.href='" + editStudyLoc.calcHref(s) + "'"}>edit</button>
    }
  }
  
  
    val editStudyLoc = Menu.param[Study](
        "editstudy", 
        "editstudy", 
        Study.findByIdAsString(_),
        _.id.toString()
        ) / "editstudy" 
        
}

class StudyDisplayer(study: Study) {
  def render = "#reference *" #> study.reference
}