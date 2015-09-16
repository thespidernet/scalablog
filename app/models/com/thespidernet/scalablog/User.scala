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
 * This is the User Class.
 *
 * There is an issue with modelling our Users.
 * if you have a recursive property, how can you possible create a User?
 *
 * The modifiedBy property is a User object.
 * So you load up the properties for THIS user.
 * get to the modifiedBy property and have to load another User.
 * The ModifiedBy User ALSO has a modifiedBy property that is a User.
 * So now you have to load another User, that has a modifiedBy property.
 *
 * In and of itself it isn't a big problem - but for - what happens when you get to the very first user?
 * It doesn't have a value for the modifiedBy property.
 *
 * There are two options.
 * Have the first User created by None or have the first User created by itself.
 *
 * I'd actually recommend the second case, and I'd recommend modelling the modifiedBy as a function for lazy
 * evaluation rather than a property that is evaluated at construction time.
 *
 * To accomplish this we will use a TRAIT.
 *
 * A trait is a Scala costruct that is much like a Java interface.
 * But in Scala - a trait can be partially completed and provide default implementations of some methods
 * to the classes that extend it.
 *
 * ***************************************************************************
 */

package models.com.thespidernet.scalablog

trait User {
	def id: Int
	def modifiedBy: User
}

case class SystemUser(id: Int,
		username: String = "ScalaBlog System",
		password: String = "",
		avatar: String = "",
		emailAddress: String = "gavinb@thespidernet.com",
		twitter: String = "@thespidernet",
		gitHub: String = "thespidernet",
		websiteURL: String = "http://www.thespidernet.com",

		firstName: String = "ScalaBlog",
		lastName: String = "System",
		displayName: String = "ScalaBlog System",
		address1: String = "The Spidernet",
		address2: String = "",
		suburb: String = "Melbourne",
		state: String = "Victoria",
		postCode: String = "3000",
		country: String = "Australia",

		homePhone: String = "",
		mobilePhone: String = "",
		workPhone: String = "",

		active: Boolean = true,

		modifiedDateTime: java.util.Date = new java.util.Date()) extends User { //Mixin the User trait
    def modifiedBy = this
}

case class NormalUser(id: Int,
	username: String,
	password: String,
	avatar: String,
	emailAddress: String,
	twitter: String,
	gitHub: String,
	websiteURL: String,

	firstName: String,
	lastName: String,
	displayName: String,
	address1: String,
	address2: String,
	suburb: String,
	state: String,
	postCode: String,
	country: String,

	homePhone: String,
	mobilePhone: String,
	workPhone: String,

	active: Boolean = true,

	modifiedBy: User,
	modifiedDateTime: java.util.Date = new java.util.Date()) extends User // Mixin the User trait

//Singleton / Companion Object for the System Account
object SystemUser {

}

//Singleton / Companion Object for NormaL Users - real people!
object NormalUser {

}

/*
case class User(
	id: Int,
	username: String,
	password: String,
	avatar: String,
	emailAddress: String,
	twitter: String,
	gitHub: String,
	websiteURL: String,

	firstName: String,
	lastName: String,
	displayName: String,
	address1: String,
	address2: String,
	suburb: String,
	state: String,
	postCode: String,
	country: String,

	homePhone: String,
	mobilePhone: String,
	workPhone: String,

	active: Boolean = true,

	modifiedBy: Option[User],
	modifiedDateTime: java.util.Date = new java.util.Date()) //User case class



	def getUserById(id: Integer): User = {

		// FIXME: Synthetically produce a User Object while testing
		this(id = 1,
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
			//modifiedBy =
			modifiedDateTime = new java.util.Date()) //theUser
		// There is no need for a RETURN in Scala if there is only one expression.
		// The last value is what is returned
	} // getUserById
*/
