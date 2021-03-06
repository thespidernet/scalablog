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
  * This is the Tag Unit Testing Object
  * It inherits from a base UNIT testing class "UnitSpec"
  *   Which is specifically setup for Unit Testing using the FunSuite
  *     Testing Style.
  *     FunSuite is MOST like xUnit testing - with extra Scala goodies!
  *
  * ***************************************************************************
  */

package com.thespidernet.scalablog.models

import org.scalatest._
import com.thespidernet.UnitSpec

/**
  * Inherit from the "base" UnitSpec and Mixin the Matchers trait.
  * The Matchers trait allows for more expressive tests beyond asserts;
  *      theUser shouldBe a [models.User]
  */
class TagUnitSuite extends UnitSpec with Matchers {

  //Define All the UNIT tests you want to run for the Tag class.

  //Instantiate the models.Tag Class
  test("Tag Unit : Instantiate the ...models.Tag Class, directly") {
    val theTag = new Tag(
      id = 0,
      tag = "TagTitle",
      modifiedBy = SystemUser(1)) shouldBe a[Tag] //shouldBe tests for type equality
  }

  //Create a new Tag via the Tag Companion Object
  test("Tag Unit : Instantiate the ...models.Tag Class, via the Companion Object") {
    //No need for a "new" when creating a case class.
    Tag.newTag(
      id = 0,
      tag = "TagTitle",
      modifiedBy = SystemUser(1)) shouldBe a[Tag] //shouldBe tests for type equality
  }

  test("Tag Unit : Set Tag property with dynamic setter.") {
    var tagObj: Tag = Tag.newTag(
      id = 0,
      tag = "TagTitle",
      modifiedBy = SystemUser(1))

    /* This test is seemingly useless. It is standard Scala syntax.
     * But... since this is a tutorial as much as is it is a working application;
     * The tests can be used as a "how to", as well.
     *
     * Notice that - Scala classes have implicit setters and getters.
     * No need for a handwritten function either..
     *     No: tagObj.setid(1)
     *     Yes: tagObj.id =1
     */
    tagObj.id = 1

    assert(tagObj.id == 1)
  }

  //Test XXXXXXXX
  test("Tag Unit : ") {
    assert(Set.empty.size == 0)
  }

  //Test XXXXXXXX
  test("Tag Unit : Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }

  //Test XXXXXXXX
  test("Tag Unit : True Is True") {
    assert(true == true)
  }
}
