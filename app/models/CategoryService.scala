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
  * Play 2.3.8 - MVC Framework
  * Akka
  * Spray
  * Cassandra Database
  * Hadoop File System
  * Hadoop
  *
  * This is the CategoryService Object (Singleton)
  *
  * It is the "Factory" for the Category class and;
  *
  * It is used as the API for the application to code "to".
  * It will then speak natively to the Data Access Objects (DAO).
  *
  * This gives a consistent API for the code in the application to be
  *     written against.
  *
  * Your application code (E.g. Category class) shouldn't know or care about caching. it just needs
  * to ask for data / save data changes etc.
  *
  * And the actual task of retrieving the data from and writing the data to persistent storage
  * (hard disk) is the domain of the "Gateway" objects or Data Access Objects (DAOs)
  *
  * From a process flow perspective the Service classes sit between these two end-points.
  * This makes them the perfect the place to include (for example) code that relates to Caching.
  *
  * Or code that does mapping between consistent API and the DAOs.
  * E.g. you might need to alter data types before they go into the DB.
  *
  * ***************************************************************************
  */
package models

object CategoryService {

}
