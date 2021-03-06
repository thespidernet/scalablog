/**
  * ***************************************************************************
  * ScalaBlog.
  * Copyright 2014-2015 Gavin Baumanis
  * gavinb@thespidernet.com
  * http://www.thespidernet.com/scalablog
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  *
  *
  * The ScalaBlog is a fully functioning Blog.
  * It was originally written as a training tool for Scala and the TypeSafe
  * technology stack; http://typesafe.com/products/typesafe-reactive-platform
  *
  * It is subsequently written with verbose comments and with readability
  * always in focus. Thus we have not always used the most concise / terse
  * code that we could have. Which is a real strength of Scala.
  *
  * The ScalaBlog also became the training ground for our efforts to
  * better understand "BIG DATA". Subsequently it uses Hadoop and some related
  * technologies that simply just aren't a requirement for a blog application.
  * Nonetheless - they are used here!
  *
  * The ScalaBlog application is free to use.
  *
  *
  * The blog utilises the following technology;
  *
  * Scala 2.11.7
  * Scala Test 3.0.0 - Testing Framework
  * Play 2.4.3 - MVC Framework
  * Akka 2.4.0 - Messaging
  * spray 2.3.3 - http
  * Cassandra Database 2.1.8
  * Hadoop / Hadoop File System 2.7.1
  * jQuery 2.1.4 - JavaScript Library
  * Bootstrap 3.3.4 - JavaScript Library
  *
  * A controller can come in two flavours. Thin and fat.
  *
  * This is a "thin" Controller. it only contains the steps required in clean
  * straight lines. there is no / little business logic contained within the
  * controller.
  *
  * The application is responsible for the business logic and the appropriate
  * event handler (here in the controller).
  *
  * In contrast a "fat" controller tends to contain a lot of the business logic
  * along with the required steps.
  *
  * This is the Application "General" Controller.
  * It provides the process of steps that are required based on events that
  * occur that within the application, that don't fit in a controller for
  * specific TYPE, E.g. Users controller.
  *
  * ***************************************************************************
  */

package com.thespidernet.scalablog.controllers

import play.api._
import play.api.mvc._
import java.util.Date._
import play.api.i18n._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.libs.json.Json

import scala.concurrent.{ ExecutionContext, Future }
import javax.inject._

import com.thespidernet.scalablog.models.SystemUser
import com.thespidernet.Utilities

class Application @Inject() (val messagesApi: MessagesApi)(implicit ec: ExecutionContext) extends Controller with I18nSupport {

  // Default / Home Page
  def index = Action {
    Ok(com.thespidernet.scalablog.views.html.index())
  } //End index

  // System Administration menu
  def sysconfig = Action {

    Ok(com.thespidernet.scalablog.views.html.sysconfig())
  } //End sysconfig

  //Application Configuration Actions
  // Configure THIS installation of the ScalaBlog application
  def appconfig = Action {

    /**
      * The Forms object defines the mapping method. This method takes the names
      * and constraints of the form, and also takes two functions: an apply
      * functioncand an unapply function.
      *
      * Normally we would also create a "full name" from the first and last
      * name. But we have left them separated here - to show how to used Nested
      * values in Play forms.
      */

    val AppConfigForm: Form[CreateAppConfigForm] = Form {
      mapping(
        "blogtitle" -> nonEmptyText,
        "blogtagline" -> nonEmptyText,
        "blogtitleimage" -> text,
        "blogurl" -> text,
        "modifiedBy" -> mapping(
          "userName" -> text,
          "firstName" -> text,
          "lastName" -> text
        )(ModifiedByForm.apply)(ModifiedByForm.unapply)
      )(CreateAppConfigForm.apply)(CreateAppConfigForm.unapply)
    } //End AppConfigForm

    /**
      * Get the current values stored in the database to display in the view via
      * the above mapping.
      */

    /**
      * TODO: get data from data source Then replace handwritten values with
      * those retrieved
      */

    val AppConfigData = AppConfigForm.fill(CreateAppConfigForm("BlogTitle1",
      "BlogTagLine1",
      "BlogTitleImage1",
      "BlogUrl1",
      ModifiedByForm("GavinB",
        "Gavin",
        "Baumanis")))

    /**
      * This is temporary for us to create a NOW timestamp to show in the
      * prototype. When we start retrieving real data this will go away.
      */
    val utilities = new com.thespidernet.Utilities()
    val theDateTime = utilities.dateTimeFormat_now

    // Display the HTML form for THIS Application's System Configuration
    Ok(com.thespidernet.scalablog.views.html.appconfig(AppConfigData, theDateTime.toString))
  } //End appconfig

  //SAVE the contents of the AppConfig Form.
  def appconfigsubmit = Action {
    //TODO: verify the contents of the form are valid
    //TODO: save the form

    //Return the SYS config Menu
    Ok(com.thespidernet.scalablog.views.html.sysconfig())
  } //End appconfigsubmit
} //End Application controller class

/**
  * Case classes
  *
  * The following case classes are used "here" within the controller only.
  * It is quite often the case that the model representation and that which is
  * needed within a view are different.
  *
  * So we can use the controller as an appropriate place to hold this
  * interfacing code.
  */

case class ModifiedByForm(userName: String, firstName: String, lastName: String)
case class CreateAppConfigForm(blogtitle: String, blogtagline: String, blogtitleimage: String, blogurl: String, modifiedBy: ModifiedByForm)
