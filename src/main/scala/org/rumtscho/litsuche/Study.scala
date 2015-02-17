package org.rumtscho.litsuche
//package study

import scala.collection.mutable.ListBuffer
import net.liftweb.mapper._

class Study 
  extends LongKeyedMapper[Study] 
  with IdPK
  with OneToMany[Long, Study]
{
  def getSingleton = Study
  
  object reference extends MappedString(this, 255)
  object description extends MappedString(this, 4000)
  
  object variableAppearances extends MappedOneToMany(VariableAppearance, VariableAppearance.study, OrderBy(VariableAppearance.id, Ascending)) with Owned[VariableAppearance] with Cascade[VariableAppearance]
}

object Study extends Study with LongKeyedMetaMapper[Study]{

}