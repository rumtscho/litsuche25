package org.rumtscho.litsuche
//package variable

import scala.collection.mutable.ListBuffer
import net.liftweb.mapper._
//import org.rumtscho.litsuche.study._

class VariableAppearance extends LongKeyedMapper[VariableAppearance] with IdPK {
	def getSingleton = VariableAppearance
	
	object authorName extends MappedString(this, 255)
	object study extends MappedLongForeignKey(this, Study)
}

object VariableAppearance extends VariableAppearance with LongKeyedMetaMapper[VariableAppearance] {

}