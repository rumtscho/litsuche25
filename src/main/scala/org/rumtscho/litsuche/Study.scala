package org.rumtscho.litsuche
package study

import scala.collection.mutable.ListBuffer

class Study private[study](
    val id: Int,
    val handmadeAuthorRef: String,  
    val humanReadableDescription: String ) 
{
}

object Study {
  
  private var currentId = 0
  
  val seedStudies = List(
		  new Study(dispenseNextFreeId, "Brooks1975", "Tells us that throwing more programmers at a project makes it run late, not early"), 
		  new Study(dispenseNextFreeId, "Dijkstra1968", "Recognizes that we need structured code")
      )
      
   private var studiesList = seedStudies.to[ListBuffer]
   
   
   private def dispenseNextFreeId: Int = {
    currentId = currentId + 1
    return currentId
  }
   
   def allStudies = studiesList.toList
   
   def addStudy(reference: String, description: String): Unit = {
     studiesList += new Study(dispenseNextFreeId, reference, description)
  }
}