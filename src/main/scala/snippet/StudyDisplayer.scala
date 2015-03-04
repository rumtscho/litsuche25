package code
package snippet


import net.liftweb.http._
import org.rumtscho.litsuche._
import net.liftweb.util.BindHelpers._
import xml.Text
import js.JsCmds
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
        Study.findByIdAsStringOrCreate(_),
        _.id.toString()
        ) / "editstudy" 
        
}

class StudyDisplayer(study: Study) {
  def render = "#referenceFirm *" #> study.reference
  
  def form = {
    var reference = study.reference.toString
    var description = study.description.toString

    
    def saveStudy() = {
      study.reference.set(reference)
      study.description.set(description)
      Study.cleanup(study)
      study.save

      
      
      JsCmds.Alert("Study created/edited. Reference was " + reference + " and description was " + description) &
        JsCmds.SetValById("reference", "") &
        JsCmds.SetValById("description", "")
    }

    "#reference" #> SHtml.text(reference, reference = _, "id" -> "reference") &
      "#description" #> SHtml.textarea(description, description = _, "id" -> "description")  &
      ".variableAppearance *" #> {
    	  study.variableAppearances += VariableAppearance.create
    	  (study.variableAppearances.map(va => 
        SHtml.text(va.authorName, va.authorName.set(_), "id" -> "authorName")) ++ SHtml.hidden(saveStudy))
      }
   
  }
}