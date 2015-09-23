package models

import play.api.libs.json._

case class AppConfig(blogtitle: String, blogtagline: String, blogtitleimage: String, blogurl: String)

object AppConfig {
  
  implicit val AppConfigFormat = Json.format[AppConfig]
}