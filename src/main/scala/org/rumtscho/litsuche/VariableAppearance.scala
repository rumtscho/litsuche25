package org.rumtscho.litsuche
//package variable

import scala.collection.mutable.ListBuffer
import net.liftweb.mapper._
//import org.rumtscho.litsuche.study._

class VariableAppearance extends LongKeyedMapper[VariableAppearance] with IdPK {
	def getSingleton = VariableAppearance
	
	object authorName extends MappedString(this, 255)
	object study extends MappedLongForeignKey(this, Study)
	
	var changeAuthorNameTo = authorName.toString()
}

object VariableAppearance extends VariableAppearance with LongKeyedMetaMapper[VariableAppearance] {
	def saveUsingTempFields(variableAppearance: VariableAppearance) = {
	  variableAppearance.authorName.set(changeAuthorNameTo)
	  
	  variableAppearance.save
	}
}