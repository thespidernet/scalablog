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
  * straight lines. There is no / little business logic contained within the
  * controller.
  * The application is responsible for the business logic and the appropriate
  * event handler (here in the controller).
  *
  * In contrast a "fat" controller tends to contain a lot of the business logic
  * along with the required steps.
  *
  *
  * This is the Application "General" Controller.
  * It provides the process of steps that are required based on events that
  * occur that within the application, that don't fit in a controller for
  * specific TYPE, E.g. Users controller.
  *
  * ***************************************************************************
  */

package com.thespidernet

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Utilities {

  /**
    * Format the current date and time to an Australian format
    * (with 24 hour time).
    */
  def dateTimeFormat_now(): String = {

    /**
      * The body of this function could be JUST the following single line.
      * java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
      *
      * No RETURN is required in Scala - the last value is returned
      * automatically
      *
      * But...I have expanded it to be more readable.
      */

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    val timeNow = java.time.LocalDateTime.now()
    val formattedDateTime = timeNow.format(formatter)

    return formattedDateTime
  } //dateTimeFormat_now

  /**
    * Format the current date to an Australian format
    */
  def dateFormat_now(): String = {

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateNow = java.time.LocalDate.now()
    val formattedDate = dateNow.format(formatter)

    return formattedDate
  } //dateFormat_now

  /**
    * Format the current time to 24 Hour Clock
    */
  def timeFormat_now(): String = {

    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val timeNow = java.time.LocalDateTime.now()
    val formattedTime = timeNow.format(formatter)

    return formattedTime
  } //timeFormat_now
} //class Utilities

