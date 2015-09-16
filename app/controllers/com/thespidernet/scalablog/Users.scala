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
 * Scala 2.11.6
 * Scala Test 2.2.5 - Testing Framework
 * Play 2.4.3 - MVC Framework
 * Akka 2.3.9 - Messaging
 * spray 2.3.3 - http
 * Cassandra Database 2.1.8
 * Hadoop / Hadoop File System 2.7.1
 * jQuery 2.1.4 - JavaScript Library
 * Bootstrap 3.3.4 - JavaScript Library
 *
 * A controller can come in two flavours. Thin and fat.
 *
 * This is a "thin" Controller. It only contains the steps required in clean straight lines.
 * there is no / little business logic contained within the controller.
 * The application is responsible for the business logic and the appropriate event handler (here in the controller).
 *
 * In contrast a "fat" controller tends to contain a lot of the business logic along with the required steps.
 *
 *
 * This is the Users Controller.
 * It provides the process of steps that are required based on "User" events that occur that within the application.
 *
 * ***************************************************************************
 */

package controllers

import play.api._
import play.api.mvc._
import java.util.Date._
import models.com.thespidernet.scalablog.SystemUser
import models.com.thespidernet.scalablog.NormalUser

object Users extends Controller {

	//User Search page Action.
	def usersearch = Action {
		// Show the usersearch view page.
		// NO parameters are passed into this view.
		Ok(views.html.usersearch())
	}

	// Individual User Administration main page
	def userconfig(userid: String) = Action {
		// FIXME : Ensure that we use the ID from the User.
		val selectedUser: NormalUser = NormalUser(id = 1,
      username = "GavinB",
      password = "True",
      avatar = "AVATAR - BLUE Dudes",
      emailAddress = "gavinb@thespidernet.com",
      twitter = "@thespidernet",
      gitHub = "thespidernet",
      websiteURL = "http://www.thespidernet.com",

      firstName = "Gavin",
      lastName = "Baumanis",
      displayName = "Beau",
      address1 = "The Spidernet",
      address2 = "",
      suburb = "Melbourne",
      state = "Victoria",
      postCode = "3000",
      country = "Australia",

      homePhone = "555-555-5555",
      mobilePhone = "555-666-6666",
      workPhone = "1234-1234-1243",

      active = true,
      
      modifiedBy = new models.com.thespidernet.scalablog.SystemUser(id=1),
      modifiedDateTime = new java.util.Date()) 

		// Display the EDIT USER form, passing into the view the "selected" user object,
		// 	with their filled-in properties.
		Ok(views.html.userconfig(selectedUser))
	}

	//Save the contents of a User Record
	def userconfigsubmit = Action {
		//TODO: verify the contents of the form are valid
		//TODO: save the form

		//Return the SYS config Menu
		Ok(views.html.sysconfig())
	}

}
