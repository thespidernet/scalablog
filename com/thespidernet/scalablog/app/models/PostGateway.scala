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
  * This is the PostGateway object (Singleton).
  * It contains all "native" code for getting data into and out of physical storage.
  * E.g. Actual SQL, ORM instructions.
  * All in native dialects for the databases supported.
  *
  * If you support three different database platforms - you may
  * well have 3 versions of each action, here.
  *
  * ***************************************************************************
  */
package models

object PostGateway {

}
