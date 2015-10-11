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
  * Scala Test 2.2.5 - Testing Framework
  * Play 2.4.3 - MVC Framework
  * Akka 2.3.14 - Messaging
  * spray 2.3.3 - http
  * Cassandra Database 2.1.8
  * Hadoop / Hadoop File System 2.7.1
  * jQuery 2.1.4 - JavaScript Library
  * Bootstrap 3.3.4 - JavaScript Library
  * A controller can come in two flavours. Thin and fat.
  *
  * This is a "thin" Controller. It only contains the steps required in clean
  * straight lines. There is no / little business logic contained within the
  * controller.
  *
  * The application is responsible for the business logic and the appropriate
  * event handler (here in the controller).
  *
  * In contrast a "fat" controller tends to contain a lot of the business logic
  * along with the required steps.
  *
  * This is the Users Controller.
  * It provides the process of steps that are required based on "User" events
  * that occur that within the application.
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
import com.thespidernet.scalablog.models.NormalUser

import com.thespidernet.Utilities

class User @Inject() (val messagesApi: MessagesApi)(implicit ec: ExecutionContext) extends Controller with I18nSupport {

  //User Search page Action.
  def usersearch = Action {
    // Show the usersearch view page.
    // NO parameters are passed into this view.
    Ok(com.thespidernet.scalablog.views.html.usersearch())
  }

  def userconfig(userid: String) = Action {
    // FIXME : Ensure that we use the ID from the User.
    // Individual User Administration main page
    /**
      * The Forms object defines the mapping method. This method takes the names
      * and constraints of the form, and also takes two functions: an apply
      * function and an unapply function.
      *
      * Normally we would also create a "full name" from the first and last
      * name. But we have left them separated here - to show how to used Nested
      * values in Play forms.
      */

    val UserConfigForm: Form[CreateUserConfigForm] = Form {
      mapping(
        "userName" -> nonEmptyText,
        "password" -> nonEmptyText,
        "avatar" -> text,
        "emailAddress" -> nonEmptyText,
        "twitter" -> text,
        "gitHub" -> text,
        "websiteURL" -> text,

        "firstName" -> nonEmptyText,
        "lastName" -> nonEmptyText,
        "displayName" -> nonEmptyText,
        "address1" -> text,
        "address2" -> text,
        "suburb" -> text,
        "state" -> text,
        "postCode" -> text,
        "country" -> text,

        "homePhone" -> text,
        "mobilePhone" -> text,
        "workPhone" -> text,

        "active" -> boolean,

        "modifiedBy" -> mapping(
          "userName" -> text,
          "firstName" -> text,
          "lastName" -> text
        )(ModifiedByForm.apply)(ModifiedByForm.unapply)
      )(CreateUserConfigForm.apply)(CreateUserConfigForm.unapply)
    } //End AppConfigForm

    /**
      * Get the current values stored in the database to display in the view via
      * the above mapping.
      */

    /**
      * TODO: get data from data source Then replace handwritten values with
      * those retrieved
      */
    val UserConfigData = UserConfigForm.fill(CreateUserConfigForm("GavinB",
      "True",
      "AVATAR - BLUE Dudes",
      "gavinb@thespidernet.com",
      "@thespidernet",
      "thespidernet",
      "http://www.thespidernet.com",

      "Gavin",
      "Baumanis",
      "Beau",
      "The Spidernet",
      "",
      "Melbourne",
      "Victoria",
      "3000",
      "Australia",

      "555-555-5555",
      "555-666-6666",
      "1234-1234-1243",

      true,

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
    Ok(com.thespidernet.scalablog.views.html.userconfig(UserConfigData, theDateTime.toString))
  }

  //Save the contents of a User Record
  def userconfigsubmit = Action {
    //TODO: verify the contents of the form are valid
    //TODO: save the form

    //Return the SYS config Menu
    Ok(com.thespidernet.scalablog.views.html.sysconfig())
  }

}

/**
  * Case classes
  *
  * The following case classes are used "here" within the controller only.
  * It is quite often the case that the model representation and that which is
  * needed within a view are different.
  * So we can use the controller as an appropriate place to hold this
  * interfacing code.
  */

case class CreateUserConfigForm(userName: String, password: String, avatar: String, emailAddress: String, twitter: String, gitHub: String, websiteURL: String,
                                firstName: String, lastName: String, displayName: String, address1: String, address2: String, suburb: String, state: String, postCode: String, country: String,
                                homePhone: String, mobilePhone: String, workPhone: String,
                                active: Boolean,
                                modifiedBy: ModifiedByForm)
