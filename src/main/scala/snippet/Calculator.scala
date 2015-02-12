package code 
package snippet

import net.liftweb.util.BindHelpers._
import net.liftweb.util._
import net.liftweb.common._


object Calculator {
	def plus = "#result *" #> (2+2)
}