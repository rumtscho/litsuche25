package bootstrap.liftweb

import net.liftweb.http.{ Html5Properties, LiftRules, Req }
import net.liftweb.sitemap.{ Menu, SiteMap }
import net.liftweb.mapper._
import net.liftweb.util._
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
      Menu.i("List studies") / "studies")

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    // where to search snippet
    LiftRules.addToPackages("code")
  }

    def configureDB() {
      for {
        driver <- Props.get("db.driver")
        url <- Props.get("db.url")
      }
      yield 
      {
      	val standardVendor = new StandardDbVendor(driver, url, Props.get("db.user"), Props.get("db.password"))
      }
      
      LiftRules.unloadHooks.append(standardVendor.closeAllConnections_!_)
      DB.defineConnectionManager(DefaultConnectionIdentifier, standardVendor)
    }
    
}