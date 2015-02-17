package org.rumtscho.litsuche
package study

import scala.collection.mutable.ListBuffer
import net.liftweb.mapper.{MappedString, LongKeyedMetaMapper, LongKeyedMapper, IdPK}

class Study 
  extends LongKeyedMapper[Study] with IdPK {
  def getSingleton = Study
  
  object reference extends MappedString(this, 255)
  object description extends MappedString(this, 4000)
}

object Study extends Study with LongKeyedMetaMapper[Study]{

}