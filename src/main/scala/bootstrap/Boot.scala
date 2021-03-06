package bootstrap.liftweb

import net.liftweb.http.{ Html5Properties, LiftRules, Req }
import net.liftweb.sitemap._
import net.liftweb.mapper._
import net.liftweb.util._
import org.rumtscho.litsuche._
import code.snippet.StudyDisplayer

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("org.rumtscho.litsuche25")

    // Build SiteMap
        
    def sitemap(): SiteMap = SiteMap(
      Menu.i("Home") / "index",
      Menu.i("List studies") / "studies", 
      Menu(StudyDisplayer.editStudyLoc),
      Menu.i("Temporary page") / "scratchpad")
      
    LiftRules.setSiteMap(sitemap())

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    // where to search snippet
    LiftRules.addToPackages("code")
    
    //Open a database connection
    configureDB()
    
    Schemifier.schemify(
        true, 
        Schemifier.infoF _, 
        Study, 
        VariableAppearance
    )
  }

  
    def configureDB() {
    
      val standardVendor = new StandardDBVendor(
          Props.get("db.driver").openOr("org.postgresql.Driver"), 
          Props.get("db.url").openOr("jdbc:postgresql://localhost/travel"), 
          Props.get("db.user"), 
          Props.get("db.password"))
      
      
      LiftRules.unloadHooks.append(standardVendor.closeAllConnections_!_)
      DB.defineConnectionManager(net.liftweb.util.DefaultConnectionIdentifier, standardVendor)
    }
    
}