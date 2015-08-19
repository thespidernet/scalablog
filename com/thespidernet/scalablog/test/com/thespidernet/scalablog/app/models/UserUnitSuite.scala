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
 * Scala Test 2.2.4 - Testing Framework
 * Play 2.3.10 - MVC Framework
 * Akka
 * Spray
 * Cassandra Database
 * Hadoop File System
 * Hadoop
 * jQuery
 * Bootstrap
 *
 * This is the User Unit Testing Object
 * It inherits from a base UNIT testing class "UnitSpec"
 * 	Which is specifically setup for Unit Testing using the FunSuite Testing Style.
 *     FunSuite is MOST like xUnit testing - with extra Scala goodies!
 *
 * ***************************************************************************
 */

package com.thespidernet.scalablog

import org.scalatest._

/**
 * Inherit from the "base" UnitSpec and Mixin the Matchers trait.
 * The Matchers trait allows for more expressive tests beyond asserts;
 *      theUser shouldBe a [models.User]
 */

class UserUnitSuite extends UnitSpec with Matchers {

	//Define All the UNIT tests you want to run for the User class.

	//Instantiate the models.User Class
	test("User Unit : Instantiate the models.Category Class, directly") {
		new models.User(
			id = 0,
			username = "gavinb",
			password = "thePassword",
			avatar = "Avatar = I am blue",
			emailAddress = "gavinb@thespidernet.com",
			twitter = "@thespidernet",
			gitHub = "https://github.com/thespidernet/scalablog",
			websiteURL = "http://thespidernet.com/scalablog",

			firstName = "Gavin",
			lastName = "Baumanis",
			displayName = "Gavin Baumanis",
			address1 = "The Spidernet",
			address2 = "",
			suburb = "Melbourne",
			state = "Victoria",
			postCode = "3000",
			country = "Australia",

			homePhone = "",
			mobilePhone = "",
			workPhone = "",

			modifiedBy = "ScalaTest") shouldBe a[models.User]
	}

	//Create a new User via the User Companion Object
	/*test("User Unit : Instantiate the models.User Class, via the Companion Object") {
        models.User.newUser(
            id = 0,
            username = "gavinb",
            password = "thePassword",
            avatar = "Avatar = I am blue",
            emailAddress = "gavinb@thespidernet.com",
            twitter = "@thespidernet",
            gitHub = "https://github.com/thespidernet/scalablog",
            websiteURL = "http://thespidernet.com/scalablog",

            firstName = "Gavin",
            lastName = "Baumanis",
            displayName = "Gavin Baumanis",
            address1 = "The Spidernet",
            address2 = "",
            suburb = "Melbourne",
            state = "Victoria",
            postCode = "3000",
            country = "Australia",

            homePhone = "",
            mobilePhone = "",
            workPhone = "",
            modifiedBy = "ScalaTest") shouldBe a[models.User]
    } */

	//Test the getUserById method
	test("User Unit: Retrieve a user by Id: Is of of type User") {
		models.User.getUserById(1) shouldBe a[models.User]
	}

	//Retrieve properties from a User object, created by the getUserById method.
	test("User Unit : Get properties from User Object, via getUserByID()") {
		val selectedUser = models.User.getUserById(1)
		assert(selectedUser.firstName == "Gavin")
	}

	//Test XXXXXXXX
	test("User Unit : Invoking head on an empty Set should produce NoSuchElementException") {
		intercept[NoSuchElementException] {
			Set.empty.head
		}
	}

	//Test XXXXXXXX
	test("User Unit : True Is True") {
		assert(true == true)
	}
}
