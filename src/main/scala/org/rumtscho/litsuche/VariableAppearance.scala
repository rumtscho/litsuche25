package org.rumtscho.litsuche
package variable

import scala.collection.mutable.ListBuffer

class VariableAppearance(
    val varId: Int, 
    val varName: String,
    val studyId: Int
    )
{

}

object VariableAppearance {
  private var variablesAppearancesList = new ListBuffer[VariableAppearance]
   private var currentId = 0
   
   
   private def dispenseNextFreeId: Int = {
    currentId = currentId + 1
    return currentId
  }
  
  def allVariableAppearances = variablesAppearancesList.toList
  
  def addVariableAppearance(name: String, studyId: Int) = {
    variablesAppearancesList += new VariableAppearance(dispenseNextFreeId, name, studyId)
  }
}