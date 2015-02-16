package org.rumtscho.litsuche
package study

import scala.collection.mutable.ListBuffer
import net.liftweb.mapper.{MappedString, LongKeyedMetaMapper, LongKeyedMapper, IdPK}

//class Study private[study] (
//  val id: Int,
//  val handmadeAuthorRef: String,
//  val humanReadableDescription: String) 
class Study 
  extends LongKeyedMapper[Study] with IdPK {
  def getSingleton = Study
  
  object reference extends MappedString(this, 255)
  object description extends MappedString(this, 4000)
}

object Study extends Study with LongKeyedMetaMapper[Study]{

  private var currentId = 0

//  val seedStudies = List(
//    new Study(dispenseNextFreeId, "Brooks1975", "Tells us that throwing more programmers at a project makes it run late, not early"),
//    new Study(dispenseNextFreeId, "Dijkstra1968", "Recognizes that we need structured code"))

  private var studiesList = new ListBuffer[Study] //= seedStudies.to[ListBuffer]

  private def dispenseNextFreeId: Int = {
    currentId = currentId + 1
    return currentId
  }

  def allStudies = studiesList.toList

  def addStudy(reference: String, description: String): Unit = {
    //studiesList += new Study( reference, description)
  }
}