@*****************************************************************************
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
 * Bootstrap / jQuery
 * 
 *****************************************************************************@
 
 The controllers folder is used to contain all the application-flow logic for
 the application.

 The controller dictates the steps requires to "action" the user's input.
 You can also think of them as "script / batch files" for required steps.
 
 Eg.
 You press a "button" on a form.
 You need to validate the form for appropriate correctness.
 You may need to check for duplicates.
 You may need to save or delete a database entry.
 You may need to to update the contents of the screen to show to the user at the 
     completion of the process.
      
 All these rules and the required steps to get from one state to another are 
 contained within the controllers.  
  
 The controllers folder forms part of the Model View Controller (MVC) design pattern.
 
 MVC has become a standard for building web applications and allows 
 developers to cleanly separate different areas of concern in their applications.
 Which allows for better collaboration, easier troubleshooting, simpler code maintenance.
 