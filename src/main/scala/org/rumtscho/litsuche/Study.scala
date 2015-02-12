package org.rumtscho.litsuche

class Study(val id: Int = -1, 
    val handmadeAuthorRef: String = "empty") 
{

}

object Study {
  val allStudies = List(
		  new Study(1, "Brooks1975"), 
		  new Study(2, "Dijkstra1968")
      )
}