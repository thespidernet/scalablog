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
 * This is the Tag Class
 *
 * ***************************************************************************
 */
package models.com.thespidernet.scalablog

case class Tag(
	var id: Int,
	var tag: String,

	var sortOrder: Int = 10,
	var active: Boolean = true,

	var modifiedBy: User,
	var modifiedDateTime: java.util.Date = new java.util.Date())

/*
 * This is the Tag Companion Object.
 * It is a singleton, "Service / Manager" object.
 */
object Tag {
	def newTag(id: Int, tag: String, modifiedBy: User): Tag = {
		models.com.thespidernet.scalablog.Tag(
			id = 0,
			tag = tag,
			modifiedBy = modifiedBy)
	}
}

/*
 * The following code shows how to create Java beans from Scala.
 * It also creates (dynamically) setter and getter methods in the Java Bean style;
 *  getXXX() / setXXX()

package models.com.thespidernet.scalablog
import scala.beans.BeanProperty

case class Tag(
	@BeanProperty var id: Int,
	@BeanProperty var tag: String,

	@BeanProperty var sortOrder: Int = 10,
	@BeanProperty var active: Boolean = true,

	@BeanProperty var modifiedBy: User,
	@BeanProperty var modifiedDateTime: java.util.Date = new java.util.Date())


// This is the Tag Companion Object.
// It is a singleton, "Service / Manager" object.
object Tag {
	def newTag(id: Int, tag: String, modifiedBy: User): Tag = {
		models.Tag(
			id = 0,
			tag = tag,
			modifiedBy = modifiedBy)
	}
}
*/
