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
  * This is the User Class.
  *
  * ***************************************************************************
  */

package models

case class User(
	var id: Int,
	var username: String,
	var password: String,
	var avatar: String,
	var emailAddress: String,
	var twitter: String,
	var gitHub: String,
	var websiteURL: String,

	var firstName: String,
	var lastName: String,
	var displayName: String,
	var address1: String,
	var address2: String,
	var suburb: String,
	var city: String,
	var state: String,
	var postCode: String,
	var country: String,

	var homePhone: String,
	var mobilePhone: String,
	var workPhone: String,

	var active: Boolean = true,
	var modifiedBy: String,
	var modifiedDateTime: java.util.Date = new java.util.Date()) //User case class

object User {
	def getUserById(id: Integer) = {

		// FIXME: Synthetically produce a User Object while testing
		this(id = 1,
			username = "GavinB",
			password = "True",
			avatar = "AVATAR - BLUE Dudes",
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

			homePhone = "555-555-5555",
			mobilePhone = "555-666-6666",
			workPhone = "1234-1234-1243",

			active = true,
			modifiedBy = "Gavin Baumanis",
			modifiedDateTime = new java.util.Date()
		) //theUser
		// There is no need for a RETURN in Scala if there is only one expression.
		// The last value is what is returned
	} // getUserById

	def getFullnameById(id: Integer) = {
		this.getUserById(id).firstName + ' ' + this.getUserById(id).lastName
	} //getFullnameById
}
