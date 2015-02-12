package code 
package snippet

import org.rumtscho.litsuche._
import net.liftweb.util.BindHelpers._
import xml.Text

object StudyDisplayer {
	
	def showStudies = {
	  val theStudies = Study.allStudies
	  
	  "li *" #> theStudies.map {
	    s => 
	      ".id *" #> Text(s.id.toString) & 
	      ".handmadeRef *" #> Text(s.handmadeAuthorRef)
	  }
	}
}