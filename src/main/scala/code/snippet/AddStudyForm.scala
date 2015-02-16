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

//    "#reference" #> SHtml.text(reference, reference = _, "id" -> "reference") &
//      "#description" #> (SHtml.textarea(description, description = _, "id" -> "description") ++ SHtml.hidden(process))
    
   
  }
  
  
    
//    def processWithMapper_!(){
//      Study.findAll().map(_.delete_!)
//      val studyData = ("Brooks1975", "Tells us that we cannot make a project finish sooner if we throw more programmers at it")::("Dijkstra1968", "Recongizes that we need well structured code")::Nil
//      
//      for(data <- studyData) {
//        Study.create.description(data._2).reference(data._1).save()
//      }
//    }
//  
//   def list = {
//	    processWithMapper_!() 
//	    
//	    "li *" #> Study.findAll().map {
//	      s => s.reference.get
//	    }
//    }
}