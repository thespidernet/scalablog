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
 *
 * This is the Category Unit Testing Object
 * It inherits from a base UNIT testing class "UnitSpec"
 * 	Which is specifically setup for Unit Testing using the FunSuite Testing Style.
 *     FunSuite is MOST like xUnit testing - with extra Scala goodies!
 *
 * ***************************************************************************
 */

package com.thespidernet.scalablog.models

import org.scalatest._

/**
 * Inherit from the "base" UnitSpec and Mixin the Matchers trait.
 * The Matchers trait allows for more expressive tests beyond asserts;
 *      theUser shouldBe a [models.SystemUser]
 */
class CategoryUnitSuite extends UnitSpec with Matchers {

	//Define All the UNIT tests you want to run for the Category class.

	//Instantiate the models.Category Class
	test("Category Unit : Instantiate the ...models.Category Class, directly") {
		//No need for a "new" when creating a case class.
    val theCat = Category(
			id = 0,
			category = "Test Categpry",
			modifiedBy = SystemUser(1)) shouldBe a[Category] //shouldBe tests for type equality
	}

  
	//Create a new Category via the Category Companion Object
	test("Category Unit : Instantiate the ...models.Category Class, via the Companion Object") {
		//No need for a "new" when creating a case class.
    Category.newCategory(
			id = 0,
			category = "Test Category",
			modifiedBy = SystemUser(1)) shouldBe a[Category] //shouldBe tests for type equality
	}

  
	//Test XXXXXXXX
	test("Category Unit : True Is True") {
		assert(true == true)
	}
}
