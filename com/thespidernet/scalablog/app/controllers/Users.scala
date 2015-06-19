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
  * Scala 2.11.3     
  * Scala Test 2.2.4 - Testing Framework
  * Play 2.3.8 - MVC Framework
  * Akka
  * Spray
  * Cassandra Database
  * Hadoop File System
  * Hadoop
  *
  * This is the Users Controller.
  * It contains all Controller actions for Users.
  *
  * ***************************************************************************
  */

package controllers

import play.api._
import play.api.mvc._
import java.util.Date._

object Users extends Controller {

	//User Search page Action.
	def usersearch = Action {
		// Show the usersearch view page.
		// NO parameters are passed into this view.
		Ok(views.html.usersearch())
	}

	// Individual User Administration main page
	def userconfig(userid: String) = Action {
		var selectedUser = models.User(id = 1,
			username = "GavinB",
			active = true,
			password = "myPassword",
			emailAddress = "gavinb@thespidernet.com",
			twitter = "@thespidernet",
			gitHub = "thespidernet",
			websiteURL = "www.thespidernet.com",

			firstName = "Gavin",
			lastName = "Baumanis",
			displayName = "Beau",
			address1 = "The Spidernet",
			address2 = "",
			suburb = "",
			city = "Melbourne",
			state = "Victoria",
			postCode = "3000",
			country = "Australia",

			phone = "555-555-5555",
			mobilePhone = "555-666-6666",
			pager = "123-123-1234",

			modifiedBy =  models.UserService.getFullnameById(1),
			modifiedDateTime = new java.util.Date()
		);
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
